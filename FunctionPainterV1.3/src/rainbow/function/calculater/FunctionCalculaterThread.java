package rainbow.function.calculater;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;
import rainbow.setting.Setting;

/**
 * 用计算的线程 共分为四种 分别用于计算四个象限。
 * 
 * @author Rainbow_Yang
 *
 */
public class FunctionCalculaterThread extends Thread {
	private Function f;
	private List<Point2D.Double> ps;
	private FunctionPointsPainter fpp;
	private int mode;

	public FunctionCalculaterThread(Function f, FunctionPointsPainter fpp, int mode) {
		this.ps = f.getPoints();
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
		System.out.println(f.getPoints());
		fpp.tryToAddImg();
	}

	public void getPoints() {
		double theAdd = Setting.theAdd;
		double xMax = Setting.xMax;
		double xMin = Setting.xMin;
		double x = 0;
		switch (mode) {
		case 1:
			for (; x < xMax + 1; x += theAdd) {
				ArrayList<Double> ys = f.getUpY(x);
				for (Double y : ys) {
					ps.add(new Point2D.Double(x, y));
				}
			}
			break;
		case 2:
			for (; x > xMin - 1; x -= theAdd) {
				ArrayList<Double> ys = f.getUpY(x);
				for (Double y : ys) {
					ps.add(new Point2D.Double(x, y));
				}
			}
			break;
		case 3:
			for (; x > xMin - 1; x -= theAdd) {
				ArrayList<Double> ys = f.getDownY(x);
				for (Double y : ys) {
					ps.add(new Point2D.Double(x, y));
				}
			}
			break;
		case 4:
			for (; x < xMax + 1; x += theAdd) {
				ArrayList<Double> ys = f.getDownY(x);
				for (Double y : ys) {
					ps.add(new Point2D.Double(x, y));
				}
			}
			break;
		}
	}
}