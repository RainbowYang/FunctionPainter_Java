package rainbow.frame.bottom;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import rainbow.frame.MainFrame;
import rainbow.system.System;

public class JButtonsBox {

	// 字符串常量 for location
	public static final String LEFT = "left";
	public static final String BOTTOM = "bottom";
	public static final String HIDE = "hide";

	private String location = LEFT;
	private int padding = 50;
	private int space = 20;

	private static System s = System.getSystem();

	//
	private int maxWidth;
	private int maxHeight;

	// 用于存储所有的按钮及其状态
	private List<JButton> buttons = new ArrayList<>();

	private Frame frame;

	public JButtonsBox(Frame frame, JButton... bs) {
		this.frame = frame;
		maxWidth = bs[0].getWidth() + 2 * padding;
		maxHeight = bs[0].getHeight() + 2 * padding;
		changeSystemWidthAndHeight();
		add(bs);
	}

	private void changeSystemWidthAndHeight() {
		// 重新加载中心
		s.setChanged(true);
		s.reO();
		switch (location) {
		case LEFT:
			s.setWidth(s.getWidth() - maxWidth);
			break;
		case BOTTOM:
			s.setHeight(s.getHeight() - maxHeight);
			break;
		default:
			break;
		}
		MainFrame.repaint();
	}

	private void locate() {
		switch (location) {
		case LEFT:
			for (int x = 0; x < buttons.size(); x++) {
				buttons.get(x).setLocation(s.getWidth() + padding, padding + x * (space + buttons.get(0).getHeight()));
			}
			break;
		case BOTTOM:
			break;
		default:
			break;
		}
	}

	public void add(JButton... bs) {
		for (JButton b : bs) {
			buttons.add(b);
			frame.add(b);
		}
		locate();
		MainFrame.repaint();
	}

	public void remove(JButton... bs) {
		for (JButton b : bs) {
			buttons.remove(b);
			frame.remove(b);
		}
		locate();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}
}
