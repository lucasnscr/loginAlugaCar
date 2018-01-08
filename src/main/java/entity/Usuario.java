package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "usuario")
	@TableGenerator(name = "usuario", allocationSize = 1)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	@Size(min = 1, max = 20)
	@Column(unique = true)
	private String login;

	@NotNull
	@Size(min = 1)
	private String senha;

	@ManyToOne(optional = false)
	private Perfil perfil;

	public Usuario() {
	}

	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(String login) {
		this.login = login;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

}
