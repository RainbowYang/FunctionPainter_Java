package rainbow.tools;

import java.awt.Color;

public class ColorGetter {
	public static Color getColor(String nm) {
		Integer intval = Integer.valueOf(nm, 16);
		int i = intval.intValue();
		return new Color((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
	}
}
