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
public class FunctionCalculaterThread4 extends Thread {
	private FunctionKeyGettter fkg;
	private Function f;
	private ArrayList<PointOfFenShu> ps = new ArrayList<>();

	public FunctionCalculaterThread4(Function f) {
		this.f = f;
		this.fkg = new FunctionKeyGettter(this.f.getUsableFunciton());
	}

	@Override
	public void run() {
		System.out.println("4-start");
		getPoints();
		f.is4 = true;
		f.points.addAll(ps);
		MainFrame.mainFrame.add(new AllPainter());
		MainFrame.mainFrame.repaint();
		System.out.println("4-finished");
	}

	public void getPoints() {
		int xIntMax = Setting.xIntMax;
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		for (FenShu x = new FenShu(); x.intValue() < xIntMax + 1; x = x.add(theAdd)) {
			ArrayList<FenShu> ys = fkg.getDownY(x);
			for (FenShu y : ys) {
				ps.add(new PointOfFenShu(x, y));
			}
		}
	}
}
