package rainbow.function.functions;

import java.util.ArrayList;
import java.util.List;

import rainbow.frame.MainFrame;
import rainbow.function.myFunctions.MyFunction;

public class Functions {
	private List<MyFunction> functions = new ArrayList<>();

	public static final List<String> typeOfFunction = new ArrayList<>();

	private static Functions Functions;

	public static Functions createFunctions() {
		return Functions = new Functions();
	}

	private Functions() {

	}

	public static Functions getFunctions() {
		return Functions;
	}

	public List<MyFunction> get() {
		return functions;
	}

	public void add(MyFunction f) {
		functions.add(f);
	}

	public void add(String f) {
		typeOfFunction.add(f);
	}

	public void add(MyFunction... fs) {
		for (MyFunction f : fs) {
			add(f);
		}
	}

	public boolean remove(MyFunction f) {
		return functions.remove(f);
	}

	public void clear() {
		functions.clear();
		MainFrame.repaint();
	}

}
