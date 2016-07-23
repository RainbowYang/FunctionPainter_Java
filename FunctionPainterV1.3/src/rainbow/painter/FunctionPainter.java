package rainbow.painter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import rainbow.frame.SettingFrame;
import rainbow.function.Function;
import rainbow.number.PointOfFenShu;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

public class FunctionPainter {
	public static Image getFunctionImage() {
		BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();

		for (Function f : SettingFrame.functions) {
			ArrayList<PointOfFenShu> ps = f.getPoints();
			for (PointOfFenShu p : ps) {
				int x = LocationChanger.Xto(p.getX());
				int y = LocationChanger.Yto(p.getY());
				g.fillRect(x, y, 2, 2);
			}
		}
		return img;
	}
}
