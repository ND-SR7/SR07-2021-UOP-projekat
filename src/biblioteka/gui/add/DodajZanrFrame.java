package biblioteka.gui.add;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import biblioteka.model.Zanr;
import net.miginfocom.swing.MigLayout;

public class DodajZanrFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField OznakaTextField;
	private JTextField OpisTextField;

	public DodajZanrFrame(Biblioteka biblioteka) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(510, 510);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][][grow]"));
		
		JLabel lblOznaka = new JLabel("Oznaka:");
		lblOznaka.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblOznaka, "cell 1 1,alignx trailing");
		
		OznakaTextField = new JTextField();
		OznakaTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.add(OznakaTextField, "cell 2 1,alignx left");
		OznakaTextField.setColumns(10);
		
		JLabel lblOpis = new JLabel("Opis");
		lblOpis.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblOpis, "cell 1 2,alignx trailing");
		
		OpisTextField = new JTextField();
		OpisTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		OpisTextField.setColumns(50);
		contentPane.add(OpisTextField, "cell 2 2,alignx left");
		
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
					boolean izmenaOK = biblioteka.proveriZanr(OznakaTextField.getText(), OpisTextField.getText());
					
					if(izmenaOK) {
						Zanr zanr = new Zanr(OznakaTextField.getText(), OpisTextField.getText(), false);
						biblioteka.getSviZanrovi().put(OznakaTextField.getText(), zanr);
						biblioteka.upisiSveZanrove();
					}
					else {
						JOptionPane.showMessageDialog(null, "Uneti podaci za žanr nisu validni.", "Pogrešan unos", JOptionPane.ERROR_MESSAGE);
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
