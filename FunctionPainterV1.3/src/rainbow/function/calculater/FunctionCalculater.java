package rainbow.function.calculater;

import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;

/**
 * 函数计算 用于创建四个线程
 * 
 * @author Rainbow_Yang
 *
 */
public class FunctionCalculater {
	private FunctionPointsPainter fpp;

	public FunctionCalculater(Function f) {
		fpp = new FunctionPointsPainter(f);
		new FunctionCalculaterThread1(f,fpp).start();
		new FunctionCalculaterThread2(f,fpp).start();
		new FunctionCalculaterThread3(f,fpp).start();
		new FunctionCalculaterThread4(f,fpp).start();
	}

}
