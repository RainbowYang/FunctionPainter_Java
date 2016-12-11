package rainbow.frame.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import rainbow.frame.MySmallFrame;
import rainbow.function.myFunctions.ExponentialFunction;
import rainbow.function.myFunctions.Line;
import rainbow.function.myFunctions.LogarithmicFunction;
import rainbow.function.myFunctions.MyFunction;
import rainbow.function.myFunctions.ConicalSection.Hyperbola;
import rainbow.function.myFunctions.ConicalSection.Oval;
import rainbow.function.myFunctions.ConicalSection.Parabola;
import rainbow.function.myFunctions.TrigonometricFunctions.Cosecant;
import rainbow.function.myFunctions.TrigonometricFunctions.Cosine;
import rainbow.function.myFunctions.TrigonometricFunctions.Cotangent;
import rainbow.function.myFunctions.TrigonometricFunctions.Secant;
import rainbow.function.myFunctions.TrigonometricFunctions.Sine;
import rainbow.function.myFunctions.TrigonometricFunctions.Tangent;

/**
 * AddMenu控制
 * 
 * @author Rainbow Yang
 *
 */
public class MainFrameAddMenuController {

	/**
	 * 一般类型
	 */
	public static final String COMMOM = "Commom";

	/**
	 * 圆锥曲线
	 */
	public static final String CONICAL_SECTION = "ConicalSection";

	/**
	 * 三角函数
	 */
	public static final String TRIGONOMETRIC_FUNCTION = "TrigonometricFunction";

	/**
	 * K = String(比如COMMOM,CONICAL_SECTION,TRIGONOMETRIC_FUNCTION) <br>
	 * V = 其中的子类的Class类的List集合
	 */
	public static Map<String, List<Class<? extends MyFunction>>> mainMap = new HashMap<>();

	/**
	 * K = String(比如COMMOM,CONICAL_SECTION,TRIGONOMETRIC_FUNCTION)<br>
	 * V = 对应其在MainFrame显示的命名为如上几类的JMenu
	 */
	private static Map<String, JMenu> menus;

	// JMenu(比如COMMOM,CONICAL_SECTION,TRIGONOMETRIC_FUNCTION) 对应其中的JMenuItem
	private static Map<JMenu, JMenuItem> menuItems = new HashMap<>();

	/**
	 * 
	 * 添加MyFunction一组的Class类到对应的组
	 * 
	 * @param clazz
	 *            extends MyFunction
	 * @param type
	 *            需要加入的组别
	 * @return add successfully or not
	 */
	public static boolean addClassTo(Class<? extends MyFunction> clazz, String type) {
		return mainMap.get(type).add(clazz);
	}

	static {
		// 创建三大组
		mainMap.put(COMMOM, new ArrayList<>());
		mainMap.put(CONICAL_SECTION, new ArrayList<>());
		mainMap.put(TRIGONOMETRIC_FUNCTION, new ArrayList<>());

		// 添加其子类
		addClassTo(new Line(0, 0, 0).getClass(), COMMOM);
		addClassTo(new LogarithmicFunction(0, 0).getClass(), COMMOM);
		addClassTo(new ExponentialFunction(0, 0).getClass(), COMMOM);

		addClassTo(new Hyperbola(0, 0, 0, 0).getClass(), CONICAL_SECTION);
		addClassTo(new Parabola(0, 0, 0, 0).getClass(), CONICAL_SECTION);
		addClassTo(new Oval(0, 0, 0, 0).getClass(), CONICAL_SECTION);

		addClassTo(new Sine(0, 0).getClass(), TRIGONOMETRIC_FUNCTION);
		addClassTo(new Cosine(0, 0).getClass(), TRIGONOMETRIC_FUNCTION);
		addClassTo(new Tangent(0, 0).getClass(), TRIGONOMETRIC_FUNCTION);
		addClassTo(new Cotangent(0, 0).getClass(), TRIGONOMETRIC_FUNCTION);
		addClassTo(new Secant(0, 0).getClass(), TRIGONOMETRIC_FUNCTION);
		addClassTo(new Cosecant(0, 0).getClass(), TRIGONOMETRIC_FUNCTION);
	}

	/**
	 * @param menus
	 * @return this
	 */
	public MainFrameAddMenuController setMenuMap(Map<String, JMenu> menus) {
		MainFrameAddMenuController.menus = menus;
		return this;
	}

	/**
	 * 生成与Class类对应的JMenuItem,并添加到对应的JMenu<br>
	 * 同时添加生成添加窗口(MySmallFrame),通过Class,具体界面由MyFunction实现
	 */
	public void addToMenu() {
		for (String type : menus.keySet()) {
			for (Class<? extends MyFunction> clazz : mainMap.get(type)) {
				JMenuItem jmi = new JMenuItem(clazz.getSimpleName());
				jmi.addActionListener(l -> {
					new MySmallFrame(clazz);
				});
				menuItems.put(menus.get(type), jmi);
				menus.get(type).add(jmi);
			}
		}
	}

}
