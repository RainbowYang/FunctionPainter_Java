package rainbow.coordinate.dimension._2D;

import rainbow.coordinate.dimension.__abs.MyPoint;

/**
 * 二维点
 * 
 * @author Rainbow Yang
 *
 */
public class PointOf2D implements MyPoint<TwoDimension> {

	public double X;
	public double Y;

	public PointOf2D(double x, double y) {
		this.X = x;
		this.Y = y;
	}

	public PointOf2D(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public void set(double x, double y) {
		this.X = x;
		this.Y = y;
	}

	public void set(int x, int y) {
		this.X = x;
		this.Y = y;
	}

}
