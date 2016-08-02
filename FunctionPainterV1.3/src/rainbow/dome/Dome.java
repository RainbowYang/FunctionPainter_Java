package rainbow.dome;

import rainbow.function.Function;
import rainbow.function.FunctionReader;
import rainbow.function.calculater.FunctionKeyGettter;

/*
 * 测试类
 */
public class Dome {
	public static void main(String[] args) {
		Sweep();
	}

	private static void Sweep() {

		Function f = new Function();
		f.setFunction("1*x^1+1*y^1=0");
		f.setUsableFunciton(new FunctionReader().read(f));

		FunctionKeyGettter fkg = new FunctionKeyGettter(f.getUsableFunciton());
		fkg.getValue(1.0, 1.0);
	}

}
