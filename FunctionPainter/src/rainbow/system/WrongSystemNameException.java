package rainbow.system;

/**
 * MySystem在调用getSystem(String name)时,name未找到对应时抛出
 * 
 * @author Rainbow Yang
 *
 */
public class WrongSystemNameException extends RuntimeException {
	private static final long serialVersionUID = 8316985534243272687L;

	public WrongSystemNameException() {
		super();
	}

	public WrongSystemNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WrongSystemNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongSystemNameException(String message) {
		super(message);
	}

	public WrongSystemNameException(Throwable cause) {
		super(cause);
	}

}
