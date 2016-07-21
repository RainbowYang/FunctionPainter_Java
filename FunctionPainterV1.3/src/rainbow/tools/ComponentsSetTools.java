package rainbow.tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;

/**
 * Component批量设置类
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class ComponentsSetTools {

	public static void add(JFrame jf, Component... components) {
		for (Component c : components) {
			jf.add(c);
		}
	}

	public static void setSize(int width, int height, Component... components) {
		for (Component c : components) {
			c.setSize(width, height);
		}
	}

	public static void setSize(Dimension d, Component... components) {
		for (Component c : components) {
			c.setSize(d);
		}
	}

	public static void setFont(Font f, Component... components) {
		for (Component c : components) {
			c.setFont(f);
		}
	}
}
