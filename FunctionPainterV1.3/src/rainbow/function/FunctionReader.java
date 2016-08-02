package rainbow.function;

import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

import rainbow.tools.MyMath;

/**
 * 
 * 函数解析
 * 
 * @author Rainbow_Yang
 * 
 * @version V1.3
 *
 */
public class FunctionReader {

	private ArrayList<DoubleBinaryOperator> functionParts = new ArrayList<>();
	private DoubleBinaryOperator usableFunciton;

	public DoubleBinaryOperator read(Function f) {
		String strFunction = f.getFunction();
		String[] part;
		if (!strFunction.contains("+")) {
			part = new String[1];
			part[0] = strFunction.substring(0, strFunction.length() - 2);
		} else {
			part = strFunction.split("[+]");
			part[part.length - 1] = part[part.length - 1].substring(0, part[part.length - 1].length() - 2);
		}

		for (String s : part) {
			if (s.contains("x")) {
				int[] intCan = new int[2];
				intCan[0] = Integer.parseInt(s.substring(0, s.indexOf('*')));
				intCan[1] = Integer.parseInt(s.substring(s.indexOf('^') + 1));

				functionParts.add((x, y) -> MyMath.pow(x, intCan[1]) * intCan[0]);
				f.xPartCount++;
				f.partCount++;
			} else if (s.contains("y")) {
				int[] intCan = new int[2];
				intCan[0] = Integer.parseInt(s.substring(0, s.indexOf('*')));
				intCan[1] = Integer.parseInt(s.substring(s.indexOf('^') + 1));
				functionParts.add((x, y) -> MyMath.pow(x, intCan[1]) * intCan[0]);
				f.yPartCount++;
				f.partCount++;
			} else {
				functionParts.add((x, y) -> Integer.parseInt(s));
				f.OPartCount++;
				f.partCount++;
			}
		}

		usableFunciton = (x, y) -> {
			double sum = 0;
			for (DoubleBinaryOperator functionPart : functionParts) {
				sum += functionPart.applyAsDouble(x, y);
			}
			return sum;
		};
		return usableFunciton;
	}
}
