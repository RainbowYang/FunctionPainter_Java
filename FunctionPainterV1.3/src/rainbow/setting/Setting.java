package rainbow.setting;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 用于输出各种参数
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class Setting {

	public static final int WelcomeFrameWidth = 600;
	public static final int WelcomeFrameHeight = 500;

	public static final int xOfMainFrame;
	public static final int yOfMainFrame = 25;
	public static final int MainFrameWidth = 1300;
	public static final int MainFrameHeight = 700;

	public static final int SettingFrameWidth = MainFrameWidth;
	public static final int SettingFrameHeight = 300;
	public static final int PowerMax = 100;

	public static final int xOfLookingFrame;
	public static final int yOfLookingFrame;
	public static final int LookingFrameWidth = WelcomeFrameWidth;
	public static final int LookingFrameHeight = WelcomeFrameHeight;

	static {
		// 居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		xOfMainFrame = ((int) screenSize.getWidth() - MainFrameWidth) / 2;

		xOfLookingFrame = ((int) screenSize.getWidth() - LookingFrameWidth) / 2;
		yOfLookingFrame = ((int) screenSize.getHeight() - LookingFrameHeight) / 2;

	}
}
