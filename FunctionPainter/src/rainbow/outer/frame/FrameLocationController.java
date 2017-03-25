package rainbow.outer.frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class FrameLocationController {

	/**
	 * 将窗体设置在屏幕的中心
	 * 
	 * @param f
	 *            需要设置的窗体
	 */
	public static void setAtCenter(Frame f) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		double width = d.getWidth();
		double height = d.getHeight();

		f.setLocation((int) (width - f.getWidth()) / 2, (int) (height - f.getHeight()) / 2);
	}
}
