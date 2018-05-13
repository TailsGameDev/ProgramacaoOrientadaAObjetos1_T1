import java.util.ArrayList;
import java.util.HashMap;

public class PrimeiroTurnoControlador extends SegundoTurnoControlador {
	
	ArrayList<CandidatoEntidade> deputadosEleitos = new ArrayList<CandidatoEntidade>();
	ArrayList<CandidatoEntidade> governadoresParaSegundoTurno = new ArrayList<CandidatoEntidade>();
	
	public ArrayList<CandidatoEntidade> getDeputadosEleitos() {
		return deputadosEleitos;
	}

	public void setDeputadosEleitos(ArrayList<CandidatoEntidade> deputadosEleitos) {
		this.deputadosEleitos = deputadosEleitos;
	}

	public ArrayList<CandidatoEntidade> getGovernadoresParaSegundoTurno() {
		return governadoresParaSegundoTurno;
	}

	public void setGovernadoresParaSegundoTurno(ArrayList<CandidatoEntidade> governadoresParaSegundoTurno) {
		this.governadoresParaSegundoTurno = governadoresParaSegundoTurno;
	}

	public int calculaQtddVotosValidosDeputado(VotacaoEntidade ve) {
		
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas();
		int votosValidos = 0;
		for(VotoEntidade voto : av) {
			if(voto.getNumeroDeputado() !=0 && voto.getNumeroDeputado() != 99) {
				votosValidos++;
			}
		}
		return votosValidos;
	}
	
	public int calculaQuocienteEleitoral(VotacaoEntidade ve) {
		int num = calculaQtddVotosValidosDeputado(ve);
		
		// divisao e arredondamento em 4 linhas
		float convertido = (float) num/3;
		float nconvertido = num/3;
		float numDecisao = convertido - nconvertido;
		int arredondado = numDecisao > .5 ? (int) nconvertido + 1 : (int) nconvertido;
		
		return arredondado;
	}
	
	public boolean haveraSegundoTurno(VotacaoEntidade ve) {
		
		boolean havera = true;

		double totalDeVotos = ve.getVotosDeTodasAsUrnas().size();
		
		//pega pelo mapaVotosGovernador (que deve ter sido gerado com o metodo SegundoTurno.gerarMapaVotosGovernador() ) a qtdd
		//de votos do mais votado
		CandidatoEntidade vencedor = this.definirGovernadorVencedor(ve);
		HashMap<CandidatoEntidade, Integer> map = ve.getMapaVotosGovernador();
		double votosDoVencedor = map.get(vencedor);
		
		double fracao = votosDoVencedor/totalDeVotos;
		
		//se mais de 50% dos votos forem do vencedor, ai nao haverah segundo turno.
		if(fracao > 0.5)
			havera = false;
		
		return havera;
	}
	
	public void geraMapaVotosDeputado(VotacaoEntidade ve) {
		//serao computados todos os votos para a votacao passada como parametro
		
				//cria array com todos os votos
				ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas(); //av eh sigla para array de votos
				
				//cria mapa para ser configurado mais abaixo no metodo
				HashMap<CandidatoEntidade, Integer> mapaVotosDeputado = new HashMap<CandidatoEntidade, Integer>();//<candidato, numero de votos nele>
				
				//percorre os votos
				for(VotoEntidade voto : av) {
					if(mapaVotosDeputado.containsKey( voto.getCandidatoDeputado() )) {
						int qtddVotosAtuais = mapaVotosDeputado.get(voto.getCandidatoDeputado());
						mapaVotosDeputado.put(voto.getCandidatoDeputado(), qtddVotosAtuais + 1);
					} else {
						mapaVotosDeputado.put(voto.getCandidatoDeputado(), 1);
					}
				}
				
				ve.setMapaVotosDeputado(mapaVotosDeputado);
	}
	
	public void listaGovernadoresParaSegundoTurno(VotacaoEntidade ve) {
		CandidatoEntidade primeiroLugar = definirGovernadorVencedor(ve);
		
		//para definir o segundo lugar, copiei a funcao definirGovernadorVencedor() aqui, e adicionei no if a expressao "&& cand != primeiroLugar"
		int maximoDeVotosAtehAgr=0;
		CandidatoEntidade segundoLugar = new CandidatoEntidade("lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9");
		for(CandidatoEntidade cand : ve.getMapaVotosGovernador().keySet()) {
			if(ve.getMapaVotosGovernador().get(cand) > maximoDeVotosAtehAgr && cand != primeiroLugar) {
				segundoLugar = cand;
			}
		}
		
		this.governadoresParaSegundoTurno.add(primeiroLugar);
		this.governadoresParaSegundoTurno.add(segundoLugar);
	}
	
