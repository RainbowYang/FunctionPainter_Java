package rainbow.system;

/**
 * MySystem在调用getSystem(int location)时,未找到对应时抛出
 * 
 * @author Rainbow Yang
 *
 */
public class WrongSystemLocationException extends RuntimeException {
	public WrongSystemLocationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WrongSystemLocationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public WrongSystemLocationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WrongSystemLocationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WrongSystemLocationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -522612159308372763L;

}
