package resource;

import javax.servlet.http.HttpServletRequest;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import anotacoes.Privado;
import anotacoes.Publico;
import entity.SegurancaAPI;
import enums.RoleEnum;
import seguranca.SegurancaService;
import util.ExemploOAuthController;

@Controller
@RequestMapping(value = "/seguranca")
public class SegurancaController extends ExemploOAuthController{
        
        @Autowired
        private SegurancaService segurancaService;
        
        @Publico
        @ResponseBody
        @RequestMapping(value = "/logar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String logar(HttpServletRequest request) {
                OAuthResponse response = segurancaService.logarOAuth(request);
                return response.getBody();
	}
        
        @Privado(role=RoleEnum.GERAL)
        @ResponseBody
        @RequestMapping(value = "/usuario/logado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SegurancaAPI retornarUsuarioLogado(HttpServletRequest request) {
                return segurancaService.getUsuarioLogado();
	}
}
