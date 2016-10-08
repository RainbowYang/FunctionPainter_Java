package rainbow.frame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import rainbow.frame.botton.MyStyleJButton;
import rainbow.function.tools.ColorGetter;
import rainbow.function.tools.ComponentsSetTools;
import rainbow.setting.Setting;

/**
 * 欢迎界面
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class WelcomeFrame {

	private final JFrame welcomeFrame = new JFrame("欢迎使用FuncitonPainterV1.3 MadeByRainbow_Yang");

	public WelcomeFrame() {

		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setLayout(null);

		int frameWidth = Setting.WelcomeFrameWidth;
		int frameHeight = Setting.WelcomeFrameHeight;
		int powerMax = Setting.PowerMax;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 居中
		welcomeFrame.setBounds(((int) screenSize.getWidth() - frameWidth) / 2,
				((int) screenSize.getHeight() - frameHeight) / 2, frameWidth, frameHeight);

		JPanel back = new JPanel();
		back.setBounds(0, 0, frameWidth, frameHeight);

		JLabel FunctionPainterLable = new JLabel("FunctionPainterV1.3");
		JLabel authorLable = new JLabel("Rainbow_Yang");
		JTextField XiShu = new JTextField();
		JLabel tip1 = new JLabel("X");
		JComboBox<String> xOry = new JComboBox<>(new String[] { "x", "y" });
		String[] power = new String[powerMax];
		for (int x = 0; x < power.length; x++) {
			power[x] = (String.valueOf(x));
		}
		JComboBox<String> powerBox = new JComboBox<>(power);
		JLabel tip2 = new JLabel("^");
		MyStyleJButton add = new MyStyleJButton("添 加");
		MyStyleJButton clear = new MyStyleJButton("清 除");
		MyStyleJButton make = new MyStyleJButton("生 成");
		JLabel tip3 = new JLabel("当前函数为:(↓可手动编辑删除)");
		JTextArea FunctionShower = new JTextArea("");

		// 四条水平线
		int line0 = 16;
		int line1 = 100;
		int line2 = 180;
		int line3 = 260;

		welcomeFrame.getComponents();

		FunctionPainterLable.setBounds(110, line0, 400, 60);
		authorLable.setBounds(350, line0 + 30, 400, 60);

		Component[] components = { XiShu, tip1, xOry, tip2, powerBox };
		setBounds(60, line1, 15, 100, 40, components);
		XiShu.setSize(XiShu.getWidth(), XiShu.getHeight());
		// setBounds(int firstPlace, int line, int space, int width,
		// Component[]components)

		add.setLocation(100, line2);
		clear.setLocation(220, line2);
		make.setLocation(frameWidth - 260, line2);

		tip3.setBounds(140, line3 - 20, 300, 20);

		FunctionShower.setBounds(80, line3, 400, 200);
		FunctionShower.setLineWrap(true);
		FunctionShower.setRows(4);

		JPanel functionPanle = new JPanel();
		JScrollPane jsp = new JScrollPane(FunctionShower);
		functionPanle.add(jsp);
		functionPanle.setLocation(FunctionShower.getLocation());
		functionPanle.setSize(FunctionShower.getWidth(), FunctionShower.getHeight() - 56);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		ComponentsSetTools.add(welcomeFrame, FunctionPainterLable, authorLable, XiShu, tip1, xOry, tip2, powerBox, add,
				clear, make, tip3, functionPanle, back);
		// ComponentsSetTools.setBackground(ColorGetter.getColor("66ffff"),
		// back);
		back.setBackground(ColorGetter.getColor("66ffff"));
		ComponentsSetTools.setFont(new Font("微软雅黑", Font.BOLD, 30), FunctionPainterLable, XiShu, tip1, xOry, tip2,
				powerBox, add, clear, make);
		authorLable.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		FunctionShower.setFont(new Font("微软雅黑", Font.BOLD, 20));
		tip3.setFont(new Font("宋体", Font.PLAIN, 20));

		// 设置窗体为不可调整大小
		welcomeFrame.setResizable(false);
		welcomeFrame.setVisible(true);

		XiShu.setDocument(new PlainDocument() {
			private static final long serialVersionUID = 6300775469881706391L;

			public void insertString(int offset, String s, AttributeSet attributeSet) throws BadLocationException {
				if (s.matches("-?\\d*")) {
					super.insertString(offset, s, attributeSet);
				}
			}
		});

		add.addActionListener(e -> {

			if (FunctionShower.getText().trim().isEmpty()) {
				if (!XiShu.getText().isEmpty()) {
					if (powerBox.getSelectedIndex() == 0) {
						FunctionShower.setText(XiShu.getText() + "=0");
					} else {
						FunctionShower.setText(XiShu.getText() + "*" + (xOry.getSelectedIndex() == 0 ? "x" : "y") + "^"
								+ powerBox.getSelectedIndex() + "=0");
					}
					XiShu.requestFocus();
					XiShu.selectAll();
				} else {
					XiShu.requestFocus();
				}
			} else {
				if (!XiShu.getText().isEmpty()) {

					if (powerBox.getSelectedIndex() == 0) {
						addAtFirst(FunctionShower, XiShu.getText());
						clearTheSameAndSort(FunctionShower);
					} else {
						addAtFirst(FunctionShower, XiShu.getText() + "*" + (xOry.getSelectedIndex() == 0 ? "x" : "y")
								+ "^" + powerBox.getSelectedIndex());
						clearTheSameAndSort(FunctionShower);
					}
					XiShu.requestFocus();
					XiShu.selectAll();

				} else {
					XiShu.requestFocus();
				}
			}
		});

		clear.addActionListener(e -> {
			FunctionShower.setText("");
			XiShu.requestFocus();
		});

		make.addActionListener(e -> {

			new SettingFrame(FunctionShower.getText());
			welcomeFrame.dispose();
		});
	}

	private void clearTheSameAndSort(JTextArea functionShower) {

		String[] funcitonParts = functionShower.getText().split("[+]");

		funcitonParts[funcitonParts.length - 1] = funcitonParts[funcitonParts.length - 1].split("=0")[0];

		HashMap<Integer, Integer> xParts = new HashMap<>();
		HashMap<Integer, Integer> yParts = new HashMap<>();
		HashMap<Integer, Integer> OParts = new HashMap<>();

		String part = null;
		String strKey = null;
		Integer value = null, key = null;

		for (int x = funcitonParts.length - 1; x > -1; x--) {
			part = funcitonParts[x];

			if (!(part.contains("*"))) {
				OParts.put(0, Integer.parseInt(part));
			} else {

				strKey = part.split("[*]")[1];
				key = new Integer(strKey.substring(2));
				value = new Integer(part.split("[*]")[0]);

				if (strKey.contains("x")) {
					xParts.put(key, value);
				} else if (strKey.contains("y")) {
					yParts.put(key, value);
				}
			}
		}
		xParts = sort(xParts);
		yParts = sort(yParts);
		StringBuilder sb = new StringBuilder();

		if (!xParts.isEmpty()) {
			Set<Integer> xKeySet = xParts.keySet();
			String[] xStrArr = new String[xKeySet.size()];
			int x = xKeySet.size() - 1;
			for (int i : xKeySet) {
				xStrArr[x] = xParts.get(i) + "*x^" + i + "+";
				x--;
			}
			for (String i : xStrArr) {
				sb.append(i);
			}
		}

		if (!OParts.isEmpty()) {
			sb.append(OParts.get(0)).append("+");
		}

		if (!yParts.isEmpty()) {

			Set<Integer> yKeySet = yParts.keySet();
			for (int i : yKeySet) {
				sb.append(yParts.get(i)).append("*y^").append(i).append("+");
			}

		}

		sb.replace(sb.length() - 1, sb.length(), "=0");
		functionShower.setText(sb.toString());

	}

	private HashMap<Integer, Integer> sort(HashMap<Integer, Integer> Parts) {

		Set<Integer> keySet = Parts.keySet();
		int[] intKeySet = new int[keySet.size()];

		int x = 0;
		for (int i : keySet) {
			intKeySet[x] = i;
			x++;
		}
		Arrays.sort(intKeySet);

		HashMap<Integer, Integer> newParts = new HashMap<>();

		for (int i : intKeySet) {
			newParts.put(i, Parts.get(i));
		}
		return newParts;
	}

	private void addAtFirst(JTextArea jta, String text) {
		String last = jta.getText();
		jta.setText(text);
		jta.append("+");
		jta.append(last);
	}

	private void setBounds(int firstPlace, int line, int space, int width, int height, Component[] components) {

		for (int x = 0; x < components.length; x++) {
			Component c = components[x];
			if (x == 0) {
				c.setBounds(firstPlace, line, width, height);
			} else if (x == 1 || x == 3) {
				// 用于X， ^之列
				c.setBounds(components[x - 1].getX() + components[x - 1].getWidth() + space, line, 40, height);
			} else {
				c.setBounds(components[x - 1].getX() + components[x - 1].getWidth() + space, line, width, height);
			}
		}
	}
}
