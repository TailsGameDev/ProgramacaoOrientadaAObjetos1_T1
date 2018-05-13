import java.util.ArrayList;

public class GeralControlador2 {
	ArrayList<VotacaoEntidade> votacoes = new ArrayList<VotacaoEntidade>();
	
	public ArrayList<VotacaoEntidade> getVotacoes() {
		return votacoes;
	}

	public void setVotacoes(ArrayList<VotacaoEntidade> votacoes) {
		this.votacoes = votacoes;
	}

	public int cadastraCoisas() {
		
		//cadastrosLimite.povoaVotacoes(this);
		
		return 99;
	}
	
	public int alteraCadastros() {
		
		return 99;
	}

	public int simulaVotacao() {
		
		return 99;
	}
	
	public int confereResultados() {
		
		return 99;
	}
	
	public static void main (String args[]) {
		GeralControlador2 geralControlador = new GeralControlador2();
		CadastrosLimite cadastrosLimite = new CadastrosLimite();
		VotoControlador votoControlador = new VotoControlador();
		PrimeiroTurnoControlador primeiroTurnoControlador = new PrimeiroTurnoControlador();
		cadastrosLimite.boasVindas();
		//geralControlador.cadastraCoisas();
		cadastrosLimite.povoaVotacoes(geralControlador);
		System.out.println(geralControlador.getVotacoes().get(0));
		cadastrosLimite.povoaZonas(geralControlador);
		System.out.println(geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0));
		ArrayList<CandidatoEntidade> candGov = cadastrosLimite.povoaArrayCandidatosGovernador();
		System.out.println(candGov.get(0));
		ArrayList<CandidatoEntidade> candDep = cadastrosLimite.povoaArrayCandidatosDeputado();
		System.out.println(candDep.get(0));
		cadastrosLimite.povoaSessoes(geralControlador, candGov, candDep);
		System.out.println(geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0).getSessoes().get(0));
		System.out.println(geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna());
		int flag = cadastrosLimite.exibeOpcoesAlteracao();
		while (flag!= -1) {
		switch(flag) {
			case 1:
					cadastrosLimite.alteraCandidatosGovernador(geralControlador);
				break;
			case 2:
					cadastrosLimite.alteraCandidatosDeputado(geralControlador);
				break;
			case 3:
					cadastrosLimite.alteraSessoes(geralControlador);
				break;
			case -1:
				break;
			default:
				break;
		}
	}
		votoControlador.instanciarVoto(1, 1, geralControlador.votacoes.get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna());
		votoControlador.instanciarVoto(1, 1, geralControlador.votacoes.get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna());
		primeiroTurnoControlador.listarVotosDeTodasAsUrnas(geralControlador.votacoes.get(0));
		primeiroTurnoControlador.gerarMapaVotosGovernador(geralControlador.votacoes.get(0));
		System.out.println(primeiroTurnoControlador.definirGovernadorVencedor(geralControlador.votacoes.get(0)).getNome());
	}
}
