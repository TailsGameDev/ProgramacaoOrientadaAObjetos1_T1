
public class InvalidCallToConstructor extends Exception {

	public InvalidCallToConstructor () {
		this("Essa classe nao deve ser instanciada diretamente pelo construtor");
	}
	
	public InvalidCallToConstructor(String message) {
		super("Erro: " + message);
	}
}
