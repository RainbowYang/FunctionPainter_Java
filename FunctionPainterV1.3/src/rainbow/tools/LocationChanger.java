
package rainbow.tools;

import rainbow.setting.Setting;

/**
 * 坐标转换类
 * 
 * @author Rainbow_Yang
 *
 */
public class LocationChanger {
	/**
	 * 
	 * @param m
	 *            实际上距左的像素数
	 * @return 相对于原点的横坐标
	 */
	public static double toX(int m) {
		return (m - Setting.xOfO) * 1.0 / Setting.blockWidth;
	}

	/**
	 * 
	 * @param n
	 *            实际上距上的像素数
	 * @return 相对于原点的纵坐标
	 */
	public static double toY(int n) {
		return (Setting.yOfO - n) * 1.0 / Setting.blockHeight;
	}

	/**
	 * 
	 * @param x
	 *            相对于原点的横坐标
	 * @return 实际上距左的像素数
	 */
	public static int Xto(int x) {

		return Setting.xOfO + (x * Setting.blockWidth);
	}

	/**
	 * 
	 * @param y
	 *            实际上距上的像素数
	 * @return
	 */
	public static int Yto(int y) {
		return Setting.yOfO - (y * Setting.blockHeight);
	}

	/**
	 * 
	 * @param x
	 *            相对于原点的横坐标
	 * @return 实际上距左的像素数
	 */
	public static int Xto(double x) {

		return (int) (Setting.xOfO + (x * Setting.blockWidth));
	}

	/**
	 * 
	 * @param y
	 *            实际上距上的像素数
	 * @return
	 */
	public static int Yto(double y) {
		return (int) (Setting.yOfO - (y * Setting.blockHeight));
	}

}
