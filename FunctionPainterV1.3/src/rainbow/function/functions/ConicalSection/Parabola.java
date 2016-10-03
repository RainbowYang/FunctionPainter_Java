package rainbow.function.functions.ConicalSection;

import java.awt.Graphics;

import rainbow.function.functions.MyFunction;
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
			lastX = LocationChanger.Xto(min - 1);
			lastY = LocationChanger.Yto(a * (min - 1) * (min - 1));

			// 得到最值
			for (x0 = min; x0 <= max + 1; x0 += s.getTheAdd()) {
				y0 = a * x0 * x0;
				g.drawLine(lastX, lastY, //
						lastX = LocationChanger.Xto(x0 + x), //
						lastY = LocationChanger.Yto(y0 + y));
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
			}

			System.out.println(min + "..." + max);
			break;

		}
	}

}

// if (x > xMax) {
// if (!(yAtXMax < yMax && yAtXMax > yMin)) {
// return;
// } else if (yAtXMin > yMax || yAtXMin < yMin) {
// min = -(MyMath.sqrt(s.getyMax() / a));
// }
//
// } else if (x > xMin) {
// if ((y > yMax && a > 0) || (y < yMin && a < 0)) {
// return;
// }
// if (yAtXMin > yMax || yAtXMin < yMin) {
// min = -(MyMath.sqrt(s.getyMax() / a));
// }
// if (yAtXMax > yMax || yAtXMax < yMin) {
// min = (MyMath.sqrt(s.getyMax() / a));
// }
// }

// min = yMin - 1;
// max = yMax + 1;
//
// double xAtYMax = a * (s.getxMin() + y) * (s.getyMin() + y);
// double xAtYMin = a * (s.getxMin() + y) * (s.getyMin() + y);
// if (a > 0) {
// if (yAtXMin > s.getyMax()) {
// min = -(MyMath.sqrt(s.getyMax() / a));
// }
//
// if (yAtXMax > s.getyMax()) {
// max = MyMath.sqrt(s.getyMax() / a);
// }
// } else {
// if (yAtXMin > s.getyMax()) {
// min = -(MyMath.sqrt(s.getyMax() / a));
// }
//
// if (yAtXMax > s.getyMax()) {
// max = MyMath.sqrt(s.getyMax() / a);
// }
//
// }
//
// if (xAtYMax > s.getxMax()) {
// min = -(MyMath.sqrt(s.getxMax() / a));
// }
//
// if (xAtYMax > s.getxMax()) {
// min = MyMath.sqrt(s.getxMax() / a);
// }
//
// lastY = LocationChanger.Yto(min + y - 1);
// lastX = LocationChanger.Xto(a * (min + y - 1) * (min + y - 1));
//
// // 得到最值
// for (y0 = min; y0 <= max; y0 += s.getTheAdd()) {
// x0 = a * y0 * y0;
// g.drawLine(lastX, lastY, //
// lastX = LocationChanger.Xto(x0 + x), //
// lastY = LocationChanger.Yto(y0 + y));
// }
// System.out.println(min + "..." + max);
//
// break;