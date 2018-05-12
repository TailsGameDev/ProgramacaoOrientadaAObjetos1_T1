import java.util.ArrayList;
import java.util.Scanner;

public class GeralControlador {

	public static void main(String[] args) {
		
		/*
		Scanner scanner = new Scanner(System.in);
		PrimeiroTurnoControlador primeiroTurnoControl = new PrimeiroTurnoControlador();
		
		System.out.println("Bem vindx aa simulacao de urna. Aperte Enter para cadastrar uma votacao");
		
		int turno=0;
		while (turno != 1 || turno !=2) {
			System.out.println("digite 1 para primeiro turno, 2 para segundo");
			turno = scanner.nextInt();
		}
		
		*/
		
		
		//instanciando controladores
		CandidatoControlador candidatoControlador = new CandidatoControlador();
		ZonaEleitoralControlador zonaEleitoralControlador = new ZonaEleitoralControlador();
		VotoControlador votoControlador = new VotoControlador();
		SegundoTurnoControlador segundoTurnoControlador = new SegundoTurnoControlador();
		
		
		//criando arrays de candidatos
		ArrayList<CandidatoEntidade> candidatosGovernador = new ArrayList<CandidatoEntidade>();
		ArrayList<CandidatoEntidade> candidatosDeputado = new ArrayList<CandidatoEntidade>();
		
		
		//povoando arrays de candidatos
		for (int i = 1; i<6; i++) {
			PartidoEnum partido = i <3 ? PartidoEnum.PT : PartidoEnum.PSDB; 
			candidatosGovernador.add( candidatoControlador.InstanciarCandidatoGovernador("candGov" + i, partido, i)  );
			candidatosDeputado.add  ( candidatoControlador.InstanciarCandidatoDeputado  ("candDep" + i, partido, i)  );
		}
		
		//cadastrando urna, secao e zona
		UrnaEntidade urnaNaUFSC = new UrnaEntidade(5, "primeiro", candidatosGovernador, candidatosDeputado); // a urna se constroi com qtdd de eleitores, turno, e candidatos
		SessaoEntidade sessaoFloripaUFSC = new SessaoEntidade("sessao UFSC", urnaNaUFSC); //a secao guarda um nome e uma urna
		ZonaEleitoralEntidade zonaFlorianopolis = new ZonaEleitoralEntidade("Zona Florianopolis"); //zona soh tem o nome
		zonaEleitoralControlador.adicionarSessaoaaZona(sessaoFloripaUFSC, zonaFlorianopolis); //dai tem que adicionar sessoes aa ela
		urnaNaUFSC.setZonaEleitoral(zonaFlorianopolis); //a urna guarda sessao e zona, mas nao as usa
		urnaNaUFSC.setSessao(sessaoFloripaUFSC);
		
		UrnaEntidade urnaSessaoSJ = new UrnaEntidade(5, "primeiro", candidatosGovernador, candidatosDeputado);
		SessaoEntidade sessaoZonaSJ = new SessaoEntidade("sessao em Sao Jose", urnaSessaoSJ);
		ZonaEleitoralEntidade zonaSaoJose = new ZonaEleitoralEntidade("Zona Sao Jose");
		zonaEleitoralControlador.adicionarSessaoaaZona(sessaoZonaSJ, zonaSaoJose);
		urnaSessaoSJ.setZonaEleitoral(zonaSaoJose);
		urnaNaUFSC.setSessao(sessaoZonaSJ);
		
		//VotoEntidade voto = votoControlador.instanciarVoto(2,3,urnaNaUFSC); exemplo de instanciacao de voto
		//System.out.println(voto.getCandidatoGovernador().getNome() + voto.getCandidatoDeputado().getNome()); exemplo de acessar informacao do voto
		
		
		//TESTANDO VOTACAO SEGUNDO TURNO
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
		int nulos = segundoTurnoControlador.contarVotosNulosGovernador(votacaoFlorianopolis);
		int brancos = segundoTurnoControlador.contarVotosBrancosGovernador(votacaoFlorianopolis);
		
		//TESTANDO VOTACAO PRIMEIRO TURNO
		VotacaoEntidade votacaoSaoJose = new VotacaoEntidade();

		//System.out.println("im here");
		
	}
}
