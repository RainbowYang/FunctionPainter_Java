package rainbow.function.tools;

import java.awt.Graphics;

import rainbow.setting.Setting;

public class CirclePainter {

	public static void paint(Graphics g, double xR, double yR) {
		int xIntR = (int) (xR * Setting.blockWidth);
		int yIntR = (int) (yR * Setting.blockWidth);

		g.drawOval(Setting.xOfO - xIntR, Setting.yOfO - yIntR, 2 * xIntR, 2 * yIntR);
	}
}
