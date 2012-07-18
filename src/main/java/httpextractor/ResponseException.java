package httpextractor;

public class ResponseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResponseException(String msg, Throwable t) {
		super(msg, t);
	}

	public ResponseException(String msg) {
		super(msg);
	}
}
