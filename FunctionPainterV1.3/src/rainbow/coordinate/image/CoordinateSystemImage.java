package rainbow.coordinate.image;

import java.awt.Image;

import rainbow.system.MySystem;
import rainbow.system.image.MyImage;

public class CoordinateSystemImage extends MyImage {

	private MySystem s;

	public CoordinateSystemImage(MySystem s) {
		this.s = s;
	}

	@Override
	public Image getImage() {
		return s.getCoordinateSystem().getImage();
	}

}
