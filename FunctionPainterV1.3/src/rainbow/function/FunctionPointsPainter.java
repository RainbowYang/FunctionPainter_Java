package rainbow.function;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import rainbow.frame.MainFrame;
import rainbow.setting.Setting;
import rainbow.system.tools.LocationChanger;

public class FunctionPointsPainter {
	private Function f;

	public FunctionPointsPainter(Function f) {
		this.f = f;
	}

	public void tryToAddImg() {
		if (f.hasPoints()) {
			Graphics g = f.getImg().getGraphics();
			g.setColor(Setting.colorOfFunciton);

			for (Point2D.Double p : f.getPoints()) {
				g.fillRect(LocationChanger.Xto(p.getX()), LocationChanger.Yto(p.getY()), 1, 1);
			}
			f.setHasImg();
			System.out.println(f.hasImg());
			MainFrame.repaint();
		}
	}
}
