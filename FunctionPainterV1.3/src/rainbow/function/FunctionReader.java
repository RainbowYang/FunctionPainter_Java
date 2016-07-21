package rainbow.function;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

import rainbow.number.FenShu;

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

	private ArrayList<BinaryOperator<FenShu>> functionParts = new ArrayList<>();
	private BinaryOperator<FenShu> usableFunciton;

	public BinaryOperator<FenShu> read(String strFunction) {
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
				functionParts.add((x, y) -> x.pow(intCan[1]).multiply(new FenShu(intCan[0])));
			} else if (s.contains("y")) {
				int[] intCan = new int[2];
				intCan[0] = Integer.parseInt(s.substring(0, s.indexOf('*')));
				intCan[1] = Integer.parseInt(s.substring(s.indexOf('^') + 1));
				functionParts.add((x, y) -> y.pow(intCan[1]).multiply(new FenShu(intCan[0])));
			} else {
				functionParts.add((x, y) -> new FenShu(Integer.parseInt(s), 1));
			}
		}

		usableFunciton = (x, y) -> {
			FenShu sum = new FenShu(0);
			for (BinaryOperator<FenShu> functionPart : functionParts) {
				sum = sum.add(functionPart.apply(x, y));
			}
			return sum;
		};
		return usableFunciton;
	}
}
