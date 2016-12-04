package rainbow.function.myFunctions.TrigonometricFunctions;

public class Secant extends TrigonometricFunction {

	public Secant(double a, double w, double f) {
		super(a, w, f);
	}

	public Secant(double a, double w) {
		super(a, w);
	}

	{
		init(x -> {
			return 1 / Math.cos(x);
		});
	}
}
