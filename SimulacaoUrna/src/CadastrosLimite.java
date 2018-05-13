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
			flag = scanner.nextInt();
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
			flag = scanner.nextInt();
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
				System.out.println("Para a votacao " + i + ", Zona "+geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getZonaEleitoral()
						+ ", quantas sessoes serao cadastradas?");
				int qtddSessoes = scanner.nextInt();
				for ( int k =0; k<qtddSessoes; k++) {
					System.out.println("quantos eleitores votarao nessa urna?");
					int qtddEleitores = scanner.nextInt();
					UrnaEntidade urna = new UrnaEntidade(qtddEleitores, "primeiro", candGov, candDep );
					System.out.println("A urna foi carregada com os candidatos previamente cadastrados");
					System.out.println("Digite o nome da secao");
					String nome = scanner.next();
					SessaoEntidade sessao = new SessaoEntidade(nome, urna);
					ArrayList<SessaoEntidade> sessoes = geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes();
					sessoes.add(sessao);
					geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).setSessoes(sessoes);
				}
			}
		}
	}
	
	public int exibeOpcoesAlteracao() {
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
			System.out.println("Momento das alteracoes. Escolha uma das opcoes:");
			System.out.println("1: Alterar Candidatos a Governador");
			System.out.println("2: Alterar Candidatos a Deputado");
			System.out.println("3: Alterar Secoes");
			System.out.println("-1: Estou satisfeitx, quero prosseguir.");
			flag = scanner.nextInt();
			return flag;
	}
	
	public void alteraCandidatosGovernador(GeralControlador2 geralControlador) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<CandidatoEntidade> candidatos = 
				geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna().getCandidatosGovernador();
		System.out.println("Alteracao de Cadastro de candidatos para Governador.");
		int flag2 = 0;
		do {
			System.out.println("Entre com uma das opcoes: ");
			System.out.println("1: adicionar candidato.");
			System.out.println("2: remover candidato.");
			System.out.println("-1: Encerrar");
			switch(flag2) {
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
		}while (flag2!= -1);
		
		for(int i=0; i<geralControlador.getVotacoes().size() ; i++) {
			for(int j=0; j<geralControlador.getVotacoes().get(i).getZonasEleitorais().size(); j++) {
				for (int k = 0; k<geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes().size();k++){
geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes().get(k).getUrna().setCandidatosGovernador(candidatos);
				}
			}
		}
	}
	
	public void alteraCandidatosDeputado(GeralControlador2 geralControlador) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<CandidatoEntidade> candidatos = 
				geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0).getSessoes().get(0).getUrna().getCandidatosDeputado();
		System.out.println("Alteracao de Cadastro de candidatos para Deputado.");
		int flag2 = 0;
		do {
			System.out.println("Entre com uma das opcoes: ");
			System.out.println("1: adicionar candidato.");
			System.out.println("2: remover candidato.");
			System.out.println("-1: Encerrar");
			switch(flag2) {
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
		}while (flag2!= -1);
		
		for(int i=0; i<geralControlador.getVotacoes().size() ; i++) {
			for(int j=0; j<geralControlador.getVotacoes().get(i).getZonasEleitorais().size(); j++) {
				for (int k = 0; k<geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes().size();k++){
geralControlador.getVotacoes().get(i).getZonasEleitorais().get(j).getSessoes().get(k).getUrna().setCandidatosDeputado(candidatos);
				}
			}
		}
	}
	
	public void alteraSessoes(GeralControlador2 geralControlador) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<SessaoEntidade> sessoes = 
				geralControlador.getVotacoes().get(0).getZonasEleitorais().get(0).getSessoes();
			int flag2 = 0;
			do {
				System.out.println("Entre com uma das opcoes: ");
				System.out.println("1: adicionar secao.");
				System.out.println("2: remover secao.");
				System.out.println("-1: Encerrar");
				switch(flag2) {
					case 1:
						System.out.println("Cada secao tem uma urna, entao entre com os dados da urna");
						System.out.println("Digite o numero de eleitores para a urna");
						int numEleit = scanner.nextInt();
						UrnaEntidade urna = new UrnaEntidade(numEleit, "primeiro",sessoes.get(0).getUrna().getCandidatosGovernador(),
								sessoes.get(0).getUrna().getCandidatosDeputado());
						System.out.println("Agora informe o nome da secao");
						String nome = scanner.next();
						SessaoEntidade sessao = new SessaoEntidade(nome, urna);
						System.out.println("Digite o nome da zona eleitoral aa qual essa secao vai pertencer");
						String nomeZona = scanner.next();
						System.out.println("A qual votacao pertence essa zona? Digitar numero da votacao.");
						int vot = scanner.nextInt();
						for (ZonaEleitoralEntidade zona : geralControlador.getVotacoes().get(vot).getZonasEleitorais()) {
							if(zona.getZonaEleitoral() == nomeZona) {
								ArrayList<SessaoEntidade> sessoesEleit = zona.getSessoes();
								sessoesEleit.add(sessao);
								zona.setSessoes(sessoesEleit);
								System.out.println("Secao adicionada!");
							}
						}
						break;
					case 2:
						System.out.println("De qual Zona Eleitoral desejas remover uma secao?");
						String nomeZona2 = scanner.next();
						System.out.println("A qual votacao pertence essa zona? Digitar numero da votacao.");
						int vot2 = scanner.nextInt();
						System.out.println("Digite o nome da secao");
						String nomeSessao = scanner.next();
						for (ZonaEleitoralEntidade zona : geralControlador.getVotacoes().get(vot2).getZonasEleitorais()) {
							if(zona.getZonaEleitoral() == nomeZona2) {
								ArrayList<SessaoEntidade> sessoesEleit = zona.getSessoes();
								for(SessaoEntidade sessao2 : sessoesEleit) {
									if(nomeSessao == sessao2.getSessao()) {
										sessoesEleit.remove(sessao2);
										zona.setSessoes(sessoesEleit);
										System.out.println("Secao removida!");
									}
								}
							}
						}
						break;
					case -1:
						break;
					default:
						break;
				}
			} while(flag2!=-1);
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