import java.util.ArrayList;

public class GeralControlador {

	public static void main(String[] args) {
		
		CandidatoControlador candidatoControlador = new CandidatoControlador();
		ZonaEleitoralControlador zonaEleitoralControlador = new ZonaEleitoralControlador();
		VotoControlador votoControlador = new VotoControlador();
		SegundoTurnoControlador segundoTurnoControlador = new SegundoTurnoControlador();
		
		
		ArrayList<CandidatoEntidade> candidatosGovernador = new ArrayList<CandidatoEntidade>();
		ArrayList<CandidatoEntidade> candidatosDeputado = new ArrayList<CandidatoEntidade>();
		
		for (int i = 1; i<6; i++) {
			PartidoEnum partido = i <3 ? PartidoEnum.PT : PartidoEnum.PSDB; 
			candidatosGovernador.add( candidatoControlador.InstanciarCandidatoGovernador("candGov" + i, partido, i)  );
			candidatosDeputado.add  ( candidatoControlador.InstanciarCandidatoDeputado  ("candDep" + i, partido, i)  );
		}
		
		UrnaEntidade urnaNaUFSC = new UrnaEntidade(5, "primeiro", candidatosGovernador, candidatosDeputado);
		SessaoEntidade sessaoFloripaUFSC = new SessaoEntidade("sessao UFSC", urnaNaUFSC);
		ZonaEleitoralEntidade zonaFlorianopolis = new ZonaEleitoralEntidade("Zona Florianopolis");
		zonaEleitoralControlador.adicionarSessaoaaZona(sessaoFloripaUFSC, zonaFlorianopolis);
		
		UrnaEntidade urnaSessaoSJ = new UrnaEntidade(5, "primeiro", candidatosGovernador, candidatosDeputado);
		SessaoEntidade sessaoZonaSJ = new SessaoEntidade("sessao em Sao Jose", urnaSessaoSJ);
		ZonaEleitoralEntidade zonaSaoJose = new ZonaEleitoralEntidade("Zona Sao Jose");
		zonaEleitoralControlador.adicionarSessaoaaZona(sessaoZonaSJ, zonaSaoJose); 
		
		//VotoEntidade voto = votoControlador.instanciarVoto(2,3,urnaNaUFSC); ok
		//System.out.println(voto.getCandidatoGovernador().getNome() + voto.getCandidatoDeputado().getNome()); ok
		
		VotacaoEntidade votacaoFlorianopolis = new VotacaoEntidade();
		segundoTurnoControlador.adicionarZonaaaVotacao(zonaFlorianopolis, votacaoFlorianopolis);
		//System.out.println(votacaoFlorianopolis.getZonasEleitorais().get(0)); ok
		
		votoControlador.instanciarVoto(1, 1, urnaNaUFSC);
		votoControlador.instanciarVoto(2, 2, urnaNaUFSC);
		votoControlador.instanciarVoto(2, 2, urnaNaUFSC);
		votoControlador.instanciarVoto(0, 0, urnaNaUFSC);
		votoControlador.instanciarVoto(42, 42, urnaNaUFSC);
//		System.out.println(urnaNaUFSC.getListaDeVotos()); ok
		segundoTurnoControlador.listarVotosDeTodasAsUrnas(votacaoFlorianopolis);
//		System.out.println(urnaNaUFSC.getListaDeVotos().get(4).getNumeroGovernador()); ok
//		System.out.println(votacaoFlorianopolis.getMapaVotosGovernador()); ok
		segundoTurnoControlador.gerarMapaVotosGovernador(votacaoFlorianopolis);
//		System.out.println(segundoTurnoControlador.definirGovernadorVencedor(votacaoFlorianopolis).getNome()); ok
		
	}

}
