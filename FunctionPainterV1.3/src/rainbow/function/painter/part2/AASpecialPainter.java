package rainbow.function.painter.part2;

import rainbow.function.Function;

public class AASpecialPainter {

	public AASpecialPainter(Function f, String[] parts, int mode) {
		paintImg(f, parts, mode);
	}

	public void paintImg(Function f, String[] parts, int mode) {
		// a*x^q+b*x^p=0 ->a*x^(q-p)+b=0 或 b*y^p+a*y^q=0 -> b+a*y^(q-p)=0
		int a = Integer.parseInt(parts[mode].substring(0, parts[mode].indexOf("*")));
		int q = Integer.parseInt(parts[mode].substring(parts[mode].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1 - mode].substring(0, parts[1 - mode].indexOf("*")));
		int p = Integer.parseInt(parts[1 - mode].substring(parts[1 - mode].indexOf("^") + 1));

		int m = q - p;

		// 把AA转换为AO
		parts[mode] = a + "*" + (mode == 0 ? "x" : "y") + "^" + m;
		parts[1 - mode] = b + "";
		new AOSpecialPainter(f, parts, mode);
	}
}