package rainbow.function.painter.part3;

import java.awt.Graphics;

import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;
import rainbow.function.calculater.FunctionCalculater;
import rainbow.setting.Setting;
import rainbow.system.tools.LocationChanger;
import rainbow.tools.MyMath;

public class AAOSpecialPainter {
	private int mode;
	private Graphics g;

	public AAOSpecialPainter(Function f, String[] parts, int mode) {
		this.mode = mode;
		this.g = f.getImg().getGraphics();
		paintImg(f, parts, mode);
	}

	public void paintImg(Function f, String[] parts, int mode) {
		int a = Integer.parseInt(parts[mode == 0 ? 0 : 2].substring(0, parts[mode == 0 ? 0 : 2].indexOf("*")));
		int m = Integer.parseInt(parts[mode == 0 ? 0 : 2].substring(parts[mode == 0 ? 0 : 2].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("*")));
		int n = Integer.parseInt(parts[1].substring(parts[1].indexOf("^") + 1));
		int c = Integer.parseInt(parts[mode == 0 ? 2 : 0]);

		double d = MyMath.pow(b * 1.0, 2.0) - 4.0 * a * c;
		if (m == 2 * n) {
			if (d >= 0) {
				double keyn1 = (-b * 1.0 + MyMath.sqrt(d)) / (2.0 * a);
				double keyn2 = (-b * 1.0 - MyMath.sqrt(d)) / (2.0 * a);

				g.setColor(Setting.colorOfFunciton);

				if (n % 2 == 0) {
					if (keyn1 >= 0) {
						double key1 = Math.pow(keyn1, n);
						paint(key1, -key1);
					}
					if (keyn2 >= 0) {
						double key1 = Math.pow(keyn2, n);
						paint(key1, -key1);
					}
				} else {
					paint(MyMath.pow(keyn1, n), MyMath.pow(keyn2, n));
				}
				f.setHasPoints();
				new FunctionPointsPainter(f).tryToAddImg();
				return;
			}
		} else
			new FunctionCalculater(f);
	}

	private void paint(double... keys) {
		for (double key : keys) {
			int line = mode == 0 ? LocationChanger.Xto(key) : LocationChanger.Yto(key);

			if (mode == 0) {
				g.drawLine(line, 0, line, Setting.MainFrameHeight);
			} else {
				g.drawLine(0, line, Setting.MainFrameHeight, line);
			}
		}
	}
}
