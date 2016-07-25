package rainbow.function.painter.parts;

import rainbow.function.Function;
import rainbow.function.painter.part2.AASpecialPainter;
import rainbow.function.painter.part2.AOSpecialPainter;
import rainbow.function.painter.part2.XYSpecialPainter;

public class SpecialPainterPart2 extends SpecialPainter {

	public static final int X = 0;
	public static final int Y = 1;
	public static final int O = 2;

	public SpecialPainterPart2(Function f) {
		paintImg(f);
	}

	@Override
	public void paintImg(Function f) {
		String str = f.getFunction();
		str = str.substring(0, str.length() - 2);

		String[] parts = str.split("[+]");
		switch (f.getxPartCount()) {
		case 0:
			switch (f.getyPartCount()) {
			case 0:
				// 0,0,无解
				break;
			case 1:
				// y,0
				new AOSpecialPainter(f, parts, Y);
				break;
			case 2:
				// y,y
				new AASpecialPainter(f, parts, Y);
				break;
			}

			break;
		case 1:
			switch (f.getyPartCount()) {
			case 1:
				// x,y
				new XYSpecialPainter(f, parts);
				break;
			case 0:
				// x,0
				new AOSpecialPainter(f, parts, X);
				break;
			}
			break;
		case 2:
			// x,x
			new AASpecialPainter(f, parts, X);
			break;
		}
	}

}
