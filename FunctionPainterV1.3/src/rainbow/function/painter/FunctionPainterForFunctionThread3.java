package rainbow.function.painter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import rainbow.frame.MainFrame;
import rainbow.function.Function;
import rainbow.number.FenShu;
import rainbow.painter.AllPainter;
import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;

//第三象限
public class FunctionPainterForFunctionThread3 extends Thread {

	private Function f;

	public FunctionPainterForFunctionThread3(Function f) {
		this.f = f;
	}

	public void run() {
		Graphics g = f.getBufferedImage().getGraphics();
		System.out.println("第三象限开始计算");
		g.drawImage(getFunctionImage3(f), 0, 0, null);
		this.f.is3 = true;
		System.out.println("第三象限完成");
		MainFrame.mainFrame.add(new AllPainter());
		MainFrame.mainFrame.repaint();
	}

	public static Image getFunctionImage3(Function f) {

		BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();
		g.setColor(Setting.colorOfFunciton);

		int xIntMin = Setting.xIntMin;
		FenShu theAdd = new FenShu(1, Setting.blockWidth);
		for (FenShu x = new FenShu(); x.intValue() > xIntMin - 1; x = x.subtract(theAdd)) {
			ArrayList<FenShu> ys = f.getDownY(x);
			for (FenShu y : ys) {
				g.fillRect(LocationChanger.Xto(x), LocationChanger.Yto(y), 2, 2);
			}
		}
		return img;
	}
}
