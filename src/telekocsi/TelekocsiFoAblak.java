package telekocsi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelekocsiFoAblak {

	private JFrame frmTelekocsi;
	private JScrollPane scrollPaneUtasok;
	private JTable tblUtasok;
	private JTable tblAutok;
	private List<Autok> autok;
	private List<Utasok> utasok;
	private DefaultTableModel tModelUtasok;
	private DefaultTableModel tModelAutok;

	private Feladatok megold;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelekocsiFoAblak window = new TelekocsiFoAblak();
					window.frmTelekocsi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelekocsiFoAblak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelekocsi = new JFrame();
		frmTelekocsi.setTitle("Telekocsi fuvarok");
		frmTelekocsi.setBounds(200, 200, 600, 530);
		frmTelekocsi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelekocsi.getContentPane().setLayout(null);

		megold = new Feladatok();

		autok = new ArrayList<Autok>();
		utasok = new ArrayList<Utasok>();

		autok = FajlKezeles.AutokBeolvasasa("F:\\Kurs\\Feladatok\\Telekocsi\\autok.csv", ";");

		utasok = FajlKezeles.UtasokBeolvasasa("F:\\Kurs\\Feladatok\\Telekocsi\\igenyek.csv", ";");

		JTabbedPane tbPaneAlap = new JTabbedPane(JTabbedPane.TOP);
		tbPaneAlap.setForeground(new Color(25, 25, 112));
		tbPaneAlap.setBackground(new Color(255, 255, 224));
		tbPaneAlap.setFont(new Font("Segoe UI", Font.BOLD, 13));
		tbPaneAlap.setBounds(10, 11, 576, 452);
		frmTelekocsi.getContentPane().add(tbPaneAlap);

		JScrollPane scrollPaneAutok = new JScrollPane();
		tbPaneAlap.addTab("Autók", null, scrollPaneAutok, null);

		tblAutok = new JTable();
		tblAutok.setForeground(new Color(25, 25, 112));
		tblAutok.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tblAutok.setBackground(new Color(255, 255, 224));
		scrollPaneAutok.setViewportView(tblAutok);

		scrollPaneUtasok = new JScrollPane();
		tbPaneAlap.addTab("Utasok", null, scrollPaneUtasok, null);

		tblUtasok = new JTable();
		tblUtasok.setForeground(new Color(25, 25, 112));
		tblUtasok.setBackground(new Color(255, 255, 224));
		tblUtasok.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		scrollPaneUtasok.setViewportView(tblUtasok);

		String[] oszlopokAutok = new String[] { "Indulás", "Cél", "Rendszám", "Telefonszám", "Szabad helyek" };
		String[] oszlopokUtasok = new String[] { "Azonosító", "Indulás", "Cél", "Utasok száma" };

		tModelUtasok = new DefaultTableModel(null, oszlopokUtasok);
		tModelAutok = new DefaultTableModel(null, oszlopokAutok);

		AutokTablaFeltoltes();
		UtasokTablaFeltoltes();

		tblAutok.setModel(tModelAutok);
		tblUtasok.setModel(tModelUtasok);

		JMenuBar menuBar = new JMenuBar();
		frmTelekocsi.setJMenuBar(menuBar);

		JMenu mnFeladatok = new JMenu("Feladatok");
		mnFeladatok.setBackground(new Color(169, 169, 169));
		mnFeladatok.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		menuBar.add(mnFeladatok);

		JMenuItem mntmKettesFeladat = new JMenuItem("2. feladat");
		mntmKettesFeladat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(frmTelekocsi, String.valueOf(autok.size()) + " autós hirdet fuvart",
						"2. feladat", JOptionPane.PLAIN_MESSAGE);

			}
		});
		mntmKettesFeladat.setForeground(new Color(255, 255, 255));
		mntmKettesFeladat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmKettesFeladat.setBackground(new Color(95, 158, 160));
		mnFeladatok.add(mntmKettesFeladat);

		JMenuItem mntmHarmasFeladat = new JMenuItem("3. feladat");
		mntmHarmasFeladat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				megold.HarmadikFeladat(autok);

			}
		});
		mntmHarmasFeladat.setForeground(Color.WHITE);
		mntmHarmasFeladat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmHarmasFeladat.setBackground(new Color(95, 158, 160));
		mnFeladatok.add(mntmHarmasFeladat);

		JMenuItem mntmNegyedikFeladat = new JMenuItem("4. feladat");
		mntmNegyedikFeladat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				megold.NegyedikFeladat(autok);

			}
		});
		mntmNegyedikFeladat.setForeground(Color.WHITE);
		mntmNegyedikFeladat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNegyedikFeladat.setBackground(new Color(95, 158, 160));
		mnFeladatok.add(mntmNegyedikFeladat);

		JMenuItem mntmOtodikFeladat = new JMenuItem("5. feladat");
		mntmOtodikFeladat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				megold.OtodikFeladat(autok, utasok);

			}
		});
		mntmOtodikFeladat.setForeground(Color.WHITE);
		mntmOtodikFeladat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmOtodikFeladat.setBackground(new Color(95, 158, 160));
		mnFeladatok.add(mntmOtodikFeladat);
	}

	private void UtasokTablaFeltoltes() {
		for (Utasok utas : utasok) {

			Object[] adatok = new Object[] { utas.getAzonosito(), utas.getIndulasVaros(), utas.getCelVaros(),
					utas.getUtasokSzama() };

			tModelUtasok.addRow(adatok);

		}

	}

	private void AutokTablaFeltoltes() {

		for (Autok auto : autok) {

			Object[] adatok = new Object[] { auto.getIndulasVaros(), auto.getCelVaros(), auto.getRendszam(),
					auto.getTelefonSzam(), auto.getFeroHelyekSzama() };

			tModelAutok.addRow(adatok);
		}

	}
}
