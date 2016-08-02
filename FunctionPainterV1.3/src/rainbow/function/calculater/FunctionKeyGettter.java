package rainbow.function.calculater;

import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

import rainbow.setting.Setting;

public class FunctionKeyGettter {
	private DoubleBinaryOperator usableFunciton;

	public FunctionKeyGettter(DoubleBinaryOperator usableFunciton) {
		this.usableFunciton = usableFunciton;
	}

	public double getValue(double x, double y) {
		return this.usableFunciton.applyAsDouble(x, y);
	}

	// 本方法暴力求解 用循环尝试取得零点 日后改进
	public ArrayList<Double> getY(double x) {

		double y = Setting.yMin;
		double theAdd = Setting.theAdd;
		double nowResult = this.getValue(x, y);
		boolean flag = nowResult >= 0;
		boolean thisfalg;
		double yMax = Setting.yMax;
		ArrayList<Double> ys = new ArrayList<>();
		for (y += theAdd; y < yMax; flag = thisfalg, y += theAdd) {
			nowResult = this.getValue(x, y);
			thisfalg = nowResult >= 0;
			if (nowResult == 0 || (thisfalg != flag)) {
				ys.add(y);
			}
		}
		return ys;
	}

	// 获取大于0的
	public ArrayList<Double> getUpY(double x) {

		double y = 0;
		double theAdd = Setting.theAdd;
		double nowResult = this.getValue(x, y);
		boolean flag = nowResult >= 0;
		boolean thisfalg;
		double yMax = Setting.yMax;

		ArrayList<Double> ys = new ArrayList<>();
		for (y += theAdd; y < yMax; flag = thisfalg, y += theAdd) {
			nowResult = this.getValue(x, y);
			thisfalg = nowResult >= 0;
			if (nowResult == 0 || (thisfalg != flag)) {
				ys.add(y);
			}
		}
		return ys;
	}

	// 获取小于0的
	public ArrayList<Double> getDownY(double x) {

		double y = 0;
		double theAdd = Setting.theAdd;
		double nowResult = this.getValue(x, y);
		boolean flag = nowResult >= 0;
		boolean thisfalg;
		double yMin = Setting.yMin;

		ArrayList<Double> ys = new ArrayList<>();
		for (y -= theAdd; y > yMin; flag = thisfalg, y -= theAdd) {
			nowResult = this.getValue(x, y);
			thisfalg = nowResult >= 0;
			if (nowResult == 0 || (thisfalg != flag)) {
				ys.add(y);
			}
		}
		return ys;
	}

}
