package rainbow.inner.math.points;

/**
 * 二维点
 *
 * @author Rainbow Yang
 */
public abstract class PointOf2D extends MyPoint {
    PointOf2D() {
        super(2);
    }

    PointOf2D(double first, double second) {
        setAll(first, second);
    }

    public void setAll(double first, double second) {
        super.setAll(first, second);
    }

    public void setFirst(double first) {
        set(0, first);
    }

    public void setSecond(double second) {
        set(1, second);
    }

    public double getFirst() {
        return get(0);
    }

    public double getSecond() {
        return get(1);
    }

    public int getIntFirst() {
        return getInt(0);
    }

    public int getIntSecond() {
        return getInt(1);
    }

}
