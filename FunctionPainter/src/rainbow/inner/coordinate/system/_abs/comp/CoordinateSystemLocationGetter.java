package rainbow.inner.coordinate.system._abs.comp;

import java.awt.Point;

import rainbow.inner.math.points.MyPoint;
import rainbow.inner.coordinate.system._abs.CoordinateSystem;

/**
 * 所有用于进行坐标转换的父类
 *
 * @author Rainbow Yang
 */
public abstract class CoordinateSystemLocationGetter {
    protected CoordinateSystem cs;

    public CoordinateSystemLocationGetter(CoordinateSystem cs) {
        this.cs = cs;
    }

    /**
     * 将一个相对于屏幕的点转换为在坐标系中的点
     *
     * @param point 转换之前的点
     * @return 转换之后的点
     */
    public abstract MyPoint toSystem(Point point);

    /**
     * 将一个在坐标系中的点转换为相对于屏幕的点
     *
     * @param point 转换之前的点
     * @return 转换之后的点
     */
    public abstract Point toReal(MyPoint point);
}
