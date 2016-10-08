package rainbow.start;

import javax.swing.UIManager;

import rainbow.frame.MainFrame;
import rainbow.function.functions.Functions;
import rainbow.function.myFunctions.ExponentialFunction;
import rainbow.function.myFunctions.Line;
import rainbow.function.myFunctions.MyFunction;
import rainbow.function.myFunctions.ConicalSection.Hyperbola;
import rainbow.function.myFunctions.ConicalSection.Oval;
import rainbow.function.myFunctions.ConicalSection.Parabola;
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
		MainFrame.createMainFrame().init();

//		MyFunction f = new Oval(0, 0, 10, 5);
//		MyFunction f2 = new Line(1, 1, 0);
//		MyFunction f3 = new Parabola(0, 0, 1, 1);
//		MyFunction f4 = new Hyperbola(0, 0, 1, 1, 0);
		MyFunction f5 = new ExponentialFunction(1, 2);

//		Functions.add(f);
//		Functions.add(f2);
//		Functions.add(f3);
//		Functions.add(f4);
		Functions.add(f5);
	}
}
