package rainbow.function.calculater;

import java.util.ArrayList;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.number.FenShu;
import rainbow.number.PointOfFenShu;
import rainbow.painter.AllPainter;
import rainbow.setting.Setting;

/**
 * 用计算的线程 共分为四种 分别用于计算四个象限。
 * 
 * @author Rainbow_Yang
 *
 */
public class FunctionCalculaterThread2 extends Thread {
	private FunctionKeyGettter fkg;
	private Function f;
	private ArrayList<PointOfFenShu> ps = new ArrayList<>();

	public FunctionCalculaterThread2(Function f) {
		this.f = f;
		this.fkg = new FunctionKeyGettter(this.f.getUsableFunciton());
	}

	@Override
	public void run() {
		System.out.println("2-start");
		getPoints();
		f.is2 = true;
		f.points.addAll(ps);
		MainFrame.mainFrame.add(new AllPainter());
		MainFrame.mainFrame.repaint();
		System.out.println("2-finished");
	}

	public void getPoints() {
		int xIntMin = Setting.xIntMin;
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		for (FenShu x = new FenShu(); x.intValue() > xIntMin - 1; x = x.subtract(theAdd)) {
			ArrayList<FenShu> ys = fkg.getUpY(x);
			for (FenShu y : ys) {
				ps.add(new PointOfFenShu(x, y));
			}
		}
	}
}
