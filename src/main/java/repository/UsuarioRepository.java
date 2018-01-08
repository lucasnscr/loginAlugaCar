package repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;

import entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@EntityGraph(value= "perfil.permissoes", type = EntityGraphType.FETCH)
	Usuario findByLogin(String login);
	
	@EntityGraph(value= "perfil.permissoes", type = EntityGraphType.FETCH)
	Usuario findByLoginAndSenha(String login, String senha);

}
