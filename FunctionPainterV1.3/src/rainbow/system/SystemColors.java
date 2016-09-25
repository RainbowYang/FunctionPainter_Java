package rainbow.system;

import java.awt.Color;

import rainbow.tools.ColorGetter;

public class SystemColors {
	private Color colorOfBack;
	private Color colorOfBlock;
	private Color colorOfO;
	private Color colorOfNum;
	private Color colorOfXY;
	private Color colorOfFunciton;

	private static SystemColors sc = new SystemColors();

	public static SystemColors getColors() {
		return sc;
	}

	private SystemColors() {
		colorOfBack = ColorGetter.getColor("");
		colorOfBlock = ColorGetter.getColor("");
		colorOfXY = ColorGetter.getColor("");
		colorOfO = ColorGetter.getColor("");
		colorOfNum = ColorGetter.getColor("");
		colorOfFunciton = ColorGetter.getColor("ff0000");
	}

	public Color getColorOfBack() {
		return colorOfBack;
	}

	public void setColorOfBack(Color colorOfBack) {
		this.colorOfBack = colorOfBack;
	}

	public Color getColorOfBlock() {
		return colorOfBlock;
	}

	public void setColorOfBlock(Color colorOfBlock) {
		this.colorOfBlock = colorOfBlock;
	}

	public Color getColorOfO() {
		return colorOfO;
	}

	public void setColorOfO(Color colorOfO) {
		this.colorOfO = colorOfO;
	}

	public Color getColorOfNum() {
		return colorOfNum;
	}

	public void setColorOfNum(Color colorOfNum) {
		this.colorOfNum = colorOfNum;
	}

	public Color getColorOfXY() {
		return colorOfXY;
	}

	public void setColorOfXY(Color colorOfXY) {
		this.colorOfXY = colorOfXY;
	}

	public Color getColorOfFunciton() {
		return colorOfFunciton;
	}

	public void setColorOfFunciton(Color colorOfFunciton) {
		this.colorOfFunciton = colorOfFunciton;
	}

}
