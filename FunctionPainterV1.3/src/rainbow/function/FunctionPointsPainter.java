package rainbow.function;

import java.awt.Graphics;

import rainbow.frame.MainFrame;
import rainbow.number.PointOfFenShu;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

public class FunctionPointsPainter {
	private Function f;

	public FunctionPointsPainter(Function f) {
		this.f = f;
	}

	public void tryToAddImg() {
		if (f.hasPoints()) {
			Graphics g = f.getImg().getGraphics();
			g.setColor(Setting.colorOfFunciton);

			for (PointOfFenShu p : f.getPoints()) {
				g.fillRect(LocationChanger.Xto(p.getX()), LocationChanger.Yto(p.getY()), 1, 1);
			}
			f.setHasImg();
			System.out.println(f.hasImg());
			MainFrame.repaint();
		}
	}
}
