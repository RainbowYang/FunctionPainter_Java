package rainbow.function.myFunctions.TrigonometricFunctions;

import java.awt.Graphics;
import java.util.function.Function;

import rainbow.function.myFunctions.MyFunction;
import rainbow.function.tools.FoldLine;

/**
 * 定义为所有三角函数的超类 并为其重写对应的paintImage <br>
 * as y=a*fun(wx+f)
 * 
 * @author Rainbow Yang
 * @see Sine
 * @see Cosine
 * @see Tangent
 * @see Cotangent
 * @see Secant
 * @see Cosecant
 */
public abstract class TrigonometricFunction extends MyFunction {

	protected final static double PI = Math.PI;

	protected double a;
	protected double w;
	protected double f;

	protected boolean inited;

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
		if (!inited) {
			function = (x) -> {
				return a * fun.apply(w * x + f);
			};
			inited = true;
		}
	}

	@Override
	public void paintImage(Graphics g) {
		g.setColor(color);

		double add = s.getTheAdd();
		double period = 2 * PI / w;
		

		//TODO
		switch (getClass().getSimpleName()) {
		case "Sine":
		case "SinePowTwo":
		case "Cosine":
			for (double x = 0; x < 2 * PI; x += add) {
				fold.add(x, function.apply(x));
			}
			fold.paintToAll(g, period);
			break;
		case "Tangent":
			for (double x = -PI / 2; x < PI / 2; x += add) {
				fold.add(x, function.apply(x));
			}
			fold.paintToAll(g, period / 2);
			break;
		case "Cotangent":
			for (double x = 0; x < PI; x += add) {
				fold.add(x, function.apply(x));
			}
			fold.paintToAll(g, period / 2);

			break;
		case "Secant":
			FoldLine fold2 = new FoldLine();

			for (double x = -PI / 2; x < PI / 2; x += add) {
				fold.add(x, function.apply(x));
			}
			for (double x = PI / 2 + add / 10; x < PI * 3 / 2; x += add) {
				fold2.add(x, function.apply(x));
			}
			fold.paintToAll(g, period);
			fold2.paintToAll(g, period);
			break;
		case "Cosecant":
			fold2 = new FoldLine();

			for (double x = 0; x < PI; x += add) {
				fold.add(x, function.apply(x));
			}
			for (double x = PI + add / 10; x < PI * 2; x += add) {
				fold2.add(x, function.apply(x));
			}
			fold.paintToAll(g, period);
			fold2.paintToAll(g, period);

		default:
			break;
		}
	}
}
