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
public class FunctionCalculaterThread extends Thread {
	private Function f;
	private ArrayList<PointOfFenShu> ps = new ArrayList<>();
	private FunctionPointsPainter fpp;
	private int mode;

	public FunctionCalculaterThread(Function f, FunctionPointsPainter fpp, int mode) {
		this.f = f;
		this.fpp = fpp;
		this.mode = mode;
	}

	@Override
	public void run() {
		System.out.println(mode + "-start");
		getPoints();
		System.out.println(mode + "-finished");
		switch (mode) {
		case 1:
			f.setFinishedThread1();
			break;
		case 2:
			f.setFinishedThread2();
			break;
		case 3:
			f.setFinishedThread3();
			break;
		case 4:
			f.setFinishedThread4();
			break;
		}
		fpp.tryToAddImg();
	}

	public void getPoints() {
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		int xIntMax = Setting.xIntMax;
		int xIntMin = Setting.xIntMin;
		switch (mode) {
		case 1:
			for (FenShu x = new FenShu(); x.intValue() < xIntMax + 1; x = x.add(theAdd)) {
				ArrayList<FenShu> ys = f.getUpY(x);
				for (FenShu y : ys) {
					ps.add(new PointOfFenShu(x, y));
				}
			}
			break;
		case 2:
			for (FenShu x = new FenShu(); x.intValue() > xIntMin - 1; x = x.subtract(theAdd)) {
				ArrayList<FenShu> ys = f.getUpY(x);
				for (FenShu y : ys) {
					ps.add(new PointOfFenShu(x, y));
				}
			}
			break;
		case 3:
			for (FenShu x = new FenShu(); x.intValue() > xIntMin - 1; x = x.subtract(theAdd)) {
				ArrayList<FenShu> ys = f.getDownY(x);
				for (FenShu y : ys) {
					ps.add(new PointOfFenShu(x, y));
				}
			}
			break;
		case 4:
			for (FenShu x = new FenShu(); x.intValue() < xIntMax + 1; x = x.add(theAdd)) {
				ArrayList<FenShu> ys = f.getDownY(x);
				for (FenShu y : ys) {
					ps.add(new PointOfFenShu(x, y));
				}
			}
			break;
		}
	}
}