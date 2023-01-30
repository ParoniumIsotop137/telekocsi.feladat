package telekocsi;

public class Autok {

	private String indulasVaros;
	private String celVaros;
	private String rendszam;
	private String telefonSzam;
	private int feroHelyekSzama;

	public Autok(String indulasVaros, String celVaros, String rendszam, String telefonSzam, int feroHelyekSzama) {
		this.indulasVaros = indulasVaros;
		this.celVaros = celVaros;
		this.rendszam = rendszam;
		this.telefonSzam = telefonSzam;
		this.feroHelyekSzama = feroHelyekSzama;
	}

	public String getIndulasVaros() {
		return indulasVaros;
	}

	public String getCelVaros() {
		return celVaros;
	}

	public String getRendszam() {
		return rendszam;
	}

	public String getTelefonSzam() {
		return telefonSzam;
	}

	public int getFeroHelyekSzama() {
		return feroHelyekSzama;
	}

	@Override
	public String toString() {
		return "Indulás helye: " + this.indulasVaros + ", uticél: " + this.celVaros + ", rendszám: " + this.rendszam
				+ ", telefonszám: " + this.telefonSzam + ", szabad helyek száma: " + this.feroHelyekSzama + " hely";
	}

}
