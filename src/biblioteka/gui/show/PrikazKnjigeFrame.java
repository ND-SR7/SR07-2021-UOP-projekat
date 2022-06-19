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

import biblioteka.gui.edit.IzmenaKnjigeFrame;
import biblioteka.model.Biblioteka;
import biblioteka.model.Knjiga;

public class PrikazKnjigeFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PrikazKnjigeFrame(Biblioteka biblioteka, ArrayList<Knjiga> sveKnjiga) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/i.png"));
		ArrayList<Knjiga> sveNeobrisane = new ArrayList<Knjiga>();
		for(Knjiga knjiga: sveKnjiga) {
			if(knjiga.isObrisana())
				continue;
			else
				sveNeobrisane.add(knjiga);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] imeKolona = new String[] {"ID", "Naslov", "Originalni naslov", "Pisac", "Godina objavljivanja", "Opis", "Zanr", "Jezik originala"};
		Object[][] info = new Object[sveNeobrisane.size()][imeKolona.length];
		
		for(int i=0; i<sveNeobrisane.size(); i++) {
			Knjiga knjiga = sveNeobrisane.get(i);
			info[i][0] = knjiga.getId();
			info[i][1] = knjiga.getNaslov();
			info[i][2] = knjiga.getOriginalniNaslov();
			info[i][3] = knjiga.getPisacImePrezime();
			info[i][4] = knjiga.getGodinaObjavljivanja();
			info[i][5] = knjiga.getOpis();
			info[i][6] = knjiga.getZanr();
			info[i][7] = knjiga.getJezikOriginala();
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
		
		JButton IzmenaButton = new JButton("Izmena izabrane knjige");
		IzmenaButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		IzmenaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite knjigu iz tabele za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
				} else {
					Knjiga izabranaKnjiga = null;
					int knjigaId = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					for(Knjiga knjiga: sveNeobrisane) {
						if(knjiga.getId() == knjigaId)
							izabranaKnjiga = knjiga;
					}
					IzmenaKnjigeFrame izmena = new IzmenaKnjigeFrame(biblioteka, izabranaKnjiga);
					izmena.setVisible(true);
				}
			}
		});
		buttonPane.add(IzmenaButton);
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton BrisanjeButton = new JButton("Brisanje izabrane knjige");
		BrisanjeButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		BrisanjeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite knjigu iz tabele za brisanje.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					Knjiga izabranaKnjiga = null;
					int knjigaId = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					for(Knjiga knjiga: sveNeobrisane) {
						if(knjiga.getId() == knjigaId)
							izabranaKnjiga = knjiga;
					}
					String[] opcije = new String[2];
					opcije[0] = "Da";
					opcije[1] = "Ne";
					
					int obrisi = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete knjigu?", "Potvrda", 0, JOptionPane.INFORMATION_MESSAGE, null, opcije, null);
					
					if(obrisi == 0) {
						izabranaKnjiga.setObrisana(true);
						biblioteka.upisiSveKnjige();
						JOptionPane.showMessageDialog(null, "Knjiga uspešno obrisana.");
					}
				}
			}
		});
		buttonPane.add(BrisanjeButton);
	}

}
