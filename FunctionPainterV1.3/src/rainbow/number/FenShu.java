package rainbow.number;

import java.math.BigDecimal;

/**
 * [数学]分数类
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class FenShu extends Number {

	private static final long serialVersionUID = -7974126317286190956L;

	public static final FenShu ONE = new FenShu(1);

	private BigDecimal zi = new BigDecimal("0");// 分子
	private BigDecimal mu = new BigDecimal("1");// 分母

	public FenShu() {
	}

	public FenShu(int zi, int mu) {
		if (mu != 0) {
			setZi(zi);
			setMu(mu);
		} else {
			System.out.println("分母为0");
		}
	}

	public FenShu(double zi, double mu) {
		if (mu != 0) {
			this.zi = new BigDecimal(zi);
			this.mu = new BigDecimal(mu);
			this.toInt();
		} else {
			System.out.println("分母为0");
		}
	}

	public FenShu(double zi) {
		this.zi = new BigDecimal(zi);
		this.mu = new BigDecimal(1);
		this.toInt();
	}

	/**
	 * 创建一个分数 分子为value，分母为1
	 * 
	 * @param value
	 *            分子
	 */
	public FenShu(int value) {
		this.zi = new BigDecimal(value);
	}

	/**
	 * @return 一个新的分数，其值与调用方法的分数相同
	 */
	public FenShu getFenShu() {
		return new FenShu(this.zi.intValue(), this.mu.intValue());
	}

	public FenShu add(FenShu fs) {
		FenShu newFenShu = new FenShu();
		newFenShu.zi = this.zi.multiply(fs.mu).add(fs.zi.multiply(this.mu));
		newFenShu.mu = this.mu.multiply(fs.mu);
		newFenShu.toSimple();
		return newFenShu;
	}

	public FenShu subtract(FenShu fs) {
		FenShu newFenShu = new FenShu();
		newFenShu.zi = this.zi.multiply(fs.mu).subtract(fs.zi.multiply(this.mu));
		newFenShu.mu = this.mu.multiply(fs.mu);
		newFenShu.toSimple();
		return newFenShu;
	}

	public FenShu multiply(FenShu fs) {
		FenShu newFenShu = new FenShu();
		newFenShu.zi = this.zi.multiply(fs.zi);
		newFenShu.mu = this.mu.multiply(fs.mu);
		newFenShu.toSimple();
		return newFenShu;
	}

	public FenShu divide(FenShu fs) {
		FenShu newFenShu = new FenShu();
		newFenShu.zi = this.zi.multiply(fs.mu);
		newFenShu.mu = this.mu.multiply(fs.zi);
		newFenShu.toSimple();
		return newFenShu;
	}

	public FenShu pow(int times) {
		FenShu newFenShu = new FenShu();
		newFenShu.zi = this.zi.pow(times);
		newFenShu.mu = this.mu.pow(times);
		return newFenShu;
	}

	public FenShu pow(double times) {
		FenShu newFenShu = new FenShu();
		newFenShu.zi = new BigDecimal(Math.pow(this.zi.doubleValue(), times));
		newFenShu.mu = new BigDecimal(Math.pow(this.mu.doubleValue(), times));
		newFenShu.toSimple();
		return newFenShu;
	}

	// 把通过double进行初始化的分子分母变成整数
	private void toInt() {
		double douZi = this.zi.doubleValue();
		double douMu = this.mu.doubleValue();
		while (douZi % 1 != 0 || douMu % 1 != 0) {
			douZi *= 10;
			douMu *= 10;
		}
		this.toSimple();
	}

	public void toSimple() {
		for (int x = 2; x <= this.zi.abs().intValue() || x <= this.mu.abs().intValue(); x++) {
			if (this.zi.intValue() % x == 0 && this.mu.intValue() % x == 0) {
				this.zi = new BigDecimal(this.zi.intValue() / x);
				this.mu = new BigDecimal(this.mu.intValue() / x);
				x = 2;
			}
		}
		// 把分母取正
		if (!(this.mu.abs().equals(this.mu))) {
			this.mu = this.mu.abs();
			this.zi = new BigDecimal(0).subtract(this.zi);
		}
	}

	/**
	 * @return 一个新的分数，其值与调用方法的分数的值的绝对值相同
	 */
	public FenShu abs() {
		FenShu newFenShu = new FenShu();
		if (this.isBigerThanZero()) {
			newFenShu = this.getFenShu();
		} else {
			newFenShu = this.getFuFenShu();
		}
		return newFenShu;
	}

	/**
	 * @return 一个新的分数，其值与调用方法的分数的值的相反數相同
	 */
	public FenShu getFuFenShu() {
		FenShu newFenShu = new FenShu();
		newFenShu = newFenShu.subtract(this);
		return newFenShu;
	}

	/**
	 * @return 如值大于(包括等于)0，返回true；小于0，则返回false
	 */
	public boolean isBigerThanZero() {
		return this.zi.multiply(this.mu).intValue() >= 0;
	}

	public BigDecimal getZi() {
		return zi;
	}

	public void setZi(BigDecimal zi) {
		this.zi = zi;
	}

	public void setZi(int zi) {
		this.zi = new BigDecimal(zi);
	}

	public BigDecimal getMu() {
		return mu;
	}

	public void setMu(BigDecimal mu) {
		this.mu = mu;
	}

	public void setMu(int mu) {
		this.mu = new BigDecimal(mu);
	}

	@Override
	public String toString() {
		return "[" + zi + "/" + mu + "]";
	}

	@Override
	public int intValue() {
		return this.zi.divide(mu).intValue();
	}

	@Override
	public long longValue() {
		return this.zi.divide(mu).longValue();
	}

	@Override
	public float floatValue() {
		return this.zi.divide(mu).floatValue();
	}

	@Override
	public double doubleValue() {
		return this.zi.divide(mu).doubleValue();
	}

}
