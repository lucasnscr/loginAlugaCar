package entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import enums.RoleEnum;

@Entity
public class Permissao {
	
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE, generator = "permissao")
	@TableGenerator(name= "permissao", allocationSize = 1)
	private Long id;
	
	@NotNull
	private String nome;
	
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private RoleEnum papel;
	
	boolean isAdmin(){
		return this.papel.equals(RoleEnum.ADMIN);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public RoleEnum getPapel() {
		return papel;
	}

	public void setPapel(RoleEnum papel) {
		this.papel = papel;
	}
	
	

}
