package rainbow.inner.math;

import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import rainbow.inner.math.points.PointOf2D;
import rainbow.inner.math.points.PointOfAxes;
import rainbow.inner.math.points.exception.NotSupportPointException;

/**
 * 此类用于构建自身的数学类，以满足一些Math类中不能满足的功能。
 *
 * @author Rainbow Yang
 */
public class MyMath {

    /**
     * 绕原点旋转180度
     *
     * @param point 需要被旋转的点
     * @return 一个新的经过旋转处理的点
     */
    public static PointOf2D spin(PointOf2D point) {
        if (point instanceof PointOfAxes) {
            PointOfAxes pp = (PointOfAxes) point;
            return new PointOfAxes(-pp.getX(), -pp.getY());
        } else {
            throw new NotSupportPointException("不支持" + pp.toString());
        }
    }
    public static PointOf2D spin(Point2D){
        
    }

    /**
     * 比较一个数组之中的的最小值
     *
     * @param nums 要比较的数组
     * @return 最大值
     */
    public static double max(double... nums) {
        if (nums == null) {
            throw new RuntimeException("There has no num.");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        double max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = max(max, nums[i]);
        }
        return max;
    }

    /**
     * 比较一个数组之中的的最小值
     *
     * @param nums 要比较的数组
     * @return 最小值
     */
    public static double min(double... nums) {
        if (nums == null) {
            throw new RuntimeException("There has no num.");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        double min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = min(min, nums[i]);
        }
        return min;
    }

    private static double max(double a, double b) {
        return Math.max(a, b);
    }

    private static double min(double a, double b) {
        return Math.min(a, b);
    }

    /**
     * 对值进行四舍五入处理,并返回int值
     *
     * @param num
     * @return 进行四舍五入处理后的值
     */
    public static int toInt(double num) {
        return (int) (num + 0.5);
    }
}
