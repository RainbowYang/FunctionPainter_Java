package rainbow.function.painter.parts;

import rainbow.function.Function;
import rainbow.function.painter.part3.OYYSpecialPainter;
import rainbow.function.painter.part3.XOYSpecialPainter;
import rainbow.function.painter.part3.XXOSpecialPainter;
import rainbow.function.painter.part3.XXXSpecialPainter;
import rainbow.function.painter.part3.XXYSpecialPainter;
import rainbow.function.painter.part3.XYYSpecialPainter;
import rainbow.function.painter.part3.YYYSpecialPainter;

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
				new OYYSpecialPainter(f, parts);
				break;
			case 3:
				new YYYSpecialPainter(f, parts);
				break;
			}
			break;
		case 1:
			switch (f.getyPartCount()) {
			case 1:
				new XOYSpecialPainter(f, parts);
				break;
			case 2:
				new XYYSpecialPainter(f, parts);
				break;
			}
			break;
		case 2:
			switch (f.getyPartCount()) {
			case 0:
				new XXOSpecialPainter(f, parts);
				break;
			case 1:
				new XXYSpecialPainter(f, parts);
				break;
			}
			break;
		case 3:
			new XXXSpecialPainter(f, parts);
			break;
		}
	}
}
