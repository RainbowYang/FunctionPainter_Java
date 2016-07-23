package rainbow.function.painter.part2;

import java.awt.Graphics;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.painter.AllPainter;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

public class XOSpecialPainter {

	public XOSpecialPainter(Function f, String[] parts) {
		paintImg(f, parts);
	}

	public void paintImg(Function f, String[] parts) {
		// a*x^m+b=0
		int a = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("*")));
		int m = Integer.parseInt(parts[0].substring(parts[0].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1]);
		int x = LocationChanger.Xto(Math.pow((-b / a), 1 / m));
		Graphics g = f.getImg().getGraphics();
		g.setColor(Setting.colorOfFunciton);

		if (m % 2 == 0) {
			if ((-b / a) >= 0) {
				g.drawLine(x, 0, x, Setting.MainFrameHeight);
				g.drawLine(-x, 0, -x, Setting.MainFrameHeight);
			}
		} else {
			g.drawLine(x, 0, x, Setting.MainFrameHeight);
		}
		f.setOk();
		MainFrame.mainFrame.add(new AllPainter());
		MainFrame.mainFrame.repaint();
		System.out.println("函数图像生成");

	}

}
