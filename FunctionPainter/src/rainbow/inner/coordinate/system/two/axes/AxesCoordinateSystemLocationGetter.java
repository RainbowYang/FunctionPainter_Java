package rainbow.inner.coordinate.system.two.axes;

import rainbow.inner.coordinate.system.two._comp.CoordinateSystemOf2DLocationGetter;
import rainbow.inner.math.points.MyPoint;
import rainbow.inner.math.points.PointOfAxes;

import java.awt.*;

/**
 * 用于进行平面轴坐标系坐标转换
 *
 * @author Rainbow Yang
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
                System.out.println(lg.toReal(new PointOfAxes(i, j)));
            }
        }
    }

    @Override
    public MyPoint toSystem(Point point) {
        PointOfAxes newPoint = new PointOfAxes();

//		newPoint.setY((acs.getY() - point.getY()) / acs.getBlockHeight()
//				/ (acs.getAngle() == Math.PI / 2 ? 1 : Math.sin(acs.getAngle())));
//		newPoint.setX((point.getX() - acs.getX()
//				- newPoint.getY() * (acs.getAngle() == Math.PI / 2 ? 0 : Math.cos(acs.getAngle())))
//				/ acs.getBlockWidth());
//
//		System.out.println(point);
//		System.out.println(newPoint);
        return (MyPoint) newPoint;
    }

    @Override
    public Point toReal(MyPoint point) {
        PointOfAxes ap = (PointOfAxes) point;
        Point newPoint = new Point();

        double x = ap.getX() * acs.getBlockWidth();
        double y = ap.getY() * acs.getBlockHeight();

        double dx = x * Math.cos(acs.getxAngle()) + y * Math.cos(acs.getyAngle());
        double dy = x * Math.sin(acs.getxAngle()) + y * Math.sin(acs.getyAngle());

        newPoint.x = acs.getX() + (int) dx;
        newPoint.y = acs.getY() - (int) dy;

        return newPoint;
    }

}
