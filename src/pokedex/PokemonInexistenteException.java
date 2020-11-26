package pokedex;

public class PokemonInexistenteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PokemonInexistenteException(String msg) {
		super(msg);
	}

}
