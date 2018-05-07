import java.util.ArrayList;
import java.util.HashMap;

public class SegundoTurnoControlador {
	
	CandidatoEntidade GovernadorVencedor;
	
	//esse metodo vai entrar em cada zona, pegar cada sessao, cada urna e somar os votos dela, pondo tudo em um grande arrayList. Que
	//eh o votosDeTodasAsUrnas, atributo de VotacaoEntidade.
	public void listarVotosDeTodasAsUrnas(VotacaoEntidade ve) {
		for (ZonaEleitoralEntidade z : ve.getZonasEleitorais()) {
			for(SessaoEntidade s : z.getSessoes()) {
				//pega votos que jah foram colocados na VotacaoEntidade
				ArrayList<VotoEntidade> a = ve.getVotosDeTodasAsUrnas();
				//pega votos da urna em questao nesse laco de repeticao
				ArrayList<VotoEntidade> aUrna = s.getUrna().getListaDeVotos();
				//poe os votos dessa urna ao fim da lista de todos os votos
				a.addAll(aUrna);
			}
		}
	}
	
	public void gerarMapaVotosGovernador(VotacaoEntidade ve) { //serao computados todos os votos para a votacao passada como parametro
		
		//cria array com todos os votos
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas(); //av eh sigla para array de votos
		
		//cria mapa para ser configurado mais abaixo no metodo
		HashMap<CandidatoEntidade, Integer> mapaVotosGovernador = new HashMap<CandidatoEntidade, Integer>();//<candidato, numero de votos nele>
		
		//percorre os votos
		for(VotoEntidade voto : av) {
			if(mapaVotosGovernador.containsKey( voto.getCandidatoGovernador() )) {
				int qtddVotosAtual = mapaVotosGovernador.get(voto.getCandidatoGovernador());
				mapaVotosGovernador.put(voto.getCandidatoGovernador(), qtddVotosAtual + 1);
			} else {
				mapaVotosGovernador.put(voto.getCandidatoGovernador(), 1);
			}
		}
		
		ve.setMapaVotosGovernador(mapaVotosGovernador);
	}
	
	public CandidatoEntidade definirGovernadorVencedor(VotacaoEntidade ve) {
		
		int maximoDeVotosAtehAgr=0;
		CandidatoEntidade vencedor = new CandidatoEntidade("lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9");
		for(CandidatoEntidade cand : ve.getMapaVotosGovernador().keySet()) {
			if(ve.getMapaVotosGovernador().get(cand) > maximoDeVotosAtehAgr) {
				vencedor = cand;
			}
		}
		return vencedor;
	}
	
	public void adicionarZonaaaVotacao(ZonaEleitoralEntidade z, VotacaoEntidade v) {
		ArrayList<ZonaEleitoralEntidade> zonasEleitorais = v.getZonasEleitorais();
		zonasEleitorais.add(z);
		v.setZonasEleitorais(zonasEleitorais);
	}
	
	public int contarVotosBrancosGovernador(VotacaoEntidade ve) {
		
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas();
		int brancos = 0;
		for (VotoEntidade voto : av) {
			if(voto.getNumeroGovernador()==99)
				brancos++;
		}
		return brancos;
	}
	
	public int contarVotosNulosGovernador(VotacaoEntidade ve) {
		
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas();
		int brancos = 0;
		for (VotoEntidade voto : av) {
			if(voto.getNumeroGovernador()==99)
				brancos++;
		}
		return brancos;
	}
	
	public int calculaQtddVotosValidosGovernador(VotacaoEntidade ve) {
		
		ArrayList<VotoEntidade> av = ve.getVotosDeTodasAsUrnas();
		int votosValidos = 0;
		for(VotoEntidade voto : av) {
			if(voto.getNumeroGovernador() !=0 && voto.getNumeroGovernador() != 99) {
				votosValidos++;
			}
		}
		return votosValidos;
	}

}
