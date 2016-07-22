package rainbow.function;

import java.awt.Image;
import java.util.ArrayList;
import java.util.function.BinaryOperator;

import rainbow.number.FenShu;
import rainbow.painter.FunctionPainterForFunction;
import rainbow.setting.Setting;

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

	private Image ImageOfFunction;

	public Function(String function) {
		System.out.println("函数:" + function + " 正在生成");
		this.function = function;
		this.usableFunciton = new FunctionReader().read(function);
		System.out.println("函数:" + function + " 生成完毕");

		System.out.println("函数图片正在生成");
		System.out.println("这需要一点时间");
		//速度过慢，之后用线程改进。
		this.ImageOfFunction = FunctionPainterForFunction.getFunctionImage(this);
		System.out.println("函数图片生成完毕");
	}

	public Image getImageOfFunction() {
		return ImageOfFunction;
	}

	public FenShu getValue(FenShu x, FenShu y) {
		return this.usableFunciton.apply(x, y);
	}

	// 本方法暴力求解 用循环尝试取得零点 日后改进
	public ArrayList<FenShu> getY(FenShu x) {

		FenShu y = Setting.yMin;
		FenShu theAdd = new FenShu(1, Setting.blockHeight);
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
