package rainbow.function.myFunctions.TrigonometricFunctions;

public class SinePowTwo extends TrigonometricFunction {

	{
		init(x -> {
			return Math.sin(x) * Math.sin(x);
		});
	}

	public SinePowTwo(double a, double w, double f) {
		super(a, w, f);
	}

	public SinePowTwo(double a, double w) {
		super(a, w);
	}

}
