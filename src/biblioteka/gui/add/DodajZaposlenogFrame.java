package biblioteka.gui.add;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Administrator;
import biblioteka.model.Biblioteka;
import biblioteka.model.Bibliotekar;
import biblioteka.model.EnumPol;
import biblioteka.model.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class DodajZaposlenogFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JTextField ImeTextField;
	private JTextField PrezimeTextField;
	private JLabel lblJmbg;
	private JTextField JMBGTextField;
	private JLabel lblAdresa;
	private JTextField AdresaTextField;
	private JLabel lblPol;
	private JRadioButton MuskoRadioButton;
	private JRadioButton ZenskoRadioButton;
	private final ButtonGroup polButtonGroup = new ButtonGroup();
	private JLabel lblPlata;
	private JTextField PlataTextField;
	private JLabel lblKorisnickoIme;
	private JTextField KorisnickoImeTextField;
	private JLabel lblLozinka;
	private JPasswordField LozinkaPasswordField;
	private JLabel lblUloga;
	private JComboBox<Object> UlogaComboBox;
	private JPanel buttonPane;
	private JButton sacuvajButton;
	private JButton odustaniButton;

	public DodajZaposlenogFrame(Biblioteka biblioteka) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(510, 510);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][]", "[grow][][][][][][][][][][][][grow][grow]"));
		
		lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblIme, "cell 1 3,alignx right");
		
		ImeTextField = new JTextField();
		ImeTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		ImeTextField.setColumns(20);
		contentPane.add(ImeTextField, "cell 2 3,alignx left");
		
		lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblPrezime, "cell 1 4,alignx right");
		
		PrezimeTextField = new JTextField();
		PrezimeTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		PrezimeTextField.setColumns(20);
		contentPane.add(PrezimeTextField, "cell 2 4,alignx left");
		
		lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblJmbg, "cell 1 5,alignx right");
		
		JMBGTextField = new JTextField();
		JMBGTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		JMBGTextField.setColumns(20);
		contentPane.add(JMBGTextField, "cell 2 5,alignx left");
		
		lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblAdresa, "cell 1 6,alignx trailing");
		
		AdresaTextField = new JTextField();
		AdresaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		AdresaTextField.setColumns(20);
		contentPane.add(AdresaTextField, "cell 2 6,alignx left");
		
		lblPol = new JLabel("Pol:");
		lblPol.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblPol, "cell 1 7,alignx right");
		
		MuskoRadioButton = new JRadioButton("Muško");
		polButtonGroup.add(MuskoRadioButton);
		MuskoRadioButton.setSelected(true);
		MuskoRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(MuskoRadioButton, "flowx,cell 2 7");
		
		ZenskoRadioButton = new JRadioButton("Žensko");
		polButtonGroup.add(ZenskoRadioButton);
		ZenskoRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(ZenskoRadioButton, "cell 2 7");
		
		lblPlata = new JLabel("Plata:");
		lblPlata.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblPlata, "cell 1 8,alignx right");
		
		PlataTextField = new JTextField();
		PlataTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		PlataTextField.setColumns(20);
		contentPane.add(PlataTextField, "cell 2 8,alignx left");
		
		lblKorisnickoIme = new JLabel("Korisničko ime:");
		lblKorisnickoIme.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblKorisnickoIme, "cell 1 9,alignx right");
		
		KorisnickoImeTextField = new JTextField();
		KorisnickoImeTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		KorisnickoImeTextField.setColumns(20);
		contentPane.add(KorisnickoImeTextField, "cell 2 9,alignx left");
		
		lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblLozinka, "cell 1 10,alignx right");
		
		LozinkaPasswordField = new JPasswordField();
		LozinkaPasswordField.setFont(new Font("Courier New", Font.PLAIN, 12));
		LozinkaPasswordField.setColumns(20);
		contentPane.add(LozinkaPasswordField, "cell 2 10,alignx left");
		
		lblUloga = new JLabel("Uloga:");
		lblUloga.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblUloga, "cell 1 11,alignx right");
		
		String[] uloge = {"Administrator", "Bibliotekar"};
		UlogaComboBox = new JComboBox<Object>(uloge);
        contentPane.add(UlogaComboBox, "cell 2 11,alignx left");
        
        buttonPane = new JPanel();
        contentPane.add(buttonPane, "cell 2 12,growx,aligny center");
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        sacuvajButton = new JButton("Sačuvaj");
        sacuvajButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        sacuvajButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opcije = new String[2];
				opcije[0] = "Da";
				opcije[1] = "Ne";
				
				int sacuvaj = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da sačuvate?", "Potvrda", 0, JOptionPane.INFORMATION_MESSAGE, null, opcije, null);
				
				if(sacuvaj == 0) {
					EnumPol pol = null;
					if(MuskoRadioButton.isSelected()) 
						pol = EnumPol.Muško;
					else if(ZenskoRadioButton.isSelected()) 
						pol = EnumPol.Žensko;
					
					String izabrano = UlogaComboBox.getSelectedItem().toString();
					String uloga = String.valueOf(izabrano.charAt(0));
					
					boolean izmenaOK = biblioteka.proveriZaposlenog(ImeTextField.getText(), PrezimeTextField.getText(), JMBGTextField.getText(), AdresaTextField.getText(),
							Double.parseDouble(PlataTextField.getText()), KorisnickoImeTextField.getText(), new String(LozinkaPasswordField.getPassword()));
					
					Zaposleni zaposleni;
					if(izmenaOK) {
						if(uloga.equals("A")) {
							zaposleni = new Administrator(ImeTextField.getText(), PrezimeTextField.getText(), JMBGTextField.getText(), 
									AdresaTextField.getText(), pol, Double.parseDouble(PlataTextField.getText()), KorisnickoImeTextField.getText(), 
									new String(LozinkaPasswordField.getPassword()), false);
						} else {
							zaposleni = new Bibliotekar(ImeTextField.getText(), PrezimeTextField.getText(), JMBGTextField.getText(), 
									AdresaTextField.getText(), pol, Double.parseDouble(PlataTextField.getText()), KorisnickoImeTextField.getText(), 
									new String(LozinkaPasswordField.getPassword()), false);
						}
						biblioteka.getSviZaposleni().add(zaposleni);
						biblioteka.upisiSveZaposlene();
					}
					else {
						JOptionPane.showMessageDialog(null, "Uneti podaci za zaposlenog nisu validni.", "Pogrešan unos", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});;
        buttonPane.add(sacuvajButton);
        
        odustaniButton = new JButton("Odustani");
        odustaniButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        odustaniButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
        buttonPane.add(odustaniButton);
	}

}
