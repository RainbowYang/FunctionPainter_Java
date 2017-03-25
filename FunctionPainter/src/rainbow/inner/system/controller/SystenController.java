package rainbow.inner.system.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 用于控制参数
 * 
 * @author Rainbow Yang
 *
 */
public abstract class SystenController<T> {

	protected Map<String, T> map = new HashMap<>();

	public abstract void add(String s, T t);
	public abstract void set(String s, T t);
}
