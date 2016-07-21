package rainbow.function;

import java.util.function.BinaryOperator;

import rainbow.number.FenShu;
/**
 * Function类 
 * 用于存贮函数并提供计算
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class Function {

	private String function = null;

	private BinaryOperator<FenShu> usableFunciton;

	public Function(String function) {
		this.function = function;
		this.usableFunciton = new FunctionReader().read(function);
	}

	public FenShu getValue(FenShu x, FenShu y) {
		return this.usableFunciton.apply(x, y);
	}

	public FenShu getY(FenShu x) {

		FenShu y = new FenShu(-1000);

		FenShu lastResult = this.getValue(x, y);
		boolean flag = lastResult.isBigerThanZero();
		y = y.add(FenShu.ONE);
		FenShu nowResult = this.getValue(x, y);
		lastResult = nowResult.getFenShu();
		while (y.intValue() < 1000) {
			y = y.add(FenShu.ONE);

			nowResult = this.getValue(x, y);

			if (nowResult.isBigerThanZero() != flag) {
				return y;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return this.function;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Function other = (Function) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		return true;
	}

}
