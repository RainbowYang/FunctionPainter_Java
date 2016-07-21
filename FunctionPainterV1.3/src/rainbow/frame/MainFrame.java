package rainbow.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		mainFrame.setLocation(Setting.xOfMainFrame, Setting.yOfMainFrame);
		mainFrame.setSize(Setting.MainFrameWidth, Setting.MainFrameHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		JPanel back = new JPanel();
		back.setBounds(0, 0, Setting.MainFrameWidth, Setting.MainFrameHeight);
		mainFrame.add(back);

		mainFrame.add(new AllPainter());
		mainFrame.setVisible(true);
	}

	public static void repaint() {
		mainFrame.add(new AllPainter());
		mainFrame.repaint();
	}
}
