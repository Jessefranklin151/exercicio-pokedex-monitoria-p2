package pokedex;

public class Data {

	private short dia;
	private short mes;
	private short ano;

	public Data() {
		super();
	}

	public Data(short dia, short mes, short ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Data(int dia, int mes, int ano) {
		this((short) dia, (short) mes, (short) ano);
	}

	public short getDia() {
		return dia;
	}

	public void setDia(short dia) {
		this.dia = dia;
	}

	public short getMes() {
		return mes;
	}

	public void setMes(short mes) {
		this.mes = mes;
	}

	public short getAno() {
		return ano;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (ano != other.ano)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}

	public boolean ehMaisAntigo(Data diaCaptura) {
		return false;
	}
	


}
