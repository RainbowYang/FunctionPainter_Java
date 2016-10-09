package rainbow.system;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.io.PrintStream;

import rainbow.frame.MainFrame;
import rainbow.function.tools.ColorGetter;
import rainbow.system.tools.LocationChanger;

/**
 * 坐标系
 * 
 * @author Rainbow Yang
 *
 */
public class System {

	// 由于类名冲突 引用java.lang.System
	// 保证外部无需加前缀
	public static final PrintStream out = java.lang.System.out;

	public static long currentTimeMillis() {
		return java.lang.System.currentTimeMillis();
	}

	private int width = MainFrame.width;
	private int height = MainFrame.height;
	// 表示原点在MainFrame中的坐标
	private int x = width / 2;
	private int y = height / 2;

	// 是否显示网格
	private boolean hasBlock = true;
	// 初始网格长宽
	private int blockWidth = 40;
	private int blockHeight = 40;
	// x轴y轴宽度
	private int XYWidth = 4;

	private Color colorOfBack = ColorGetter.getColor("dcedc8");
	private Color colorOfBlock = ColorGetter.getColor();
	private Color colorOfO = ColorGetter.getColor();
	private Color colorOfNum = ColorGetter.getColor();
	private Color colorOfXY = ColorGetter.getColor();

	private int ArrowLength = 40;
	private double ArrowAngle = Math.PI / 6;

	private double theAdd = 1.0 / blockWidth * 10;

	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private int xIntMax;
	private int xIntMin;
	private int yIntMax;
	private int yIntMin;

	// 单例
	private static System system;

	public static void createSystem() {
		if (system == null)
			system = new System();
		system.reXY();
	}

	public static System getSystem() {
		return system;
	}

	private System() {
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
	 * 移动坐标系
	 * 
	 * @param x
	 *            中心位于坐标系的x位置
	 * @param y
	 *            中心位于坐标系的y位置
	 */
	public void moveTo(double x, double y) {
		this.x = LocationChanger.Xto(-x);
		this.y = LocationChanger.Yto(-y);
	}

	/**
	 * 调整System的Width和Height
	 */
	public void reWidthAndHeight() {
		width = MainFrame.getWidth() - MainFrame.box.getMaxWidth();
		height = MainFrame.getHeight() - MainFrame.box.getMaxHeight();

		reO();
		reXY();
	}

	/**
	 * 调整xy的最值
	 */
	private void reXY() {
		xMax = LocationChanger.toX(width);
		xMin = LocationChanger.toX(0);
		yMax = LocationChanger.toY(0);
		yMin = LocationChanger.toY(height);

		xIntMax = (int) xMax;
		xIntMin = (int) xMin;
		yIntMax = (int) yMax;
		yIntMin = (int) yMin;
	}

	/**
	 * 用于滚轮调整大小
	 * 
	 * @param add
	 *            来自滚轮
	 */
	public void reset(MouseWheelEvent e) {

		double x = LocationChanger.toX(e.getX() - 26);
		double y = LocationChanger.toY(e.getY() - 40);
		moveTo(-x, -y);

		int add = -e.getWheelRotation();
		if (blockWidth >= 1 || add > 0) {
			blockWidth += add;
			if (blockWidth > 60) {
				for (int i = (blockWidth - 60) / 10; i > 0; i--) {
					if (add > 0)
						blockWidth++;
					else
						blockWidth--;
				}
			}
			setBlockHeight(blockWidth);
			theAdd = 1.0 / blockWidth;

			moveTo(x, y);

			reXY();
		}
	}

	/**
	 * 调整圆心位置
	 * 
	 * @param x
	 *            来自鼠标
	 * @param y
	 *            来自鼠标
	 */
	public void resetO(int x, int y) {
		this.x = x;
		this.y = y;
		reXY();
	}

	public int getX() {
		return x;
	}

	public System setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public System setY(int y) {
		this.y = y;
		return this;
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

	public double getxMax() {
		return xMax;
	}

	public double getxMin() {
		return xMin;
	}

	public double getyMax() {
		return yMax;
	}

	public double getyMin() {
		return yMin;
	}

	public int getxIntMax() {
		return xIntMax;
	}

	public int getxIntMin() {
		return xIntMin;
	}

	public int getyIntMax() {
		return yIntMax;
	}

	public int getyIntMin() {
		return yIntMin;
	}

	public boolean hasBlock() {
		return hasBlock;
	}

	public void setHasBlock(boolean hasBlock) {
		this.hasBlock = hasBlock;
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

	public int getXYWidth() {
		return XYWidth;
	}

	public void setXYWidth(int xYWidth) {
		XYWidth = xYWidth;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Color getColorOfBack() {
		return colorOfBack;
	}

	public void setColorOfBack(Color colorOfBack) {
		this.colorOfBack = colorOfBack;
	}

}
