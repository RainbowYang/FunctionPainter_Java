package rainbow.function.myFunctions.TrigonometricFunctions;

public class Cosine extends TrigonometricFunction {

	/**
	 * y=a*cos(wx)<br>
	 * 对应下面的参数
	 * 
	 * @param a
	 * @param w
	 */
	public Cosine(double a, double w) {
		super(a, w);
		init(Math::cos);
	}

	/**
	 * y=a*cos(wx+f)<br>
	 * 对应下面的参数
	 * 
	 * @param a
	 * @param w
	 * @param f
	 */
	public Cosine(double a, double w, double f) {
		super(a, w, f);
		init(Math::cos);
	}

}
