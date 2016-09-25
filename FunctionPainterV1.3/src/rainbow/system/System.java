package rainbow.system;

import java.io.PrintStream;

import rainbow.frame.MainFrame;
import rainbow.setting.Setting;
import rainbow.system.tools.LocationChanger;

/**
 * 坐标系
 * 
 * @author Rainbow Yang
 *
 */
public class System {

	// 由于类名冲突 引用java.lang.System.out
	// 保证外部正常输出 无需加前缀
	public static final PrintStream out = java.lang.System.out;

	// 表示原点在MainFrame中的坐标
	private int x = MainFrame.getWidth() / 2;
	private int y = MainFrame.getHeight() / 2;

	private boolean hasBlock = true;
	private int blockWidth = 40;
	private int blockHeight = 40;
	@SuppressWarnings("unused")
	private double theAdd;

	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private int xIntMax;
	private int xIntMin;
	private int yIntMax;
	private int yIntMin;

	public System() {
		reXY();
	}

	private void reXY() {
		xMax = LocationChanger.toX(MainFrame.getWidth());
		xMin = LocationChanger.toX(0);
		yMax = LocationChanger.toY(0);
		yMin = LocationChanger.toY(MainFrame.getHeight());

		xIntMax = (int) xMax;
		xIntMin = (int) xMin;
		yIntMax = (int) yMax;
		yIntMin = (int) yMin;
	}

	// 单例
	private static System system = new System();

	public static System getSystem() {
		return system;
	}

	public void reset(int add) {
		if (blockWidth >= 1 || add > 0) {
			blockWidth += add;
			if (blockWidth > 60) {
				for (int x = (blockWidth - 60) / 10; x > 0; x--) {
					if (add > 0)
						blockWidth++;
					else
						blockWidth--;
				}
			}
			System.out.println(blockWidth);
			setBlockHeight(blockWidth);
			theAdd = 1.0 / Setting.blockWidth;

			xMax = LocationChanger.toX(MainFrame.getWidth());
			xMin = LocationChanger.toX(0);
			yMax = LocationChanger.toY(0);
			yMin = LocationChanger.toY(MainFrame.getHeight());

			xIntMax = (int) xMax;
			xIntMin = (int) xMin;
			yIntMax = (int) yMax;
			yIntMin = (int) yMin;
		}
	}

	public void resetO(int x, int y) {
		this.x = x;
		this.y = y;

		xMax = LocationChanger.toX(MainFrame.getWidth());
		xMin = LocationChanger.toX(0);
		yMax = LocationChanger.toY(0);
		yMin = LocationChanger.toY(MainFrame.getHeight());

		xIntMax = (int) xMax;
		xIntMin = (int) xMin;
		yIntMax = (int) yMax;
		yIntMin = (int) yMin;
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

	public boolean hasBlock() {
		return hasBlock;
	}

	public void setHasBlock(boolean hasBlock) {
		this.hasBlock = hasBlock;
	}

}
