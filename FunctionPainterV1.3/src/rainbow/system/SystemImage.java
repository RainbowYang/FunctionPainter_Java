package rainbow.system;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import rainbow.frame.MainFrame;
import rainbow.system.tools.LocationChanger;;

/**
 * 
 * 界面图片
 * 
 * @author Rainbow_Yang
 * @version 1.3
 */
public class SystemImage {

	// 图片缓存
	private Image cacheImg = null;

	private static final SystemImage systemImage = new SystemImage();

	private System s = System.getSystem();

	/**
	 * @return 所需要的图片
	 */
	public static Image getImage() {
		return systemImage.getBaseImage();
	}

	public Image getBaseImage() {
		if (!s.isChanged() && cacheImg != null) {
			s.setChanged(false);
			return cacheImg;
		}

		{
			
			int MainFrameWidth = MainFrame.getWidth();
			int MainFrameHeight = MainFrame.getHeight();
			BufferedImage img = new BufferedImage(MainFrameWidth, MainFrameHeight, BufferedImage.TYPE_4BYTE_ABGR);
			Graphics g = img.getGraphics();

			// 画空白背景
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, MainFrameWidth, MainFrameHeight);

			System.out.println(123);

			// 判断是否画网格
			if (System.getSystem().hasBlock()) {
				网格初始化(g);
			} else {
				坐标格点化(g);
			}
			坐标轴初始化(g);
			画原点(g);
			画数字(g);

			cacheImg = img;

			return img;
		}
	}

	private void 坐标格点化(Graphics g) {

		// 设置网格颜色
		g.setColor(s.getColorOfBlock());

		// 画网格
		// 画与x轴垂直的线
		for (int x = s.getxIntMin() - 1; x < s.getxIntMax() + 1; x++) {
			int Xto = LocationChanger.Xto(x);
			int yOfO = s.getY();
			g.drawLine(Xto, yOfO + 5, Xto, yOfO - 5);
		}

		// 画与y轴垂直的线
		for (int y = s.getyIntMin() - 1; y < s.getyIntMax() + 1; y++) {
			int Yto = LocationChanger.Yto(y);
			int xOfO = s.getX();
			g.drawLine(xOfO + 5, Yto, xOfO - 5, Yto);
		}
	}

	private void 网格初始化(Graphics g) {

		// 设置网格颜色
		g.setColor(s.getColorOfBlock());

		// 画网格
		// 画与x轴垂直的线
		for (int x = s.getxIntMin() - 1; x < s.getxIntMax() + 1; x++) {
			int xto = LocationChanger.Xto(x);
			// System.out.println(xto+"------");
			System.out.println();
			g.drawLine(xto, 0, xto, MainFrame.getHeight());
		}

		// 画与y轴垂直的线
		for (int y = s.getyIntMin() - 1; y < s.getyIntMax() + 1; y++) {
			int yto = LocationChanger.Yto(y);
			g.drawLine(0, yto, MainFrame.getWidth(), yto);
		}
	}

	private void 画数字(Graphics g) {
		g.setColor(s.getColorOfNum());
		int xMax = s.getxIntMax();
		int xMin = s.getxIntMin();
		int yMax = s.getyIntMax();
		int yMin = s.getyIntMin();

		// 画数字
		// 画x轴数字
		for (int x = xMin; x < xMax + 1; x++) {
			if (x != 0) {
				g.drawString(String.valueOf(x), LocationChanger.Xto(x), s.getY() + 18);
			}
		}

		// 画y轴数字
		for (int y = yMin; y < yMax + 1; y++) {
			if (y != 0) {
				g.drawString(String.valueOf(y), s.getX() - 15, LocationChanger.Yto(y) + 10);
			}
		}
	}

	private void 坐标轴初始化(Graphics g) {

		int x = s.getX();
		int y = s.getY();
		System.out.println(x);
		System.out.println(y);

		int width = MainFrame.getWidth();
		int height = MainFrame.getHeight();

		int widthOfXY = s.getXYWidth();

		int arrowLength = s.getArrowLength();
		double arrowAngle = s.getArrowAngle();

		// 设置坐标轴颜色
		g.setColor(s.getColorOfXY());
		// x轴
		g.fillRect(0, y - widthOfXY / 2, width, widthOfXY);
		// y轴
		g.fillRect(x - widthOfXY / 2, 0, widthOfXY, height);

		// 画箭头
		int cosLength = (int) (arrowLength * Math.cos(arrowAngle));
		int sinLength = (int) (arrowLength * Math.sin(arrowAngle));
		// x轴箭头
		g.drawLine(width, y, width - cosLength, (y + sinLength));
		g.drawLine(width, y, width - cosLength, (y - sinLength));

		// y轴箭头
		g.drawLine(x, 0, x + sinLength, cosLength);
		g.drawLine(x, 0, x - sinLength, cosLength);

	}

	private void 画原点(Graphics g) {
		g.setColor(s.getColorOfO());
		g.drawString("O", s.getX() - 15, s.getY() + 15);

	}
}
