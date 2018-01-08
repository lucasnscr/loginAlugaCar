package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;


@Entity
public class SegurancaAPI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "seguranca")
	@TableGenerator(name = "seguranca", allocationSize = 1)
	private Long id;
	
	@Column(length = 1000)
	private String token = "(init)";
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiracaoToken = new Date();
	
	@OneToOne
	private Usuario usuario;
	
	public SegurancaAPI(String token, Date expiracaoToken, Usuario usuario){
		this.token =token;
		this.expiracaoToken = expiracaoToken;
		this.usuario = usuario;
	}
	
	public SegurancaAPI() {
		
	}
	
	public void atualizarToken(String token, Date expiracaoToken) {
		this.token = token;
		this.expiracaoToken = expiracaoToken;
	}
	
	public void expirarToken() {
		this.atualizarToken("", new Date());
	}
	
	public boolean expirado() {
		return expiracaoToken != null && expiracaoToken.before(new Date());
	}
	
	public String getToken() {
		if(StringUtils.isBlank(token)) {
			return null;
		}
		
		return token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExpiracaoToken() {
		return expiracaoToken;
	}

	public void setExpiracaoToken(Date expiracaoToken) {
		this.expiracaoToken = expiracaoToken;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean isSalvo() {
		return getId() != null;
	}
}
