package rainbow.function;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

import rainbow.function.calculater.FunctionKeyGettter;
import rainbow.function.painter.FunctionImagePainter;
import rainbow.number.FenShu;
import rainbow.number.PointOfFenShu;
import rainbow.setting.Setting;

/**
 * Function类 用于存贮函数并提供计算
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class Function {

	private String function = null;

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	private BinaryOperator<FenShu> usableFunciton;

	public List<PointOfFenShu> points = Collections.synchronizedList(new ArrayList<>());

	private BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
			BufferedImage.TYPE_4BYTE_ABGR);


	public boolean is1, is2, is3, is4;

	public long start;

	private boolean showed;

	private boolean calculated;

	protected int partCount;// 用于记录函数的项数
	protected int xPartCount;// 用于记录函数的x项数
	protected int yPartCount;// 用于记录函数的y项数
	protected int OPartCount;// 用于记录函数的0项数

	public Function(String function) {
		System.out.println("函数:" + function + " 正在生成");
		this.function = function;
		this.usableFunciton = new FunctionReader().read(this);
		System.out.println("函数:" + function + " 生成完毕");

		System.out.println("函数正在计算");
		System.out.println("这需要一点时间");
		start = System.currentTimeMillis();
		new FunctionImagePainter(this);
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public boolean isCalculated() {
		return calculated;
	}

	public void setCalculated(boolean calculated) {
		this.calculated = calculated;
	}

	public int getPartCount() {
		return partCount;
	}

	public void setPartCount(int partCount) {
		this.partCount = partCount;
	}

	public int getxPartCount() {
		return xPartCount;
	}

	public void setxPartCount(int xPartCount) {
		this.xPartCount = xPartCount;
	}

	public int getyPartCount() {
		return yPartCount;
	}

	public void setyPartCount(int yPartCount) {
		this.yPartCount = yPartCount;
	}

	public int getOPartCount() {
		return OPartCount;
	}

	public void setOPartCount(int oPartCount) {
		OPartCount = oPartCount;
	}

	public boolean isOk() {
		return is1 && is2 && is3 && is4;
	}

	public BinaryOperator<FenShu> getUsableFunciton() {
		return this.usableFunciton;
	}

	public FenShu getValue(FenShu x, FenShu y) {
		return this.usableFunciton.apply(x, y);
	}

	public ArrayList<FenShu> getY(FenShu x) {
		return new FunctionKeyGettter(this.usableFunciton).getY(x);
	}

	public ArrayList<FenShu> getUpY(FenShu x) {
		return new FunctionKeyGettter(this.usableFunciton).getUpY(x);
	}

	public ArrayList<FenShu> getDownY(FenShu x) {
		return new FunctionKeyGettter(this.usableFunciton).getDownY(x);
	}

	@Override
	public String toString() {
		return this.function;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Function other = (Function) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		return true;
	}

	public boolean isNotShow() {
		return !showed;
	}

	public void showed() {
		this.showed = true;
	}
}