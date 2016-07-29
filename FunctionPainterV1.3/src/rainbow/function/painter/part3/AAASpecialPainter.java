package rainbow.function.painter.part3;

import rainbow.function.Function;

public class AAASpecialPainter {

	public AAASpecialPainter(Function f, String[] parts, int mode) {
		paintImg(f, parts, mode);
	}

	public void paintImg(Function f, String[] parts, int mode) {
		// a*x^m+b*x^n+c*x^q=0 -> a*x(m-q)+b*x^(n-q)+c=0
		int a = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("*")));
		int m = Integer.parseInt(parts[0].substring(parts[0].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("*")));
		int n = Integer.parseInt(parts[1].substring(parts[1].indexOf("^") + 1));
		int c = Integer.parseInt(parts[2].substring(0, parts[2].indexOf("*")));
		int q = Integer.parseInt(parts[2].substring(parts[2].indexOf("^") + 1));

		switch (mode) {
		case 0:
			parts[0] = a + "*x^" + (m - q);
			parts[1] = b + "*x^" + (n - q);
			parts[2] = c + "";

			break;
		case 1:
			parts[0] = a + "";
			parts[1] = b + "*y^" + (n - m);
			parts[2] = c + "*y^" + (q - m);

			break;
		}
		new AAOSpecialPainter(f, parts, mode);
	}
}
