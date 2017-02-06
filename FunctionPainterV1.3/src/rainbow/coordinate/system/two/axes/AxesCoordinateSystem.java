package rainbow.coordinate.system.two.axes;

import java.awt.Color;
import java.awt.Point;

import rainbow.GUI.frame.MainFrameController;
import rainbow.coordinate.system.two.CoordinateSystemOf2D;
import rainbow.tools.ColorGetter;

/**
 * 轴坐标系
 * 
 * @author Rainbow Yang
 *
 */
public class AxesCoordinateSystem extends CoordinateSystemOf2D {
	private int width = MainFrameController.getWidth();
	private int height = MainFrameController.getHeight();

	// 表示原点在MainFrame中的坐标
	private int x = width / 2;
	private int y = height / 2;

	// 两坐标轴的夹角
	private double angle = Math.PI / 2;

	// 是否显示网格
	private boolean hasBlock = true;
	// 初始网格长宽
	private int blockWidth = 40;
	private int blockHeight = 40;
	// x轴y轴宽度
	private int XYWidth = 4;

	private Color colorOfBlock = ColorGetter.getColor();
	private Color colorOfO = ColorGetter.getColor();
	private Color colorOfNum = ColorGetter.getColor();
	private Color colorOfXY = ColorGetter.getColor();

	private int ArrowLength = 40;
	private double ArrowAngle = Math.PI / 6;

	// 画函数时每隔多少的像素进行计算
	private double fineness = 2.0;
	private double theAdd = fineness / blockWidth;

	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private int xIntMax;
	private int xIntMin;
	private int yIntMax;
	private int yIntMin;

	public AxesCoordinateSystem() {
		super();

		reO();
		reXY();
	}

	@Override
	protected void initForLocationGetter() {
		getter = new AxesCoordinateSystemLocationGetter(this);
	}

	@Override
	protected void initForPainter() {
		painter = new AxesCoordinateSystemPainter(this);
	}

	/**
	 * 使原点回到SystemImage中心
	 */
	public void reO() {
		this.x = width / 2;
		this.y = height / 2;
	}

	/**
	 * 用于缩放时调整原点位置
	 * 
	 * @param x
	 * @param y
	 */
	public void setO(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 调整xy的最值
	 */
	private void reXY() {
		xMax = ((PointOfAxes) (toSystem(new Point(width, 0)))).getX();
		xMin = ((PointOfAxes) (toSystem(new Point(0, 0)))).getX();
		yMax = ((PointOfAxes) (toSystem(new Point(0, 0)))).getY();
		yMin = ((PointOfAxes) (toSystem(new Point(0, height)))).getY();

		xIntMax = (int) xMax + 1;
		xIntMin = (int) xMin - 1;
		yIntMax = (int) yMax + 1;
		yIntMin = (int) yMin - 1;
	}

	// /**
	// * 移动坐标系
	// *
	// * @param x
	// * 中心位于坐标系的x位置
	// * @param y
	// * 中心位于坐标系的y位置
	// */
	// public void moveTo(double x, double y) {
	// this.x = LocationChanger.Xto(-x);
	// this.y = LocationChanger.Yto(-y);
	// }
	//
	// /**
	// * 调整System的Width和Height
	// */
	// public void reWidthAndHeight() {
	// width = MainFrame.getWidth();
	// height = MainFrame.getHeight();
	//
	// reO();
	// reXY();
	// }
	//
	//
	//
	// /**
	// * 用于滚轮调整大小
	// *
	// * @param add
	// * 来自滚轮
	// */
	// public void reset(MouseWheelEvent e) {
	//
	// int add = -e.getWheelRotation();
	//
	// if (blockWidth >= 1 || add > 0) {
	//
	// // 控制缩放中心为鼠标所在位置
	// double x = LocationChanger.toX(e.getX());// 皮肤导致的
	// double y = LocationChanger.toY(e.getY());// 同上
	// moveTo(-x, -y);
	//
	// blockWidth += add;
	// if (blockWidth > 60) {
	// for (int i = (blockWidth - 60) / 10; i > 0; i--) {
	// if (add > 0)
	// blockWidth++;
	// else
	// blockWidth--;
	// }
	// }
	// setBlockHeight(blockWidth);
	// theAdd = 1.0 / blockWidth;
	//
	// moveTo(x, y);
	//
	// reXY();
	//
	// }
	// }
	//
	// /**
	// * 调整圆心位置
	// *
	// * @param x
	// * 来自鼠标
	// * @param y
	// * 来自鼠标
	// */
	// public void resetO(int x, int y) {
	// this.x = x;
	// this.y = y;
	// reXY();
	// }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public int getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}

	public boolean hasBlock() {
		return hasBlock;
	}

	public void setHasBlock(boolean hasBlock) {
		this.hasBlock = hasBlock;
	}

	public int getXYWidth() {
		return XYWidth;
	}

	public void setXYWidth(int xYWidth) {
		XYWidth = xYWidth;
	}

	public Color getColorOfBlock() {
		return colorOfBlock;
	}

	public void setColorOfBlock(Color colorOfBlock) {
		this.colorOfBlock = colorOfBlock;
	}

	public Color getColorOfO() {
		return colorOfO;
	}

	public void setColorOfO(Color colorOfO) {
		this.colorOfO = colorOfO;
	}

	public Color getColorOfNum() {
		return colorOfNum;
	}

	public void setColorOfNum(Color colorOfNum) {
		this.colorOfNum = colorOfNum;
	}

	public Color getColorOfXY() {
		return colorOfXY;
	}

	public void setColorOfXY(Color colorOfXY) {
		this.colorOfXY = colorOfXY;
	}

	public int getArrowLength() {
		return ArrowLength;
	}

	public void setArrowLength(int arrowLength) {
		ArrowLength = arrowLength;
	}

	public double getArrowAngle() {
		return ArrowAngle;
	}

	public void setArrowAngle(double arrowAngle) {
		ArrowAngle = arrowAngle;
	}

	public double getTheAdd() {
		return theAdd;
	}

	public void setTheAdd(double theAdd) {
		this.theAdd = theAdd;
	}

	public double getxMax() {
		return xMax;
	}

	public void setxMax(double xMax) {
		this.xMax = xMax;
	}

	public double getxMin() {
		return xMin;
	}

	public void setxMin(double xMin) {
		this.xMin = xMin;
	}

	public double getyMax() {
		return yMax;
	}

	public void setyMax(double yMax) {
		this.yMax = yMax;
	}

	public double getyMin() {
		return yMin;
	}

	public void setyMin(double yMin) {
		this.yMin = yMin;
	}

	public int getxIntMax() {
		return xIntMax;
	}

	public void setxIntMax(int xIntMax) {
		this.xIntMax = xIntMax;
	}

	public int getxIntMin() {
		return xIntMin;
	}

	public void setxIntMin(int xIntMin) {
		this.xIntMin = xIntMin;
	}

	public int getyIntMax() {
		return yIntMax;
	}

	public void setyIntMax(int yIntMax) {
		this.yIntMax = yIntMax;
	}

	public int getyIntMin() {
		return yIntMin;
	}

	public void setyIntMin(int yIntMin) {
		this.yIntMin = yIntMin;
	}

	public int getHeight() {
		return MainFrameController.getHeight();
	}

	public int getWidth() {
		return MainFrameController.getWidth();
	}
}
