package exceptions;

public class ExemploOAuthException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExemploOAuthException(){
		super();
	}

	public ExemploOAuthException(String message) {
		super(message);
	}

	public ExemploOAuthException(Throwable cause) {
        super(cause);
}

}
