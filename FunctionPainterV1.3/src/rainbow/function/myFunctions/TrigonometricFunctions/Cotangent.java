package rainbow.function.myFunctions.TrigonometricFunctions;

import java.awt.Graphics;

import rainbow.function.tools.FoldLine;

public class Cotangent extends TrigonometricFunction {

	public Cotangent(double a, double w, double f) {
		super(a, w, f);
		init(x -> {
			return Math.cos(x) / Math.sin(x);
		});
	}

	public Cotangent(double a, double w) {
		super(a, w);
		init(x -> {
			return Math.cos(x) / Math.sin(x);
		});
	}

	@Override
	public void paintImage(Graphics g) {
		g.setColor(color);

		fold = new FoldLine();

		for (double x = 0; x < PI; x += s.getTheAdd() / w) {
			fold.add(x, function.apply(x));
		}
		fold.paintToAll(g, PI / w);
		// fold.paintLine(g);
	}

}
