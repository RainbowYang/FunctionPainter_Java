package rainbow.frame;

import java.util.ArrayList;

import javax.swing.JFrame;

import rainbow.function.Function;
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
	private static ArrayList<Function> lastFuncitons = new ArrayList<>();

	public MainFrame() {
		mainFrame.setLocation(Setting.xOfMainFrame - 25, Setting.yOfMainFrame);
		mainFrame.setSize(Setting.MainFrameTrueWidth, Setting.MainFrameTrueHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.add(new AllPainter());
		mainFrame.setVisible(true);
	}

	public static void repaint() {
		if (lastFuncitons.isEmpty() || !(lastFuncitons.equals(SettingFrame.functions))) {
			System.out.println("正在添加函数");
			mainFrame.add(new AllPainter());
			mainFrame.repaint();
			System.out.println("函数添加完毕");
		}
		lastFuncitons = new ArrayList<>();
		lastFuncitons.addAll(SettingFrame.functions);
	}
}
