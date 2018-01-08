package enums;


public enum RoleEnum {

    GERAL(1),
    VISITANTE(2),
    ADMIN(3);

    private int valor;

    RoleEnum(int valor){ this.valor = valor;}

    public int getEmprestado(){return valor;}

	public int getValor() {
		return valor;
	}

}
