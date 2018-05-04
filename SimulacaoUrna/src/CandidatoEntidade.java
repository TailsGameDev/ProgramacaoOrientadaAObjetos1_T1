
public class CandidatoEntidade {
	private String nome;
	private CargoEnum cargo;
	private PartidoEnum partido;
	private int numero;
	
	public CandidatoEntidade(String chave) {
		try {
			//essa string estranha eh para ter certeza de que nao estah sendo usado o construtor diretamente.
			if(chave != "lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9") {
				throw new InvalidCallToConstructor("Instanciar CandidatoEntidade usando o metodo CandidatoControlador.InstanciarCandidatoGovernador()"
						+ "ou CandidatoControlador.InstanciarCandidatoDeputado()");
			}
		} catch (InvalidCallToConstructor i) {
			System.out.println(i.getMessage());
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public CargoEnum getCargo() {
		return cargo;
	}
	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}
	public PartidoEnum getPartido() {
		return partido;
	}
	public void setPartido(PartidoEnum partido) {
		this.partido = partido;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}

enum CargoEnum {GOVERNADOR, DEPUTADO}
enum PartidoEnum {PT, PSDB}