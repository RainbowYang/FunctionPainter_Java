package rainbow.function.tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import rainbow.function.FunctionPoint;
import rainbow.system.System;

/**
 * 用于MyFunction通过一些点来描绘一些折线
 * 
 * @author Rainbow Yang
 *
 */
public class FoldLine {

	private List<FunctionPoint> points = new ArrayList<>();

	private System s = System.getSystem();

	private int width = 0;

	public FoldLine() {
	}

	/**
	 * @param point
	 *            第一个点
	 */
	public FoldLine(double x, double y) {
		add(x, y);
	}

	/**
	 * 添加一个点
	 * 
	 * @param x
	 *            点的横坐标
	 * @param y
	 *            点的纵坐标
	 */
	public void add(double x, double y) {
		points.add(new FunctionPoint(x, y));
	}

	/**
	 * 删除一个点
	 * 
	 * @param point
	 */
	public void remove(FunctionPoint point) {
		points.remove(point);
	}

	/**
	 * 清除所有点
	 */
	public void clear() {
		points.clear();
	}

	/**
	 * 以period进行左右平移画出周期函数<br>
	 * 用于周期函数 只需画出一个周期
	 * 
	 * @param g
	 *            所需的Graphics画笔
	 * @param period
	 *            横向移动周期
	 */
	public void paintToAll(Graphics g, double period) {
		if (points.isEmpty() || points.size() == 1) {
			return;
		}
		double x = 0;

		for (; x > s.getxMin() - period && x < s.getxMax() + period; x -= period) {
			paintLine(g, x, 0);
		}
		for (x = 0; x < s.getxMax() + period && x > s.getxMin() - period; x += period) {
			paintLine(g, x, 0);
		}

	}

	/**
	 * 以目前所有的点 依次连接 划线
	 * 
	 * @param g
	 *            所需的Graphics画笔
	 */
	public void paintLine(Graphics g) {
		paintLine(g, 0, 0);
	}

	/**
	 * 以目前所有的点 依次连接 划线<br>
	 * 同时将其平移x和y
	 * 
	 * @param g
	 *            所需的Graphics画笔
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 */
	public void paintLine(Graphics g, double x, double y) {
		if (points.isEmpty() || points.size() == 1) {
			return;
		}

		FunctionPoint lastPoint = points.get(0);
		int lastX = lastPoint.getRealX(x);
		int lastY = lastPoint.getRealY(y);

		BufferedImage img = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics gg = img.getGraphics();

		for (int i = 1; i < points.size(); i++) {
			FunctionPoint point = points.get(i);
			g.drawLine(lastX, lastY, lastX = point.getRealX(x), lastY = point.getRealY(y));
		}

		paintBiger(gg, img);

	}

	// 以width(默认为1)进行上下左右的移动
	private void paintBiger(Graphics g, Image img) {

		for (int x = -width; x <= width; x++) {
			for (int y = -width; y <= width; y++) {
				g.drawImage(img, 0, 0, null);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
