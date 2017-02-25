package rainbow.coordinate.system._abs.comp;

import java.awt.Image;

import rainbow.coordinate.system._abs.CoordinateSystem;
import rainbow.system.image.MyImage;

/**
 * 所有用于进行坐标轴绘画的父类
 * @author Rainbow Yang
 *
 */
public abstract class CoordinateSystemPainter extends MyImage {

	protected CoordinateSystem cs;

	public CoordinateSystemPainter(CoordinateSystem cs) {
		this.cs = cs;
	}

	public abstract Image getImage();
}
