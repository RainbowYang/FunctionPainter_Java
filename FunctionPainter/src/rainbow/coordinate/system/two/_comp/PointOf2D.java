package rainbow.coordinate.system.two._comp;

import rainbow.coordinate.system._abs.comp.MyPoint;

/**
 * 二维点
 * 
 * @author Rainbow Yang
 *
 */
public abstract class PointOf2D implements MyPoint {
	protected double first;
	protected double second;

	public PointOf2D() {
	}

	public PointOf2D(double first, double second) {
		this.first = first;
		this.second = second;
	}
}
