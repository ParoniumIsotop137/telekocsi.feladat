package telekocsi;

public class Utasok {

	private String azonosito;
	private String indulasVaros;
	private String celVaros;
	private int utasokSzama;

	public Utasok(String azonosito, String indulasVaros, String celVaros, int utasokSzama) {
		this.azonosito = azonosito;
		this.indulasVaros = indulasVaros;
		this.celVaros = celVaros;
		this.utasokSzama = utasokSzama;
	}

	public String getAzonosito() {
		return azonosito;
	}

	public String getIndulasVaros() {
		return indulasVaros;
	}

	public String getCelVaros() {
		return celVaros;
	}

	public int getUtasokSzama() {
		return utasokSzama;
	}

	@Override
	public String toString() {
		return "Azonosító: " + this.azonosito + ", indulás városa: " + this.indulasVaros + ", uticél: " + this.celVaros
				+ ", utasokSzama: " + this.utasokSzama;
	}

}
