package biblioteka.gui.edit;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import biblioteka.model.EnumJezik;
import biblioteka.model.Knjiga;
import biblioteka.model.Zanr;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;

public class IzmenaKnjigeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdTextField;
	private JTextField NaslovTextField;
	private JTextField OriginalniNaslovTextField;
	private JTextField PisacTextField;
	private JTextField GodinaObjavljivanjaTextField;
	private JTextField OpisTextField;

	public IzmenaKnjigeFrame(Biblioteka biblioteka,Knjiga knjiga) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(510, 510);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][][][][][][grow][][]"));
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblNewLabel, "cell 1 1,alignx right");
		
		IdTextField = new JTextField(Integer.toString(knjiga.getId()));
		IdTextField.setEditable(false);
		IdTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(IdTextField, "cell 2 1,alignx left");
		IdTextField.setColumns(10);
		
		JLabel lblNaslov = new JLabel("Naslov:");
		lblNaslov.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblNaslov, "cell 1 2,alignx right");
		
		NaslovTextField = new JTextField(knjiga.getNaslov());
		NaslovTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		NaslovTextField.setColumns(20);
		contentPane.add(NaslovTextField, "cell 2 2,alignx left");
		
		JLabel lblOriginalniNaslov = new JLabel("Originalni naslov:");
		lblOriginalniNaslov.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblOriginalniNaslov, "cell 1 3,alignx right");
		
		OriginalniNaslovTextField = new JTextField(knjiga.getOriginalniNaslov());
		OriginalniNaslovTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		OriginalniNaslovTextField.setColumns(20);
		contentPane.add(OriginalniNaslovTextField, "cell 2 3,alignx left");
		
		JLabel lblPisac = new JLabel("Pisac:");
		lblPisac.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblPisac, "cell 1 4,alignx trailing");
		
		PisacTextField = new JTextField(knjiga.getPisacImePrezime());
		PisacTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		PisacTextField.setColumns(20);
		contentPane.add(PisacTextField, "cell 2 4,alignx left");
		
		JLabel lblGodinaObjavljivanja = new JLabel("Godina objavljivanja:");
		lblGodinaObjavljivanja.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblGodinaObjavljivanja, "cell 1 5,alignx trailing");
		
		GodinaObjavljivanjaTextField = new JTextField(Integer.toString(knjiga.getGodinaObjavljivanja()));
		GodinaObjavljivanjaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		GodinaObjavljivanjaTextField.setColumns(20);
		contentPane.add(GodinaObjavljivanjaTextField, "cell 2 5,alignx left");
		
		JLabel lblOpis = new JLabel("Opis:");
		lblOpis.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblOpis, "cell 1 6,alignx trailing");
		
		OpisTextField = new JTextField(knjiga.getOpis());
		OpisTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		OpisTextField.setColumns(35);
		contentPane.add(OpisTextField, "cell 2 6,alignx left");
		
		JLabel lblZanr = new JLabel("Žanr:");
		lblZanr.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblZanr, "cell 1 7,alignx trailing");
		
		JComboBox<Object> ZanrComboBox = new JComboBox<Object>();
		ZanrComboBox.setMinimumSize(new Dimension(71, 20));
		ZanrComboBox.setMaximumSize(new Dimension(120, 20));
		ZanrComboBox.setPreferredSize(new Dimension(120, 20));
		ZanrComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		for(Zanr zanr: biblioteka.getSviZanrovi().values())
			ZanrComboBox.addItem(zanr);
		ZanrComboBox.setSelectedItem(knjiga.getZanr());
		contentPane.add(ZanrComboBox, "cell 2 7,alignx left");
		
		JLabel lblJezikOriginala = new JLabel("Jezik originala:");
		lblJezikOriginala.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblJezikOriginala, "cell 1 8,alignx trailing");
		
		JComboBox<Object> JezikComboBox = new JComboBox<Object>(EnumJezik.values());
		JezikComboBox.setPreferredSize(new Dimension(120, 20));
		JezikComboBox.setMaximumSize(new Dimension(120, 20));
		JezikComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		JezikComboBox.setSelectedItem(knjiga.getJezikOriginala());
		contentPane.add(JezikComboBox, "cell 2 8,alignx left");
		
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
					boolean izmenaOK = biblioteka.proveriKnjigu(NaslovTextField.getText(), OriginalniNaslovTextField.getText(), PisacTextField.getText(),
							GodinaObjavljivanjaTextField.getText(), OpisTextField.getText());
					
					if(izmenaOK) {
						knjiga.setNaslov(NaslovTextField.getText());
						knjiga.setOriginalniNaslov(OriginalniNaslovTextField.getText());
						knjiga.setPisacImePrezime(PisacTextField.getText());
						knjiga.setGodinaObjavljivanja(Integer.parseInt(GodinaObjavljivanjaTextField.getText()));
						knjiga.setOpis(OpisTextField.getText());
						biblioteka.upisiSveKnjige();
					}
					else {
						JOptionPane.showMessageDialog(null, "Uneti podaci za knjigu nisu validni.", "Pogrešan unos", JOptionPane.ERROR_MESSAGE);
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
