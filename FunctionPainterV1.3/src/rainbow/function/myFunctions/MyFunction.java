package rainbow.function.myFunctions;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Function;

import rainbow.function.tools.FoldLine;
import rainbow.system.System;

public abstract class MyFunction {

	protected String commonExpression;
	protected String specialExpression;

	protected FoldLine fold = new FoldLine();
	protected Function<Double, Double> function;

	protected boolean isShow = true;

	protected Color color = Color.red;

	protected System s = System.getSystem();

	@Override
	public String toString() {
		return getClass().getName() + ":" + commonExpression;
	}

	/**
	 * 计算数据
	 */
	public void init() {
	}

	/**
	 * 绘画
	 * 
	 * @param g
	 *            画笔
	 */
	public void paintImage(Graphics g) {
		g.setColor(color);
		fold.paintLine(g);
	}

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
