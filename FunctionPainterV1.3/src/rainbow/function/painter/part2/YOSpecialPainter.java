package rainbow.function.painter.part2;

import java.awt.Graphics;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

public class YOSpecialPainter {

	public YOSpecialPainter(Function f, String[] parts) {
		paintImg(f, parts);
	}

	public void paintImg(Function f, String[] parts) {
		// a*x^m+b=0
		int a = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("*")));
		int m = Integer.parseInt(parts[1].substring(parts[1].indexOf("^") + 1));
		int b = Integer.parseInt(parts[0]);

		int y = LocationChanger.Yto(Math.pow((-b / a), 1 / m));
		Graphics g = f.getImg().getGraphics();
		g.setColor(Setting.colorOfFunciton);

		if (m % 2 == 0) {
			if ((-b / a) >= 0) {
				g.drawLine(0, y, Setting.MainFrameWidth, y);
				g.drawLine(0, -y, Setting.MainFrameWidth, -y);
			}

		} else {
			g.drawLine(0, y, Setting.MainFrameWidth, y);
		}
		f.setHasImg();
		MainFrame.repaint();
		System.out.println("函数图像生成");
	}
}
