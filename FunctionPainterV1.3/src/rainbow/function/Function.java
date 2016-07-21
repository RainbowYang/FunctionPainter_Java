package rainbow.function;

import rainbow.number.FenShu;

public class Function {

	private String function = null;

	private java.util.function.Function<FenShu[], FenShu> usableFunciton;

	public Function(String function) {
		this.function = function;
		this.usableFunciton = new FunctionReader().read(function);
	}

	public FenShu getValue(FenShu x, FenShu y) {
		FenShu[] d = { x, y };
		return this.usableFunciton.apply(d);
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
