import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ResultadosLimite {
	
	public int exibeTelaOpcoesResultado() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual resultado da Votacao selecionada deseja conferir?");
		System.out.println("1: Exibir governador eleito.");
		System.out.println("2: Exibir deputados eleitos.");
		System.out.println("3: Exibir tabela de votos por governador.");
		System.out.println("4: Exibir tabela de votos por deputado.");
		System.out.println("-1: Encerrar.");
		int flag = scanner.nextInt();
		return flag;
	}

	public void exibeTabelaVotosDeputado(VotacaoEntidade ve) {//HashMap<CandidatoEntidade,Integer> map){
		
		System.out.println("Candidatos Votos");
		ArrayList<CandidatoEntidade> jahImpressos = new ArrayList<>();
		for(VotoEntidade voto : ve.getVotosDeTodasAsUrnas()) {
			if(voto.getCandidatoDeputado()!= null) {
				if(ve.getMapaVotosDeputado().containsKey(voto.getCandidatoDeputado()) && !jahImpressos.contains(voto.getCandidatoDeputado())) {
					System.out.println(voto.getCandidatoDeputado().getNome() + " " + ve.getMapaVotosDeputado().get(voto.getCandidatoDeputado()));
					jahImpressos.add(voto.getCandidatoDeputado());
				}
			}
		}
		
		/*Set<CandidatoEntidade> keys = map.keySet(); //tem um exemplo que a professora exibiu um mapa assim
		
		TreeSet<CandidatoEntidade> sortedKeys = new TreeSet<CandidatoEntidade>(keys);
		
		for(CandidatoEntidade key : sortedKeys) {
			System.out.printf("%-10s%10s\n", key.getNome(), map.get(key));
			System.out.printf("\nsize:%d\nisEmpty:%b\n",map.size(), map.isEmpty());
		}
		*/
	}
	
}
