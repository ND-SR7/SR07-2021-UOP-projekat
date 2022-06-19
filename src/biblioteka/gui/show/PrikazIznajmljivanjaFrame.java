package biblioteka.gui.show;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import biblioteka.gui.edit.IzmenaIznajmljivanjaFrame;
import biblioteka.model.Biblioteka;
import biblioteka.model.IznajmljivanjeKnjige;
import biblioteka.model.PrimerakKnjige;

public class PrikazIznajmljivanjaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PrikazIznajmljivanjaFrame(Biblioteka biblioteka, ArrayList<IznajmljivanjeKnjige> sveIznajmljivanje) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/i.png"));
		ArrayList<IznajmljivanjeKnjige> sveNeobrisano = new ArrayList<IznajmljivanjeKnjige>();
		for(IznajmljivanjeKnjige iznajmljivanje: sveIznajmljivanje) {
			if(iznajmljivanje.isObrisano())
				continue;
			else
				sveNeobrisano.add(iznajmljivanje);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] imeKolona = new String[] {"Datum iznajmljivanja", "Datum vraćanja", "Primerak", "Član", "Zaposleni"};
		Object[][] info = new Object[sveNeobrisano.size()][imeKolona.length];
		
		for(int i=0; i<sveNeobrisano.size(); i++) {
			IznajmljivanjeKnjige iznajmljivanje = sveNeobrisano.get(i);
			info[i][0] = iznajmljivanje.getDatumIznajmljivanja();
			info[i][1] = iznajmljivanje.getDatumVracanja();
			info[i][2] = iznajmljivanje.getIznajmljenPrimerak();
			info[i][3] = iznajmljivanje.getClan();
			info[i][4] = iznajmljivanje.getZaposleni();
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(info, imeKolona);
		JTable tabela = new JTable(tableModel);
		
		tabela.setRowSelectionAllowed(true);
		tabela.setColumnSelectionAllowed(false);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setDefaultEditor(Object.class, null);
		tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setFont(new Font("Courier New", Font.PLAIN, 12));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel buttonPane = new JPanel();
		
		JButton IzmenaButton = new JButton("Izmena izabranog iznajmljivanja");
		IzmenaButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		IzmenaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite iznajmljivanje iz tabele za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					IznajmljivanjeKnjige izabranoIznajmljivanje = null;
					PrimerakKnjige iznajmljeniPrimerak = (PrimerakKnjige) tableModel.getValueAt(red, 2);
					for(IznajmljivanjeKnjige iznajmljivanje: sveNeobrisano) {
						if(iznajmljivanje.getIznajmljenPrimerak() == iznajmljeniPrimerak)
							izabranoIznajmljivanje = iznajmljivanje;
					}
					IzmenaIznajmljivanjaFrame izmena = new IzmenaIznajmljivanjaFrame(biblioteka, izabranoIznajmljivanje);
					izmena.setVisible(true);
				}
			}
		});
		buttonPane.add(IzmenaButton);
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton BrisanjeButton = new JButton("Brisanje izabranog iznajmljivanja");
		BrisanjeButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		BrisanjeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite iznajmljivanje iz tabele za brisanje.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					IznajmljivanjeKnjige izabranoIznajmljivanje = null;
					PrimerakKnjige iznajmljeniPrimerak = (PrimerakKnjige) tableModel.getValueAt(red, 2);
					for(IznajmljivanjeKnjige iznajmljivanje: sveNeobrisano) {
						if(iznajmljivanje.getIznajmljenPrimerak() == iznajmljeniPrimerak)
							izabranoIznajmljivanje = iznajmljivanje;
					}
					String[] opcije = new String[2];
					opcije[0] = "Da";
					opcije[1] = "Ne";
					
					int obrisi = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete iznajmljivanje?", "Potvrda", 0, JOptionPane.INFORMATION_MESSAGE, null, opcije, null);
					
					if(obrisi == 0) {
						izabranoIznajmljivanje.setObrisano(true);
						biblioteka.upisiSveIznajmljivanje();
						JOptionPane.showMessageDialog(null, "Iznajmljivanje uspešno obrisano.");
					}
				}
			}
		});
		buttonPane.add(BrisanjeButton);
	}

}
