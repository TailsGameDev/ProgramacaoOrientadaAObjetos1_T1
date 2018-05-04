import java.util.ArrayList;

public class ZonaEleitoralControlador {
	public void adicionarSessaoaaZona(SessaoEntidade se, ZonaEleitoralEntidade zee) {
		ArrayList<SessaoEntidade> sessoes = zee.getSessoes();
		sessoes.add(se);
		zee.setSessoes(sessoes);
	}
}
