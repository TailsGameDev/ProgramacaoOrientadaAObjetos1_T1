import java.util.ArrayList;
import java.util.Scanner;

public class CadastrosLimite {
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
					CargoEnum cargo = CargoEnum.GOVERNADOR;
					System.out.println("Entre com o numero do Partido");
					PartidoEnum ap[] = PartidoEnum.values(); //sigla para Array de Partidos
					for (int i = 0; i<ap.length; i++) {
						System.out.println(i + ": " + ap[i]);
					}
					break;
				case 2:
					break;
				case -1:
					break;
				default:
					break;
			}
		}while (flag!= -1);
		return candidatos;
	}
	
}
/*
private String nome;
private CargoEnum cargo;
private PartidoEnum partido;
private int numero;
*/