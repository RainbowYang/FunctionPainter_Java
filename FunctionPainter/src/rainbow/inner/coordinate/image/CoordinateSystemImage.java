package rainbow.inner.coordinate.image;

import java.awt.Image;

import rainbow.inner.system.MySystem;
import rainbow.inner.system.image.MyImage;

/**
 * 坐标轴图片
 * 
 * @author Rainbow Yang
 *
 */
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
