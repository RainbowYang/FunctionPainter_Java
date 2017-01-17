package rainbow.system;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import rainbow.system.tools.LocationChanger;;

/**
 * 
 * 背景图片
 * 
 * @author Rainbow_Yang
 * @version 1.3
 */
public class SystemImage {

	// 图片缓存
	private Image cacheImg = null;

	private static final SystemImage systemImage = new SystemImage();

	private System s = System.getSystem();

	/**
	 * @return 所需要的图片
	 */
	public static Image getImage() {
		return systemImage.cacheImg;
	}

	/**
	 * 重新绘制图片
	 */
	public static void repaint() {
		systemImage.repaint0();
	}

	private SystemImage() {
	}

	public void repaint0() {

		int Width = s.getWidth();
		int Height = s.getHeight();
		BufferedImage img = new BufferedImage(Width, Height, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();

		// 画空白背景
		g.setColor(s.getColorOfBack());
		g.fillRect(0, 0, Width, Height);

		// 判断是否画网格
		if (s.hasBlock()) {
			网格初始化(g);
		} else {
			坐标格点化(g);
		}
		坐标轴初始化(g);
		画原点(g);
		画数字(g);

		cacheImg = img;
	}

	private void 坐标格点化(Graphics g) {

		// 设置网格颜色
		g.setColor(s.getColorOfBlock());

		// 画网格
		// 画与x轴垂直的线
		for (int x = s.getxIntMin() - 1; x < s.getxIntMax() + 1; x++) {
			int Xto = LocationChanger.Xto(x);
			int yOfO = s.getY();
			g.drawLine(Xto, yOfO + 5, Xto, yOfO - 5);
		}

		// 画与y轴垂直的线
		for (int y = s.getyIntMin() - 1; y < s.getyIntMax() + 1; y++) {
			int Yto = LocationChanger.Yto(y);
			int xOfO = s.getX();
			g.drawLine(xOfO + 5, Yto, xOfO - 5, Yto);
		}
	}

	private void 网格初始化(Graphics g) {

		// 设置网格颜色
		g.setColor(s.getColorOfBlock());

		// 画网格
		// 画与x轴垂直的线
		for (int x = s.getxIntMin() - 1; x < s.getxIntMax() + 1; x++) {
			int xto = LocationChanger.Xto(x);
			// System.out.println(xto+"------");
			g.drawLine(xto, 0, xto, s.getHeight());
		}

		// 画与y轴垂直的线
		for (int y = s.getyIntMin() - 1; y < s.getyIntMax() + 1; y++) {
			int yto = LocationChanger.Yto(y);
			g.drawLine(0, yto, s.getWidth(), yto);
		}
	}

	private void 画数字(Graphics g) {
		g.setColor(s.getColorOfNum());
		int xMax = s.getxIntMax();
		int xMin = s.getxIntMin();
		int yMax = s.getyIntMax();
		int yMin = s.getyIntMin();

		// 画数字
		// 画x轴数字
		for (int x = xMin; x < xMax + 1; x++) {
			if (x != 0) {
				g.drawString(String.valueOf(x), LocationChanger.Xto(x), s.getY() + 18);
			}
		}

		// 画y轴数字
		for (int y = yMin; y < yMax + 1; y++) {
			if (y != 0) {
				g.drawString(String.valueOf(y), s.getX() - 15, LocationChanger.Yto(y) + 10);
			}
		}
	}

	private void 坐标轴初始化(Graphics g) {

		int x = s.getX();
		int y = s.getY();

		int width = s.getWidth()-16;
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

		// y轴箭头
		Polygon yp = new Polygon();
		yp.addPoint(x, 0);
		yp.addPoint(x + sinLength, cosLength);
		yp.addPoint(x, cosLength / 2);
		yp.addPoint(x - sinLength, cosLength);
		g.fillPolygon(yp);

		// x轴
		g.fillRect(0, y - widthOfXY / 2, width - cosLength / 3, widthOfXY);
		// y轴
		g.fillRect(x - widthOfXY / 2, cosLength / 3, widthOfXY, height);
	}

	private void 画原点(Graphics g) {
		g.setColor(s.getColorOfO());
		g.drawString("O", s.getX() - 15, s.getY() + 15);

	}
}
