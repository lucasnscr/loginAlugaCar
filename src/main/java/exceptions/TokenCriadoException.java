package exceptions;

import entity.SegurancaAPI;

public class TokenCriadoException extends ExemploOAuthException {

	private static final long serialVersionUID = 1L;
	private SegurancaAPI segurancaAPI;
	
    public TokenCriadoException(SegurancaAPI segurancaAPI) {
            super("Token ja criado para este usuario.");
            this.segurancaAPI = segurancaAPI;
    }
	public SegurancaAPI getSegurancaAPI() {
		return segurancaAPI;
	}

}
