package rainbow.function.painter.parts;

import rainbow.function.Function;
import rainbow.function.calculater.FunctionCalculater;

public class SpecialPainterPart3 extends SpecialPainter {

	public SpecialPainterPart3(Function f) {
		paintImg(f);
	}

	@Override
	public void paintImg(Function f) {
		String str = f.getFunction();
		str = str.substring(0, str.length() - 2);
		String[] parts = str.split("[+]");

		new FunctionCalculater(f);

	}

}
