package rainbow.inner.math.points;

public class PointOfAxes extends PointOf2D {

	public PointOfAxes() {
		super();
	}

	public PointOfAxes(double x, double y) {
		super(x, y);
	}

	public void setX(double x) {
		setFirst(x);
	}

	public void setY(double y) {
		setSecond(y);
	}

	public double getX() {
		return getFirst();
	}

	public double getY() {
		return getSecond();
	}

	public int getIntX() {
		return getIntFirst();
	}

	public int getIntY() {
		return getIntSecond();
	}

	@Override
	public String toString() {
		return "PointOfAxes [x=" + getX() + ", y=" + getY() + "]";
	}

}
