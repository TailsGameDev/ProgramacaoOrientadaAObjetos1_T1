import java.util.ArrayList;

public class UrnaEntidade {
	//a qtddMaximaEleitores eh usada na Entidade mesmo, nessa classe, no metodo setListaDeVotos.
	private int qtddMaximaEleitores;
	private String turno;
	private ArrayList<CandidatoEntidade> candidatosGovernador = new ArrayList<CandidatoEntidade>();
	private ArrayList<CandidatoEntidade> candidatosDeputado = new ArrayList<CandidatoEntidade>();
	private ArrayList<VotoEntidade> ListaDeVotos = new ArrayList<VotoEntidade>();
	
	public UrnaEntidade(int q, String t , ArrayList<CandidatoEntidade> vcandidatosGovernador,ArrayList<CandidatoEntidade> vcandidatosDeputado) {
		qtddMaximaEleitores = q; turno = t;
		candidatosGovernador = vcandidatosGovernador;
		candidatosDeputado = vcandidatosDeputado;
	}
	
	public int getQtddMaximaEleitores() {
		return qtddMaximaEleitores;
	}
	public void setQtddMaximaEleitores(int qtddMaximaEleitores) {
		this.qtddMaximaEleitores = qtddMaximaEleitores;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public ArrayList<CandidatoEntidade> getCandidatosGovernador() {
		return candidatosGovernador;
	}
	public void setCandidatosGovernador(ArrayList<CandidatoEntidade> candidatosGovernador) {
		this.candidatosGovernador = candidatosGovernador;
	}
	public ArrayList<CandidatoEntidade> getCandidatosDeputado() {
		return candidatosDeputado;
	}
	public void setCandidatosDeputado(ArrayList<CandidatoEntidade> candidatosDeputado) {
		this.candidatosDeputado = candidatosDeputado;
	}
	public ArrayList<VotoEntidade> getListaDeVotos() {
		return ListaDeVotos;
	}
	
	//a quantidade limite de votos de acordo com a qtddDeEleitores estah implementada bem aqui
	public void setListaDeVotos(ArrayList<VotoEntidade> listaDeVotos) {
		try {
				if(listaDeVotos.size()>qtddMaximaEleitores) {
					throw new IllegalArgumentException("Quantidade de votos maior do que a de eleitores para essa urna.");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
		ListaDeVotos = listaDeVotos;
	}
}

