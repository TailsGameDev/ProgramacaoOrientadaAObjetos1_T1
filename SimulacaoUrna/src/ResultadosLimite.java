import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class ResultadosLimite {

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
