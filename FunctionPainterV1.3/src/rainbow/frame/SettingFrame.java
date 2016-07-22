package rainbow.frame;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import rainbow.function.Function;
import rainbow.setting.Setting;
import rainbow.style.MyStyleJButton;
import rainbow.tools.ColorGetter;
import rainbow.tools.ComponentsSetTools;

/**
 * 
 * 设置界面
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class SettingFrame {

	private static final String name = "SettingFrame  ";
	private static final JFrame settingFrame = new JFrame(name);
	private static DefaultListModel<String> FunctionElements = new DefaultListModel<>();

	private StringBuilder functionBuilder = new StringBuilder();

	public static final ArrayList<Function> functions = new ArrayList<>();

	public SettingFrame(String StrFunction) {
		settingFrame.setLayout(null);
		settingFrame.setLocation(Setting.xOfMainFrame, Setting.yOfMainFrame + Setting.MainFrameHeight - 10);
		settingFrame.setSize(Setting.SettingFrameWidth, Setting.SettingFrameHeight);
		settingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel back = new JPanel();
		back.setBounds(0, 0, settingFrame.getWidth(), settingFrame.getHeight());
		JLabel FunctionPainterLable = new JLabel("FunctionPainterV1.3");
		JLabel authorLable = new JLabel("Rainbow_Yang");
		JTextField XiShu = new JTextField();
		JLabel tip1 = new JLabel("X");
		JComboBox<String> xOry = new JComboBox<>(new String[] { "x", "y" });
		String[] power = new String[Setting.PowerMax];
		for (int x = 0; x < power.length; x++) {
			power[x] = (String.valueOf(x));
		}
		JComboBox<String> powerBox = new JComboBox<>(power);
		JLabel tip2 = new JLabel("^");
		MyStyleJButton add = new MyStyleJButton("添 加");
		MyStyleJButton clear = new MyStyleJButton("清 除");
		MyStyleJButton make = new MyStyleJButton("生 成");
		MyStyleJButton look = new MyStyleJButton("查 看");

		Component[] components1 = { XiShu, tip1, xOry, tip2, powerBox };
		setBounds(20, 30, 15, 100, 40, components1);

		if (!StrFunction.isEmpty()) {
			FunctionElements.addElement(StrFunction);
			functions.add(new Function(StrFunction));
			MainFrame.repaint();
		}

		JList<String> FunctionShower = new JList<String>(FunctionElements);
		FunctionShower.setBounds(0, 0, 600, 200);
		FunctionShower.setFixedCellHeight(22);
		FunctionShower.setFixedCellWidth(700);
		FunctionShower.setFont(new Font("微软雅黑", Font.BOLD, 20));

		JScrollPane FuncitonShowerPane = new JScrollPane(FunctionShower);
		JPanel functionPanle = new JPanel();
		FuncitonShowerPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		FuncitonShowerPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		functionPanle.add(FuncitonShowerPane);
		functionPanle.setLocation(500, 10);
		functionPanle.setSize(720, 200);

		int line = 120;
		add.setLocation(20, line);
		clear.setLocation(135, line);
		make.setLocation(250, line);
		look.setLocation(365, line);

		Font f = new Font("微软雅黑", Font.BOLD, 30);

		ComponentsSetTools.setFont(f, FunctionPainterLable, XiShu, tip1, xOry, tip2, powerBox, add, clear, make, look);
		ComponentsSetTools.add(settingFrame, FunctionPainterLable, authorLable, XiShu, tip1, xOry, tip2, powerBox, add,
				clear, make, look, functionPanle, back);

		back.setBackground(ColorGetter.getColor("66ffff"));

		XiShu.setDocument(new PlainDocument() {
			private static final long serialVersionUID = -7750320796795153332L;

			public void insertString(int offset, String s, AttributeSet attributeSet) throws BadLocationException {
				System.out.println(s.matches("-?\\d*"));
				if (s.matches("-?\\d*")) {
					super.insertString(offset, s, attributeSet);
				}
			}
		});

		add.addActionListener(e -> {
			if (!XiShu.getText().isEmpty()) {
				if (functionBuilder.toString().isEmpty()) {
					if (powerBox.getSelectedIndex() == 0) {
						functionBuilder.append(XiShu.getText() + "=0");
					} else {
						functionBuilder.append(XiShu.getText() + "*" + (xOry.getSelectedIndex() == 0 ? "x" : "y") + "^"
								+ powerBox.getSelectedIndex() + "=0");
					}
				} else {
					if (powerBox.getSelectedIndex() == 0) {
						functionBuilder.insert(0, XiShu.getText() + "+");
						clearTheSameAndSort();
					} else {
						functionBuilder.insert(0, XiShu.getText() + "*" + (xOry.getSelectedIndex() == 0 ? "x" : "y")
								+ "^" + powerBox.getSelectedIndex() + "+");
						clearTheSameAndSort();
					}
				}
			} else {
				XiShu.requestFocus();
			}
			settingFrame.setTitle(name + "当前正在编辑的函数为：" + functionBuilder.toString());
		});

		clear.addActionListener(e -> {
			if ((!FunctionShower.isSelectionEmpty())) {
				FunctionElements.remove(FunctionShower.getSelectedIndex());
				MainFrame.repaint();
			}
		});

		make.addActionListener(e -> {
			if (!(functionBuilder.toString().isEmpty() || FunctionElements.contains(functionBuilder.toString()))) {
				FunctionElements.addElement(functionBuilder.toString());

				functions.add(new Function(functionBuilder.toString()));

				functionBuilder = new StringBuilder();
				settingFrame.setTitle(name);

				MainFrame.repaint();
			}
		});

		look.addActionListener(e -> {
			if (!(FunctionShower.isSelectionEmpty())) {
				new LookingFrame(FunctionElements.get(FunctionShower.getSelectedIndex()));
			}
		});

		// 设置窗体为不可调整大小
		settingFrame.setResizable(false);
		settingFrame.setVisible(true);
	}

	public static void change(String firstFunction, String nowFunction) {
		if (nowFunction.trim().isEmpty()) {
			FunctionElements.remove(FunctionElements.indexOf(firstFunction));
		} else {
			int location = FunctionElements.indexOf(firstFunction);
			FunctionElements.set(location, nowFunction);

			Function delete = null;

			for (Function f : functions) {
				if (f.equals(new Function(firstFunction))) {
					delete = f;
				}
			}
			functions.remove(delete);

			functions.add(new Function(nowFunction));

		}
		MainFrame.repaint();

	}

	private void clearTheSameAndSort() {

		String[] funcitonParts = functionBuilder.toString().split("[+]");

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
		int[] xIntKeySet = sort(xParts);
		int[] yIntKeySet = sort(yParts);
		StringBuilder sb = new StringBuilder();

		if (xIntKeySet.length != 0) {
			String[] xStrArr = new String[xIntKeySet.length];
			int x = xIntKeySet.length - 1;
			for (int i : xIntKeySet) {
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

		if (yIntKeySet.length != 0) {

			for (int i : yIntKeySet) {
				sb.append(yParts.get(i)).append("*y^").append(i).append("+");
			}

		}

		sb.replace(sb.length() - 1, sb.length(), "=0");

		functionBuilder = sb;
	}

	private int[] sort(HashMap<Integer, Integer> Parts) {

		Set<Integer> keySet = Parts.keySet();
		int[] intKeySet = new int[keySet.size()];

		int x = 0;
		for (int i : keySet) {
			intKeySet[x] = i;
			x++;
		}
		Arrays.sort(intKeySet);

		return intKeySet;
	}

	private void setBounds(int firstPlace, int line, int space, int width, int height, Component... components) {
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
