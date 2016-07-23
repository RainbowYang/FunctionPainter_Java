package rainbow.function.calculater;

import rainbow.function.Function;

/**
 * 函数计算 用于创建四个线程
 * 
 * @author Rainbow_Yang
 *
 */
public class FunctionCalculater {

	public FunctionCalculater(Function f) {
		f.setCalculated(true);
		new FunctionCalculaterThread1(f).start();
		new FunctionCalculaterThread2(f).start();
		new FunctionCalculaterThread3(f).start();
		new FunctionCalculaterThread4(f).start();
	}

}
