package rainbow.number;

import java.math.BigDecimal;

public class FenShu extends Number {

	private static final long serialVersionUID = -7974126317286190956L;

	private BigDecimal zi = new BigDecimal("0");// 分子
	private BigDecimal mu = new BigDecimal("1");// 分母

	public FenShu(int zi, int mu) {
		if (mu != 0) {
			setZi(zi);
			setMu(mu);
		} else {
			System.out.println("分母为0");
		}
	}

	public FenShu(int value) {
		this.zi = new BigDecimal(value);
	}

	public FenShu add(FenShu fs) {
		this.zi = this.zi.multiply(fs.mu).add(fs.zi.multiply(this.mu));
		this.mu = this.mu.multiply(fs.mu);
		this.toSimple();
		return this;
	}

	public FenShu subtract(FenShu fs) {
		this.zi = this.zi.multiply(fs.mu).subtract(fs.zi.multiply(this.mu));
		this.mu = this.mu.multiply(fs.mu);
		this.toSimple();
		return this;
	}

	public FenShu multiply(FenShu fs) {
		this.zi = this.zi.multiply(fs.zi);
		this.mu = this.mu.multiply(fs.mu);
		this.toSimple();
		return this;
	}

	public FenShu divide(FenShu fs) {
		this.zi = this.zi.multiply(fs.mu);
		this.mu = this.mu.multiply(fs.zi);
		this.toSimple();
		return this;
	}

	public FenShu pow(int times) {
		this.zi = this.zi.pow(times);
		this.mu = this.mu.pow(times);
		return this;
	}

	public void toSimple() {
		for (int x = 2; x < this.zi.intValue() || x < this.mu.intValue(); x++) {
			// for (int x = 2; x <= this.zi.intValue() || x <=
			// this.mu.intValue(); x++) {
			if (this.zi.intValue() % x == 0 && this.mu.intValue() % x == 0) {
				this.zi = new BigDecimal(this.zi.intValue() / x);
				this.mu = new BigDecimal(this.mu.intValue() / x);
				x = 2;
			}
		}
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
		return "FenShu [" + zi + "/" + mu + "]";
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
