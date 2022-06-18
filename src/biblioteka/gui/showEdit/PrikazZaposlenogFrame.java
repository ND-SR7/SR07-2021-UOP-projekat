package biblioteka.gui.showEdit;

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

import biblioteka.model.Biblioteka;
import biblioteka.model.Zaposleni;

public class PrikazZaposlenogFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public PrikazZaposlenogFrame(Biblioteka biblioteka, ArrayList<Zaposleni> sviZaposleni) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/i.png"));
		ArrayList<Zaposleni> sviNeobrisani = new ArrayList<Zaposleni>();
		for(Zaposleni zaposleni: sviZaposleni) {
			if(zaposleni.isObrisan())
				continue;
			else
				sviNeobrisani.add(zaposleni);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] imeKolona = new String[] {"ID", "Korisničko ime", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Plata", "Uloga"};
		Object[][] info = new Object[sviNeobrisani.size()][imeKolona.length];
		
		for(int i=0; i<sviNeobrisani.size(); i++) {
			Zaposleni zaposleni = sviNeobrisani.get(i);
			info[i][0] = zaposleni.getId();
			info[i][1] = zaposleni.getKorisnickoIme();
			info[i][2] = zaposleni.getIme();
			info[i][3] = zaposleni.getPrezime();
			info[i][4] = zaposleni.getJMBG();
			info[i][5] = zaposleni.getAdresa();
			info[i][6] = zaposleni.getPol();
			info[i][7] = zaposleni.getPlata();
			if(zaposleni.getUloga() == "A")
				info[i][8] = "Administrator";
			else
				info[i][8] = "Bibliotekar";
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
		
		JButton IzmenaButton = new JButton("Izmena izabranog zaposlenog");
		IzmenaButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		IzmenaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite zaposlenog iz tabele za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					Zaposleni izabraniZaposleni = null;
					int zaposleniId = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					for(Zaposleni zaposleni: sviNeobrisani) {
						if(zaposleni.getId() == zaposleniId)
							izabraniZaposleni = zaposleni;
					}
					IzmenaZaposlenogFrame izmena = new IzmenaZaposlenogFrame(biblioteka, izabraniZaposleni);
					izmena.setVisible(true);
				}
			}
		});
		contentPane.add(IzmenaButton, BorderLayout.SOUTH);
	}

}
