package pokedex;

import java.util.ArrayList;
import java.util.List;

public class PokeDex {

	private List<Pokemon> pokemons;

	public PokeDex() {
		pokemons = new ArrayList<>();
	}

	public void adicionarPokemon(Pokemon p) {
		pokemons.add(p);
	}

	public void adicionarPokemon(String nome, Tipo tipo, Data diaCaptura) {
		adicionarPokemon(new Pokemon(nome, tipo, diaCaptura));
	}

	public int getQuantidadePokemons() {
		return pokemons.size();
	}

	public int getQuantidadePokemons(Tipo tipo) {
		return getPokemonsPorTipo(tipo).size();
	}

	public List<Pokemon> getPokemonsPorTipo(Tipo tipo) {
		List<Pokemon> pokemonsPorTipo = new ArrayList<>();
		for (Pokemon pokemon : pokemons) {
			if (pokemon.getTipo().equals(tipo)) {
				pokemonsPorTipo.add(pokemon);
			}
		}
		return pokemonsPorTipo;
	}

	public List<Pokemon> getPokemonsCapturados(Data dia) {
		List<Pokemon> pokemonsCapturadosNoDia = new ArrayList<>();

		for (Pokemon pokemon : pokemons) {

			if (pokemon.getDiaCaptura().equals(dia)) {
				pokemonsCapturadosNoDia.add(pokemon);
			}

		}

		if (pokemonsCapturadosNoDia.isEmpty()) {
			return null;
		}

		return pokemonsCapturadosNoDia;
	}

	public Pokemon getPokemonMaisAntigo() {
		Pokemon maisAntigo = null;
		for (Pokemon pokemon : pokemons) {
			if (maisAntigo == null) {
				maisAntigo = pokemon;
			}

			// verificar se o pokemon atual da lista � mais antigo que o pokemon guardado
			// mais antigo.
			if (pokemon.ehMaisAntigo(maisAntigo)) {
				maisAntigo = pokemon;
			}
		}
		return maisAntigo;
	}

	public Tipo getTipoPokemonPredominante() {
		Tipo tipo = null; // tipo predominante;
		int quantidadeDeTipoMaior = 0; // quantidade to tipo predominante;

		// POKEMON LUTADOR � O PREDOMINANTE COM 3 POKEMONS
		// [ POKEMON.NORMAL, POKEMON.LUTADOR, POKEMON.NORMAL, POKEMON.VENENOSO,
		// POKEMON.LUTADOR, POKEMON.LUTADOR ]
		for (int i = 0; i < pokemons.size(); i++) {
			Pokemon pokemon = pokemons.get(i);
			int quantidadePokemons = getQuantidadePokemons(pokemon.getTipo());

			if (tipo == null) {
				tipo = pokemon.getTipo();
				quantidadeDeTipoMaior = quantidadePokemons;
			} else {
				if (quantidadePokemons > quantidadeDeTipoMaior) {
					tipo = pokemon.getTipo();
					quantidadeDeTipoMaior = quantidadePokemons;
				}
			}

		}

		return tipo;
	}

	public List<Pokemon> removerPokemons(Tipo tipo) {
		List<Pokemon> pokemonsPorTipo = getPokemonsPorTipo(tipo);
		pokemons.removeAll(pokemonsPorTipo);
		return pokemonsPorTipo;
	}

	public List<Pokemon> acharPokemonPorNome(String nome) {
		List<Pokemon> pokemonsPorNome = new ArrayList<>();
		for (Pokemon pokemon : pokemons) {
			if (pokemon.getNome().equals(nome)) {
				pokemonsPorNome.add(pokemon);
			}
		}
		return pokemonsPorNome;
	}

	public void removerPokemons(Pokemon p) throws PokemonInexistenteException {
		List<Pokemon> pokemonsComOMesmoNome = acharPokemonPorNome(p.getNome());
		if (pokemonsComOMesmoNome.size() == 0) {
			throw new PokemonInexistenteException("Nenhum pokemon n�o encontrado!");
		}
		pokemons.removeAll(pokemonsComOMesmoNome);
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

}
