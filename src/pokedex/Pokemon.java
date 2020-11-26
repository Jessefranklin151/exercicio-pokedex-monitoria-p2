package pokedex;

public class Pokemon {

	private String nome;

	private Tipo tipo;

	private Data diaCaptura;

	public Pokemon() {
		super();
	}

	public Pokemon(String nome, Tipo tipo, Data diaCaptura) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.diaCaptura = diaCaptura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Data getDiaCaptura() {
		return diaCaptura;
	}

	public void setDiaCaptura(Data diaCaptura) {
		this.diaCaptura = diaCaptura;
	}

	@Override
	public String toString() {
		return "Pokemon [nome=" + nome + ", tipo=" + tipo + ", diaCaptura=" + diaCaptura + "]";
	}

	public boolean ehMaisAntigo(Pokemon maisAntigo) {
		Data dataPokemonMaisAntigo = maisAntigo.getDiaCaptura();

		if (dataPokemonMaisAntigo.getAno() < diaCaptura.getAno()) {
			return false;
		}

		if (dataPokemonMaisAntigo.getMes() < diaCaptura.getMes()) {
			return false;
		}

		if (dataPokemonMaisAntigo.getDia() < diaCaptura.getDia()) {
			return false;
		}

		return true;
	}

}
