package rainbow.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import rainbow.frame.bottom.JButtonsBox;
import rainbow.frame.bottom.MyStyleJButton;
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

	private JButtonsBox box;

	public MainFrame() {
		s = System.getSystem();
		// mainFrame.setLayout(null);
		mainFrame.setLocation(x - 25, y);
		mainFrame.setSize(width + 52, height + 80);// 消除皮肤造成的窗体缩小
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setResizable(false);
		mainFrame.addMouseWheelListener(e -> {
			System.getSystem().reset(-e.getWheelRotation());
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

		addJButtons();

		mainFrame.add(new AllPainter());
		mainFrame.setVisible(true);
		System.out.println("窗体加载用时：" + (System.currentTimeMillis() - Start.start));
	}

	private void addJButtons() {
		MyStyleJButton button1 = new MyStyleJButton("123");
		MyStyleJButton button2 = new MyStyleJButton("123");
		MyStyleJButton button3 = new MyStyleJButton("123");
		MyStyleJButton button4 = new MyStyleJButton("123");
		box = new JButtonsBox(mainFrame, button1, button2, button3, button4);
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
