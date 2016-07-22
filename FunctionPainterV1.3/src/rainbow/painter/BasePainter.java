package rainbow.painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.setting.Setting;
import rainbow.tools.LocationChanger;;

/**
 * 
 * 界面初始化
 * 
 * @author Rainbow_Yang
 * @version 1.3
 */
public class BasePainter {

	public static Image getBaseImage() {
		BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);

		//画空白背景
		g.fillRect(0, 0, Setting.MainFrameWidth, Setting.MainFrameHeight);

		// 判断是否画网格
		if (Setting.isBlock) {
			// 画网格
			网格初始化(g);
		} else
			坐标格点化(g);
		// 画坐标轴
		坐标轴初始化(g);
		// 画原点
		画原点(g);
		// 画单位数字
		画数字(g);
		return img;
	}

	private static void 坐标格点化(Graphics g) {

		// 设置网格颜色
		g.setColor(Setting.colorOfBlock);

		// 画网格
		// 画与x轴垂直的线
		for (int x = Setting.xIntMin - 1; x < Setting.xIntMax + 1; x++) {
			g.drawLine(LocationChanger.Xto(x), Setting.yOfO + 5, LocationChanger.Xto(x), Setting.yOfO - 5);
		}

		// 画与y轴垂直的线
		for (int y = Setting.yIntMin - 1; y < Setting.yIntMax + 1; y++) {
			g.drawLine(Setting.xOfO + 5, LocationChanger.Yto(y), Setting.xOfO - 5, LocationChanger.Yto(y));
		}
	}

	private static void 网格初始化(Graphics g) {

		// 设置网格颜色
		g.setColor(Setting.colorOfBlock);

		// 画网格
		// 画与x轴垂直的线
		for (int x = Setting.xIntMin - 1; x < Setting.xIntMax + 1; x++) {
			g.drawLine(LocationChanger.Xto(x), 0, LocationChanger.Xto(x), Setting.MainFrameHeight);
		}

		// 画与y轴垂直的线
		for (int y = Setting.yIntMin - 1; y < Setting.yIntMax + 1; y++) {
			g.drawLine(0, LocationChanger.Yto(y), Setting.MainFrameWidth, LocationChanger.Yto(y));
		}
	}

	private static void 坐标轴初始化(Graphics g) {

		// 设置坐标轴颜色
		g.setColor(Setting.colorOfXY);
		// x轴
		g.fillRect(0, Setting.yOfO - Setting.widthOfXY / 2, Setting.MainFrameWidth, Setting.widthOfXY);
		// y轴
		g.fillRect(Setting.xOfO - Setting.widthOfXY / 2, 0, Setting.widthOfXY, Setting.MainFrameHeight);

		// 画箭头
		// x轴箭头
		g.drawLine(Setting.MainFrameWidth, Setting.yOfO,
				Setting.MainFrameWidth - (int) (Setting.ArrowLength * Math.cos(Setting.ArrowAngle)),
				(int) (Setting.yOfO + Setting.ArrowLength * Math.sin(Setting.ArrowAngle)));
		g.drawLine(Setting.MainFrameWidth, Setting.yOfO,
				Setting.MainFrameWidth - (int) (Setting.ArrowLength * Math.cos(Setting.ArrowAngle)),
				(int) (Setting.yOfO - Setting.ArrowLength * Math.sin(Setting.ArrowAngle)));

		// y轴箭头
		g.drawLine(Setting.xOfO, 0, (int) (Setting.xOfO + Setting.ArrowLength * Math.sin(Setting.ArrowAngle)),
				(int) (Setting.ArrowLength * Math.cos(Setting.ArrowAngle)));
		g.drawLine(Setting.xOfO, 0, (int) (Setting.xOfO - Setting.ArrowLength * Math.sin(Setting.ArrowAngle)),
				(int) (Setting.ArrowLength * Math.cos(Setting.ArrowAngle)));

	}

	private static void 画原点(Graphics g) {
		g.setColor(Setting.colorOfO);
		g.drawString("O", Setting.xOfO - 15, Setting.yOfO + 15);

	}

	private static void 画数字(Graphics g) {
		g.setColor(Setting.colorOfNum);
		int xMax = Setting.xIntMax;
		int xMin = Setting.xIntMin;
		int yMax = Setting.yIntMax;
		int yMin = Setting.yIntMin;

		// 画数字
		// 画x轴数字
		for (int x = xMin; x < xMax + 1; x++) {
			if (x != 0) {
				g.drawString(String.valueOf(x), LocationChanger.Xto(x), Setting.yOfO + 18);
			}
		}

		// 画y轴数字
		for (int y = yMin; y < yMax + 1; y++) {
			if (y != 0) {
				g.drawString(String.valueOf(y), Setting.xOfO - 15, LocationChanger.Yto(y) + 10);
			}
		}
	}
}
