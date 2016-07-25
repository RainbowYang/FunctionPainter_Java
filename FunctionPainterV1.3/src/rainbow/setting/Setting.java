package rainbow.setting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import rainbow.number.FenShu;
import rainbow.tools.ColorGetter;
import rainbow.tools.LocationChanger;

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
	public static final int yOfMainFrame = 15;
	public static final int MainFrameWidth = 1300;
	public static final int MainFrameHeight = 700;

	// 用于消除由该皮肤导致的窗体缩小
	public static final int MainFrameTrueWidth = MainFrameWidth + 52;
	public static final int MainFrameTrueHeight = MainFrameHeight + 80;

	public static final int SettingFrameWidth = MainFrameWidth;
	public static final int SettingFrameHeight = 300;
	public static final int PowerMax = 100;

	public static final int xOfLookingFrame;
	public static final int yOfLookingFrame;
	public static final int LookingFrameWidth = WelcomeFrameWidth;
	public static final int LookingFrameHeight = WelcomeFrameHeight;

	public static final int xOfO;
	public static final int yOfO;

	public static final int blockWidth = 40;
	public static final int blockHeight = blockWidth;

	public static final boolean isBlock = true;
	public static final Color colorOfBack;
	public static final Color colorOfBlock;
	public static final Color colorOfO;
	public static final Color colorOfNum;
	public static final Color colorOfXY;
	public static final Color colorOfFunciton;
	
	public static final int widthOfXY = 4;

	public static final FenShu xMax;
	public static final FenShu xMin;
	public static final FenShu yMax;
	public static final FenShu yMin;

	public static final int xIntMax;
	public static final int xIntMin;
	public static final int yIntMax;
	public static final int yIntMin;

	public static final int ArrowLength = 40;
	public static final double ArrowAngle = Math.PI / 6;

	static {
		// 居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		xOfMainFrame = ((int) screenSize.getWidth() - MainFrameTrueWidth) / 2;
		xOfLookingFrame = ((int) screenSize.getWidth() - LookingFrameWidth) / 2;
		yOfLookingFrame = ((int) screenSize.getHeight() - LookingFrameHeight) / 2;

		xOfO = MainFrameWidth / 2;
		yOfO = MainFrameHeight / 2;

		xMax = LocationChanger.toX(MainFrameWidth);
		xMin = LocationChanger.toX(0);
		yMax = LocationChanger.toY(0);
		yMin = LocationChanger.toY(MainFrameHeight);

		xIntMax = xMax.intValue();
		xIntMin = xMin.intValue();
		yIntMax = yMax.intValue();
		yIntMin = yMin.intValue();
		
		colorOfBack = ColorGetter.getColor("");
		colorOfBlock = ColorGetter.getColor("");
		colorOfXY = ColorGetter.getColor("");
		colorOfO = ColorGetter.getColor("");
		colorOfNum = ColorGetter.getColor("");
		colorOfFunciton = ColorGetter.getColor("ff0000");
	}
}
