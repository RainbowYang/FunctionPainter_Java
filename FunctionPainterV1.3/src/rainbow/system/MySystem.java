package rainbow.system;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import rainbow.coordinate.dimension._2D.axes.AxesCoordinateSystem;
import rainbow.coordinate.dimension.__abs.CoordinateSystem;

public class MySystem {

	// private static List<MySystem> list = new ArrayList<>();
	private static Set<MySystem> set = Collections.synchronizedSet(new HashSet<>());

	// 记录有多少个MySystem
	private static int num = 0;

	private static int now = 0;

	private String name;
	private int location;

	/**
	 * 新建一个MySystem,name为"System-"+num,num从0开始<br>
	 * 默认使用平面轴坐标系.
	 * 
	 * @return 所新建的MySystem
	 */
	public static MySystem createSystem() {
		return createSystem("System-" + num, new AxesCoordinateSystem());
	}

	/**
	 * 新建一个MySystem,使用给定的name<br>
	 * 默认使用平面轴坐标系.
	 * 
	 * @param name
	 *            给定的name
	 * @return 所新建的MySystem
	 */
	public static MySystem createSystem(String name) {
		return createSystem(name, new AxesCoordinateSystem());
	}

	/**
	 * 新建一个MySystem,name为"System-"+num,num从0开始<br>
	 * 使用给定的坐标系.
	 * 
	 * @param cs
	 *            给定的坐标系
	 * @return 所新建的MySystem
	 */
	public static MySystem createSystem(CoordinateSystem cs) {
		return createSystem("System-" + num, cs);
	}

	/**
	 * 新建一个MySystem,使用给定的name,CoordinateSystem.
	 * 
	 * @param name
	 *            给定的name
	 * @param cs
	 *            给定的坐标系
	 * @return 所新建的MySystem
	 */
	public static MySystem createSystem(String name, CoordinateSystem cs) {
		MySystem s = new MySystem();
		s.location = num;
		s.name = name;
		s.cs = cs;

		num++;

		set.add(s);
		return s;
	}

	/**
	 * 通过其MySystem的location获得MySystem
	 * 
	 * @param location
	 * @return 对应的MySystem
	 * @throws WrongSystemLocationException
	 */
	public static MySystem getSystem(int location) {
		for (MySystem mySystem : set) {
			if (mySystem.location == location) {
				return mySystem;
			}
		}
		throw new WrongSystemLocationException("No system has this location:" + location);
	}

	/**
	 * 通过其MySystem的name获得MySystem
	 * 
	 * @param name
	 * @return 对应的MySystem
	 * @throws WrongSystemNameException
	 */
	public static MySystem getSystem(String name) {
		for (MySystem mySystem : set) {
			if (mySystem.name == name) {
				return mySystem;
			}
		}
		throw new WrongSystemNameException("No system has this name:" + name);
	}

	/**
	 * 返回当前所处的MySystem
	 * @return
	 */
	public static MySystem getSystem() {
		return getSystem(now);
	}

	public static void changeLocation(MySystem s1, MySystem s2) {
		if (s1.equals(s2))
			return;

		int location = s1.location;
		s1.location = s2.location;
		s2.location = location;
	}

	public CoordinateSystem cs;

	public void setCoordinateSystem(CoordinateSystem cs) {
		this.cs = cs;
	}

	public CoordinateSystem getCoordinateSystem() {
		return cs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + location;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySystem other = (MySystem) obj;
		if (location != other.location)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MySystem [name=" + name + ", location=" + location + "]";
	}

}
