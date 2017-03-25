package rainbow.inner.math.points.exception;

/**
 * 当点接收到错误维度的参数的时抛出此异常
 * @author Rainbow Yang
 * @version V1.4
 */
public class NotRightDimensionException extends RuntimeException{

    public NotRightDimensionException() {
    }

    public NotRightDimensionException(String message) {
        super(message);
    }

    public NotRightDimensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotRightDimensionException(Throwable cause) {
        super(cause);
    }

    public NotRightDimensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}