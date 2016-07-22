package rainbow.frame;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import rainbow.setting.Setting;
import rainbow.style.MyStyleJButton;
import rainbow.tools.ColorGetter;
import rainbow.tools.ComponentsSetTools;

/**
 * 
 * 用于查看函数的界面
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class LookingFrame {

	public LookingFrame(String function) {

		JFrame lookingFrame = new JFrame("查看函数(你也可以在里面编辑)");

		lookingFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		lookingFrame.setLayout(null);
		lookingFrame.setResizable(false);

		lookingFrame.setLocation(Setting.xOfLookingFrame, Setting.yOfLookingFrame);
		lookingFrame.setSize(Setting.LookingFrameWidth, Setting.LookingFrameHeight);

		JTextArea FunctionShower = new JTextArea("");
		FunctionShower.setBounds(10, 0, Setting.LookingFrameWidth - 75, Setting.LookingFrameHeight-195);
		FunctionShower.setLineWrap(true);
		FunctionShower.setRows(10);
		FunctionShower.setFont(new Font("微软雅黑", Font.BOLD, 20));
		FunctionShower.setText(function);

		JPanel functionPanle = new JPanel();
		JScrollPane jsp = new JScrollPane(FunctionShower);
		functionPanle.add(jsp);
		
		functionPanle.setLocation(10, 10);
		functionPanle.setSize(FunctionShower.getSize());
		
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		JPanel back = new JPanel();
		back.setBackground(ColorGetter.getColor("66ffff"));
		back.setBounds(0, 0, Setting.LookingFrameWidth, Setting.LookingFrameWidth);

		MyStyleJButton save = new MyStyleJButton("保 存");
		MyStyleJButton cancel = new MyStyleJButton("取 消");

		int line = 330;
		save.setLocation(100, line);
		cancel.setLocation(320, line);

		ComponentsSetTools.add(lookingFrame, save, cancel, functionPanle, back);
		
		lookingFrame.setVisible(true);

		save.addActionListener(e -> {
			SettingFrame.change(function, FunctionShower.getText());
			lookingFrame.dispose();
		});

		cancel.addActionListener(e -> {
			lookingFrame.dispose();
		});

	}
}
