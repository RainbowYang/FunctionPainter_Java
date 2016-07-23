package rainbow.function.calculater;

import rainbow.function.Function;
/**
 * 函数计算 用于创建四个线程
 * @author Rainbow_Yang
 *
 */
public class FunctionCalculater {
	@SuppressWarnings("unused")
	private Function f;

	public FunctionCalculater(Function f) {
		this.f = f;
		new FunctionCalculaterThread1(f).run();
		new FunctionCalculaterThread2(f).run();
		new FunctionCalculaterThread3(f).run();
		new FunctionCalculaterThread4(f).run();
	}

}