	public void listaDeputadosEleitos(VotacaoEntidade ve) {
		
		//PrimeiroTurnoControlador p = new PrimeiroTurnoControlador();
		int quantidadeDeDeputadosAEleger = this.calculaQuocienteEleitoral(ve);
		
		//esse for executa uma vez para cada deputado a eleger
		for (int i = quantidadeDeDeputadosAEleger; i>0; i--) {
			int maximoDeVotosAtehAgr=0;
			CandidatoEntidade vencedor = new CandidatoEntidade("lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9");
			for(CandidatoEntidade cand : ve.getMapaVotosDeputado().keySet()) { //ele percorre o mapa de candidatos
				if(cand!=null) {
					if(ve.getMapaVotosDeputado().get(cand) > maximoDeVotosAtehAgr) { //se ele tem a maior quantidade de votos da rodada
						if(!deputadosEleitos.contains(cand)) { //e ele ainda nao foi eleito
							maximoDeVotosAtehAgr=ve.getMapaVotosDeputado().get(cand);
							vencedor = cand; //guarda ele porque
						}
					}
				}
			}
			deputadosEleitos.add(vencedor); //ele serah adicionado aos eleitos caso ninguem supere ele.
		}
		
	}
	
	public int calculaQtddVotosBrancosDeputado(VotacaoEntidade ve) {
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas();
		int brancos = 0;
		for (VotoEntidade voto : av) {
			if(voto.getNumeroDeputado()==99)
				brancos++;
		}
		return brancos;
	}
	
	public int calculaQtddVotosNulosDeputado(VotacaoEntidade ve) {
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas();
		int nulos = 0;
		for (VotoEntidade voto : av) {
			if(voto.getNumeroDeputado()==0)
				nulos++;
		}
		return nulos;
	}

}
	
	
		
		/* tentativa anterior condizente com a politica verdadeira
		  
		//cria array com todos os votos
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas(); //av eh sigla para array de votos
		//mapa de votos com chave partido
		HashMap<PartidoEnum, Integer> votosPorPartido = new HashMap<PartidoEnum, Integer>();
		
		//monta o mapa de votos com chave partido. Contabiliza os votos por partido
		for (VotoEntidade voto : av) {
			if(votosPorPartido.containsKey(voto.getCandidatoDeputado().getPartido())) {
				int qtddVotosAtual = votosPorPartido.get(voto.getCandidatoDeputado().getPartido());
				votosPorPartido.put(voto.getCandidatoDeputado().getPartido(), qtddVotosAtual + 1);
			}
		}
		
		int cadeirasReservadas = 0;
		//pega os votos por partido e transforma em um mapa de Quocientes Partidarios por partido
		HashMap<PartidoEnum, Integer> quocientesPartidariosPorPartido = new HashMap<PartidoEnum, Integer>();
		PartidoEnum ap[] = PartidoEnum.values(); //sigla para Array de Partidos
		for (PartidoEnum partido : ap) {
			if(votosPorPartido.containsKey(partido)) {
				if(votosPorPartido.get(partido) > this.calculaQuocienteEleitoral(ve)) {
					int quoc = votosPorPartido.get(partido);
					quocientesPartidariosPorPartido.put(partido, quoc/this.calculaQuocienteEleitoral(ve));
					cadeirasReservadas += quocientesPartidariosPorPartido.get(partido);
				}
			}
		}
		//a ideia eh esse mapa jah conter por partido o numero de cadeiras que terah disponivel
		
		//decidir para vagas restantes se houver
		int numeroDeCadeirasFaltantes = 3-cadeirasReservadas;
		ArrayList<PartidoEnum> partidoQuePegarahVaga = new ArrayList<PartidoEnum>();
		int pontuacao = 0;
		for (int i = numeroDeCadeirasFaltantes; i>0 ; i-- ) {
			for (PartidoEnum partido : ap) {
				if(votosPorPartido.containsKey(partido)) {
					int VVP = votosPorPartido.get(partido); //Votos Validos do Partido
					int QPP = quocientesPartidariosPorPartido.get(partido); //Quociente Partidario do Partido
					if(VVP/(QPP+1)>pontuacao) {
						pontuacao = VVP/(QPP+1);
						partidoQuePegarahVaga.add(partido); //pelo texto que li entendi que eh uma vaga soh, mas generalizei
					}
				}
			}
		}
		
		//adicionar cadeiras
		for (PartidoEnum partido : partidoQuePegarahVaga) {
			int cadeiras = quocientesPartidariosPorPartido.get(partido);
			quocientesPartidariosPorPartido.put(partido, cadeiras +1);
		}
		
		
		*/
	
	
/*	public double quoeficientePartidario(VotacaoEntidade ve) {
		//cria array com todos os votos
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas(); //av eh sigla para array de votos
		//ArrayList<Integer> votosPorPartido = new ArrayList<Integer>();
		HashMap<PartidoEnum, Integer> votosPorPartido = new HashMap<PartidoEnum, Integer>();
		
		for (VotoEntidade voto : av) {
			if(votosPorPartido.containsKey(voto.getCandidatoDeputado().getPartido())) {
				int qtddVotosAtual = votosPorPartido.get(voto.getCandidatoDeputado().getPartido());
				votosPorPartido.put(voto.getCandidatoDeputado().getPartido(), qtddVotosAtual + 1);
			}
		}
		return 123.45;
	}
	*/

