package rainbow.function.tools;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import rainbow.function.FunctionPoint;

/**
 * 用于MyFunction通过一些点来描绘一些折线
 * 
 * @author Rainbow Yang
 *
 */
public class FoldLineForMyFunction {

	private List<FunctionPoint> points = new ArrayList<>();

	public FoldLineForMyFunction() {
	}

	/**
	 * @param point
	 *            第一个点
	 */
	public FoldLineForMyFunction(double x, double y) {
		add(x, y);
	}

	public void add(double x, double y) {
		points.add(new FunctionPoint(x, y));
	}

	public void remove(FunctionPoint point) {
		points.remove(point);
	}

	public void clear() {
		points.clear();
	}

	public void paintLine(Graphics g) {
		if (points.isEmpty() || points.size() == 1) {
			return;
		}

		FunctionPoint lastPoint = points.get(0);
		int lastX = lastPoint.getRealX();
		int lastY = lastPoint.getRealY();

		for (int x = 1; x < points.size(); x++) {
			FunctionPoint point = points.get(x);
			g.drawLine(lastX, lastY, lastX = point.getRealX(), lastY = point.getRealY());
		}
	}

}
