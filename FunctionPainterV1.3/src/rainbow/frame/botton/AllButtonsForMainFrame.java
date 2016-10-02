package rainbow.frame.botton;

import rainbow.frame.MainFrame;
import rainbow.system.System;
import rainbow.system.SystemImage;

public class AllButtonsForMainFrame {

	public static void addJButtons() {
		MyStyleJButton add = new MyStyleJButton("Add");
		MyStyleJButton list = new MyStyleJButton("List");
		MyStyleJButton clear = new MyStyleJButton("Clear");
		MyStyleJButton exit = new MyStyleJButton("Exit");
		MainFrame.box = new JButtonsBox(MainFrame.mainFrame, add, list, clear, exit);

		System.getSystem().reWidthAndHeight();
		SystemImage.repaint();
	}

}
