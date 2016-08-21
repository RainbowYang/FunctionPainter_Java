package rainbow.function.calculater;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import rainbow.function.Function;
import rainbow.function.FunctionPointsPainter;
import rainbow.setting.Setting;

/**
 * 函数计算 用于创建四个线程
 * 
 * @author Rainbow_Yang
 *
 */
public class FunctionCalculater {
	private FunctionPointsPainter fpp;
	private Function f;

	public FunctionCalculater(Function f) {
		this.f = f;
		fpp = new FunctionPointsPainter(f);
		 new FunctionCalculaterThread(f, fpp, 1).start();
		 new FunctionCalculaterThread(f, fpp, 2).start();
		 new FunctionCalculaterThread(f, fpp, 3).start();
		 new FunctionCalculaterThread(f, fpp, 4).start();
//		getFirstPoints();
//		f.setHasPoints();
//		fpp.tryToAddImg();
	}

	private void getFirstPoints() {
		double ran = (Math.random() * (Setting.xIntMax - Setting.xIntMin) + Setting.xIntMin);

		System.out.println(ran);
		ArrayList<Double> ys = f.getY(ran);
		System.out.println(ys);
		
		if (!ys.isEmpty()) {
			for (double y : ys) {
				getPoint(ran, y);
			}
		} else {
			getFirstPoints();
		}
	}

	private void getPoint(double x, double y) {
		if (x > Setting.xMax || x < Setting.xMin || y > Setting.yMax || y < Setting.yMin) {
			f.getCalculatedPoints().add(new Point2D.Double(x, y));
			return;
		}
		if (!f.getCalculatedPoints().contains(x)) {
			double value = f.getValue(x, y);
			Point2D.Double point = new Point2D.Double(x, y);
			f.getCalculatedPoints().add(point);
			System.out.println(x + "---" + y + "---" + value);
			double theAdd = Setting.theAdd;
			if (value <= theAdd && value >= -theAdd) {
				f.getPoints().add(point);
				getPoint(x += theAdd, y += theAdd);
				getPoint(x, y += theAdd);
				getPoint(x -= theAdd, y += theAdd);
				getPoint(x += theAdd, y);
				getPoint(x -= theAdd, y);
				getPoint(x += theAdd, y -= theAdd);
				getPoint(x, y -= theAdd);
				getPoint(x -= theAdd, y -= theAdd);
			}
		}
	}

}
