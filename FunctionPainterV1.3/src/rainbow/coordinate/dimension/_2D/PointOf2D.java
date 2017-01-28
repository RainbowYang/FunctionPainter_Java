package rainbow.coordinate.dimension._2D;

import rainbow.coordinate.dimension.__abs.MyPoint;

/**
 * 二维点
 * 
 * @author Rainbow Yang
 *
 */
public abstract class PointOf2D implements MyPoint{
	protected double first;
	protected double second;

	public PointOf2D() {
	}

	public PointOf2D(double first, double second) {
		this.first = first;
		this.second = second;
	}
}
