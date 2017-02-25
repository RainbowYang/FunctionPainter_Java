package rainbow.coordinate.system.two.axes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;

import rainbow.coordinate.system._abs.CoordinateSystem;
import rainbow.coordinate.system.two._comp.CoordinateSystemOf2DPainter;

public class AxesCoordinateSystemPainter extends CoordinateSystemOf2DPainter {

	AxesCoordinateSystem acs;
	AxesCoordinateSystem s = acs;

	public AxesCoordinateSystemPainter(CoordinateSystem cs) {
		super(cs);
		acs = (AxesCoordinateSystem) cs;
		s = acs;
	}

	@Override
	public Image getImage() {
		repaint();
		return cache;
	}

	public void repaint() {
//		changeToNewImage();

		// 判断是否画网格
//		if (s.hasBlock()) {
//			网格初始化(g);
//		}
		// else {
		// 坐标格点化(g);
		// }
		坐标轴初始化(g);
		// 画原点(g);
		// 画数字(g);
	}

	// private void 坐标格点化(Graphics g) {
	//
	// // 设置网格颜色
	// g.setColor(s.getColorOfBlock());
	//
	// // 画网格
	// // 画与x轴垂直的线
	// for (int x = s.getxIntMin() - 1; x < s.getxIntMax() + 1; x++) {
	// int Xto = LocationChanger.Xto(x);
	// int yOfO = s.getY();
	// g.drawLine(Xto, yOfO + 5, Xto, yOfO - 5);
	// }
	//
	// // 画与y轴垂直的线
	// for (int y = s.getyIntMin() - 1; y < s.getyIntMax() + 1; y++) {
	// int Yto = LocationChanger.Yto(y);
	// int xOfO = s.getX();
	// g.drawLine(xOfO + 5, Yto, xOfO - 5, Yto);
	// }
	// }

	private void 网格初始化(Graphics g) {

		// 设置网格颜色
		g.setColor(s.getColorOfBlock());

		// 画网格
		// 画与y轴平行的线
		for (int x = s.getxIntMin() - 1; x < s.getxIntMax() + 1; x++) {
			Point p1 = s.toReal(new PointOfAxes(x, s.getyIntMax()));
			Point p2 = s.toReal(new PointOfAxes(x, s.getyIntMin()));
			g.drawLine(p1.x, 0, p2.x, s.getHeight());
		}

		// 画与x轴平行的线
		for (int y = s.getyIntMin() - 1; y < s.getyIntMax() + 1; y++) {
			Point p = s.toReal(new PointOfAxes(0, y));
			g.drawLine(0, p.y, s.getWidth(), p.y);
		}
	}

	// private void 画数字(Graphics g) {
	// g.setColor(s.getColorOfNum());
	// int xMax = s.getxIntMax();
	// int xMin = s.getxIntMin();
	// int yMax = s.getyIntMax();
	// int yMin = s.getyIntMin();
	//
	// // 画数字
	// // 画x轴数字
	// for (int x = xMin; x < xMax + 1; x++) {
	// if (x != 0) {
	// g.drawString(String.valueOf(x), LocationChanger.Xto(x), s.getY() + 18);
	// }
	// }
	//
	// // 画y轴数字
	// for (int y = yMin; y < yMax + 1; y++) {
	// if (y != 0) {
	// g.drawString(String.valueOf(y), s.getX() - 15, LocationChanger.Yto(y) +
	// 10);
	// }
	// }
	// }

	private void 坐标轴初始化(Graphics g) {

		int y = s.getY();

		int width = s.getWidth() - 16;
		int height = s.getHeight();

		int widthOfXY = s.getXYWidth();

		int arrowLength = s.getArrowLength();
		double arrowAngle = s.getArrowAngle();

		// 设置坐标轴颜色
		g.setColor(s.getColorOfXY());

		// 画箭头
		int cosLength = (int) (arrowLength * Math.cos(arrowAngle));
		int sinLength = (int) (arrowLength * Math.sin(arrowAngle));

		// x轴箭头
		Polygon xp = new Polygon();
		xp.addPoint(width, y);
		xp.addPoint(width - cosLength, y + sinLength);
		xp.addPoint(width - cosLength / 2, y);
		xp.addPoint(width - cosLength, y - sinLength);
		g.fillPolygon(xp);

		// x轴
		g.fillRect(0, y - widthOfXY / 2, width - cosLength / 3, widthOfXY);

		Point p = s.toReal(new PointOfAxes(s.getX(), s.getyMax()));
		System.out.println(p);
		int x = p.x;

		// y轴箭头
		Polygon yp = new Polygon();
		yp.addPoint(x, 0);
		yp.addPoint(x + sinLength, cosLength);
		yp.addPoint(x, cosLength / 2);
		yp.addPoint(x - sinLength, cosLength);
		g.fillPolygon(yp);

		// y轴
		g.fillRect(x - widthOfXY / 2, cosLength / 3, widthOfXY, height);
	}

	private void 画原点(Graphics g) {
		g.setColor(s.getColorOfO());
		g.drawString("O", s.getX() - 15, s.getY() + 15);

	}

}
