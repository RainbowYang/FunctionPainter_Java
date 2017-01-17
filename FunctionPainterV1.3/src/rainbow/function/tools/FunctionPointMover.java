package rainbow.function.tools;

import static rainbow.system.tools.LocationChanger.Xto;
import static rainbow.system.tools.LocationChanger.Yto;

import java.util.List;

/**
 * 本类提供关于坐标点的转换(由LocationChanger提供),以及变换(例如旋转,对称翻转)<br>
 * 
 * @see LocationChanger
 * @see FoldLine
 * 
 * @author Rainbow Yang
 *
 */
public class FunctionPointMover {
	/**
	 * 用于getIntPoints(points,axes)中的axes
	 */
	public static final int X = 0, Y = 1;

	// 表示平移的坐标
	private double x, y;

	/**
	 * 表示平移的坐标
	 * 
	 * @param x
	 * @param y
	 */
	public FunctionPointMover(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public int[] getIntPoints(List<Double> points, int axes) {
		int[] ps = new int[points.size()];

		for (int i = 0; i < points.size(); i++) {
			switch (axes) {
			case X:
				ps[i] = Xto(points.get(i) + x);
//				System.out.println(ps[i]);
				break;
			case Y:
				ps[i] = Yto(points.get(i) + y);
//				System.out.println(ps[i]);
				break;
			default:
				break;
			}
		}
		return ps;
	}
}