package rainbow.coordinate.system.two.axes;

import rainbow.coordinate.system.two._comp.PointOf2D;

public class PointOfAxes extends PointOf2D {

	public PointOfAxes() {
		super();
	}

	public PointOfAxes(double x, double y) {
		super(x, y);
	}

	public void set(double x, double y) {
		first = x;
		second = y;
	}

	public void setX(double x) {
		first = x;
	}

	public void setY(double y) {
		second = y;
	}

	public double getX() {
		return first;
	}

	public double getY() {
		return second;
	}

	public int getIntX() {
		return (int) first;
	}

	public int getIntY() {
		return (int) second;
	}

	@Override
	public String toString() {
		return "PointOfAxes [x=" + first + ", y=" + second + "]";
	}

}
