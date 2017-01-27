package rainbow.coordinate.dimension.__abs;

import java.awt.Image;

import rainbow.system.image.MyImage;

public abstract class CoordinateSystemPainter<D extends MyDimension> extends MyImage {

	protected CoordinateSystem<D> cs;

	public CoordinateSystemPainter(CoordinateSystem<D> cs) {
		this.cs = cs;
	}

	public abstract Image getImage();
}
