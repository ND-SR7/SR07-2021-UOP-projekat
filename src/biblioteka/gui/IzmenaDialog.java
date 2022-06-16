package biblioteka.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JTextField;

public class IzmenaDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField NazivTextField;
	private JTextField AdresaTextField;
	private JTextField BrTelefonTextField;
	private JTextField RadnoVremeTextField;

	public IzmenaDialog(Biblioteka biblioteka) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setSize(540, 360);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][][][][][grow]", "[][][][][][]"));
		{
			JLabel NazivLabel = new JLabel("Naziv:");
			NazivLabel.setFont(new Font("Courier New", Font.BOLD, 18));
			contentPanel.add(NazivLabel, "cell 6 2,alignx right");
		}
		{
			NazivTextField = new JTextField(biblioteka.getNaziv());
			NazivTextField.setFont(new Font("Courier New", Font.PLAIN, 16));
			contentPanel.add(NazivTextField, "cell 7 2,growx");
			NazivTextField.setColumns(15);
		}
		{
			JLabel AdresaLabel = new JLabel("Adresa:");
			AdresaLabel.setFont(new Font("Courier New", Font.BOLD, 18));
			contentPanel.add(AdresaLabel, "cell 6 3,alignx trailing");
		}
		{
			AdresaTextField = new JTextField(biblioteka.getAdresa());
			AdresaTextField.setFont(new Font("Courier New", Font.PLAIN, 16));
			AdresaTextField.setColumns(15);
			contentPanel.add(AdresaTextField, "cell 7 3,growx");
		}
		{
			JLabel TelefonLabel = new JLabel("Broj telefona:");
			TelefonLabel.setFont(new Font("Courier New", Font.BOLD, 18));
			contentPanel.add(TelefonLabel, "cell 6 4,alignx trailing");
		}
		{
			BrTelefonTextField = new JTextField(biblioteka.getBrTelefon());
			BrTelefonTextField.setFont(new Font("Courier New", Font.PLAIN, 16));
			BrTelefonTextField.setColumns(15);
			contentPanel.add(BrTelefonTextField, "cell 7 4,growx");
		}
		{
			JLabel VremeLabel = new JLabel("Radno vreme:");
			VremeLabel.setFont(new Font("Courier New", Font.BOLD, 18));
			contentPanel.add(VremeLabel, "cell 6 5,alignx trailing");
		}
		{
			RadnoVremeTextField = new JTextField(biblioteka.getRadnoVreme());
			RadnoVremeTextField.setFont(new Font("Courier New", Font.PLAIN, 16));
			RadnoVremeTextField.setColumns(15);
			contentPanel.add(RadnoVremeTextField, "cell 7 5,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
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
							boolean izmenaOK = biblioteka.proveriIzmenu(NazivTextField.getText(), AdresaTextField.getText(), BrTelefonTextField.getText(), RadnoVremeTextField.getText());
							if(izmenaOK) {
								biblioteka.setNaziv(NazivTextField.getText());
								biblioteka.setAdresa(AdresaTextField.getText());
								biblioteka.setBrTelefon(BrTelefonTextField.getText());
								biblioteka.setRadnoVreme(RadnoVremeTextField.getText());
								biblioteka.upisiBiblioteku();
							}
							else {
								JOptionPane.showMessageDialog(null, "Uneti podaci za biblioteku nisu validni.", "Pogrešan unos", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});;
				buttonPane.add(sacuvajButton);
				getRootPane().setDefaultButton(sacuvajButton);
			}
			{
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
	}

}
