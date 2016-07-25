package rainbow.function.calculater;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

import rainbow.number.FenShu;
import rainbow.setting.Setting;

public class FunctionKeyGettter {
	private BinaryOperator<FenShu> usableFunciton;

	public FunctionKeyGettter(BinaryOperator<FenShu> usableFunciton) {
		this.usableFunciton = usableFunciton;
	}

	public FenShu getValue(FenShu x, FenShu y) {
		return this.usableFunciton.apply(x, y);
	}

	// 本方法暴力求解 用循环尝试取得零点 日后改进
	public ArrayList<FenShu> getY(FenShu x) {

		FenShu y = Setting.yMin;
		FenShu theAdd = Setting.theAdd;
		FenShu nowResult = this.getValue(x, y);
		boolean flag = nowResult.isBigerThanZero();
		boolean thisfalg;
		int yIntMax = Setting.yIntMax;

		ArrayList<FenShu> ys = new ArrayList<>();
		for (y = y.add(theAdd); y.intValue() < yIntMax + 1; flag = thisfalg, y = y.add(theAdd)) {
			nowResult = this.getValue(x, y);
			thisfalg = nowResult.isBigerThanZero();
			if (nowResult.getZi().intValue() == 0 || (thisfalg != flag)) {
				y.toSimple();

				ys.add(y);
			}
		}
		return ys;
	}

	// 获取大于0的
	public ArrayList<FenShu> getUpY(FenShu x) {

		FenShu y = new FenShu();
		FenShu theAdd = Setting.theAdd;
		FenShu nowResult = this.getValue(x, y);
		boolean flag = nowResult.isBigerThanZero();
		boolean thisfalg;
		int yIntMax = Setting.yIntMax;

		ArrayList<FenShu> ys = new ArrayList<>();
		for (y = y.add(theAdd); y.intValue() < yIntMax + 1; flag = thisfalg, y = y.add(theAdd)) {
			nowResult = this.getValue(x, y);
			thisfalg = nowResult.isBigerThanZero();
			if (nowResult.getZi().intValue() == 0 || (thisfalg != flag)) {
				y.toSimple();

				ys.add(y);
			}
		}
		return ys;
	}

	// 获取小于0的
	public ArrayList<FenShu> getDownY(FenShu x) {

		FenShu y = new FenShu();
		FenShu theAdd = new FenShu(1, Setting.blockHeight);
		FenShu nowResult = this.getValue(x, y);
		boolean flag = nowResult.isBigerThanZero();
		boolean thisfalg;
		int yIntMin = Setting.yIntMin;

		ArrayList<FenShu> ys = new ArrayList<>();
		for (y = y.subtract(theAdd); y.intValue() > yIntMin - 1; flag = thisfalg, y = y.subtract(theAdd)) {
			nowResult = this.getValue(x, y);
			thisfalg = nowResult.isBigerThanZero();
			if (nowResult.getZi().intValue() == 0 || (thisfalg != flag)) {
				y.toSimple();

				ys.add(y);
			}
		}
		return ys;
	}

}
