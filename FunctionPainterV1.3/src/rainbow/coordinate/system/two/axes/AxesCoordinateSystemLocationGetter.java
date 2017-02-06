package rainbow.coordinate.system.two.axes;

import java.awt.Point;

import rainbow.coordinate.system._abs.comp.MyPoint;
import rainbow.coordinate.system.two._comp.CoordinateSystemOf2DLocationGetter;

/**
 * 用于进行平面轴坐标系坐标转换
 * 
 * @author Rainbow Yang
 *
 */
public class AxesCoordinateSystemLocationGetter extends CoordinateSystemOf2DLocationGetter {

	AxesCoordinateSystem acs;

	public AxesCoordinateSystemLocationGetter(AxesCoordinateSystem cs) {
		super(cs);
		acs = (AxesCoordinateSystem) cs;
	}

	public static void main(String[] args) {
		AxesCoordinateSystemLocationGetter lg = new AxesCoordinateSystemLocationGetter(new AxesCoordinateSystem());
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				lg.toReal(new PointOfAxes(i, i));
			}
		}
	}

	@Override
	public MyPoint toSystem(Point point) {
		PointOfAxes newPoint = new PointOfAxes();
		Point ap = (Point) point;

		newPoint.setY((acs.getY() - ap.getY()) / acs.getBlockHeight()
				/ (acs.getAngle() == Math.PI / 2 ? 1 : Math.sin(acs.getAngle())));
		newPoint.setX((ap.getX() - acs.getX()
				- newPoint.getY() * (acs.getAngle() == Math.PI / 2 ? 0 : Math.cos(acs.getAngle())))
				/ acs.getBlockWidth());

		System.out.println(point);
		System.out.println(newPoint);
		return (MyPoint) newPoint;
	}

	@Override
	public Point toReal(MyPoint point) {
		Point newPoint = new Point();
		PointOfAxes ap = (PointOfAxes) point;

		double x = ap.getX() * acs.getBlockWidth();
		double y = ap.getY() * acs.getBlockHeight();

		newPoint.y = (int) (acs.getY() - (y * (acs.getAngle() == Math.PI / 2 ? 1 : Math.sin(acs.getAngle()))));
		newPoint.x = (int) (acs.getX() + x + (y * (acs.getAngle() == Math.PI / 2 ? 0 : Math.cos(acs.getAngle()))));
		System.out.println("----------------");
		System.out.println(point);
		System.out.println(newPoint);
		System.out.println("----------------");
		

		return newPoint;
	}

}
