package rainbow.coordinate.dimension._2D;

import rainbow.coordinate.dimension.__abs.CoordinateSystem;
import rainbow.coordinate.dimension.__abs.CoordinateSystemPainter;

public abstract class CoordinateSystemOf2DPainter<D extends TwoDimension> extends CoordinateSystemPainter<D> {
	public CoordinateSystemOf2DPainter(CoordinateSystem<D> cs) {
		super(cs);
	}
}
