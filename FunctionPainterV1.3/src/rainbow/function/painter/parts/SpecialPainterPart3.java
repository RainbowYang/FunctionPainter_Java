package rainbow.function.painter.parts;

import rainbow.function.Function;
import rainbow.function.painter.part3.AAASpecialPainter;
import rainbow.function.painter.part3.AABSpecialPainter;
import rainbow.function.painter.part3.AAOSpecialPainter;
import rainbow.function.painter.part3.XOYSpecialPainter;

public class SpecialPainterPart3 extends SpecialPainter {

	public SpecialPainterPart3(Function f) {
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
			case 2:
				new AAOSpecialPainter(f, parts, Y);
				break;
			case 3:
				new AAASpecialPainter(f, parts, Y);
				break;
			}
			break;
		case 1:
			switch (f.getyPartCount()) {
			case 1:
				new XOYSpecialPainter(f, parts);
				break;
			case 2:
				new AABSpecialPainter(f, parts, Y);
				break;
			}
			break;
		case 2:
			switch (f.getyPartCount()) {
			case 0:
				new AAOSpecialPainter(f, parts, X);
				break;
			case 1:
				new AABSpecialPainter(f, parts, X);
				break;
			}
			break;
		case 3:
			new AAASpecialPainter(f, parts, X);
			break;
		}
	}
}
