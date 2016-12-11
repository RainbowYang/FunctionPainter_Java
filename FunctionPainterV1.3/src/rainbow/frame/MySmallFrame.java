package rainbow.frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import rainbow.function.functions.Functions;
import rainbow.function.myFunctions.MyFunction;

/**
 * 可以实现一系列功能的临时小界面
 * 
 * @author Rainbow Yang
 *
 */
public class MySmallFrame extends JFrame {
	private static final long serialVersionUID = 4050685538443560857L;

	private int width = 600;
	private int height = 500;

	public static final String LIST = "List";

	/**
	 * 为Add提供界面 得到Class文件 界面由MyFunction及其子类控制
	 * 
	 * @param clazz
	 *            Class类
	 */
	public MySmallFrame(Class<? extends MyFunction> clazz) {

		setTitle("Adding  " + clazz.getSimpleName());
	}

	/**
	 * 
	 * @param type
	 *            所需生成的Frame的用处
	 * @see 目前有 List Setting
	 */
	public MySmallFrame(String type) {
		switch (type) {
		case LIST:
			listInit();
			break;
		default:
			break;
		}

	}

	private void listInit() {
		setTitle("All MyFunctions List");

		DefaultListModel<String> mo = new DefaultListModel<>();
		JList<String> jlist = new JList<>(mo);
		for (MyFunction f : Functions.getFunctions().get()) {
			mo.addElement(f.toString());
		}
		this.add(jlist);
	}

	public MySmallFrame() {
	}

	{
		// 居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (screenSize.getWidth() - width) / 2, (int) (screenSize.getHeight() - height) / 2, //
				width, height);
		setVisible(true);

		Graphics g = getGraphics();
		g.fillRect(0, 0, width, height);
	}

}
