package sisrh.soap;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;

import sisrh.banco.Banco;
import sisrh.dto.Solicitacao;
import sisrh.dto.Solicitacoes;
import sisrh.seguranca.Autenticador;

@WebService
@SOAPBinding(style = Style.RPC)
public class ServicoSolicitacao {
	@Resource
	WebServiceContext context;

	@WebMethod(action = "listar")
	public Solicitacoes listar(String usuario) throws Exception {

		if (usuario.isEmpty() || usuario.contains("?")) {
			throw new Exception("Campo usuário é obrigatório");
		}

		Solicitacoes solicitacoes = new Solicitacoes();
		List<Solicitacao> lista = Banco.listarSolicitacoes(usuario);

		if (lista.isEmpty()) {
			throw new Exception(
					"Usuário informado não possui nenhuma solicitação");
		}

		Autenticador.autenticarUsuarioSenha(context);

		for (Solicitacao emp : lista) {
			solicitacoes.getSolicitacoes().add(emp);
		}
		return solicitacoes;
	}
}
