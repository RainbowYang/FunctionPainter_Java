package rainbow.function.myFunctions;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Function;

import rainbow.function.tools.FoldLineForMyFunction;
import rainbow.system.System;

public abstract class MyFunction {

	protected String commonExpression;
	protected String specialExpression;
	protected String type;

	protected FoldLineForMyFunction fold;
	protected Function<Double, Double> function;

	protected boolean isShow = true;

	protected Color color = Color.BLACK;

	protected System s = System.getSystem();

	@Override
	public String toString() {
		return type + ":" + commonExpression;
	}

	public abstract void paintImage(Graphics g);

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

}