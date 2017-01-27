package rainbow.coordinate.dimension.__abs;

import java.awt.Image;

/**
 * 用于描述函数坐标系并规定一些方法
 * 
 * @author Rainbow Yang
 *
 */
public abstract class CoordinateSystem<D extends MyDimension> {

	protected CoordinateSystemLocationGetter<D> getter;
	protected CoordinateSystemPainter<D> painter;

	/**
	 * 需对CoordinateSystemLocationGetter getter和CoordinateSystemPainter painter
	 * 进行初始化
	 */
	protected abstract void init();

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
	public MyPoint<D> toSystem(MyPoint<D> point) {
		return getter.toSystem(point);
	}

	/**
	 * 将一个在坐标系中的点转换为相对于屏幕的点
	 * 
	 * @param point
	 *            转换之前的点
	 * @return 转换之后的点
	 */
	public MyPoint<D> toReal(MyPoint<D> point) {
		return getter.toReal(point);
	}

}
