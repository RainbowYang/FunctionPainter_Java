package rainbow.outer.tools;

import java.awt.Color;

public class ColorGetter {

	/**
	 * @param RGB
	 *            共六位 e.g. FFFFFF
	 * @return 六位RGB所对应的Color类
	 */
	public static Color getColor(String RGB) {
		if (RGB.isEmpty()) {
			return Color.black;
		} else {
			Integer intval = Integer.valueOf(RGB, 16);
			int i = intval.intValue();
			return new Color((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
		}
	}

	/**
	 * @return 默认为黑色
	 */
	public static Color getColor() {
		return Color.BLACK;
	}
}
