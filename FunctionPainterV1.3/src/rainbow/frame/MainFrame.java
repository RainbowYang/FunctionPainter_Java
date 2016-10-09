package rainbow.frame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import rainbow.frame.botton.JButtonsBox;
import rainbow.frame.botton.MyStyleJButton;
import rainbow.frame.painter.AllPainter;
import rainbow.function.FunctionRepainter;
import rainbow.start.Start;
import rainbow.system.System;
import rainbow.system.SystemImage;

/**
 * 这是主界面
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class MainFrame {
	public static JFrame mainFrame = null;

	private int x = 100;
	private int y = 30;

	public static final int width = 1300;
	public static final int height = 700;

	// 用于鼠标拖动
	private int xOfMouse;
	private int yOfMouse;

	private System s;

	public static JButtonsBox box = new JButtonsBox();

	public static MainFrame createMainFrame() {
		mainFrame = new JFrame("FunctionPrinterV1.3");
		return new MainFrame();
	}

	private MainFrame() {
	}

	public void init() {
		s = System.getSystem();
		mainFrame.setVisible(true);
		mainFrame.setLocation(x - 25, y);
		mainFrame.setSize(width + 52, height + 80);// 消除皮肤造成的窗体缩小
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setResizable(false);

		addJButtons();

		mainFrame.add(new AllPainter());
		System.out.println("窗体加载用时：" + (System.currentTimeMillis() - Start.start));

		mainFrame.addMouseWheelListener(e -> {
			s.reset(e);
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
	}

	private void addJButtons() {
		MyStyleJButton add = new MyStyleJButton("Add");
		MyStyleJButton list = new MyStyleJButton("List");
		MyStyleJButton clear = new MyStyleJButton("Clear");
		MyStyleJButton exit = new MyStyleJButton("Exit");
		// 用于改变按钮位置
		MyStyleJButton change = new MyStyleJButton("Change");

		box.setFrame(mainFrame);
		box.add(add, clear, list, change, exit);
		box.changeBoxWidthAndHeight();

		System.getSystem().reWidthAndHeight();
		SystemImage.repaint();

		add.addActionListener(e -> {

		});
		list.addActionListener(e -> {
		});
		clear.addActionListener(e -> {
		});
		change.addActionListener(e -> {
			box.setLocation(box.getLocation() == JButtonsBox.BOTTOM ? JButtonsBox.LEFT : JButtonsBox.BOTTOM);
			s.reWidthAndHeight();
			repaint();
			System.out.println(s.getWidth() + "..." + s.getHeight());
		});
		exit.addActionListener(e -> {
			java.lang.System.exit(0);
		});
	}

	public void addJButton(JButton jb) {
		box.add(jb);
	}

	public static void repaint() {
		mainFrame.add(new AllPainter());
		mainFrame.repaint();
	}

	public static int getWidth() {
		return mainFrame == null ? width : mainFrame.getWidth() - 52;
	}

	public static int getHeight() {
		return mainFrame == null ? height : mainFrame.getHeight() - 80;
	}
}
