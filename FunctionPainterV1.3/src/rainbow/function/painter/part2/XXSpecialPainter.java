package rainbow.function.painter.part2;

import rainbow.function.Function;
import rainbow.function.painter.parts.SpecialPainter;

public class XXSpecialPainter extends SpecialPainter {

	public XXSpecialPainter(Function f) {
		paintImg(f);
	}

	@Override
	public void paintImg(Function f) {

		String str = f.getFunction();
		str = str.substring(0, str.length() - 2);

		String[] parts = str.split("[+]");
		
		

	}

}
