package sisrh.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Solicitacoes {

	@XmlElement(name = "solicitacao")
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}
}
