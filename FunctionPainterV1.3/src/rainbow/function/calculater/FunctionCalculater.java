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
	private Function f;

	public FunctionCalculater(Function f) {
		this.f=f;
		fpp = new FunctionPointsPainter(f);
		new FunctionCalculaterThread(f,fpp,1).start();
		new FunctionCalculaterThread(f,fpp,2).start();
		new FunctionCalculaterThread(f,fpp,3).start();
		new FunctionCalculaterThread(f,fpp,4).start();
	}
}
