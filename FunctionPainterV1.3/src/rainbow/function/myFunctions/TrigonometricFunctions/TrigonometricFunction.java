package rainbow.function.myFunctions.TrigonometricFunctions;

import java.awt.Graphics;
import java.util.function.Function;

import rainbow.function.myFunctions.MyFunction;
import rainbow.function.tools.FoldLine;

/**
 * 定义为所有三角函数的超类 <br>
 * as y=a*fun(wx+f)
 * 
 * @author Rainbow Yang
 * @see Sine
 * @see Cosine
 *
 */
public abstract class TrigonometricFunction extends MyFunction {

	protected final static double PI = Math.PI;

	protected double a;
	protected double w;
	protected double f;

	protected TrigonometricFunction(double a, double w, double f) {
		this.a = a;
		this.w = w;
		this.f = f;
	}

	protected TrigonometricFunction(double a, double w) {
		this.a = a;
		this.w = w;
	}

	protected void init(Function<Double, Double> fun) {
		function = (x) -> {
			return a * fun.apply(w * x);
		};
	}

	@Override
	public void paintImage(Graphics g) {
		g.setColor(color);

		fold = new FoldLine();

		for (double x = 0; x < 2 * PI; x += s.getTheAdd() / w) {
			fold.add(x, function.apply(x));
		}
		fold.paintToAll(g, 2 * PI / w);
		// fold.paintLine(g);
	}
}
