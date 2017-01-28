package rainbow.coordinate.dimension.__abs;

import rainbow.coordinate.dimension._2D.axes.PointOfAxes;

public abstract class CoordinateSystemLocationGetter {
	protected CoordinateSystem cs;

	public CoordinateSystemLocationGetter(CoordinateSystem cs) {
		this.cs = cs;
	}

	/**
	 * 将一个相对于屏幕的点转换为在坐标系中的点
	 * 
	 * @param point
	 *            转换之前的点
	 * @return 转换之后的点
	 */
	public abstract MyPoint toSystem(PointOfAxes point);

	/**
	 * 将一个在坐标系中的点转换为相对于屏幕的点
	 * 
	 * @param point
	 *            转换之前的点
	 * @return 转换之后的点
	 */
	public abstract PointOfAxes toReal(MyPoint point);
}
