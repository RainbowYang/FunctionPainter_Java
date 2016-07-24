package rainbow.function.painter.part3;

import java.awt.Graphics;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.number.FenShu;
import rainbow.setting.Setting;
import rainbow.tools.CirclePainter;

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

			System.out.println("enter");
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
		}
	}
}
