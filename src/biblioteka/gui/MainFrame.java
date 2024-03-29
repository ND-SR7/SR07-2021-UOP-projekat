package biblioteka.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.gui.add.DodajClanaFrame;
import biblioteka.gui.add.DodajIznajmljivanjeFrame;
import biblioteka.gui.add.DodajKnjiguFrame;
import biblioteka.gui.add.DodajPrimerakFrame;
import biblioteka.gui.add.DodajZanrFrame;
import biblioteka.gui.add.DodajZaposlenogFrame;
import biblioteka.gui.show.PrikazClanaFrame;
import biblioteka.gui.show.PrikazIznajmljivanjaFrame;
import biblioteka.gui.show.PrikazKnjigeFrame;
import biblioteka.gui.show.PrikazPrimerkaFrame;
import biblioteka.gui.show.PrikazZanraFrame;
import biblioteka.gui.show.PrikazZaposlenogFrame;
import biblioteka.model.Biblioteka;
import biblioteka.model.Zanr;
import biblioteka.model.Zaposleni;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MainFrame(Biblioteka biblioteka, Zaposleni zaposleni) {
		setMinimumSize(new Dimension(780, 210));
		setTitle("Glavni Meni");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/bi.png"));
		setFont(new Font("Courier New", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 620);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Courier New", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu BibliotekaMenu = new JMenu("Biblioteka");
		BibliotekaMenu.setFont(new Font("Courier New", Font.BOLD, 14));
		menuBar.add(BibliotekaMenu);
		
		JMenuItem InformacijeMenuItem = new JMenuItem("Informacije");
		InformacijeMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		InformacijeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					InformacijeDialog info = new InformacijeDialog(biblioteka);
					info.setModal(true);
					info.setVisible(true);
			}
		});
		BibliotekaMenu.add(InformacijeMenuItem);
		
		JMenuItem IzmenaMenuItem = new JMenuItem("Izmena");
		IzmenaMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		IzmenaMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IzmenaDialog izmena = new IzmenaDialog(biblioteka);
				izmena.setModal(true);
				izmena.setVisible(true);
			}
		});
		BibliotekaMenu.add(IzmenaMenuItem);
		
		JMenu PregledMenu = new JMenu("Pregled");
		PregledMenu.setFont(new Font("Courier New", Font.BOLD, 14));
		menuBar.add(PregledMenu);
		
		JMenuItem ClanoviMenuItem = new JMenuItem("Članova");
		ClanoviMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		ClanoviMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazClanaFrame clanFrame = new PrikazClanaFrame(biblioteka, biblioteka.getSviClanovi());
				clanFrame.setVisible(true);
			}
		});
		PregledMenu.add(ClanoviMenuItem);
		
		JMenuItem ZaposleniMenuItem = new JMenuItem("Zaposlenih");
		ZaposleniMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		ZaposleniMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(zaposleni.getUloga().equals("A")) {
					PrikazZaposlenogFrame zaposleniFrame = new PrikazZaposlenogFrame(biblioteka, biblioteka.getSviZaposleni());
					zaposleniFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Nemate dozvolu za pristup zaposlenima.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		PregledMenu.add(ZaposleniMenuItem);
		
		JSeparator separator = new JSeparator();
		PregledMenu.add(separator);
		
		JMenuItem KnjigeMenuItem = new JMenuItem("Knjiga");
		KnjigeMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		KnjigeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazKnjigeFrame knjigaFrame = new PrikazKnjigeFrame(biblioteka, biblioteka.getSveKnjige());
				knjigaFrame.setVisible(true);
			}
		});
		PregledMenu.add(KnjigeMenuItem);
		
		JMenuItem PrimerciMenuItem = new JMenuItem("Primeraka knjiga");
		PrimerciMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		PrimerciMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazPrimerkaFrame primerakFrame = new PrikazPrimerkaFrame(biblioteka, biblioteka.getSviPrimerciKnjiga());
				primerakFrame.setVisible(true);
			}
		});
		PregledMenu.add(PrimerciMenuItem);
		
		JMenuItem ZanroviMenuItem = new JMenuItem("Žanrova");
		ZanroviMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		ZanroviMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Zanr> hashMapa = biblioteka.getSviZanrovi();
				ArrayList<Zanr> sviZanrovi = hashMapa.values().stream().collect(Collectors.toCollection(ArrayList::new));
				PrikazZanraFrame zanrFrame = new PrikazZanraFrame(biblioteka, sviZanrovi);
				zanrFrame.setVisible(true);
			}
		});
		PregledMenu.add(ZanroviMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		PregledMenu.add(separator_1);
		
		JMenuItem IznajmljivanjaMenuItem = new JMenuItem("Iznajmljivanja");
		IznajmljivanjaMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		IznajmljivanjaMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazIznajmljivanjaFrame iznajmljivanjeFrame = new PrikazIznajmljivanjaFrame(biblioteka, biblioteka.getSveIznajmljivanje());
				iznajmljivanjeFrame.setVisible(true);
			}
		});
		PregledMenu.add(IznajmljivanjaMenuItem);
		
		JMenu DodavanjeMenu = new JMenu("Dodavanje");
		DodavanjeMenu.setFont(new Font("Courier New", Font.BOLD, 14));
		menuBar.add(DodavanjeMenu);
		
		JMenuItem ClanoviAddMenuItem = new JMenuItem("Člana");
		ClanoviAddMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		ClanoviAddMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					DodajClanaFrame dodaj = new DodajClanaFrame(biblioteka);
					dodaj.setVisible(true);
			}
		});
		DodavanjeMenu.add(ClanoviAddMenuItem);
		
		JMenuItem ZaposleniAddMenuItem = new JMenuItem("Zaposlenog");
		ZaposleniAddMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		ZaposleniAddMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(zaposleni.getUloga().equals("A")) {
					DodajZaposlenogFrame dodaj = new DodajZaposlenogFrame(biblioteka);
					dodaj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Nemate dozvolu za dodavanje zaposlenih.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		DodavanjeMenu.add(ZaposleniAddMenuItem);
		
		JSeparator separator_2 = new JSeparator();
		DodavanjeMenu.add(separator_2);
		
		JMenuItem KnjigeAddMenuItem = new JMenuItem("Knjige");
		KnjigeAddMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		KnjigeAddMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajKnjiguFrame dodaj = new DodajKnjiguFrame(biblioteka);
				dodaj.setVisible(true);
			}
		});
		DodavanjeMenu.add(KnjigeAddMenuItem);
		
		JMenuItem PrimerciAddMenuItem = new JMenuItem("Primerka knjige");
		PrimerciAddMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		PrimerciAddMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajPrimerakFrame dodaj = new DodajPrimerakFrame(biblioteka);
				dodaj.setVisible(true);
			}
		});
		DodavanjeMenu.add(PrimerciAddMenuItem);
		
		JMenuItem ZanroviAddMenuItem = new JMenuItem("Žanra");
		ZanroviAddMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		ZanroviAddMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajZanrFrame dodaj = new DodajZanrFrame(biblioteka);
				dodaj.setVisible(true);
			}
		});
		DodavanjeMenu.add(ZanroviAddMenuItem);
		
		JSeparator separator_1_1 = new JSeparator();
		DodavanjeMenu.add(separator_1_1);
		
		JMenuItem IznajmljivanjaAddMenuItem = new JMenuItem("Iznajmljivanja");
		IznajmljivanjaAddMenuItem.setFont(new Font("Courier New", Font.PLAIN, 12));
		IznajmljivanjaAddMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajIznajmljivanjeFrame dodaj = new DodajIznajmljivanjeFrame(biblioteka);
				dodaj.setVisible(true);
			}
		});
		DodavanjeMenu.add(IznajmljivanjaAddMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel InfoLabel = new JLabel("Bibliotekarski Informacioni Sistem");
		InfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		InfoLabel.setFont(new Font("Courier New", Font.PLAIN, 36));
		contentPane.add(InfoLabel, BorderLayout.CENTER);
		
		JLabel VersionLabel = new JLabel("v1.1");
		VersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		VersionLabel.setVerticalAlignment(SwingConstants.TOP);
		VersionLabel.setFont(new Font("Courier New", Font.PLAIN, 36));
		contentPane.add(VersionLabel, BorderLayout.SOUTH);
	}

}
