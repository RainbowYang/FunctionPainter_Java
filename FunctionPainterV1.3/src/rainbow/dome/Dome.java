package rainbow.dome;

import rainbow.function.Function;
import rainbow.number.FenShu;
import rainbow.setting.Setting;

/*
 * 函数测试类
 */
public class Dome {
	public static void main(String[] args) {

		Function f = new Function("1*x^1+10+5*y^1=0");
		int xIntMax = Setting.xIntMax;
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		for (FenShu x = Setting.xMin; x.intValue() < xIntMax; x = x.add(theAdd)) {
			System.out.println("当x=" + x + "时，y的值" + f.getY(x));
		}
		System.out.println("此方程的函数为" + f);

	}
}
