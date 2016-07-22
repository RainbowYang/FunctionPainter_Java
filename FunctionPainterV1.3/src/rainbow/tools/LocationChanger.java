
package rainbow.tools;

import rainbow.number.FenShu;
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
	public static FenShu toX(int m) {
		return new FenShu(m - Setting.xOfO, Setting.blockWidth);
	}

	/**
	 * 
	 * @param n
	 *            实际上距上的像素数
	 * @return 相对于原点的纵坐标
	 */
	public static FenShu toY(int n) {
		return new FenShu(Setting.yOfO - n, Setting.blockHeight);
	}

	/**
	 * 
	 * @param x
	 *            相对于原点的横坐标
	 * @return 实际上距左的像素数
	 */
	public static int Xto(FenShu x) {

		return x.multiply(new FenShu(Setting.blockWidth)).intValue() + Setting.xOfO;
	}

	/**
	 * 
	 * @param y
	 *            实际上距上的像素数
	 * @return
	 */
	public static int Yto(FenShu y) {
		return -(y.multiply(new FenShu(Setting.blockHeight)).intValue()) + Setting.yOfO;
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

}
