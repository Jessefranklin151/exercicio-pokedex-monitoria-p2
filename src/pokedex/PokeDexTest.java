package pokedex;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PokeDexTest {

	private PokeDex pokedex;

	@Before
	public void setUp() throws Exception {
		pokedex = new PokeDex();
	}

	@Test
	public void adicionarPokemonTest() {
		Pokemon p = new Pokemon();
		p.setNome("Pikachu");
		pokedex.adicionarPokemon(p);
		assertEquals(1, pokedex.getQuantidadePokemons());
	}

	@Test
	public void pokemonMaisAntigoTest() {
		Pokemon p = new Pokemon();
		p.setNome("Pikachu");
		p.setDiaCaptura(new Data(26, 11, 2020));
		pokedex.adicionarPokemon(p);
		Pokemon p2 = new Pokemon();
		p2.setNome("Charizard");
		p2.setDiaCaptura(new Data(22, 11, 2020));
		pokedex.adicionarPokemon(p2);
		
		Pokemon p3 = new Pokemon();
		p3.setNome("Bulbasaur");
		p3.setDiaCaptura(new Data(24, 11, 2020));
		pokedex.adicionarPokemon(p3);
		
		Pokemon p4 = new Pokemon();
		p4.setNome("Bulbasaur");
		p4.setDiaCaptura(new Data(24, 11, 2020));
		pokedex.adicionarPokemon(p4);

		Pokemon pokemonMaisAntigo = pokedex.getPokemonMaisAntigo();
		assertEquals(pokemonMaisAntigo.getNome(), "Charizard");
	}

}
