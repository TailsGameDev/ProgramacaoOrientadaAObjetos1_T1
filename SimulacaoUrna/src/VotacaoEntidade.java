import java.util.ArrayList;
import java.util.HashMap;

public class VotacaoEntidade {
	private ArrayList<ZonaEleitoralEntidade> zonasEleitorais = new ArrayList<ZonaEleitoralEntidade>();
	private ArrayList<VotoEntidade> votosDeTodasAsUrnas = new ArrayList<VotoEntidade>();
	private HashMap<CandidatoEntidade, Integer> mapaVotosGovernador = new HashMap<CandidatoEntidade, Integer>();
	private HashMap<CandidatoEntidade, Integer> mapaVotosDeputado = new HashMap<CandidatoEntidade, Integer>();
	
	public ArrayList<ZonaEleitoralEntidade> getZonasEleitorais() {
		return zonasEleitorais;
	}
	public void setZonasEleitorais(ArrayList<ZonaEleitoralEntidade> zonasEleitorais) {
		this.zonasEleitorais = zonasEleitorais;
	}
	public ArrayList<VotoEntidade> getVotosDeTodasAsUrnas() {
		return votosDeTodasAsUrnas;
	}
	public void setVotosDeTodasAsUrnas(ArrayList<VotoEntidade> votosDeTodasAsUrnas) {
		this.votosDeTodasAsUrnas = votosDeTodasAsUrnas;
	}
	public HashMap<CandidatoEntidade, Integer> getMapaVotosGovernador() {
		return mapaVotosGovernador;
	}
	public void setMapaVotosGovernador(HashMap<CandidatoEntidade, Integer> mapaVotosGovernador) {
		this.mapaVotosGovernador = mapaVotosGovernador;
	}
	public HashMap<CandidatoEntidade, Integer> getMapaVotosDeputado() {
		return mapaVotosDeputado;
	}
	public void setMapaVotosDeputado(HashMap<CandidatoEntidade, Integer> mapaVotosDeputado) {
		this.mapaVotosDeputado = mapaVotosDeputado;
	}
	
}
