package rainbow.function;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.function.functions.Functions;
import rainbow.function.myFunctions.MyFunction;
import rainbow.system.System;

/**
 * 所有图形(MyFunction)的图片
 * 
 * @author Rainbow Yang
 *
 */
public class FunctionImages {
	public static System s = System.getSystem();

	public static Image getFunctionImage() {
		BufferedImage img = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();
		for (MyFunction f : Functions.getFunctions().get()) {
			if (f.isShow()){
				f.calcPoints();
				f.paintImage(g);
			}
		}
		return img;
	}
}
