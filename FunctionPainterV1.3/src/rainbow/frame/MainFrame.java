package rainbow.frame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import rainbow.frame.botton.AllButtonsForMainFrame;
import rainbow.frame.botton.JButtonsBox;
import rainbow.frame.painter.AllPainter;
import rainbow.function.FunctionRepainter;
import rainbow.start.Start;
import rainbow.system.System;

/**
 * 这是主界面
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class MainFrame {
	public final static JFrame mainFrame = new JFrame("FunctionPrinterV1.3");

	private int x = 100;
	private int y = 30;

	private static int width = 1300;
	private static int height = 700;

	// 用于鼠标拖动
	private int xOfMouse;
	private int yOfMouse;

	private System s;

	public static JButtonsBox box;

	public MainFrame() {
		s = System.getSystem();
		mainFrame.setVisible(true);
		mainFrame.setLocation(x - 25, y);
		mainFrame.setSize(width + 52, height + 80);// 消除皮肤造成的窗体缩小
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setResizable(false);
		mainFrame.addMouseWheelListener(e -> {
			s.reset(-e.getWheelRotation());
			FunctionRepainter.repaint();
		});
		mainFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xOfMouse = s.getX() - e.getX();
				yOfMouse = s.getY() - e.getY();
			}
		});
		mainFrame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				s.resetO(e.getX() + xOfMouse, e.getY() + yOfMouse);
				FunctionRepainter.repaint();
			}
		});
		mainFrame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				s.reWidthAndHeight();
				box.relocate();
				repaint();
			}
		});

		AllButtonsForMainFrame.addJButtons();

		mainFrame.add(new AllPainter());
		System.out.println("窗体加载用时：" + (System.currentTimeMillis() - Start.start));
	}

	public void addJButton(JButton jb) {
		box.add(jb);
	}

	public static void repaint() {
		long start = System.currentTimeMillis();
		mainFrame.add(new AllPainter());
		mainFrame.repaint();
		System.out.println(System.currentTimeMillis() - start);
	}

	public static int getWidth() {
		return mainFrame.getWidth() == 0 ? width : mainFrame.getWidth() - 52;
	}

	public static int getHeight() {
		return mainFrame.getHeight() == 0 ? height : mainFrame.getHeight() - 80;
	}
}
