package rainbow.system.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.GUI.frame.MainFrameController;

/**
 * 
 * 此类用于显示在MainFrame的Image<br>
 * 已给出BufferedImage的Graphics提供使用<br>
 * 需实现getImage()
 * 
 * @author Rainbow Yang
 *
 */
public abstract class MyImage {

	protected MyImage self;

	// TODO
	protected int width = MainFrameController.getWidth();
	protected int height = MainFrameController.getHeight();

	protected Image cache = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
	/**
	 * 提供的Graphics画笔
	 */
	protected Graphics g = cache.getGraphics();

	public abstract Image getImage();

	protected void changeToNewImage() {
		width = MainFrameController.getWidth();
		height = MainFrameController.getHeight();
		cache = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		g = cache.getGraphics();
	}
}
