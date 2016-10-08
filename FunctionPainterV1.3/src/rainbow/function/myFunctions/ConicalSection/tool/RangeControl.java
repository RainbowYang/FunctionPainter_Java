package rainbow.function.myFunctions.ConicalSection.tool;

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
		if (xMax <= xMin || yMax <= yMin) {
			System.out.println("范围错误" + xMax + "..." + xMin + "..." + yMax + "..." + yMin + "...");
			return;
		}
		System.out.println(xMax + "..." + xMin + "..." + yMax + "..." + yMin);
		calculate();
	}

	private void calculate() {

		double yAtXMax = f.apply(xMax);
		double yAtXMin = f.apply(xMin);
		double xAtYMax = oppF.apply(yMax);
		double xAtYMin = oppF.apply(yMin);
		System.out.println(f + "" + yAtXMax + "..." + yAtXMin + "..." + xAtYMax + "..." + xAtYMin);

		if (yMax <= 0) {
			return;
		} else if (yMax > 0 && yMin < 0) {
			if (xMax < 0) {
				if (yAtXMax > yMax) {
					return;
				} else {
					max = xMax;
					min = -xAtYMax;
				}
			} else if (xMin > 0) {
				if (yAtXMin > yMax) {
					return;
				} else {
					min = xMin;
					max = xAtYMax;
				}
			} else {
				min = xMin;
				max = xMax;
				if (yAtXMin > yMax) {
					min = -xAtYMax;
				}

				if (yAtXMax > yMax) {
					max = xAtYMax;
				}
			}
		} else if (yMin >= 0) {
			if (xMax < 0) {
				if (yAtXMax >= yMax) {
					return;
				} else if (yAtXMax > yMin) {
					max = xMax;
					min = xMin;
					if (yAtXMin > yMax)
						min = -xAtYMax;
				} else {
					if (yAtXMin > yMax) {
						min = -xAtYMax;
						max = -xAtYMin;
					} else if (yAtXMin > yMin) {
						min = xMin;
						max = -xAtYMin;
					} else {
						return;
					}
				}

			} else if (xMin > 0) {
				if (yAtXMin >= yMax) {
					return;
				} else if (yAtXMin <= yMin) {
					if (yAtXMax < yMin) {
						return;
					} else if (yAtXMax >= yMax) {
						min = xAtYMin;
						max = xAtYMax;
					} else {
						min = xAtYMin;
					}
				} else {
					if (yAtXMax > yMax) {
						min = xMin;
						max = xAtYMax;
					} else {
						min = xMin;
						max = xMax;
					}
				}
			} else {
				min = xMin;
				max = xMax;
				if (yAtXMin > yMax) {
					min = -xAtYMax;
				}

				if (yAtXMax > yMax) {
					max = xAtYMax;
				}
				if (yAtXMax < yMin && yAtXMin < yMin) {
					return;
				}
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
