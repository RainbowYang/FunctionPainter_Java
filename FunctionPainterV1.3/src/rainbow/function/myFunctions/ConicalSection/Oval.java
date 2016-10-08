package rainbow.function.myFunctions.ConicalSection;

import java.awt.Graphics;

import rainbow.system.tools.LocationChanger;

/**
 * 椭圆(包括圆)
 * 
 * @author Rainbow Yang
 *
 */
public class Oval extends ConicalSection {

	// 圆心位置
	private double x;
	private double y;

	private double a;
	private double b;

	/**
	 * @param x
	 *            圆心横坐标
	 * @param y
	 *            圆心纵坐标
	 * @param a
	 *            横向轴
	 * @param b
	 *            纵向轴
	 */
	public Oval(double x, double y, double a, double b) {
		type = "Oval";
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}

	@Override
	public void paintImage(Graphics g) {
		g.setColor(color);
		// 表示实际对应的像素数
		int realWidth = (int) (a * s.getBlockWidth());
		int realHeight = (int) (b * s.getBlockHeight());
		g.drawOval(LocationChanger.Xto(x) - realWidth, LocationChanger.Yto(y) - realHeight, //
				realWidth * 2, realHeight * 2);
	}

}
