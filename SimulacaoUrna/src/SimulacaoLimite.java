import java.util.Scanner;

public class SimulacaoLimite {
	public void boasVidasAaSimulacao() {
		System.out.println("Iniciando simulacao das votacoes");
	}
	
	public void boasVindasAaSessao(int votacao, SessaoEntidade sessao) {
		System.out.println("Iniciando, para a votacao " + votacao + ", a secao " + sessao.getSessao() );
	}
	
	public int exibeMenuUrna() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha uma das opcoes:");
		System.out.println("1: votar.");
		System.out.println("-1: encerrar votacao.");
		int flag= scanner.nextInt();
		return flag;
	}
	
	public void votar(UrnaEntidade urna, VotoControlador votoControlador) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem vindo(a) eleitor(a). Entre com o numero do candidato a governador");
		
		String padrao = "0";
		String nGov = scanner.nextLine();
		String concatenados = padrao + nGov;
		int numGov = Integer.parseInt(padrao + nGov);

		System.out.println("Entre com o numero do candidato a deputado.");
		
		String vpadrao = "0";
		String nDep = scanner.nextLine();
		String vconcatenados = vpadrao + nDep;
		int numDep = Integer.parseInt(vpadrao + nDep);

		votoControlador.instanciarVoto(numGov, numDep, urna);
	}
}
