package rainbow.function.myFunctions.TrigonometricFunctions;

public class Tangent extends TrigonometricFunction {

	public Tangent(double a, double w, double f) {
		super(a, w, f);
	}

	public Tangent(double a, double w) {
		super(a, w);
	}

	{
		init(x -> {
			return Math.sin(x) / Math.cos(x);
		});
	}

}
