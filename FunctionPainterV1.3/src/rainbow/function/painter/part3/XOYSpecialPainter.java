package rainbow.function.painter.part3;

import java.awt.Graphics;
import java.util.List;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;
import rainbow.number.FenShu;
import rainbow.number.PointOfFenShu;
import rainbow.setting.Setting;
import rainbow.tools.CirclePainter;
import rainbow.tools.MyMath;

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
			double xR = Math.sqrt(new FenShu(-c, a).doubleValue());

			// y
			double yR = Math.sqrt(new FenShu(-c, b).doubleValue());

			new CirclePainter(g, xR, yR);
			f.setHasImg();
			MainFrame.repaint();
			System.out.println("函数图像生成");
		} else {

			FunctionPointsPainter fpp = new FunctionPointsPainter(f);
			List<PointOfFenShu> points = f.getPoints();

			FenShu theAdd = Setting.theAdd;

			double Fu_a_chu_b = -a * 1.0 / b;
			double Fu_c_chu_b = -c * 1.0 / b;
			for (FenShu x = Setting.xMin; x.intValue() < Setting.xIntMax + 1; x = x.add(theAdd)) {
				double g = x.pow(m).doubleValue() * Fu_a_chu_b + Fu_c_chu_b;
				if (n % 2 == 0) {
					if (g >= 0) {
						FenShu y = new FenShu(MyMath.pow(g, 1.0 / n));
						points.add(new PointOfFenShu(x, y));
						points.add(new PointOfFenShu(x, y.getFuFenShu()));
					}
				} else {
					FenShu y = new FenShu(MyMath.pow(g, 1.0 / n));
					points.add(new PointOfFenShu(x, y));
				}
			}

			double Fu_b_chu_a = -b * 1.0 / a;
			double Fu_c_chu_a = -c * 1.0 / a;
			for (FenShu y = Setting.yMin; y.intValue() < Setting.yIntMax + 1; y = y.add(theAdd)) {
				double g = y.pow(n).doubleValue() * Fu_b_chu_a + Fu_c_chu_a;
				if (m % 2 == 0) {
					if (g >= 0) {
						FenShu x = new FenShu(MyMath.pow(g, 1.0 / m));
						points.add(new PointOfFenShu(x, y));
						points.add(new PointOfFenShu(x.getFuFenShu(), y));
					}
				} else {
					FenShu x = new FenShu(MyMath.pow(g, 1.0 / m));
					points.add(new PointOfFenShu(x, y));
				}
			}

			f.setHasPoints();
			fpp.tryToAddImg();
			System.out.println("函数图像生成");
		}
	}
}
