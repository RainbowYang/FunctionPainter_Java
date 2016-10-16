package rainbow.function.myFunctions.ConicalSection;

import java.awt.Graphics;

import rainbow.function.tools.FoldLine;
import rainbow.function.tools.MyMath;

/**
 * 双曲线
 * 
 * @author Rainbow Yang
 *
 */
public class Hyperbola extends ConicalSection {

	private double x;
	private double y;
	private double a;
	private double b;

	private FoldLine fold2;

	private int faceTo = toX;

	public static final int toY = 0;
	public static final int toX = 1;

	public Hyperbola() {
	}

	@Override
	public void paintImage(Graphics g) {
		g.setColor(color);

		fold = new FoldLine();
		fold2 = new FoldLine();

		double x0, y0;
		// int lastX, lastY, lastX1, lastY1;

		double min, max, xMax, xMin, yMax, yMin;
		xMax = s.getxMax() - x;
		xMin = s.getxMin() - x;
		yMax = s.getyMax() - y;
		yMin = s.getyMin() - y;
		switch (faceTo) {
		case toY:

			min = xMin - 1;
			max = xMax + 1;
			double yAtXMin = MyMath.sqrt(a * a * (1 + ((xMin - 1) * (xMin - 1)) / (b * b)));
			double yAtXMax = MyMath.sqrt(a * a * (1 + ((xMax - 1) * (xMax - 1)) / (b * b)));

			if (a > 0) {
				if (yAtXMin > yMax) {
					min = -(MyMath.sqrt(b * b * (-1 + ((xMin - 1) * (xMin - 1)) / (a * a))));
				}

				if (yAtXMax > yMax) {
					max = MyMath.sqrt(b * b * (-1 + ((xMin - 1) * (xMin - 1)) / (a * a)));
				}
			} else {
				if (yAtXMin < yMin) {
					min = -(MyMath.sqrt(b * b * (-1 + ((xMin - 1) * (xMin - 1)) / (a * a))));
				}

				if (yAtXMax < yMin) {
					max = MyMath.sqrt(b * b * (-1 + ((xMin - 1) * (xMin - 1)) / (a * a)));
				}

			}

			// 得到最值
			for (x0 = min - 1; x0 <= max + 1; x0 += s.getTheAdd()) {
				y0 = MyMath.sqrt(a * a * (1 + (x0 * x0) / (b * b)));
				fold.add(x0 + x, y0 + y);
				fold2.add(x0 + x, -y0 + y);
			}

			fold.paintLine(g);
			fold2.paintLine(g);

			// System.out.println(min + "..." + max);
			break;
		case toX:
			min = yMin - 1;
			max = yMax + 1;

			double xAtYMin = MyMath.sqrt(a * a * (1 + ((yMin - 1) * (yMin - 1)) / (b * b)));
			double xAtYMax = MyMath.sqrt(a * a * (1 + ((yMax - 1) * (yMax - 1)) / (b * b)));

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
			// 得到最值
			for (y0 = min; y0 <= max + 1; y0 += s.getTheAdd()) {
				x0 = MyMath.sqrt(a * a * (1 + (y0 * y0) / (b * b)));
				fold.add(x0 + x, y0 + y);
				fold2.add(-x0 + x, y0 + y);
			}

			fold.paintLine(g);
			fold2.paintLine(g);

			// System.out.println(min + "..." + max);
			break;
		}
	}

	public Hyperbola(double x, double y, double a, double b) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}

	public Hyperbola(double x, double y, double a, double b, int faceTo) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
		this.faceTo = faceTo;
	}

}
