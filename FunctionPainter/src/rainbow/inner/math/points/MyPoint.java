package rainbow.inner.math.points;


import rainbow.inner.math.MyMath;

/**
 * 表示为数学上的一个点,不限维度
 *
 * @author Rainbow Yang
 */
public abstract class MyPoint {

    double[] nums;

    MyPoint(int length) {
        setLength(length);
    }

    MyPoint(double... nums) {
        setAll(nums);
    }

    /**
     * 设置所需的纬度或个数，只能设置一次
     *
     * @param length 所需的纬度或个数
     */
    void setLength(int length) {
        if (nums == null) {
            nums = new double[length];
        }
    }

    void set(int i, double value) {
        nums[i] = value;
    }

    void setAll(double... nums) {
        if (nums.length == this.nums.length || this.nums == null) {
            this.nums = nums;
        }
    }

    double get(int i) {
        return nums[i];
    }

    int getInt(int i) {
        return MyMath.toInt(get(i));
    }

    double[] getNums() {
        return nums;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + nums;
    }
}
