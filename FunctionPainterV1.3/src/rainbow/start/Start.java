package rainbow.start;

import javax.swing.UIManager;

import rainbow.frame.MainFrame;

/**
 * 这是FunctionPainter的第三个小版本
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class Start {
	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MainFrame();
	}
}
