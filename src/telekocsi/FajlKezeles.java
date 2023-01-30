package telekocsi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FajlKezeles {

	private static BufferedReader br;

	public static List<Autok> AutokBeolvasasa(String fajlNev, String elvalaszto) {

		List<Autok> autok = new ArrayList<Autok>();

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlNev), "UTF-8"));

			br.readLine();

			while (br.ready()) {

				String[] sor = br.readLine().split(elvalaszto);

				Autok a = new Autok(sor[0], sor[1], sor[2], sor[3], Integer.parseInt(sor[4]));

				autok.add(a);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok beolvasásakor!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
		}

		return autok;

	}

	public static List<Utasok> UtasokBeolvasasa(String fajlNev, String elvalaszto) {

		List<Utasok> utasok = new ArrayList<Utasok>();

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlNev), "UTF-8"));

			br.readLine();

			while (br.ready()) {

				String[] sor = br.readLine().split(elvalaszto);

				Utasok u = new Utasok(sor[0], sor[1], sor[2], Integer.parseInt(sor[3]));
				utasok.add(u);
			}

			br.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok beolvasásakor!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
		}

		return utasok;
	}

	public static void FajlbaIras(StringBuilder kiirasFajlba, String fajlnev) {

		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev, false), "UTF-8");

			out.write(kiirasFajlba.toString());

			out.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok kiírásakor!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
		}

		JOptionPane.showMessageDialog(null, "Sikeres fájlba írás!", "6. feladat", JOptionPane.PLAIN_MESSAGE);

	}

}
