package rainbow.function.tools;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.function.Consumer;

import javax.swing.JFrame;

/**
 * Component批量设置类
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class ComponentsSetTools {

	public static void setBackground(Color color, Component... cs) {
		forEach(c -> c.setBackground(color), cs);
	}

	public static void add(JFrame jf, Component... cs) {
		forEach(c -> jf.add(c), cs);
	}

	public static void setSize(int width, int height, Component... cs) {
		forEach(c -> c.setSize(width, height), cs);
	}

	public static void setSize(Dimension d, Component... cs) {
		forEach(c -> c.setSize(d), cs);
	}

	public static void setFont(Font f, Component... cs) {
		forEach(c -> c.setFont(f), cs);
	}

	private static void forEach(Consumer<Component> con, Component[] cs) {
		for (Component c : cs) {
			con.accept(c);
		}
	}
}
