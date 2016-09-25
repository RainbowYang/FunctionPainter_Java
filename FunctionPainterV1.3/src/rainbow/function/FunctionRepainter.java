package rainbow.function;

import rainbow.frame.MainFrame;
import rainbow.frame.SettingFrame;
import rainbow.function.painter.FunctionImagePainter;

public class FuncitionRepainter {

	public static void repaint() {
		for (Function f : SettingFrame.functions) {
			f.cleanImg();
			if (f.hasPoints()) {
				new FunctionPointsPainter(f).tryToAddImg();
			} else {
				new FunctionImagePainter(f);
			}
		}
		MainFrame.repaint();
	}
}
