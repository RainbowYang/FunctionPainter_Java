package rainbow.coordinate.dimension._2D.axes;

import java.awt.Color;

import rainbow.GUI.frame.MainFrameController;
import rainbow.coordinate.dimension._2D.CoordinateSystemOf2D;
import rainbow.tools.ColorGetter;

public class AxesCoordinateSystem extends CoordinateSystemOf2D<Axes> {
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
		init();
	}

	@Override
	protected void init() {
		getter = new AxesCoordinateSystemLocationGettter(this);
		painter = new AxesCoordinateSystemPainter(this);

	}

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

}
