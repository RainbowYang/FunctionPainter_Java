package rainbow.function.painter.parts;

import rainbow.function.Function;
import rainbow.function.painter.part2.OOSpecialPainter;
import rainbow.function.painter.part2.XOSpecialPainter;
import rainbow.function.painter.part2.XXSpecialPainter;
import rainbow.function.painter.part2.XYSpecialPainter;
import rainbow.function.painter.part2.YOSpecialPainter;
import rainbow.function.painter.part2.YYSpecialPainter;

public class SpecialPainterPart2 extends SpecialPainter {

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
				// 0,0
				new OOSpecialPainter(f, parts);
				break;
			case 1:
				// y,0
				new YOSpecialPainter(f, parts);
				break;
			case 2:
				// y,y
				new YYSpecialPainter(f, parts);
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
				new XOSpecialPainter(f, parts);
				break;
			}
			break;
		case 2:
			// x,x
			new XXSpecialPainter(f, parts);
			break;
		}
	}

}
