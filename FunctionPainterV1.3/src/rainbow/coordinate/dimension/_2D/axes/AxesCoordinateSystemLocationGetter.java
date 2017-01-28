package rainbow.coordinate.dimension._2D.axes;

import rainbow.coordinate.dimension._2D.CoordinateSystemOf2DLocationGetter;
import rainbow.coordinate.dimension.__abs.MyPoint;

public class AxesCoordinateSystemLocationGetter extends CoordinateSystemOf2DLocationGetter{

	AxesCoordinateSystem acs;

	public AxesCoordinateSystemLocationGetter(AxesCoordinateSystem cs) {
		super(cs);
		acs = (AxesCoordinateSystem) cs;
	}

	@Override
	public MyPoint toSystem(PointOfAxes point) {
		PointOfAxes newPoint = new PointOfAxes();
		PointOfAxes ap = (PointOfAxes) point;

		newPoint.setY((acs.getY() - ap.getY()) / acs.getBlockHeight()
				/ (acs.getAngle() == Math.PI / 2 ? 1 : Math.sin(acs.getAngle())));
		newPoint.setX((ap.getX() - acs.getX()
				- newPoint.getY() * (acs.getAngle() == Math.PI / 2 ? 0 : Math.cos(acs.getAngle())))
				/ acs.getBlockWidth());

		return (MyPoint) newPoint;
	}

	@Override
	public PointOfAxes toReal(MyPoint point) {
		PointOfAxes newPoint = new PointOfAxes();
		PointOfAxes ap = (PointOfAxes) point;

		double x = ap.getX() * acs.getBlockWidth();
		double y = ap.getY() * acs.getBlockHeight();

		newPoint.setY(acs.getY() - (y * (acs.getAngle() == Math.PI / 2 ? 1 : Math.sin(acs.getAngle()))));
		newPoint.setX(acs.getX() + x + (y * (acs.getAngle() == Math.PI / 2 ? 0 : Math.cos(acs.getAngle()))));

		return newPoint;
	}


}
