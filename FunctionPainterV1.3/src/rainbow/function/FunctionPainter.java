package rainbow.function;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.frame.SettingFrame;
import rainbow.setting.Setting;

public class FunctionPainter {
	public static Image getFunctionImage() {
		BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();
		for (Function f : SettingFrame.functions) {
			if (f.hasImg()) {
				if (!f.isShowed()) {
					System.out.println(System.currentTimeMillis() - f.start);
					f.setShowed();
				}
				g.drawImage(f.getImg(), 0, 0, null);
			}
		}
		return img;
	}
}
