package biblioteka.gui.edit;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import biblioteka.model.Clan;
import biblioteka.model.IznajmljivanjeKnjige;
import biblioteka.model.PrimerakKnjige;
import biblioteka.model.Zaposleni;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class IzmenaIznajmljivanjaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField DatumIznajmljivanjaTextField;
	private JTextField DatumVracanjaTextField;
	private JLabel lblFormat1;
	private JLabel lblFormat2;
	private JLabel lblPrimerakKnjige;
	private JLabel lblClan;
	private JLabel lblZaposleni;
	private JComboBox<Object> PrimerakComboBox;
	private JComboBox<Object> ClanComboBox;
	private JComboBox<Object> ZaposleniComboBox;

	public IzmenaIznajmljivanjaFrame(Biblioteka biblioteka, IznajmljivanjeKnjige iznajmljivanje) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(510, 510);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][][][][][grow]"));
		
		JLabel lblDatumIznajmljivanja = new JLabel("Datum iznajmljivanja:");
		lblDatumIznajmljivanja.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblDatumIznajmljivanja, "cell 1 1,alignx trailing");
		
		DatumIznajmljivanjaTextField = new JTextField(iznajmljivanje.getDatumIznajmljivanja().toString());
		DatumIznajmljivanjaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(DatumIznajmljivanjaTextField, "flowx,cell 2 1,alignx left");
		DatumIznajmljivanjaTextField.setColumns(15);
		
		JLabel lblDatumVracanja = new JLabel("Datum vraćanja:");
		lblDatumVracanja.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblDatumVracanja, "cell 1 2,alignx trailing");
		
		DatumVracanjaTextField = new JTextField(iznajmljivanje.getDatumVracanja().toString());
		DatumVracanjaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		DatumVracanjaTextField.setColumns(15);
		contentPane.add(DatumVracanjaTextField, "flowx,cell 2 2,alignx left");
		
		lblFormat1 = new JLabel("YYYY-mm-dd");
		lblFormat1.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(lblFormat1, "cell 2 1");
		
		lblFormat2 = new JLabel("YYYY-mm-dd");
		lblFormat2.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(lblFormat2, "cell 2 2");
		
		lblPrimerakKnjige = new JLabel("Primerak knjige:");
		lblPrimerakKnjige.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblPrimerakKnjige, "cell 1 3,alignx trailing");
		
		PrimerakComboBox = new JComboBox<Object>();
		PrimerakComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		for(PrimerakKnjige primerak: biblioteka.getSviPrimerciKnjiga())
			PrimerakComboBox.addItem(primerak);
		PrimerakComboBox.setSelectedItem(iznajmljivanje.getIznajmljenPrimerak());
		contentPane.add(PrimerakComboBox, "cell 2 3,alignx left");
		
		lblClan = new JLabel("Član:");
		lblClan.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblClan, "cell 1 4,alignx trailing");
		
		ClanComboBox = new JComboBox<Object>();
		ClanComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		for(Clan clan: biblioteka.getSviClanovi())
			ClanComboBox.addItem(clan);
		ClanComboBox.setSelectedItem(iznajmljivanje.getClan());
		contentPane.add(ClanComboBox, "cell 2 4,alignx left");
		
		lblZaposleni = new JLabel("Zaposleni:");
		lblZaposleni.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblZaposleni, "cell 1 5,alignx trailing");
		
		ZaposleniComboBox = new JComboBox<Object>();
		ZaposleniComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		for(Zaposleni zaposleni: biblioteka.getSviZaposleni())
			ZaposleniComboBox.addItem(zaposleni);
		ZaposleniComboBox.setSelectedItem(iznajmljivanje.getZaposleni());
		contentPane.add(ZaposleniComboBox, "cell 2 5,alignx left");
		
		JPanel buttonPane = new JPanel();
        contentPane.add(buttonPane, "cell 2 12,growx,aligny center");
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JButton sacuvajButton = new JButton("Sačuvaj");
        sacuvajButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        sacuvajButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opcije = new String[2];
				opcije[0] = "Da";
				opcije[1] = "Ne";
				
				int sacuvaj = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da sačuvate?", "Potvrda", 0, JOptionPane.INFORMATION_MESSAGE, null, opcije, null);
				
				if(sacuvaj == 0) {
					boolean izmenaOK = biblioteka.proveriIznajmljivanje(LocalDate.parse(DatumIznajmljivanjaTextField.getText()), LocalDate.parse(DatumVracanjaTextField.getText()));
					
					if(izmenaOK) {
						iznajmljivanje.setDatumIznajmljivanja(LocalDate.parse(DatumIznajmljivanjaTextField.getText()));
						iznajmljivanje.setDatumVracanja(LocalDate.parse(DatumVracanjaTextField.getText()));
						iznajmljivanje.setIznajmljenPrimerak((PrimerakKnjige) PrimerakComboBox.getSelectedItem());
						iznajmljivanje.getIznajmljenPrimerak().setIznajmljen(true);
						iznajmljivanje.setClan((Clan) ClanComboBox.getSelectedItem());
						iznajmljivanje.setZaposleni((Zaposleni) ZaposleniComboBox.getSelectedItem());
						biblioteka.upisiSvePrimerke();
						biblioteka.upisiSveIznajmljivanje();
					}
					else {
						JOptionPane.showMessageDialog(null, "Uneti podaci za iznajmljivanje nisu validni.", "Pogrešan unos", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});;
        buttonPane.add(sacuvajButton);
        
        JButton odustaniButton = new JButton("Odustani");
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
