package rainbow.function.painter.part2;

import java.awt.Graphics;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.painter.AllPainter;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

public class YYSpecialPainter {

	public YYSpecialPainter(Function f, String[] parts) {
		paintImg(f, parts);
	}

	public void paintImg(Function f, String[] parts) {

		// a*y^q+b*y^p=0 ->a*y^(q-p)+b=0
		int a = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("*")));
		int q = Integer.parseInt(parts[0].substring(parts[0].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("*")));
		int p = Integer.parseInt(parts[1].substring(parts[1].indexOf("^") + 1));

		int m = q - p;
		int y;
		Graphics g = f.getImg().getGraphics();
		g.setColor(Setting.colorOfFunciton);
		y = LocationChanger.Yto(Math.pow((-b / a), 1 / m));

		if (m % 2 == 0) {
			if ((-b / a) >= 0) {
				g.drawLine(0, y, Setting.MainFrameWidth, y);
				g.drawLine(0, -y, Setting.MainFrameWidth, -y);
			}
		} else {
			g.drawLine(0, y, Setting.MainFrameWidth, y);
		}
		f.setOk();
		MainFrame.mainFrame.add(new AllPainter());
		MainFrame.mainFrame.repaint();
		System.out.println("函数图像生成");
	}

}
