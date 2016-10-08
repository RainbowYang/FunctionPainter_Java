package rainbow.frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DataFrame extends JFrame {
	private static final long serialVersionUID = 4050685538443560857L;

	private int width = 600;
	private int height = 500;

	public DataFrame() {
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (screenSize.getWidth() - width) / 2, //
				(int) (screenSize.getHeight() - height) / 2, //
				width, height);
		setVisible(true);

//		Graphics g = getGraphics().setColor();
//		g.fillRect(0, 0, width, height);
	}
}
