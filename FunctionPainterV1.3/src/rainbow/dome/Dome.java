package rainbow.dome;

import java.math.BigDecimal;

/*
 * 函数测试类
 */
public class Dome {
	public static void main(String[] args) {

		int a = 8;
		int b = 3;
		double c_chu_a = new BigDecimal(a).divide(new BigDecimal(b)).doubleValue();
		System.out.println(Math.sqrt(c_chu_a));
	}
}
