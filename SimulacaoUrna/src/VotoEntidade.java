
public class VotoEntidade {
	private int numeroGovernador, numeroDeputado;
	private CandidatoEntidade candidatoGovernador, candidatoDeputado;
	
	public VotoEntidade(String chave) {

		try {
			//essa string estranha eh para ter certeza de que nao estah sendo usado o construtor diretamente.
			if(chave != "lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9") {
				throw new InvalidCallToConstructor("Instanciar Voto usando VotoControlador.instanciarVoto()");
			}
		} catch (InvalidCallToConstructor i) {
			System.out.println(i.getMessage());
		}
		
	}
	
	//gets e sets
	public int getNumeroGovernador() {
		return numeroGovernador;
	}

	public void setNumeroGovernador(int numeroGovernador) {
		this.numeroGovernador = numeroGovernador;
	}

	public int getNumeroDeputado() {
		return numeroDeputado;
	}

	public void setNumeroDeputado(int numeroDeputado) {
		this.numeroDeputado = numeroDeputado;
	}

	public CandidatoEntidade getCandidatoGovernador() {
		return candidatoGovernador;
	}

	public void setCandidatoGovernador(CandidatoEntidade candidatoGovernador) {
		this.candidatoGovernador = candidatoGovernador;
	}

	public CandidatoEntidade getCandidatoDeputado() {
		return candidatoDeputado;
	}

	public void setCandidatoDeputado(CandidatoEntidade candidatoDeputado) {
		this.candidatoDeputado = candidatoDeputado;
	}
	
	
}
