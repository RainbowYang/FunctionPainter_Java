package rainbow.start;

import javax.swing.UIManager;

import codeLinesReader.rainbow.CodeLinesReaderUser;
import rainbow.frame.MainFrame;
import rainbow.function.functions.Functions;
import rainbow.function.myFunctions.MyFunction;
import rainbow.function.myFunctions.TrigonometricFunctions.Sine;
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

	public static final double PI = Math.PI;

	public static void main(String[] args) {
		linesCount();

		getStartTime();
		// skinSetter();
		init();
		functionAdd();

		MainFrame.repaint();
	}

	public static void linesCount() {
		new CodeLinesReaderUser(".", CodeLinesReaderUser.SIMPLE);
		System.out.println();
	}

	public static void init() {
		System.createSystem();
		Functions.createFunctions();
		MainFrame.createMainFrame().init();
	}

	public static void getStartTime() {
		start = System.currentTimeMillis();
	}

	public static void skinSetter() {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void functionAdd() {

		Functions fs = Functions.getFunctions();

		// MyFunction f = new Oval(0, 0, 10, 5);
		// MyFunction f2 = new Line(1, 1, 0);
		// MyFunction f3 = new Parabola(0, 0, 1, 1);
		// MyFunction f4 = new Hyperbola(0, 0, 1, 1, 0);
		// MyFunction f5 = new ExponentialFunction(1, 2);
		// MyFunction f6 = new LogarithmicFunction(1, 2);
		MyFunction f7 = new Sine(1, PI / 2);
		// MyFunction f8 = new Cosine(1, 1);
		// MyFunction f9 = new Tangent(1, 1);
		// MyFunction f10 = new Cotangent(1, 1);
		// MyFunction f11 = new Secant(1, 1);
		// MyFunction f12 = new Cosecant(1, 1);
		// MyFunction f13 = new SinePowTwo(1, PI / 2);

		// fs.add(f);
		// fs.add(f2);
		// fs.add(f3);
		// fs.add(f4);
		// fs.add(f5);
		// fs.add(f6);

		fs.add(f7);
		// fs.add(f8);
		// fs.add(f9);
		// fs.add(f10);
		// fs.add(f11);
		// fs.add(f12);

		// fs.add(f13);
	}
}
