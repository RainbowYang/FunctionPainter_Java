package rainbow.painter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.frame.SettingFrame;
import rainbow.function.Function;
import rainbow.setting.Setting;

public class FunctionPainter {
	public static Image getFunctionImage() {
		BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();

		for (Function f : SettingFrame.functions) {
			g.drawImage(f.getImageOfFunction(), 0, 0, null);
		}
		return img;
	}
}
