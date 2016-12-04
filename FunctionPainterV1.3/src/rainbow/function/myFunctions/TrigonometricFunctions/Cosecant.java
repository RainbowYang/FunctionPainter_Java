package rainbow.function.myFunctions.TrigonometricFunctions;

public class Cosecant extends TrigonometricFunction {

	public Cosecant(double a, double w, double f) {
		super(a, w, f);
	}

	public Cosecant(double a, double w) {
		super(a, w);
	}

	{
		init(x -> {
			return 1 / Math.sin(x);
		});
	}
}
