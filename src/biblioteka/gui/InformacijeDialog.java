package biblioteka.gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class InformacijeDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public InformacijeDialog(Biblioteka biblioteka) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/i.png"));
		setSize(540, 360);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][][grow]", "[][][][][][]"));
		
		JLabel NazivLabel = new JLabel("Naziv:");
		NazivLabel.setFont(new Font("Courier New", Font.BOLD, 18));
		contentPanel.add(NazivLabel, "cell 1 2,alignx right");
		
		JLabel BibliotekaNazivLabel = new JLabel(biblioteka.getNaziv());
		BibliotekaNazivLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		contentPanel.add(BibliotekaNazivLabel, "cell 2 2,alignx left");
		
		JLabel AdresaLabel = new JLabel("Adresa:");
		AdresaLabel.setFont(new Font("Courier New", Font.BOLD, 18));
		contentPanel.add(AdresaLabel, "cell 1 3,alignx right");
		
		JLabel BibliotekaAdresaLabel = new JLabel(biblioteka.getAdresa());
		BibliotekaAdresaLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		contentPanel.add(BibliotekaAdresaLabel, "cell 2 3,alignx left");
		
		JLabel TelefonLabel = new JLabel("Broj telefona:");
		TelefonLabel.setFont(new Font("Courier New", Font.BOLD, 18));
		contentPanel.add(TelefonLabel, "cell 1 4,alignx right");
		
		JLabel BibliotekaTelefonLabel = new JLabel(biblioteka.getBrTelefon());
		BibliotekaTelefonLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		contentPanel.add(BibliotekaTelefonLabel, "cell 2 4,alignx left");
		
		JLabel VremeLabel = new JLabel("Radno vreme:");
		VremeLabel.setFont(new Font("Courier New", Font.BOLD, 18));
		contentPanel.add(VremeLabel, "cell 1 5,alignx right");
		
		JLabel BibliotekaVremeLabel = new JLabel(biblioteka.getRadnoVreme());
		BibliotekaVremeLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		contentPanel.add(BibliotekaVremeLabel, "cell 2 5,alignx left");
	}

}
