package rainbow.function;

import rainbow.system.tools.LocationChanger;

/**
 * 用于描述一些基于坐标系的点并能给出实际的相对于系统的点
 * 
 * @author Rainbow Yang
 *
 */
public class FunctionPoint {
	private double x;
	private double y;

	public FunctionPoint(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getRealX() {
		return LocationChanger.Xto(x);
	}

	public int getRealY() {
		return LocationChanger.Yto(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}