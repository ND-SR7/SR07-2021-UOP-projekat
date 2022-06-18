package biblioteka.gui.showEdit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import biblioteka.model.EnumClanarina;
import biblioteka.model.EnumPol;
import biblioteka.model.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class IzmenaZaposlenogFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdTextField;
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
	private JTextField brMeseciClanarineTextField;
	private JRadioButton rdbtnAktivan;
	private JComboBox<Object> clanarinaComboBox;
	private JPanel buttonPane;
	private JButton sacuvajButton;
	private JButton odustaniButton;
	private JTextField DatumTextField;

	public IzmenaZaposlenogFrame(Biblioteka biblioteka, Zaposleni zaposleni) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(510, 510);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][]", "[grow][][][][][][][][][][][][grow][grow]"));
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblID, "cell 1 1,alignx right");
		
		IdTextField = new JTextField(Integer.toString(zaposleni.getId()));
		IdTextField.setEditable(false);
		IdTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(IdTextField, "cell 2 1,alignx left");
		IdTextField.setColumns(10);
		
		lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblIme, "cell 1 3,alignx right");
		
		ImeTextField = new JTextField(zaposleni.getIme());
		ImeTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		ImeTextField.setColumns(20);
		contentPane.add(ImeTextField, "cell 2 3,alignx left");
		
		lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblPrezime, "cell 1 4,alignx right");
		
		PrezimeTextField = new JTextField(zaposleni.getPrezime());
		PrezimeTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		PrezimeTextField.setColumns(20);
		contentPane.add(PrezimeTextField, "cell 2 4,alignx left");
		
		lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblJmbg, "cell 1 5,alignx right");
		
		JMBGTextField = new JTextField(zaposleni.getJMBG());
		JMBGTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		JMBGTextField.setColumns(20);
		contentPane.add(JMBGTextField, "cell 2 5,alignx left");
		
		lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblAdresa, "cell 1 6,alignx trailing");
		
		AdresaTextField = new JTextField(zaposleni.getAdresa());
		AdresaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		AdresaTextField.setColumns(20);
		contentPane.add(AdresaTextField, "cell 2 6,alignx left");
		
		lblPol = new JLabel("Pol:");
		lblPol.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblPol, "cell 1 7,alignx right");
		
		MuskoRadioButton = new JRadioButton("Muško");
		polButtonGroup.add(MuskoRadioButton);
		MuskoRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(MuskoRadioButton, "flowx,cell 2 7");
		
		ZenskoRadioButton = new JRadioButton("Žensko");
		polButtonGroup.add(ZenskoRadioButton);
		ZenskoRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(ZenskoRadioButton, "cell 2 7");
		
		if(zaposleni.getPol() == EnumPol.Muško)
			MuskoRadioButton.setSelected(true);
		else if(zaposleni.getPol() == EnumPol.Žensko)
			ZenskoRadioButton.setSelected(true);
        
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
					
					LocalDate datum = LocalDate.parse(DatumTextField.getText());
					
					boolean aktivan = false;
					if(rdbtnAktivan.isSelected())
						aktivan = true;
					
					EnumClanarina clanarina = (EnumClanarina) clanarinaComboBox.getSelectedItem();
					
					boolean izmenaOK = biblioteka.proveriClana(ImeTextField.getText(), PrezimeTextField.getText(), JMBGTextField.getText(), AdresaTextField.getText(),
							Integer.parseInt(brMeseciClanarineTextField.getText()));
					
					if(izmenaOK) {
//						clan.setIme(ImeTextField.getText());
//						clan.setPrezime(PrezimeTextField.getText());
//						clan.setJMBG(JMBGTextField.getText());
//						clan.setAdresa(AdresaTextField.getText());
//						clan.setPol(pol);
//						clan.setDatumPoslednjeUplate(datum);
//						clan.setBrMeseciClanarine(Integer.parseInt(brMeseciClanarineTextField.getText()));
//						clan.setAktivan(aktivan);
//						clan.setTipClanarine(clanarina);
//						biblioteka.upisiSveClanove();
					}
					else {
						JOptionPane.showMessageDialog(null, "Uneti podaci za člana nisu validni.", "Pogrešan unos", JOptionPane.ERROR_MESSAGE);
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
