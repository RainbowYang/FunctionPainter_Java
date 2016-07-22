package rainbow.painter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import rainbow.frame.SettingFrame;
import rainbow.function.Function;
import rainbow.number.FenShu;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

/**
 * 函数绘画
 * 
 * @author Rainbow_Yang
 * @version 1.3
 *
 */
public class FunctionPainterForFunction {

	public static Image getFunctionImage(Function f) {

		BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();
		g.setColor(Setting.colorOfFunciton);

		int xIntMax = Setting.xIntMax;
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		for (FenShu x = Setting.xMin; x.intValue() < xIntMax+1; x = x.add(theAdd)) {
			ArrayList<FenShu> ys = f.getY(x);
			for (FenShu y : ys) {
				g.fillRect(LocationChanger.Xto(x), LocationChanger.Yto(y), 2, 2);
			}
		}
		return img;
	}

}
