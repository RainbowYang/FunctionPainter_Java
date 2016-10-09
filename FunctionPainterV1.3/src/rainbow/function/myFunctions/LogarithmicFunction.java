package rainbow.function.myFunctions;

import java.awt.Graphics;
import java.util.function.Function;

import rainbow.function.tools.FoldLineForMyFunction;

/**
 * 对数函数 as y=a*log(n)x
 * 
 * @author Rainbow Yang
 *
 */
public class LogarithmicFunction extends MyFunction {

	private double a;
	private double n;
	private static final double E = Math.E;

	public LogarithmicFunction(double a, double n) {
		super();
		this.a = a;
		this.n = n;
		function = new Function<Double, Double>() {
			@Override
			public Double apply(Double x) {
				if (n == E) {
					return a * Math.log(x);
				} else if (n == 10) {
					return a * Math.log10(x);
				} else {
					return a * (Math.log10(x) / Math.log10(n));
				}
			}
		};
	}

	@Override
	public void paintImage(Graphics g) {

		if (a == 0 || s.getyMin() > 0)
			return;
		g.setColor(color);
		double mid = 0.5;
		double max = s.getxMax();
		if (a > 0) {
		} else if (a < 0) {
		}
		fold = new FoldLineForMyFunction();
		for (double x = 0; x <= mid; x += s.getTheAdd() / 4) {
			double y = function.apply(x);
			if (y > s.getyMax()) {
				break;
			}
			fold.add(x, y);
			System.out.println(x + "." + function.apply(x));
		}
		for (double x = mid; x <= max; x += s.getTheAdd()) {
			double y = function.apply(x);
			if (y > s.getyMax()) {
				break;
			}
			fold.add(x, y);
			System.out.println(x + "." + function.apply(x));
		}
		fold.paintLine(g);
	}

}
