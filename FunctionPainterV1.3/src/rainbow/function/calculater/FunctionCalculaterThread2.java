package rainbow.function.calculater;

import java.util.ArrayList;

import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;
import rainbow.number.FenShu;
import rainbow.number.PointOfFenShu;
import rainbow.setting.Setting;

/**
 * 用计算的线程 共分为四种 分别用于计算四个象限。
 * 
 * @author Rainbow_Yang
 *
 */
public class FunctionCalculaterThread2 extends Thread {
	private Function f;
	private ArrayList<PointOfFenShu> ps = new ArrayList<>();
	private FunctionPointsPainter fpp;

	public FunctionCalculaterThread2(Function f, FunctionPointsPainter fpp) {
		this.f = f;
		this.fpp = fpp;
	}

	@Override
	public void run() {
		System.out.println("2-start");
		getPoints();
		System.out.println("2-finished");
		f.setFinishedThread2();
		fpp.tryToAddImg();
	}

	public void getPoints() {
		int xIntMin = Setting.xIntMin;
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		for (FenShu x = new FenShu(); x.intValue() > xIntMin - 1; x = x.subtract(theAdd)) {
			ArrayList<FenShu> ys = f.getUpY(x);
			for (FenShu y : ys) {
				ps.add(new PointOfFenShu(x, y));
			}
		}
	}
}
