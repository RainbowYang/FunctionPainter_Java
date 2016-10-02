package rainbow.frame.painter;

import java.awt.Graphics;

import javax.swing.JPanel;

import rainbow.frame.MainFrame;
import rainbow.function.tools.ColorGetter;
import rainbow.system.SystemImage;

/**
 * 主界面总图
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class AllPainter extends JPanel {

	private static final long serialVersionUID = -6464238758502442112L;

	protected void paintComponent(Graphics g) {
		g.setColor(ColorGetter.getColor("4caf50"));
		g.fillRect(0, 0, MainFrame.mainFrame.getWidth(), MainFrame.mainFrame.getHeight());
		// 添加背景
		SystemImage.repaint();
		g.drawImage(SystemImage.getImage(), 0, 0, null);
		// 添加函数
		// g.drawImage(FunctionPainter.getFunctionImage(), 0, 0, null);

	}
}
