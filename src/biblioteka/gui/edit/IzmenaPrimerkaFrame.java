package biblioteka.gui.edit;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import biblioteka.model.EnumJezik;
import biblioteka.model.EnumTipPoveza;
import biblioteka.model.Knjiga;
import biblioteka.model.PrimerakKnjige;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class IzmenaPrimerkaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdTextField;
	private JTextField BrStranaTextField;
	private JTextField GodinaTextField;
	private final ButtonGroup IznajmljenButtonGroup = new ButtonGroup();

	public IzmenaPrimerkaFrame(Biblioteka biblioteka, PrimerakKnjige primerak) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(510, 510);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblNewLabel, "cell 1 1,alignx trailing");
		
		IdTextField = new JTextField(Integer.toString(primerak.getId()));
		IdTextField.setEditable(false);
		IdTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(IdTextField, "cell 2 1,alignx left");
		IdTextField.setColumns(10);
		
		JLabel lblBrojStrana = new JLabel("Broj strana:");
		lblBrojStrana.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblBrojStrana, "cell 1 2,alignx trailing");
		
		BrStranaTextField = new JTextField(Integer.toString(primerak.getBrojStrana()));
		BrStranaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(BrStranaTextField, "cell 2 2,alignx left");
		BrStranaTextField.setColumns(10);
		
		JLabel lblTipPoveza = new JLabel("Tip poveza:");
		lblTipPoveza.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblTipPoveza, "cell 1 3,alignx trailing");
		
		JComboBox<Object> PovezComboBox = new JComboBox<Object>(EnumTipPoveza.values());
		PovezComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		PovezComboBox.setSelectedItem(primerak.getTipPoveza());
		contentPane.add(PovezComboBox, "cell 2 3,alignx left");
		
		JLabel lblGodinatampanja = new JLabel("Godina štampanja:");
		lblGodinatampanja.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblGodinatampanja, "cell 1 4,alignx trailing");
		
		GodinaTextField = new JTextField(Integer.toString(primerak.getGodinaStampanja()));
		GodinaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		GodinaTextField.setColumns(10);
		contentPane.add(GodinaTextField, "cell 2 4,alignx left");
		
		JLabel lblIznajmljen = new JLabel("Iznajmljen:");
		lblIznajmljen.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblIznajmljen, "cell 1 5,alignx right");
		
		JRadioButton IznajmljenRadioButton = new JRadioButton("Da");
		IznajmljenRadioButton.setEnabled(false);
		IznajmljenButtonGroup.add(IznajmljenRadioButton);
		IznajmljenRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(IznajmljenRadioButton, "flowx,cell 2 5");
		
        JRadioButton NeiznajmljenRadioButton = new JRadioButton("Ne");
        NeiznajmljenRadioButton.setEnabled(false);
        IznajmljenButtonGroup.add(NeiznajmljenRadioButton);
        NeiznajmljenRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        contentPane.add(NeiznajmljenRadioButton, "cell 2 5");
        
        if(primerak.isIznajmljen())
        	IznajmljenRadioButton.setSelected(true);
        else
        	NeiznajmljenRadioButton.setSelected(true);
		
		JLabel lblKnjiga = new JLabel("Knjiga:");
		lblKnjiga.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblKnjiga, "cell 1 6,alignx trailing");
		
		JComboBox<Object> KnjigaComboBox = new JComboBox<Object>();
		KnjigaComboBox.setEnabled(false);
		KnjigaComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		for(Knjiga knjiga: biblioteka.getSveKnjige())
			KnjigaComboBox.addItem(knjiga);
		KnjigaComboBox.setSelectedItem(primerak.getKnjiga());
		contentPane.add(KnjigaComboBox, "cell 2 6,alignx left");
		
		JLabel lblJeziktampanja = new JLabel("Jezik štampanja:");
		lblJeziktampanja.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblJeziktampanja, "cell 1 7,alignx trailing");
		
		JComboBox<Object> JezikComboBox = new JComboBox<Object>(EnumJezik.values());
		JezikComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(JezikComboBox, "cell 2 7,alignx left");
		
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
					boolean izmenaOK = biblioteka.proveriPrimerak(Integer.parseInt(BrStranaTextField.getText()), Integer.parseInt(GodinaTextField.getText()));
					
					if(izmenaOK) {
						primerak.setBrojStrana(Integer.parseInt(BrStranaTextField.getText()));
						primerak.setTipPoveza((EnumTipPoveza) PovezComboBox.getSelectedItem());
						primerak.setGodinaStampanja(Integer.parseInt(GodinaTextField.getText()));
						primerak.setJezikStampanja((EnumJezik) JezikComboBox.getSelectedItem());
						biblioteka.upisiSvePrimerke();
					}
					else {
						JOptionPane.showMessageDialog(null, "Uneti podaci za primerak knjige nisu validni.", "Pogrešan unos", JOptionPane.ERROR_MESSAGE);
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
