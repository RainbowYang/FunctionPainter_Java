package rainbow.function.painter.part2;

import java.util.List;

import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;
import rainbow.number.FenShu;
import rainbow.number.PointOfFenShu;
import rainbow.setting.Setting;
import rainbow.tools.MyMath;

public class XYSpecialPainter {

	public XYSpecialPainter(Function f, String[] parts) {
		paintImg(f, parts);
	}

	public void paintImg(Function f, String[] parts) {

		// a*x^m+b*y*n=0
		int a = Integer.parseInt(parts[0].substring(0, parts[0].indexOf("*")));
		int m = Integer.parseInt(parts[0].substring(parts[0].indexOf("^") + 1));
		int b = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("*")));
		int n = Integer.parseInt(parts[1].substring(parts[1].indexOf("^") + 1));

		FunctionPointsPainter fpp = new FunctionPointsPainter(f);
		List<PointOfFenShu> points = f.getPoints();

		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		double Fu_a_chu_b = -a / b;

		for (FenShu x = Setting.xMin; x.intValue() < Setting.xIntMax + 1; x = x.add(theAdd)) {

			double g = x.pow(m).doubleValue() * Fu_a_chu_b;
			if (n % 2 == 0) {
				if (g >= 0) {
					FenShu y = new FenShu(MyMath.pow(g, 1.0 / n));
					points.add(new PointOfFenShu(x, y));
					points.add(new PointOfFenShu(x, y.getFuFenShu()));
				}
			} else {
				FenShu y = new FenShu(MyMath.pow(g, 1.0 / n));
				points.add(new PointOfFenShu(x, y));
			}

		}

		double Fu_b_chu_a = -b / a;
		for (FenShu y = Setting.yMin; y.intValue() < Setting.yIntMax + 1; y = y.add(theAdd)) {
			double g = y.pow(n).doubleValue() * Fu_b_chu_a;
			if (m % 2 == 0) {
				if (g >= 0) {
					FenShu x = new FenShu(MyMath.pow(g, 1.0 / m));
					points.add(new PointOfFenShu(x, y));
					points.add(new PointOfFenShu(x.getFuFenShu(), y));
				}
			} else {
				FenShu x = new FenShu(MyMath.pow(g, 1.0 / m));
				points.add(new PointOfFenShu(x, y));
			}
		}
		f.setHasPoints();
		fpp.tryToAddImg();
		System.out.println("函数图像生成");
	}
}
