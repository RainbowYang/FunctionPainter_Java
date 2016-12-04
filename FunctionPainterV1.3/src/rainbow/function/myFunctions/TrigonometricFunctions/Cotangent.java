package rainbow.function.myFunctions.TrigonometricFunctions;

public class Cotangent extends TrigonometricFunction {

	public Cotangent(double a, double w, double f) {
		super(a, w, f);
	}

	public Cotangent(double a, double w) {
		super(a, w);
	}

	{
		init(x -> {
			return Math.cos(x) / Math.sin(x);
		});
	}

}
