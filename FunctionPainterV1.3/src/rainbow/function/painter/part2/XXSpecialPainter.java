package rainbow.function.painter.part2;

import java.awt.Graphics;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.painter.AllPainter;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

public class XXSpecialPainter {

	public XXSpecialPainter(Function f, String[] parts) {
		paintImg(f, parts);
	}

	public void paintImg(Function f, String[] parts) {
		// a*x^q+b*x^p=0 ->a*x^(q-p)+b=0
		int a = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("*")));
		int q = Integer.parseInt(parts[0].substring(parts[0].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("*")));
		int p = Integer.parseInt(parts[1].substring(parts[1].indexOf("^") + 1));

		int m = q - p;
		int x;
		Graphics g = f.getImg().getGraphics();
		g.setColor(Setting.colorOfFunciton);
		x = LocationChanger.Xto(Math.pow((-b / a), 1 / m));

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
