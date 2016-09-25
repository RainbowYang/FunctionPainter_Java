package rainbow.system;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.frame.MainFrame;
import rainbow.setting.Setting;
import rainbow.system.tools.LocationChanger;;

/**
 * 
 * 界面初始化
 * 
 * @author Rainbow_Yang
 * @version 1.3
 */
public class SystemImage {

	private static SystemImage systemImage = new SystemImage();

	private Color colorOfBlock;
	private Color colorOfO;
	private Color colorOfNum;
	private Color colorOfXY;

	private int xOfO;
	private int yOfO;

	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private int xIntMax;
	private int xIntMin;
	private int yIntMax;
	private int yIntMin;

	public static Image getImage() {
		return systemImage.getBaseImage();
	}

	// 重新加载数据
	private void reset() {
		SystemColors sc = SystemColors.getColors();
		this.colorOfBlock = sc.getColorOfBlock();
		this.colorOfO = sc.getColorOfO();
		this.colorOfNum = sc.getColorOfNum();
		this.colorOfXY = sc.getColorOfXY();

		System s = System.getSystem();
		xOfO = s.getX();
		yOfO = s.getY();

		xMax = s.getxMax();
		xMin = s.getxMin();
		yMax = s.getyMax();
		yMin = s.getyMin();

		xIntMax = s.getxIntMax();
		xIntMin = s.getxIntMin();
		yIntMax = s.getyIntMax();
		yIntMin = s.getyIntMin();
	}

	public Image getBaseImage() {
		reset();
		int MainFrameWidth = MainFrame.getWidth();
		int MainFrameHeight = MainFrame.getHeight();
		BufferedImage img = new BufferedImage(MainFrameWidth, MainFrameHeight, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = img.getGraphics();

		// 画空白背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, MainFrameWidth, MainFrameHeight);

		// 判断是否画网格
		if (System.getSystem().hasBlock()) {
			网格初始化(g);
		} else {
			坐标格点化(g);
		}
		坐标轴初始化(g);
		画原点(g);
		画数字(g);

		return img;
	}

	private void 坐标格点化(Graphics g) {

		// 设置网格颜色
		g.setColor(colorOfBlock);

		// 画网格
		// 画与x轴垂直的线
		for (int x = xIntMin - 1; x < xIntMax + 1; x++) {
			int Xto = LocationChanger.Xto(x);
			g.drawLine(Xto, yOfO + 5, Xto, yOfO - 5);
		}

		// 画与y轴垂直的线
		for (int y = yIntMin - 1; y <yIntMax + 1; y++) {
			int Yto = LocationChanger.Yto(y);
			g.drawLine(xOfO + 5, Yto, xOfO - 5, Yto);
		}
	}

	private void 网格初始化(Graphics g) {

		// 设置网格颜色
		g.setColor(colorOfBlock);

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

	private void 坐标轴初始化(Graphics g) {

		// 设置坐标轴颜色
		g.setColor(colorOfXY);
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

	private void 画原点(Graphics g) {
		g.setColor(colorOfO);
		g.drawString("O", Setting.xOfO - 15, Setting.yOfO + 15);

	}

	private void 画数字(Graphics g) {
		g.setColor(colorOfNum);
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
