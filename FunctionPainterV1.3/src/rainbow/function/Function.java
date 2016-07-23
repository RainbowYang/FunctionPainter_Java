package rainbow.function;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

import rainbow.function.calculater.FunctionCalculater;
import rainbow.function.calculater.FunctionKeyGettter;
import rainbow.number.FenShu;
import rainbow.number.PointOfFenShu;

/**
 * Function类 用于存贮函数并提供计算
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class Function {

	private String function = null;

	private BinaryOperator<FenShu> usableFunciton;

	private ArrayList<PointOfFenShu> points;

	public boolean is1, is2, is3, is4;

	public Function(String function) {
		System.out.println("函数:" + function + " 正在生成");
		this.function = function;
		this.usableFunciton = new FunctionReader().read(function);
		System.out.println("函数:" + function + " 生成完毕");

		System.out.println("函数正在计算");
		System.out.println("这需要一点时间");
		new FunctionCalculater(this);

		// new FunctionPainterForFunctionThread1(this).start();
		// new FunctionPainterForFunctionThread2(this).start();
		// new FunctionPainterForFunctionThread3(this).start();
		// new FunctionPainterForFunctionThread4(this).start();
	}

	public ArrayList<PointOfFenShu> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<PointOfFenShu> points) {
		this.points = points;
	}

	public boolean isOk() {
		return is1 && is2 && is3 && is4;
	}

	public BinaryOperator<FenShu> getUsableFunciton() {
		return this.usableFunciton;
	}

	public FenShu getValue(FenShu x, FenShu y) {
		return this.usableFunciton.apply(x, y);
	}

	public ArrayList<FenShu> getY(FenShu x) {
		return new FunctionKeyGettter(this.usableFunciton).getY(x);
	}

	public ArrayList<FenShu> getUpY(FenShu x) {
		return new FunctionKeyGettter(this.usableFunciton).getUpY(x);
	}

	public ArrayList<FenShu> getDownY(FenShu x) {
		return new FunctionKeyGettter(this.usableFunciton).getDownY(x);
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