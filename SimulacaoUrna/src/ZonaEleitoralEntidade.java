import java.util.ArrayList;

public class ZonaEleitoralEntidade {
	private String ZonaEleitoral;
	private ArrayList<SessaoEntidade> sessoes = new ArrayList<SessaoEntidade>();
	
	public ZonaEleitoralEntidade(String z) {
		ZonaEleitoral = z;
	}
	
	public String getZonaEleitoral() {
		return ZonaEleitoral;
	}
	public void setZonaEleitoral(String zonaEleitoral) {
		ZonaEleitoral = zonaEleitoral;
	}
	public ArrayList<SessaoEntidade> getSessoes() {
		return sessoes;
	}
	public void setSessoes(ArrayList<SessaoEntidade> sessoes) {
		this.sessoes = sessoes;
	}
}
