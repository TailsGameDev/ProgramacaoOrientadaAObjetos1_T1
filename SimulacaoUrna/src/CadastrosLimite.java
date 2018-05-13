import java.util.ArrayList;
import java.util.Scanner;

public class CadastrosLimite {
	
	CandidatoControlador candidatoControlador = new CandidatoControlador();
	
	public void boasVindas() {
		System.out.println("Bem vindx aa simulacao de urna. Vamos comecar simulando o primeiro turno de uma votacao. Por favor, cadastre os candidatos.");
	}
	
	public ArrayList<CandidatoEntidade> povoaArrayCandidatosGovernador() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<CandidatoEntidade> candidatos = new ArrayList<>();
		System.out.println("Cadastro de candidatos para governador.");
		int flag = 0;
		do {
			System.out.println("Entre com uma das opcoes: ");
			System.out.println("1: cadastrar candidato.");
			System.out.println("2: remover candidato.");
			System.out.println("-1: Encerrar");
			switch(flag) {
				case 1:
					
					System.out.println("Digite o nome do candidato");
					String nome = scanner.next();
					
					System.out.println("Entre com o numero do Partido");
					PartidoEnum ap[] = PartidoEnum.values(); //sigla para Array de Partidos
					
					for (int i = 0; i<ap.length; i++) {
						System.out.println(i + ": " + ap[i]);
					}
					PartidoEnum partido = ap[scanner.nextInt()];
					
					System.out.println("Entre com o numero do candidato, de 1 a 98");
					int numero = scanner.nextInt();
					
					CandidatoEntidade cand = this.candidatoControlador.InstanciarCandidatoGovernador(nome, partido, numero);
					cand.setCargo(CargoEnum.GOVERNADOR);
					
					candidatos.add(cand);
					break;
					
				case 2:
					System.out.println("Favor entrar com o nome do candidato");
					String name = scanner.next();
					boolean removido = false;
					for(int i =0; i<candidatos.size(); i++) {
						CandidatoEntidade candidatinho = candidatos.get(i);
						if(name == candidatinho.getNome()) {
							candidatos.remove(i);
							removido=true;
						}
					}
					if(removido) {
						System.out.println("Candidato removido com sucesso");
					} else {
						System.out.println("Nao consta um candidato com esse nome na lista");
					}
					
					break;
				case -1:
					break;
				default:
					break;
			}
		}while (flag!= -1);
		return candidatos;
	}
	
	public ArrayList<CandidatoEntidade> povoaArrayCandidatosDeputado() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<CandidatoEntidade> candidatos = new ArrayList<>();
		System.out.println("Cadastro de candidatos para Deputado.");
		int flag = 0;
		do {
			System.out.println("Entre com uma das opcoes: ");
			System.out.println("1: cadastrar candidato.");
			System.out.println("2: remover candidato.");
			System.out.println("-1: Encerrar");
			switch(flag) {
				case 1:
					
					System.out.println("Digite o nome do candidato");
					String nome = scanner.next();
					
					System.out.println("Entre com o numero do Partido");
					PartidoEnum ap[] = PartidoEnum.values(); //sigla para Array de Partidos
					
					for (int i = 0; i<ap.length; i++) {
						System.out.println(i + ": " + ap[i]);
					}
					PartidoEnum partido = ap[scanner.nextInt()];
					
					System.out.println("Entre com o numero do candidato, de 1 a 98");
					int numero = scanner.nextInt();
					
					CandidatoEntidade cand = this.candidatoControlador.InstanciarCandidatoDeputado(nome, partido, numero);
					cand.setCargo(CargoEnum.DEPUTADO);
					
					candidatos.add(cand);
					break;
					
				case 2:
					System.out.println("Favor entrar com o nome do candidato");
					String name = scanner.next();
					boolean removido = false;
					for(int i =0; i<candidatos.size(); i++) {
						CandidatoEntidade candidatinho = candidatos.get(i);
						if(name == candidatinho.getNome()) {
							candidatos.remove(i);
							removido=true;
						}
					}
					if(removido) {
						System.out.println("Candidato removido com sucesso");
					} else {
						System.out.println("Nao consta um candidato com esse nome na lista");
					}
					
					break;
				case -1:
					break;
				default:
					break;
			}
		}while (flag!= -1);
		return candidatos;
	}
	
	public void povoaVotacoes(GeralControlador2 geralControlador) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quantas votacoes desejas realizar?");
		int numVot = scanner.nextInt();
		for (int k = 0; k<numVot; k++) {
			VotacaoEntidade votacao = new VotacaoEntidade();
			geralControlador.votacoes.add(votacao);
			System.out.println("Criada Votacao de Numero " + k);
		}
	}
	
	public void povoaZonas(GeralControlador2 geralControlador) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<geralControlador.getVotacoes().size() ; i++) {
			System.out.println("Para a votacao " + i + " quantas zonas eleitorais serao cadastradas?");
			int qtddZonas = scanner.nextInt();
			for(int k=0; k<qtddZonas; k++) {
				System.out.println("Digite o nome da Zona");
				String nome = scanner.next();
				ZonaEleitoralEntidade zona = new ZonaEleitoralEntidade(nome);
				ArrayList<ZonaEleitoralEntidade> zonas = geralControlador.getVotacoes().get(i).getZonasEleitorais();
				zonas.add(zona);
				geralControlador.getVotacoes().get(i).setZonasEleitorais(zonas);
			}
		}
	}
	
	public void povoaSessoes(GeralControlador2 geralControlador, ArrayList<CandidatoEntidade> candGov, ArrayList<CandidatoEntidade> candDep ) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<geralControlador.getVotacoes().size() ; i++) {
			for(int j=0; j<geralControlador.getVotacoes().get(i).getZonasEleitorais().size(); j++) {
				System.out.println("Para a votacao " + i + ", Sessao "+geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getZonaEleitoral()
						+ ", quantas sessoes serao cadastradas?");
				int qtddSessoes = scanner.nextInt();
				for ( int k =0; k<qtddSessoes; k++) {
					System.out.println("quantos eleitores votarao nessa urna?");
					int qtddEleitores = scanner.nextInt();
					UrnaEntidade urna = new UrnaEntidade(qtddEleitores, "primeiro", candGov, candDep );
					System.out.println("A urna foi carregada com os candidatos previamente cadastrados");
					System.out.println("Digite o nome da sessao");
					String nome = scanner.next();
					SessaoEntidade sessao = new SessaoEntidade(nome, urna);
				}
			}
		}
	}
	
	public void exibeOpcoesAlteracao(GeralControlador2 geralControlador) {
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
		while (flag!= -1) {
			System.out.println("Momento das alteracoes. Escolha uma das opcoes:");
			System.out.println("1: Adicionar Candidato");
			System.out.println("2: Remover Candidato");
			System.out.println("3: Adicionar Sessao");
			System.out.println("4: Remover Sessao");
			System.out.println("-1: Estou satisfeitx, quero prosseguir.");
			switch(flag) {
				case 1:
					for(int i=0; i<geralControlador.getVotacoes().size() ; i++) {
						for(int j=0; j<geralControlador.getVotacoes().get(i).getZonasEleitorais().size(); j++) {
						}
					}
						
					
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
		}
	}
	
	/*public UrnaEntidade retornaUrna (ArrayList<CandidatoEntidade> candGov, ArrayList<CandidatoEntidade> candDep) {
		return new UrnaEntidade()
	}*/
	
}
/*
private String nome;
private CargoEnum cargo;
private PartidoEnum partido;
private int numero;
*/