package rainbow.function;

import java.util.ArrayList;

import rainbow.number.FenShu;

public class FunctionReader {

	private ArrayList<java.util.function.Function<FenShu[], FenShu>> functionParts = new ArrayList<>();

	public java.util.function.Function<FenShu[], FenShu> read(String strFunction) {

		String[] part;
		if (!strFunction.contains("+")) {
			part = new String[1];
			part[0] = strFunction.substring(0, strFunction.length() - 2);
		} else {
			part = strFunction.split("+");
			part[part.length - 1] = part[part.length - 1].substring(0, part[part.length - 1].length() - 2);
		}

		for (String s : part) {
			if (s.contains("x")) {
				String[] can = s.split("*x^");
				int[] intCan = new int[2];
				intCan[0] = Integer.parseInt(can[0]);
				intCan[1] = Integer.parseInt(can[1]);
				functionParts.add((FenShu[] fs) -> fs[0].pow(intCan[1]).multiply(new FenShu(intCan[0], 1)));
			} else if (s.contains("y")) {

				String[] can = s.split("*y^");
				int[] intCan = new int[2];
				intCan[0] = Integer.parseInt(can[0]);
				intCan[1] = Integer.parseInt(can[1]);

				functionParts.add(fs -> fs[1].pow(intCan[1]).multiply(new FenShu(intCan[0], 1)));
			} else {
				functionParts.add(fs -> new FenShu(Integer.parseInt(s), 1));
			}

		}

		return null;
	}
}
