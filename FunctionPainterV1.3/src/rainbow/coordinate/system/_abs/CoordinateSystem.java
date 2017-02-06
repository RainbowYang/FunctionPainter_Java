package rainbow.coordinate.system._abs;

import java.awt.Image;
import java.awt.Point;

import rainbow.coordinate.system._abs.comp.CoordinateSystemLocationGetter;
import rainbow.coordinate.system._abs.comp.CoordinateSystemPainter;
import rainbow.coordinate.system._abs.comp.MyPoint;

/**
 * 用于描述函数坐标系并规定一些方法
 * 
 * @author Rainbow Yang
 *
 */
public abstract class CoordinateSystem {

	protected CoordinateSystemLocationGetter getter;
	protected CoordinateSystemPainter painter;
	// protected CoordinateSystemResetter setter;
	// protected CoordinateSystemRanger ranger;
	// protected CoordinateSystemColorer colorer;
	
	

	/**
	 * 进行初始化
	 */
	protected void init() {
		initForLocationGetter();
		initForPainter();
	}

	protected abstract void initForLocationGetter();

	protected abstract void initForPainter();

	protected CoordinateSystem() {
		init();
	}

	/**
	 * @return 需给出坐标轴的图片
	 */
	public Image getImage() {
		return painter.getImage();
	}

	/**
	 * 将一个相对于屏幕的点转换为在坐标系中的点
	 * 
	 * @param point
	 *            转换之前的点
	 * @return 转换之后的点
	 */
	public MyPoint toSystem(Point point) {
		return getter.toSystem(point);
	}

	/**
	 * 将一个在坐标系中的点转换为相对于屏幕的点
	 * 
	 * @param point
	 *            转换之前的点
	 * @return 转换之后的点
	 */
	public Point toReal(MyPoint point) {
		return getter.toReal(point);
	}

}
