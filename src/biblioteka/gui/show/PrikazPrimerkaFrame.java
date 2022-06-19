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

import biblioteka.gui.edit.IzmenaPrimerkaFrame;
import biblioteka.model.Biblioteka;
import biblioteka.model.PrimerakKnjige;

public class PrikazPrimerkaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PrikazPrimerkaFrame(Biblioteka biblioteka, ArrayList<PrimerakKnjige> sviPrimerci) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/i.png"));
		ArrayList<PrimerakKnjige> sviNeobrisani = new ArrayList<PrimerakKnjige>();
		for(PrimerakKnjige primerak: sviPrimerci) {
			if(primerak.isObrisan())
				continue;
			else
				sviNeobrisani.add(primerak);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] imeKolona = new String[] {"ID", "Broj strana", "Tip poveza", "Godina štampanja", "Iznajmljen", "Knjiga", "Jezik štampanja"};
		Object[][] info = new Object[sviNeobrisani.size()][imeKolona.length];
		
		for(int i=0; i<sviNeobrisani.size(); i++) {
			PrimerakKnjige primerak = sviNeobrisani.get(i);
			info[i][0] = primerak.getId();
			info[i][1] = primerak.getBrojStrana();
			info[i][2] = primerak.getTipPoveza();
			info[i][3] = primerak.getGodinaStampanja();
			if(primerak.isIznajmljen())
				info[i][4] = "Da";
			else
				info[i][4] = "Ne";
			info[i][5] = primerak.getKnjiga();
			info[i][6] = primerak.getJezikStampanja();
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
		
		JButton IzmenaButton = new JButton("Izmena izabranog primerka");
		IzmenaButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		IzmenaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite primerak iz tabele za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					PrimerakKnjige izabraniPrimerak = null;
					int primerakId = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					for(PrimerakKnjige primerak: sviNeobrisani) {
						if(primerak.getId() == primerakId)
							izabraniPrimerak = primerak;
					}
					IzmenaPrimerkaFrame izmena = new IzmenaPrimerkaFrame(biblioteka, izabraniPrimerak);
					izmena.setVisible(true);
				}
			}
		});
		buttonPane.add(IzmenaButton);
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton BrisanjeButton = new JButton("Brisanje izabranog primerka");
		BrisanjeButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		BrisanjeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite primerak iz tabele za brisanje.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					PrimerakKnjige izabraniPrimerak = null;
					int primerakId = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					for(PrimerakKnjige primerak: sviNeobrisani) {
						if(primerak.getId() == primerakId)
							izabraniPrimerak = primerak;
					}
					String[] opcije = new String[2];
					opcije[0] = "Da";
					opcije[1] = "Ne";
					
					int obrisi = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete primerak?", "Potvrda", 0, JOptionPane.INFORMATION_MESSAGE, null, opcije, null);
					
					if(obrisi == 0) {
						izabraniPrimerak.setObrisan(true);
						biblioteka.upisiSvePrimerke();
						JOptionPane.showMessageDialog(null, "Primerak uspešno obrisan.");
					}
				}
			}
		});
		buttonPane.add(BrisanjeButton);
	}

}
