package rainbow.function.myFunctions;

import java.awt.Graphics;
import java.util.function.Function;

import rainbow.function.tools.FoldLineForMyFunction;

/**
 * 指数函数 as y=ax^n
 * 
 * @author Rainbow Yang
 *
 */
public class ExponentialFunction extends MyFunction {

	// y=a*n^x
	private double a;
	private double n;

	public ExponentialFunction(double a, double n) {
		super();
		this.a = a;
		this.n = n;
		function = new Function<Double, Double>() {
			@Override
			public Double apply(Double x) {
				return a * Math.pow(n, x);
			}
		};
	}

	public ExponentialFunction() {
	}

	@Override
	public void paintImage(Graphics g) {
		if (a == 0)
			return;
		g.setColor(color);
		double min = s.getxMin();
		double max = s.getxMax();
		if (a > 0) {
		} else if (a < 0) {
		}
		fold = new FoldLineForMyFunction();
		for (double x = min; x <= max; x += s.getTheAdd()) {
			double y = function.apply(x);
			fold.add(x, y);
			// System.out.println(x + "." + function.apply(x));
		}
		fold.paintLine(g);
	}

}
