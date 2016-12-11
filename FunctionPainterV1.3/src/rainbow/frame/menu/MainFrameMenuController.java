package rainbow.frame.menu;

import static rainbow.function.tools.SetTools.setFont;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import rainbow.frame.MySmallFrame;
import rainbow.function.functions.Functions;

/**
 * 控制MainFrame的菜单
 * 
 * @author Rainbow Yang
 *
 */
public class MainFrameMenuController {

	public void menuInit(JFrame mainFrame) {
		JMenuBar menubar = new JMenuBar();
		// menubar.setLayout();
		JMenu add = new JMenu("Add");
		addMyFunctions(add);

		JMenu operation = new JMenu("Operations");
		JMenuItem list = new JMenuItem("List");
		list.addActionListener(l -> {
			new MySmallFrame(MySmallFrame.LIST);
		});

		JMenuItem clear = new JMenuItem("Clear");
		clear.addActionListener(l -> {
			Functions.getFunctions().clear();
		});

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(l -> {
			System.exit(0);
		});

		addToJMenu(operation, //
				list, clear, exit);

		addToJMenuBar(menubar, //
				add, operation);

		Font font = new Font("微软雅黑", Font.BOLD, 15);
		setFont(font, add, list, operation, clear, exit);

		mainFrame.setJMenuBar(menubar);
	}

	private void addMyFunctions(JMenu add) {
		// 三大组JMenu
		JMenu common = new JMenu("Common");
		JMenu ConicalSection = new JMenu("ConicalSection");
		JMenu TrigonometricFunctions = new JMenu("TrigonometricFunctions");

		addToJMenu(add, common, ConicalSection, TrigonometricFunctions);

		Map<String, JMenu> menus = new HashMap<String, JMenu>();
		menus.put(MainFrameAddMenuController.COMMOM, common);
		menus.put(MainFrameAddMenuController.CONICAL_SECTION, ConicalSection);
		menus.put(MainFrameAddMenuController.TRIGONOMETRIC_FUNCTION, TrigonometricFunctions);

		new MainFrameAddMenuController().setMenuMap(menus).addToMenu();

	}

	private void addToJMenuBar(JMenuBar menubar, JMenuItem... jMenuItems) {
		for (JMenuItem jMenuItem : jMenuItems) {
			menubar.add(jMenuItem);
		}
	}

	private void addToJMenu(JMenu jMenu, JMenuItem... jMenuItems) {
		for (JMenuItem jMenuItem : jMenuItems) {
			jMenu.add(jMenuItem);
		}
	}
}
