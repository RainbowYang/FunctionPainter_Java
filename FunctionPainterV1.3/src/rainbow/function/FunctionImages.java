package rainbow.function;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.function.functions.Functions;
import rainbow.function.myFunctions.MyFunction;
import rainbow.system.System;

public class FunctionImages {
	public static System s = System.getSystem();

	public static Image getFunctionImage() {
		BufferedImage img = new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();
		for (MyFunction f : Functions.functions) {
			if (f.isShow())
				f.paintImage(g);
		}
		return img;
	}
}
