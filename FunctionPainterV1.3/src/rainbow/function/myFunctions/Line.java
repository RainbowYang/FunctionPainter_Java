package rainbow.function.myFunctions;

import java.awt.Graphics;

import rainbow.system.tools.LocationChanger;

/**
 * 用来描述一次函数
 * 
 * @author Rainbow Yang
 *
 */
public class Line extends MyFunction {

	private double a;
	private double b;
	private double c;

	// ax+by+c=0
	public Line(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public void paintImage(Graphics g) {
		fold = null;
		// x=(-by-c)/a
		double y1, y2, x1, x2;
		if (a != 0) {
			y1 = s.getyMax();
			y2 = s.getyMin();
			x1 = (-y1 * b - c) / a;
			x2 = (-y2 * b - c) / a;
		} else {
			y1 = -c / b;
			y2 = -c / b;
			x1 = s.getxMin();
			x2 = s.getxMax();
		}
		fold.add(LocationChanger.Xto(x1), LocationChanger.Yto(y1));
		fold.add(LocationChanger.Xto(x2), LocationChanger.Yto(y2));

	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

}
