package rainbow.coordinate.dimension._2D.axes;

import rainbow.coordinate.dimension._2D.CoordinateSystemOf2DLocationGetter;
import rainbow.coordinate.dimension.__abs.MyPoint;

public class AxesCoordinateSystemLocationGettter extends CoordinateSystemOf2DLocationGetter<Axes> {

	public AxesCoordinateSystemLocationGettter(AxesCoordinateSystem cs) {
		super(cs);
	}

	@Override
	public MyPoint<Axes> toSystem(MyPoint<Axes> point) {
		return null;
	}

	@Override
	public MyPoint<Axes> toReal(MyPoint<Axes> point) {
		return null;
	}

}
