package rainbow.function.myFunctions.ConicalSection;

import java.awt.Graphics;

import rainbow.function.myFunctions.MyFunction;
import rainbow.function.tools.FoldLine;
import rainbow.function.tools.MyMath;
import rainbow.system.tools.LocationChanger;

/**
 * 抛物线
 * 
 * @author Rainbow Yang
 *
 */
public class Parabola extends MyFunction {

	// 定点坐标
	private double x;
	private double y;
	// 表示系数和开口大小有关
	private double a;

	// 表示抛物线的朝向
	private int faceTo;

	public static final int toY = 0;
	public static final int toX = 1;

	public Parabola(double x, double y, double a) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
	}

	public Parabola(double x, double y, double a, int faceTo) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.faceTo = faceTo;
	}

	@Override
	public void paintImage(Graphics g) {
		g.setColor(color);
		// RangeControl rc = new RangeControl(e -> a * e * e, e -> MyMath.sqrt(y
		// / a), s.getxMax() - x,
		// s.getxMin() - x, s.getyMax() - y, s.getyMin() - y);
		// System.out.println(rc.getMax() + "..." + rc.getMin());
		// double x0 = rc.getMin(), y0;
		// int lastX, lastY;
		// lastX = LocationChanger.Xto(x0 - 1);
		// lastY = LocationChanger.Yto(a * (x0 - 1) * (x0 - 1));
		//
		// for (x0 = rc.getMin(); x0 <= rc.getMax(); x0 += s.getTheAdd()) {
		// y0 = a * x0 * x0;
		// g.drawLine(lastX, lastY, //
		// lastX = LocationChanger.Xto(x0 + x), //
		// lastY = LocationChanger.Yto(y0 + y));
		// }

		fold = new FoldLine();

		double x0, y0;
		int lastX, lastY;
		double min, max, xMax, xMin, yMax, yMin;
		xMax = s.getxMax() - x;
		xMin = s.getxMin() - x;
		yMax = s.getyMax() - y;
		yMin = s.getyMin() - y;
		switch (faceTo) {
		case toY:

			min = xMin - 1;
			max = xMax + 1;
			double yAtXMin = a * xMin * xMin;
			double yAtXMax = a * xMax * xMax;

			if (a > 0) {
				if (yAtXMin > yMax) {
					min = -(MyMath.sqrt(yMax / a));
				}

				if (yAtXMax > yMax) {
					max = MyMath.sqrt(yMax / a);
				}
			} else {
				if (yAtXMin < yMin) {
					min = -(MyMath.sqrt(yMin / a));
				}

				if (yAtXMax < yMin) {
					max = MyMath.sqrt(yMin / a);
				}

			}

			// 得到最值
			for (x0 = min; x0 <= max + 1; x0 += s.getTheAdd()) {
				y0 = a * x0 * x0;
				fold.add(x0 + x, y0 + y);
			}

			System.out.println(min + "..." + max);
			break;
		case toX:
			min = yMin - 1;
			max = yMax + 1;

			double xAtYMin = a * yMin * yMin;
			double xAtYMax = a * yMax * yMax;

			if (a > 0) {
				if (xAtYMin > xMax) {
					min = -(MyMath.sqrt(xMax / a));
				}

				if (xAtYMax > xMax) {
					max = MyMath.sqrt(xMax / a);
				}
			} else {
				if (xAtYMin < xMin) {
					min = -(MyMath.sqrt(xMin / a));
				}

				if (xAtYMax < xMin) {
					max = MyMath.sqrt(xMin / a);
				}

			}
			lastY = LocationChanger.Yto(min - 1);
			lastX = LocationChanger.Xto(a * (min - 1) * (min - 1));

			// 得到最值
			for (y0 = min; y0 <= max + 1; y0 += s.getTheAdd()) {
				x0 = a * y0 * y0;
				g.drawLine(lastX, lastY, //
						lastX = LocationChanger.Xto(x0 + x), //
						lastY = LocationChanger.Yto(y0 + y));
				fold.add(x0 + x, y0 + y);
			}

			System.out.println(min + "..." + max);
			break;
		}
	}
}
