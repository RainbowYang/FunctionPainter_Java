
package rainbow.dome;

import rainbow.function.Function;
import rainbow.number.FenShu;

/*
 * 函数测试类
 */
public class Dome {
	public static void main(String[] args) {
		
		Function f = new Function("5*x^1+10+5*y^1=0");
		int x = 10;
		System.out.println("当x=" + x + "时，y的值" + f.getY(new FenShu(x)));
		System.out.println("此方程的函数为" + f);
	}
}
