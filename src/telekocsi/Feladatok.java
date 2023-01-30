package telekocsi;

import java.util.List;

import javax.swing.JOptionPane;

public class Feladatok {

	public void HarmadikFeladat(List<Autok> autok) {

		int szabadHely = 0;

		for (Autok auto : autok) {
			if (auto.getIndulasVaros().equalsIgnoreCase("budapest") && auto.getCelVaros().equalsIgnoreCase("miskolc")) {
				szabadHely += auto.getFeroHelyekSzama();
			}
		}
		JOptionPane.showMessageDialog(null,
				"Összesen: " + String.valueOf(szabadHely) + " férőhelyet hirdettek az autósok Budapestről Miskolcra.",
				"3. feladat", JOptionPane.PLAIN_MESSAGE);

	}

	public void NegyedikFeladat(List<Autok> autok) {

		int max = 0;

		for (int i = 0; i < autok.size(); i++) {
			if (autok.get(i).getFeroHelyekSzama() > autok.get(max).getFeroHelyekSzama()) {
				max = i;
			}
		}
		JOptionPane.showMessageDialog(null,
				"A legtöbb férfőhelyet (" + String.valueOf(autok.get(max).getFeroHelyekSzama()) + "-et) a "
						+ autok.get(max).getIndulasVaros() + "-" + autok.get(max).getCelVaros()
						+ " útvonalon ajánlották fel a hirdetők.",
				"4. feladat", JOptionPane.PLAIN_MESSAGE);

	}

	public void OtodikFeladat(List<Autok> autok, List<Utasok> utasok) {

		StringBuilder kiiras = new StringBuilder();
		StringBuilder kiirasFajlba = new StringBuilder();

		for (Utasok utas : utasok) {
			for (Autok auto : autok) {
				if ((utas.getIndulasVaros().equals(auto.getIndulasVaros())
						&& (utas.getCelVaros().equals(auto.getCelVaros())))) {
					if (utas.getUtasokSzama() <= auto.getFeroHelyekSzama()) {
						kiiras.append(utas.getAzonosito() + " => " + auto.getRendszam() + "\n");
						kiirasFajlba.append(utas.getAzonosito() + ": Rendszám: " + auto.getRendszam()
								+ ", Telefonszám: " + auto.getTelefonSzam() + "\n");
					} else {
						kiirasFajlba.append(utas.getAzonosito() + ": Sajnos nem sikerült autót találni\n");
					}

				}
			}
		}

		JOptionPane.showMessageDialog(null, kiiras.toString(), "5. feladat", JOptionPane.PLAIN_MESSAGE);

		FajlKezeles.FajlbaIras(kiirasFajlba, "F:\\Kurs\\Feladatok\\Telekocsi\\utasUzenetek.txt");

	}

}
