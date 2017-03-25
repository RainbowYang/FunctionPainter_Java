package rainbow.inner.system.controller.exception;

/**
 * 当SystemController其实现类中发生错误
 * 
 * @author Rainbow Yang
 *
 */
@SuppressWarnings("serial")
public class ControllerException extends Exception {

	public ControllerException() {
		super();
	}

	public ControllerException(String message) {
		super(message);
	}
}
