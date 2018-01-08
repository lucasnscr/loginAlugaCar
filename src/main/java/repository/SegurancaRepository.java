package repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import entity.SegurancaAPI;
import entity.Usuario;


public interface SegurancaRepository extends CrudRepository<SegurancaAPI, Long> {

	@Query("SELECT seg FROM SegurancaAPI seg WHERE seg.token = :token")
	SegurancaAPI findByToken(@Param("token")String token);
	
	
	SegurancaAPI findByUsuario(Usuario usuario);	
	
}
