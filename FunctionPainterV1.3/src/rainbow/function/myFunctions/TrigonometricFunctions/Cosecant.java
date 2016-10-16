package rainbow.function.myFunctions.TrigonometricFunctions;

import java.awt.Graphics;

import rainbow.function.tools.FoldLine;

public class Cosecant extends TrigonometricFunction {

	private FoldLine fold2;

	public Cosecant(double a, double w, double f) {
		super(a, w, f);
		init(x -> {
			return 1 / Math.sin(x);
		});
	}

	public Cosecant(double a, double w) {
		super(a, w);
		init(x -> {
			return 1 / Math.sin(x);
		});
	}

	@Override
	public void paintImage(Graphics g) {

		g.setColor(color);

		fold = new FoldLine();
		fold2 = new FoldLine();

		for (double x = 0; x < PI; x += s.getTheAdd() / w) {
			fold.add(x, function.apply(x));
		}
		for (double x = PI + s.getTheAdd() / w / 10; x < PI * 2; x += s.getTheAdd() / w) {
			fold2.add(x, function.apply(x));
		}
		fold.paintToAll(g, PI * 2 / w);
		fold2.paintToAll(g, PI * 2 / w);
		// fold.paintLine(g);
		// fold2.paintLine(g);
	}

}
