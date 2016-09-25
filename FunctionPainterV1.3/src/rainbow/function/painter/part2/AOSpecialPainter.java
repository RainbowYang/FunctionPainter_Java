package rainbow.function.painter.part2;

import java.awt.Graphics;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.setting.Setting;
import rainbow.system.tools.LocationChanger;

//包括XO和YO
public class AOSpecialPainter {

	/**
	 * 
	 * @param f
	 * @param parts
	 * @param mode
	 *            x=0,y=1
	 */
	public AOSpecialPainter(Function f, String[] parts, int mode) {
		paintImg(f, parts, mode);
	}

	public void paintImg(Function f, String[] parts, int mode) {
		// a*x^m+b=0 或 b+a*y^m=0
		int a = Integer.parseInt(parts[mode].substring(0, parts[mode].indexOf("*")));
		int m = Integer.parseInt(parts[mode].substring(parts[mode].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1 - mode]);
		int key = mode == 0 ? LocationChanger.Xto(Math.pow((-b * 1.0 / a), 1.0 / m))
				: LocationChanger.Yto(Math.pow((-b * 1.0 / a), 1.0 / m));
		Graphics g = f.getImg().getGraphics();
		g.setColor(Setting.colorOfFunciton);

		if (m % 2 == 0) {
			if ((-b / a) >= 0) {
				if (mode == 0) {
					g.drawLine(key, 0, key, Setting.MainFrameHeight);
					g.drawLine(-key, 0, -key, Setting.MainFrameHeight);
				} else {
					g.drawLine(0, key, Setting.MainFrameWidth, key);
					g.drawLine(0, -key, Setting.MainFrameWidth, -key);
				}
			}
		} else {
			if (mode == 0) {
				g.drawLine(key, 0, key, Setting.MainFrameHeight);
			} else {
				g.drawLine(0, key, Setting.MainFrameWidth, key);
			}
		}

		f.setHasImg();
		MainFrame.repaint();
		System.out.println("函数图像生成");

	}

}
