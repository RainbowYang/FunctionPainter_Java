package rainbow.inner.math.points.exception;

/**
 * @author Rainbow Yang
 * @Date 2017/3/4.
 */
public class NotSupportPointException extends RuntimeException {

    public NotSupportPointException() {
    }

    public NotSupportPointException(String message) {
        super(message);
    }

    public NotSupportPointException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportPointException(Throwable cause) {
        super(cause);
    }

    public NotSupportPointException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
