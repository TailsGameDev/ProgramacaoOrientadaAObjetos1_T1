
public class SessaoEntidade {
	
	private String sessao;
	private UrnaEntidade urna;
	
	public SessaoEntidade(String s, UrnaEntidade u) {
		sessao=s; urna =u;
		u.setSessao(this);
	}
	
	public String getSessao() {
		return sessao;
	}
	public void setSessao(String sessao) {
		this.sessao = sessao;
	}
	public UrnaEntidade getUrna() {
		return urna;
	}
	public void setUrna(UrnaEntidade urna) {
		this.urna = urna;
	}
}
