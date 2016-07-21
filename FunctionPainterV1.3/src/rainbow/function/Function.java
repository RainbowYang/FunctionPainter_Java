package rainbow.function;

import java.util.function.BinaryOperator;

import rainbow.number.FenShu;

public class Function {

	private String function = null;

	private BinaryOperator<FenShu> usableFunciton;

	public Function(String function) {
		long start = System.currentTimeMillis();
		this.function = function;
		this.usableFunciton = new FunctionReader().read(function);
		System.out.println(this.getValue(new FenShu(1), new FenShu(1)));
		System.out.println(System.currentTimeMillis() - start);
	}

	public FenShu getValue(FenShu x, FenShu y) {
		return this.usableFunciton.apply(x, y);
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
