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

import biblioteka.gui.edit.IzmenaZanraFrame;
import biblioteka.model.Biblioteka;
import biblioteka.model.Zanr;

public class PrikazZanraFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PrikazZanraFrame(Biblioteka biblioteka, ArrayList<Zanr> sviZanrovi) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/i.png"));
		ArrayList<Zanr> sviNeobrisani = new ArrayList<Zanr>();
		for(Zanr zanr: sviZanrovi) {
			if(zanr.isObrisan())
				continue;
			else
				sviNeobrisani.add(zanr);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] imeKolona = new String[] {"Oznaka", "Opis"};
		Object[][] info = new Object[sviNeobrisani.size()][imeKolona.length];
		
		for(int i=0; i<sviNeobrisani.size(); i++) {
			Zanr zanr = sviNeobrisani.get(i);
			info[i][0] = zanr.getOznaka();
			info[i][1] = zanr.getOpis();
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
		
		JButton IzmenaButton = new JButton("Izmena izabranog žanra");
		IzmenaButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		IzmenaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite žanr iz tabele za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					Zanr izabraniZanr = null;
					String zanrOznaka = tableModel.getValueAt(red, 0).toString();
					for(Zanr zanr: sviNeobrisani) {
						if(zanr.getOznaka() == zanrOznaka)
							izabraniZanr = zanr;
					}
					IzmenaZanraFrame izmena = new IzmenaZanraFrame(biblioteka, izabraniZanr);
					izmena.setVisible(true);
				}
			}
		});
		buttonPane.add(IzmenaButton);
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton BrisanjeButton = new JButton("Brisanje izabranog žanra");
		BrisanjeButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		BrisanjeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite žanr iz tabele za brisanje.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					Zanr izabraniZanr = null;
					String zanrOznaka = tableModel.getValueAt(red, 0).toString();
					for(Zanr zanr: sviNeobrisani) {
						if(zanr.getOznaka() == zanrOznaka)
							izabraniZanr = zanr;
					}
					String[] opcije = new String[2];
					opcije[0] = "Da";
					opcije[1] = "Ne";
					
					int obrisi = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete žanr?", "Potvrda", 0, JOptionPane.INFORMATION_MESSAGE, null, opcije, null);
					
					if(obrisi == 0) {
						izabraniZanr.setObrisan(true);
						biblioteka.upisiSveZanrove();
						JOptionPane.showMessageDialog(null, "Žanr uspešno obrisan.");
					}
				}
			}
		});
		buttonPane.add(BrisanjeButton);
	}

}
