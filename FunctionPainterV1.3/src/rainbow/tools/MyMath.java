package rainbow.tools;

public class MyMath {
	public static double pow(double a, double b) {
		if (a < 0) {
			return -Math.pow(-a, b);
		} else {
			return Math.pow(a, b);
		}
	}

	public static double sqrt(double a) {
		return Math.sqrt(a);
	}
}
