package rainbow.frame.botton;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import rainbow.frame.MainFrame;

public class JButtonsBox {

	// 字符串常量 for location
	public static final String LEFT = "left";
	public static final String BOTTOM = "bottom";
	public static final String HIDE = "hide";

	private String location = LEFT;
	private int padding = 50;
	private int space = 20;

	//
	private int maxWidth;
	private int maxHeight;

	// 用于存储所有的按钮
	private List<JButton> buttons = new ArrayList<>();

	private Frame frame;

	public JButtonsBox(Frame frame, JButton... bs) {
		this.frame = frame;
		add(bs);
		changeBoxWidthAndHeight();

	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void relocate() {
		locate();
	}

	private void changeBoxWidthAndHeight() {
		switch (location) {
		case LEFT:
			maxWidth = buttons.get(0).getWidth() + 2 * padding;
			maxHeight = 0;
			break;
		case BOTTOM:
			maxWidth = 0;
			maxHeight = buttons.get(0).getHeight() + 2 * padding;
			break;
		default:
			break;
		}
		MainFrame.repaint();
	}

	// 重新定位按钮
	private void locate() {
		switch (location) {
		case LEFT:
			for (int x = 0; x < buttons.size(); x++) {
				JButton jb = buttons.get(x);
				jb.setLocation(MainFrame.getWidth() - (padding + jb.getWidth()),
						padding + x * (space + buttons.get(0).getHeight()));
			}
			break;
		case BOTTOM:
			for (int x = 0; x < buttons.size(); x++) {
				JButton jb = buttons.get(x);
				jb.setLocation(padding + x * (space + buttons.get(0).getWidth()),
						MainFrame.getHeight() - (padding + jb.getHeight()));
			}
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
		changeBoxWidthAndHeight();
		locate();
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
