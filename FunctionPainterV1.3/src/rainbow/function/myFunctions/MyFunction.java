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
		return getClass().getSimpleName() + ":" + commonExpression;
	}

	/**
	 * 计算所有的点并添加至fold中，由paintImage()使用 <br>
	 * 也可以不实现,直接重写paintImage()
	 */
	public void calcPoints() {
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
