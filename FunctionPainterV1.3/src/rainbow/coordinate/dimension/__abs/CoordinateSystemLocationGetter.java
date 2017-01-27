package rainbow.coordinate.dimension.__abs;

public abstract class CoordinateSystemLocationGetter<D extends MyDimension> {
	protected CoordinateSystem<D> cs;

	public CoordinateSystemLocationGetter(CoordinateSystem<D> cs) {
		this.cs = cs;
	}

	/**
	 * 将一个相对于屏幕的点转换为在坐标系中的点
	 * 
	 * @param point
	 *            转换之前的点
	 * @return 转换之后的点
	 */
	public abstract MyPoint<D> toSystem(MyPoint<D> point);

	/**
	 * 将一个在坐标系中的点转换为相对于屏幕的点
	 * 
	 * @param point
	 *            转换之前的点
	 * @return 转换之后的点
	 */
	public abstract MyPoint<D> toReal(MyPoint<D> point);
}
