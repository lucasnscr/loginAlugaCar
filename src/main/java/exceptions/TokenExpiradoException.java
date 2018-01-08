package exceptions;

public class TokenExpiradoException extends ExemploOAuthException {

	private static final long serialVersionUID = 1L;

	public TokenExpiradoException(String message) {
            super(message);
    }

    public TokenExpiradoException(Throwable cause) {
            super(cause);
    }
    
}
