package rainbow.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import rainbow.function.FuncitionRepainter;
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

	private int x;
	private int y;

	public MainFrame() {
		mainFrame.setLocation(Setting.xOfMainFrame - 25, Setting.yOfMainFrame);
		mainFrame.setSize(Setting.MainFrameTrueWidth, Setting.MainFrameTrueHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.addMouseWheelListener(e -> {
			Setting.reset(-e.getWheelRotation());
			FuncitionRepainter.repaint();
		});
		mainFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = Setting.xOfO - e.getX();
				y = Setting.yOfO - e.getY();
			}
		});
		mainFrame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Setting.resetO(e.getX() + x, e.getY() + y);
				FuncitionRepainter.repaint();
			}
		});
		mainFrame.add(new AllPainter());
		mainFrame.setVisible(true);
	}

	public static void repaint() {
		mainFrame.add(new AllPainter());
		mainFrame.repaint();
	}
}
