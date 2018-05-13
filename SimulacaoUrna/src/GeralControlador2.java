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
		cadastrosLimite.boasVindas();
		//geralControlador.cadastraCoisas();
		cadastrosLimite.povoaVotacoes(geralControlador);
		cadastrosLimite.povoaZonas(geralControlador);
		ArrayList<CandidatoEntidade> candGov = cadastrosLimite.povoaArrayCandidatosGovernador();
		ArrayList<CandidatoEntidade> candDep = cadastrosLimite.povoaArrayCandidatosDeputado();
		cadastrosLimite.povoaSessoes(geralControlador, candGov, candDep);
		
	}
}
