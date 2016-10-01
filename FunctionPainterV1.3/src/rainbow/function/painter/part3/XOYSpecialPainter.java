package rainbow.function.painter.part3;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.List;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;
import rainbow.function.tools.CirclePainter;
import rainbow.function.tools.MyMath;
import rainbow.setting.Setting;

public class XOYSpecialPainter {

	public XOYSpecialPainter(Function f, String[] parts) {
		paintImg(f, parts);
	}

	public void paintImg(Function f, String[] parts) {
		// a*x^m+b*y^n+c=0
		int a = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("*")));
		int m = Integer.parseInt(parts[0].substring(parts[0].indexOf("^") + 1));
		int b = Integer.parseInt(parts[2].substring(0, parts[2].indexOf("*")));
		int n = Integer.parseInt(parts[2].substring(parts[2].indexOf("^") + 1));
		int c = Integer.parseInt(parts[1]);

		// 椭圆
		if (m == 2 && n == 2 && (a * c) < 0 && (b * c) < 0) {
			Graphics g = f.getImg().getGraphics();
			g.setColor(Setting.colorOfFunciton);

			// 算x方向半轴
			double xR = Math.sqrt(-c * 1.0 / a);

			// y
			double yR = Math.sqrt(-c * 1.0 / b);

			new CirclePainter(g, xR, yR);
			f.setHasImg();
			MainFrame.repaint();
			System.out.println("函数图像生成");
		} else {

			FunctionPointsPainter fpp = new FunctionPointsPainter(f);
			List<Point2D.Double> points = f.getPoints();

			double theAdd = Setting.theAdd;

			double Fu_a_chu_b = -a * 1.0 / b;
			double Fu_c_chu_b = -c * 1.0 / b;

			double xMax = Setting.xMax;
			for (double x = Setting.xMin; x < xMax; x += theAdd) {
				double g = MyMath.pow(x, m) * Fu_a_chu_b + Fu_c_chu_b;
				if (n % 2 == 0) {
					if (g >= 0) {
						double y = MyMath.pow(g, 1.0 / n);
						points.add(new Point2D.Double(x, y));
						points.add(new Point2D.Double(x, -y));
					}
				} else {
					double y = MyMath.pow(g, 1.0 / n);
					points.add(new Point2D.Double(x, y));
				}
			}

			double Fu_b_chu_a = -b * 1.0 / a;
			double Fu_c_chu_a = -c * 1.0 / a;

			double yMax = Setting.yMax;
			for (double y = Setting.yMin; y< yMax ; y += theAdd) {
				double g = MyMath.pow(y, n) * Fu_b_chu_a + Fu_c_chu_a;
				if (m % 2 == 0) {
					if (g >= 0) {
						double x = MyMath.pow(g, 1.0 / m);
						points.add(new Point2D.Double(x, y));
						points.add(new Point2D.Double(-x, y));
					}
				} else {
					double x = MyMath.pow(g, 1.0 / m);
					points.add(new Point2D.Double(x, y));
				}
			}

			f.setHasPoints();
			fpp.tryToAddImg();
			System.out.println("函数图像生成");
		}
	}
}
