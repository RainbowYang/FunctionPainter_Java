package rainbow.function.painter;

import rainbow.function.Function;
import rainbow.function.calculater.FunctionCalculater;
import rainbow.function.painter.parts.SpecialPainterPart2;
import rainbow.function.painter.parts.SpecialPainterPart3;

/**
 * 此类用于选出一些特殊情况，最后在执行暴力循环求解。
 * 
 * @author Rainbow_Yang
 *
 */
public class FunctionImagePainter {

	public FunctionImagePainter(Function f) {

		switch (f.getPartCount()) {
		case 1:
			//只有一项不处理
			break;
		case 2:
			new SpecialPainterPart2(f);
			break;
		case 3:
			new SpecialPainterPart3(f);
			break;
		default:
			new FunctionCalculater(f);
			break;
		}
	}
}
