package rainbow.painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

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
		g.setColor(Color.black);

		for (Function f : SettingFrame.functions) {
			if (f.isCalculated()) {
				List<PointOfFenShu> ps = f.points;
				for (PointOfFenShu p : ps) {
					int x = LocationChanger.Xto(p.getX());
					int y = LocationChanger.Yto(p.getY());
					g.fillRect(x, y, 2, 2);
				}
			} else {
				g.drawImage(f.getImg(), 0, 0, null);
			}

			if (f.isOk() && f.isNotShow()) {
				System.out.println(System.currentTimeMillis() - f.start);
				// 此方法用于标记已显示
				f.showed();
			}
		}
		return img;
	}
}
