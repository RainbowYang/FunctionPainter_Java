package rainbow.coordinate.dimension._2D;

import rainbow.coordinate.dimension.__abs.CoordinateSystem;
import rainbow.coordinate.dimension.__abs.CoordinateSystemLocationGetter;

public abstract class CoordinateSystemOf2DLocationGetter<D extends TwoDimension>
		extends CoordinateSystemLocationGetter<D> {

	public CoordinateSystemOf2DLocationGetter(CoordinateSystem<D> cs) {
		super(cs);
	}
}
