
package rainbow.system.tools;

import rainbow.system.System;

/**
 * 坐标转换类
 * 
 * @author Rainbow_Yang
 *
 */
public class LocationChanger {

	private static final System s = System.getSystem();

	/**
	 * 
	 * @param m
	 *            实际上距左的像素数
	 * @return 相对于原点的横坐标
	 */
	public static double toX(int m) {
		return (m - s.getX()) * 1.0 / s.getBlockWidth();
	}

	/**
	 * 
	 * @param n
	 *            实际上距上的像素数
	 * @return 相对于原点的纵坐标
	 */
	public static double toY(int n) {
		return (s.getY()- n) * 1.0 / s.getBlockHeight();
	}

	/**
	 * 
	 * @param x
	 *            相对于原点的横坐标
	 * @return 实际上距左的像素数
	 */
	public static int Xto(int x) {

		return s.getX()+ (x * s.getBlockWidth());
	}

	/**
	 * 
	 * @param y
	 *            实际上距上的像素数
	 * @return
	 */
	public static int Yto(int y) {
		return s.getY()- (y * s.getBlockHeight());
	}

	/**
	 * 
	 * @param x
	 *            相对于原点的横坐标
	 * @return 实际上距左的像素数
	 */
	public static int Xto(double x) {

		return (int) (s.getX()+ (x * s.getBlockWidth()));
	}

	/**
	 * 
	 * @param y
	 *            实际上距上的像素数
	 * @return
	 */
	public static int Yto(double y) {
		return (int) (s.getY()- (y * s.getBlockHeight()));
	}

}
