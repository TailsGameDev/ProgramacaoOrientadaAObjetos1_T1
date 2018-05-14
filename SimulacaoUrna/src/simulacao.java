
public interface simulacao {
	void boasVindasAaSimulacao();
	void boasVindasAaSessao(int votacao, SessaoEntidade sessao);
	int exibeMenuUrna();
	void votar(UrnaEntidade urna, VotoControlador vc);
}
