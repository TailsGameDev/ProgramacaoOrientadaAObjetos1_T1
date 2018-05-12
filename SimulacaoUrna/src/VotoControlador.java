import java.util.ArrayList;

public class VotoControlador {
	
	//o metodo cria um voto, e poe ele na urna. Se o numero for 0 ele nao atribui candidato, se for um numero sem candidato, eh cadastrado 99
	//e nao eh atribuido candidato
	public void instanciarVoto(int numGov, int numDep, UrnaEntidade urna) {

		//passa a chave para ter certeza de que estah sendo usado esse metodo para instanciacao
		VotoEntidade voto = new VotoEntidade("lasdfas982h3n4uf9dsajfpja98r3npdfe9jd832dnum9");
		
		//seta os parametros faceis
		voto.setNumeroGovernador(numGov); voto.setNumeroDeputado(numDep);
		//obs: se o numero for zero, jah estah tudo ok, porque dai foi atribuido zero nessa ultima linha
//System.out.println(voto.getNumeroGovernador() + " "+ voto.getNumeroDeputado());		
		//captura os arrayLists de candidatos governador e deputado
		ArrayList<CandidatoEntidade> candidatosGovernador = urna.getCandidatosGovernador();
		ArrayList<CandidatoEntidade> candidatosDeputado = urna.getCandidatosDeputado();
//System.out.println(candidatosDeputado.get(1).getNome());
		
		//percorre os candidatos a governador, atribuindo o candidato de acordo com o numero ou 99 se nao encontrar algum correspondente
		if(numGov != 0) { //se numGov for 0, nada deve ser feito
			for (CandidatoEntidade candidatoGov : candidatosGovernador) {
				if(candidatoGov.getNumero() == numGov) {
					voto.setCandidatoGovernador(candidatoGov);
				}
			}
			if(voto.getCandidatoGovernador() == null) { //significa que o numero digitado nao tem candidato
				voto.setNumeroGovernador(99);
			}
		}
		
		//percorre os candidatos a deputado, atribuindo o candidato de acordo com o numero ou 99 se nao encontrar algum correspondente
		if(numDep != 0) { //se numDep for 0, nada deve ser feito
			for (CandidatoEntidade candidato : candidatosDeputado) {
				if(candidato.getNumero() == numDep) {
					voto.setCandidatoDeputado(candidato);
				}
			}
			if(voto.getCandidatoDeputado() == null) { //significa que o numero digitado nao tem candidato
				voto.setNumeroDeputado(99);
			}
		}
		
		ArrayList<VotoEntidade> av = new ArrayList<VotoEntidade>(); // av eh Array de Votos;
		av=urna.getListaDeVotos();
		av.add(voto);
		urna.setListaDeVotos(av);
		
	}
	
}
