package rainbow.function.functions.ConicalSection.tool;

import java.util.function.Function;

/**
 * 用于控制抛物线和双曲线的范围
 * 
 * @author Administrator
 *
 */
public class RangeControl {

	private Function<Double, Double> f;
	private Function<Double, Double> oppF;

	private double xMax, xMin, yMax, yMin;

	private double min, max;

	public RangeControl(Function<Double, Double> f, Function<Double, Double> oppF, double xMax, double xMin,
			double yMax, double yMin) {
		super();
		this.f = f;
		this.oppF = oppF;
		this.xMax = xMax;
		this.xMin = xMin;
		this.yMax = yMax;
		this.yMin = yMin;
		if (xMax >= xMin || yMax >= yMin) {
			System.out.println("范围错误");
			return;
		}
		calculate();
	}

	private void calculate() {

		if (yMax <= 0) {
			return;
		} else if (yMax > 0 && yMin < 0) {

			if (xMax < 0) {

				if (f.apply(xMax) > yMax) {
					return;
				} else {
					max = xMax;
					min = -oppF.apply(yMax);
				}

			} else if (xMin > 0) {
				if (f.apply(xMin) > yMax) {
					return;
				} else {
					min = xMin;
					max = oppF.apply(yMax);
				}

			} else {
				min = xMin;
				max = xMax;
				if (f.apply(xMin) > yMax) {
					min = -oppF.apply(yMax);
				}

				if (f.apply(xMax) > yMax) {
					max = oppF.apply(yMax);
				}

			}

		} else if (yMin >= 0) {
			if (xMax < 0) {

				// if (f.apply(xMax) > yMax) {
				// return;
				// } else {
				// max = xMax;
				// min = -oppF.apply(yMax);
				// }

			} else if (xMin > 0) {
				if (f.apply(xMin) >= yMax) {
					return;
				} else if (f.apply(xMin) <= yMin) {
					if (f.apply(xMax) < yMin) {
						return;
					} else if (f.apply(xMax) >= yMax) {
						min = oppF.apply(yMin);
						min = oppF.apply(yMax);
					} else {
						min = oppF.apply(yMin);
					}
				} else {

				}

			} else {
				// min = xMin;
				// max = xMax;
				// if (f.apply(xMin) > yMax) {
				// min = -oppF.apply(yMax);
				// }
				//
				// if (f.apply(xMax) > yMax) {
				// max = oppF.apply(yMax);
				// }

			}

		}

	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}
}
