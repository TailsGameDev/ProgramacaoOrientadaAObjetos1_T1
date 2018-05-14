import java.util.Scanner;

//deve haver apenas uma instancia de CandidatoControlador
public class CandidatoControlador {
	boolean[] numerosDisponiveisGovernador, numerosDisponiveisDeputado;
	
	public CandidatoControlador(){
		//as proximas 4 linhas inicializam os "numerosDisponiveis" como true
		numerosDisponiveisGovernador= new boolean[100];
		numerosDisponiveisDeputado= new boolean[100];
		for (int i=1; i<99;i++) {
			numerosDisponiveisGovernador[i]=true;
			numerosDisponiveisDeputado[i]=true;
		}
		numerosDisponiveisGovernador[0] =false;	numerosDisponiveisDeputado[0] =false;
		numerosDisponiveisGovernador[99]=false;	numerosDisponiveisDeputado[99]=false;
	}
	
	//o metodo instancia um candidato governador jah verificando se o numero eh valido
	public CandidatoEntidade InstanciarCandidatoGovernador(String nome, PartidoEnum partido, int numero) throws java.lang.IllegalArgumentException{
		
		//essa string estranha eh para ter certeza de que nao estah sendo usado o construtor diretamente.
		CandidatoEntidade cand = new CandidatoEntidade("lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9");
		
		//"seta" os campos tranquilos
		cand.setNome(nome); cand.setPartido(partido); cand.setCargo(CargoEnum.GOVERNADOR);
		
		try {
			//verifica se o numero estah disponivel e throw exception se nao estiver
			if(!numerosDisponiveisGovernador[numero]) {
				throw new IllegalArgumentException("numero ja cadastrado para o candidato");
			} else {
				numerosDisponiveisGovernador[numero]=false;
				cand.setNumero(numero);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("Ou tentativa de cadastrar com 0");
			System.out.println("Favor digitar numero exclusivo para um candidato, diferente de 0.");
			Scanner scanner = new Scanner(System.in);
			int novoNumero = scanner.nextInt();
			CandidatoEntidade c = InstanciarCandidatoGovernador(nome, partido, novoNumero);
			return c;
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("numero invalido. Favor digitar novo numero");
			Scanner scanner = new Scanner(System.in);
			int novoNumero = scanner.nextInt();
			CandidatoEntidade c = InstanciarCandidatoGovernador(nome, partido, novoNumero);
			return c;
		}
		
		return cand;
	}
	
	//o metodo instancia um candidato governador jah verificando se o numero eh valido
	public CandidatoEntidade InstanciarCandidatoDeputado(String nome, PartidoEnum partido, int numero) throws java.lang.IllegalArgumentException{
		
		//essa string estranha eh para ter certeza de que nao estah sendo usado o construtor diretamente.
		CandidatoEntidade cand = new CandidatoEntidade("lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9");
		
		//"seta" os campos tranquilos
		cand.setNome(nome); cand.setPartido(partido); cand.setCargo(CargoEnum.DEPUTADO);
		
		try {
			//verifica se o numero estah disponivel e throw exception se nao estiver
			if(!numerosDisponiveisDeputado[numero]) {
				throw new IllegalArgumentException("numero ja cadastrado");
			} else {
				numerosDisponiveisDeputado[numero]=false;
				cand.setNumero(numero);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("Ou tentativa de cadastrar com 0");
			System.out.println("Favor digitar numero exclusivo para um candidato, diferente de 0.");
			Scanner scanner = new Scanner(System.in);
			int novoNumero = scanner.nextInt();
			CandidatoEntidade c = InstanciarCandidatoGovernador(nome, partido, novoNumero);
			return c;
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("numero invalido. Favor digitar novo numero");
			Scanner scanner = new Scanner(System.in);
			int novoNumero = scanner.nextInt();
			CandidatoEntidade c = InstanciarCandidatoGovernador(nome, partido, novoNumero);
			return c;
		}
		return cand;
	}
	
}
