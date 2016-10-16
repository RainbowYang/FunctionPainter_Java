package rainbow.start;

import javax.swing.UIManager;

import rainbow.frame.MainFrame;
import rainbow.function.functions.Functions;
import rainbow.function.myFunctions.MyFunction;
import rainbow.function.myFunctions.TrigonometricFunctions.Cosecant;
import rainbow.function.myFunctions.TrigonometricFunctions.Cosine;
import rainbow.function.myFunctions.TrigonometricFunctions.Cotangent;
import rainbow.function.myFunctions.TrigonometricFunctions.Secant;
import rainbow.function.myFunctions.TrigonometricFunctions.Sine;
import rainbow.function.myFunctions.TrigonometricFunctions.Tangent;
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

		functionText();
	}

	public static void functionText() {

		// MyFunction f = new Oval(0, 0, 10, 5);
		// MyFunction f2 = new Line(1, 1, 0);
		// MyFunction f3 = new Parabola(0, 0, 1, 1);
		// MyFunction f4 = new Hyperbola(0, 0, 1, 1, 0);
		// MyFunction f5 = new ExponentialFunction(1, 2);
		// MyFunction f6 = new LogarithmicFunction(1, 2);
		MyFunction f7 = new Sine(1, 1);
		MyFunction f8 = new Cosine(1, 1);
		MyFunction f9 = new Tangent(1, 1);
		MyFunction f10 = new Cotangent(1, 1);
		MyFunction f11 = new Secant(1, 1);
		MyFunction f12 = new Cosecant(1, 1);

		// Functions.add(f);
		// Functions.add(f2);
		// Functions.add(f3);
		// Functions.add(f4);
		// Functions.add(f5);
		// Functions.add(f6);
		Functions.add(f7);
		Functions.add(f8);
		Functions.add(f9);
		Functions.add(f10);
		Functions.add(f11);
		Functions.add(f12);
	}
}
