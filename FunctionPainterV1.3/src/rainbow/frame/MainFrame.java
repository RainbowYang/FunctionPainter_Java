package rainbow.frame;

import javax.swing.JFrame;

import rainbow.painter.AllPainter;
import rainbow.setting.Setting;

/**
 * 这是主界面
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class MainFrame {
	public final static JFrame mainFrame = new JFrame("FunctionPrinterV1.3");

	public MainFrame() {
		mainFrame.setLocation(Setting.xOfMainFrame - 25, Setting.yOfMainFrame);
		mainFrame.setSize(Setting.MainFrameTrueWidth, Setting.MainFrameTrueHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.add(new AllPainter());
		mainFrame.setVisible(true);
	}

	public static void repaint() {
		mainFrame.add(new AllPainter());
		mainFrame.repaint();
	}
}
