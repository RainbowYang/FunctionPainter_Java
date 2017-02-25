package rainbow.back;

import java.awt.Color;
import java.awt.Image;

import rainbow.system.image.MyImage;
import rainbow.tools.ColorGetter;

/**
 * 背景
 * 
 * @author Rainbow Yang
 *
 */
public class BackImage extends MyImage {
	
	Color color = ColorGetter.getColor("323232");

	@Override
	public Image getImage() {
		changeToNewImage();
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		return cache;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
