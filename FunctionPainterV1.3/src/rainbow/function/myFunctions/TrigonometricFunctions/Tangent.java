package rainbow.function.myFunctions.TrigonometricFunctions;

import java.awt.Graphics;

import rainbow.function.tools.FoldLine;

public class Tangent extends TrigonometricFunction {

	public Tangent(double a, double w, double f) {
		super(a, w, f);
		init(x -> {
			return Math.sin(x) / Math.cos(x);
		});
	}

	public Tangent(double a, double w) {
		super(a, w);
		init(x -> {
			return Math.sin(x) / Math.cos(x);
		});
	}

	@Override
	public void paintImage(Graphics g) {
		g.setColor(color);

		fold = new FoldLine();

		for (double x = -PI / 2; x < PI / 2; x += s.getTheAdd() / w) {
			fold.add(x, function.apply(x));
		}
		fold.paintToAll(g, PI/w);
		// fold.paintLine(g);
	}

}
