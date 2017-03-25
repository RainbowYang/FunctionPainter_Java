package rainbow.outer.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * 主界面控制类
 * 
 * @author Rainbow Yang
 * @version V1.4
 *
 */
public class MainFrameController {

	private static String name = "FunctionPrinter";
	private static String version = "V1.4";
	private static String author = "Rainbow_Yang";

	public static JFrame mainFrame = null;

	private static int firstWidth = 1300;
	private static int firstHeight = 700;

	private MainFrameController() {
	}

	/**
	 * 对此类中的JFrame进行初始化
	 */
	public static void init() {
		mainFrame = new JFrame(name + version + "    Made By " + author);

		mainFrame.setSize(firstWidth, firstHeight);
		FrameLocationController.setAtCenter(mainFrame);

		addMenus();

		// setFullScreen();

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// mainFrame.setUndecorated(true);

		mainFrame.setVisible(true);

	}

	private static void setFullScreen() {
		// mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH); 最大化

		// GraphicsEnvironment ge =
		// GraphicsEnvironment.getLocalGraphicsEnvironment();
		// // 通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了
		// GraphicsDevice gd = ge.getDefaultScreenDevice();
		// // 全屏设置
		// gd.setFullScreenWindow(mainFrame);
		// GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(mainFrame);

		// 全屏,同上
		mainFrame.getGraphicsConfiguration().getDevice().setFullScreenWindow(mainFrame);

	}

	private static void addMenus() {
		// TODO
		// new MainFrameMenuController().menuInit(mainFrame);
	}

	public static void repaint() {
		mainFrame.repaint();
	}

	public static void addImage(JPanel jp) {
		mainFrame.add(jp);
	}

	public static int getWidth() {
		return mainFrame == null ? firstWidth : mainFrame.getWidth();
	}

	public static int getHeight() {
		return mainFrame == null ? firstHeight : mainFrame.getHeight();
	}

}
