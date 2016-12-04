package rainbow.function.myFunctions.TrigonometricFunctions;

public class Sine extends TrigonometricFunction {

	/**
	 * y=a*sin(wx)<br>
	 * 对应下面的参数
	 * 
	 * @param a
	 * @param w
	 */
	public Sine(double a, double w) {
		super(a, w);
	}

	/**
	 * y=a*sin(wx+f)<br>
	 * 对应下面的参数
	 * 
	 * @param a
	 * @param w
	 * @param f
	 */
	public Sine(double a, double w, double f) {
		super(a, w, f);
	}

	{
		init(Math::sin);
	}
}
