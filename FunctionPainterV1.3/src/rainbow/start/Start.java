package rainbow.start;

import javax.swing.UIManager;

import rainbow.frame.MainFrame;
import rainbow.system.System;

/**
 * 这是FunctionPainter的第三个小版本
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class Start {
	// 开始时间
	public static long start;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.createSystem();
		new MainFrame();
	}
}
