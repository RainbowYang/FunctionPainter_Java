package rainbow.frame.menu;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import rainbow.function.functions.Functions;
import static rainbow.function.tools.SetTools.setFont;

public class MainFrameMenuController {

	public static void menuInit(JFrame mainFrame) {
		JMenuBar menubar = new JMenuBar();
		// menubar.setLayout();
		JMenu add = new JMenu("Add");
		JMenuItem add2 = new JMenuItem("Add");

		add.add(add2);

		JMenu operation = new JMenu("Operations");

		JMenuItem clear = new JMenuItem("Clear");
		clear.addActionListener(l -> {
			Functions.getFunctions().clear();
		});

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(l -> {
			System.exit(0);
		});

		Font f = new Font("微软雅黑", Font.BOLD, 15);
		add.setFont(f);
		add(operation, clear, exit);

		add(menubar, add, operation);

		setFont(f, add, operation, clear, exit);

		mainFrame.setJMenuBar(menubar);
	}

	private static void add(JMenuBar menubar, JMenuItem... jMenuItems) {
		for (JMenuItem jMenuItem : jMenuItems) {
			menubar.add(jMenuItem);
		}
	}

	private static void add(JMenu jMenu, JMenuItem... jMenuItems) {
		for (JMenuItem jMenuItem : jMenuItems) {
			jMenu.add(jMenuItem);
		}
	}
}
