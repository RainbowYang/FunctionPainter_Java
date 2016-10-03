package rainbow.function.functions;

import java.util.ArrayList;
import java.util.List;

public class Functions {
	public static final List<MyFunction> functions = new ArrayList<>();

	public static void add(MyFunction f) {
		functions.add(f);
	}

	public static boolean remove(MyFunction f) {
		return functions.remove(f);
	}
}
