package rainbow.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import rainbow.function.FunctionRepainter;
import rainbow.painter.AllPainter;
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

	private int x = 20;
	private int y = 30;

	private static int width = 1300;
	private static int height = 700;

	// 用于鼠标拖动
	private int xOfMouse;
	private int yOfMouse;

	public MainFrame() {
		mainFrame.setLocation(x - 25, y);
		mainFrame.setSize(width + 52, height + 80);// 消除皮肤造成的窗体缩小
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.addMouseWheelListener(e -> {
			System.getSystem().reset(-e.getWheelRotation());
			FunctionRepainter.repaint();
		});
		mainFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xOfMouse = System.getSystem().getX() - e.getX();
				yOfMouse = System.getSystem().getY() - e.getY();
			}
		});
		mainFrame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.getSystem().resetO(e.getX() + xOfMouse, e.getY() + yOfMouse);
				FunctionRepainter.repaint();
			}
		});
		mainFrame.add(new AllPainter());
		mainFrame.setVisible(true);
	}

	public static void repaint() {
		mainFrame.add(new AllPainter());
		mainFrame.repaint();
	}

	public static int getWidth() {
		return mainFrame.getWidth() == 0 ? width : mainFrame.getWidth() - 52;
	}

	public static int getHeight() {
		return mainFrame.getHeight() == 0 ? height : mainFrame.getHeight() - 80;
	}
}
