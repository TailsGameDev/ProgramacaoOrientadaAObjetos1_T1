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
		//instanciando controladores
		GeralControlador2 geralControlador = new GeralControlador2();
		CadastrosLimite cadastrosLimite = new CadastrosLimite();
		VotoControlador votoControlador = new VotoControlador();
		PrimeiroTurnoControlador primeiroTurnoControlador = new PrimeiroTurnoControlador();
		
		//iniciando cadastros
		cadastrosLimite.boasVindas();
		cadastrosLimite.povoaVotacoes(geralControlador);
		System.out.println(geralControlador.getVotacoes().get(0));
		cadastrosLimite.povoaZonas(geralControlador);
		System.out.println(geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0));
		ArrayList<CandidatoEntidade> candGov = cadastrosLimite.povoaArrayCandidatosGovernador();
		System.out.println(candGov.get(0));
		ArrayList<CandidatoEntidade> candDep = cadastrosLimite.povoaArrayCandidatosDeputado();
		System.out.println(candDep.get(0).getNome());
		cadastrosLimite.povoaSessoes(geralControlador, candGov, candDep);
		System.out.println(geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0).getSessoes().get(0));
		System.out.println(geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna().getCandidatosDeputado().get(0).getNome());
		
		//momento das alteracoes
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
		
		/* teste funcionou para um candidato gov e um dep
		votoControlador.instanciarVoto(1, 1, geralControlador.votacoes.get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna());
		votoControlador.instanciarVoto(1, 1, geralControlador.votacoes.get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna());
		votoControlador.instanciarVoto(1, 1, geralControlador.votacoes.get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna());
	
		primeiroTurnoControlador.listarVotosDeTodasAsUrnas(geralControlador.votacoes.get(0));
		primeiroTurnoControlador.gerarMapaVotosGovernador(geralControlador.votacoes.get(0));
		primeiroTurnoControlador.geraMapaVotosDeputado(geralControlador.votacoes.get(0));
		
		System.out.println(primeiroTurnoControlador.definirGovernadorVencedor(geralControlador.votacoes.get(0)).getNome());
		primeiroTurnoControlador.listaDeputadosEleitos(geralControlador.votacoes.get(0));
		for(CandidatoEntidade depEleit : primeiroTurnoControlador.getDeputadosEleitos()) {
			System.out.println(depEleit.getNome());
		}
		//*/ 
		
		//iniciando simulacao de urna
		SimulacaoLimite simulacaoLimite = new SimulacaoLimite();
		simulacaoLimite.boasVidasAaSimulacao();
		for(int i = 0; i<geralControlador.getVotacoes().size(); i++) {
			for(int j = 0; j<geralControlador.getVotacoes().get(i).getZonasEleitorais().size(); j++ ) {
				for(int k=0; k<geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes().size(); k++) {
					
		simulacaoLimite.boasVindasAaSessao(i, geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes().get(k));
					do {
						flag = simulacaoLimite.exibeMenuUrna();
						if(flag==1)
						simulacaoLimite.votar(
								geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes().get(k).getUrna(), votoControlador);
					} while(flag!= -1);
					
					
				}
			}
		}
		
		//iniciando resultados.
		ResultadosLimite resultadosLimite = new ResultadosLimite();
		do {
			flag = resultadosLimite.exibeTelaOpcoesResultado();
			switch(flag) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case -1:
					break;
				default:
					break;
			}
		} while (flag!=-1);
	}
}
