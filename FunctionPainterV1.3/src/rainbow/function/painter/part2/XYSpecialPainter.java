package rainbow.function.painter.part2;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.number.FenShu;
import rainbow.number.PointOfFenShu;
import rainbow.painter.AllPainter;
import rainbow.setting.Setting;

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

		FenShu x = Setting.xMin;
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		for (; x.intValue() < Setting.xIntMax + 1; x = x.add(theAdd)) {
			FenShu y = new FenShu(Math.pow((-a / b) * (x.pow(m).doubleValue()), 1 / n));
			f.points.add(new PointOfFenShu(x, y));
		}

		FenShu y = Setting.yMin;
		for (; y.intValue() < Setting.yIntMax + 1; y = y.add(theAdd)) {
			x = new FenShu(Math.pow((-a / b) * (y.pow(n).doubleValue()), 1 / m));
			f.points.add(new PointOfFenShu(x, y));
			f.points.add(new PointOfFenShu(x.getFuFenShu(), y));
		}
		f.setOk();
		f.setCalculated(true);
		MainFrame.mainFrame.add(new AllPainter());
		MainFrame.mainFrame.repaint();
		System.out.println("函数图像生成");
	}
}
