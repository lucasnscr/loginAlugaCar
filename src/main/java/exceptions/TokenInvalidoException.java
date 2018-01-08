package exceptions;

public class TokenInvalidoException extends ExemploOAuthException {

	private static final long serialVersionUID = 1L;

	public TokenInvalidoException(String message) {
            super(message);
    }

    public TokenInvalidoException(Throwable cause) {
            super(cause);
    }
    
}