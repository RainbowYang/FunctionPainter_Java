package rainbow.coordinate.dimension.__abs;

import java.awt.Image;

import rainbow.system.image.MyImage;

public abstract class CoordinateSystemPainter extends MyImage {

	protected CoordinateSystem cs;

	public CoordinateSystemPainter(CoordinateSystem cs) {
		this.cs = cs;
	}

	public abstract Image getImage();
}
