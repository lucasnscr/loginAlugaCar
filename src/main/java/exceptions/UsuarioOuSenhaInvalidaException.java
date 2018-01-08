package exceptions;

public class UsuarioOuSenhaInvalidaException extends ExemploOAuthException {

	private static final long serialVersionUID = 1L;

	public UsuarioOuSenhaInvalidaException(String message) {
            super(message);
    }

    public UsuarioOuSenhaInvalidaException(Throwable cause) {
            super(cause);
    }
    
}