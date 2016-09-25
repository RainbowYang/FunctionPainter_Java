package rainbow.painter;

import java.awt.Graphics;

import javax.swing.JPanel;

import rainbow.setting.Setting;
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
		g.fillRect(0, 0, Setting.MainFrameWidth, Setting.MainFrameHeight);
		// 添加背景
		g.drawImage(SystemImage.getImage(), 0, 0, null);
		// 添加函数
		g.drawImage(FunctionPainter.getFunctionImage(), 0, 0, null);

	}
}
