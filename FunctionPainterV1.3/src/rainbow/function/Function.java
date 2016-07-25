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

	private BinaryOperator<FenShu> usableFunciton;

	private List<PointOfFenShu> points = Collections.synchronizedList(new ArrayList<>());

	private BufferedImage img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight,
			BufferedImage.TYPE_4BYTE_ABGR);

	private boolean hasImg, showed, finishedThread1, finishedThread2, finishedThread3, finishedThread4;

	public long start;

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

	public void cleanImg() {
		this.img = new BufferedImage(Setting.MainFrameWidth, Setting.MainFrameHeight, BufferedImage.TYPE_4BYTE_ABGR);
	}

	public void setFinishedThread1() {
		this.finishedThread1 = true;
	}

	public void setFinishedThread2() {
		this.finishedThread2 = true;
	}

	public void setFinishedThread3() {
		this.finishedThread3 = true;
	}

	public void setFinishedThread4() {
		this.finishedThread4 = true;
	}

	public void setHasPoints() {
		setFinishedThread1();
		setFinishedThread2();
		setFinishedThread3();
		setFinishedThread4();
	}

	public boolean hasPoints() {
		// 所有都完成了才表示有了完整的点集
		return finishedThread1 && finishedThread2 && finishedThread3 && finishedThread4;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public BinaryOperator<FenShu> getUsableFunciton() {
		return usableFunciton;
	}

	public void setUsableFunciton(BinaryOperator<FenShu> usableFunciton) {
		this.usableFunciton = usableFunciton;
	}

	public List<PointOfFenShu> getPoints() {
		return points;
	}

	public void setPoints(List<PointOfFenShu> points) {
		this.points = points;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public boolean isShowed() {
		return showed;
	}

	public void setShowed() {
		this.showed = true;
	}

	public boolean hasImg() {
		return hasImg;
	}

	public void setHasImg() {
		this.hasImg = true;
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
}