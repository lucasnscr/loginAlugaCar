package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import enums.RoleEnum;

@Entity
public class Perfil  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "perfil")
	@TableGenerator(name= "perfil", allocationSize =1)
	private Long id;
	
	@NotNull
	private String nome;
	
	private String descricao;
	
	@JsonIgnore
	@ManyToMany
	private List<Permissao> permissoes;
	
	@JsonIgnore
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;
	
	public boolean contemRoleOuAdmin(RoleEnum roleConfig) {
		
		if(CollectionUtils.isEmpty(permissoes)) {
			 if (permissoes.stream().anyMatch((perm) -> (perm.getPapel().equals(roleConfig) || perm.isAdmin()))) {
                 return true;
         }
			
		}
		
		return false;
		
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

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
