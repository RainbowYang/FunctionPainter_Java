package rainbow.painter;

import java.awt.Graphics;

import javax.swing.JPanel;

import rainbow.frame.MainFrame;
import rainbow.frame.SettingFrame;
import rainbow.function.Function;

/**
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class AllPainter extends JPanel {

	private static final long serialVersionUID = -6464238758502442112L;

	protected void paintComponent(Graphics g) {
		// 添加背景
		g.drawImage(BasePainter.getBaseImage(), 0, 0, null);
		// 添加函数
		g.drawImage(FunctionPainter.getFunctionImage(), 0, 0, null);

	}
}
