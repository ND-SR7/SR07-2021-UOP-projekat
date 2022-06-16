package biblioteka.gui.showEdit;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import biblioteka.model.Biblioteka;
import biblioteka.model.Clan;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrikazClanaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PrikazClanaFrame(Biblioteka biblioteka, ArrayList<Clan> sviClanovi) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/i.png"));
		ArrayList<Clan> sviNeobrisani = new ArrayList<Clan>();
		for(Clan clan: sviClanovi) {
			if(clan.isObrisan())
				continue;
			else
				sviNeobrisani.add(clan);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Courier New", Font.PLAIN, 12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] imeKolona = new String[] {"ID", "Broj članske karte", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Datum poslednje uplate", "Broj meseci članarine", "Aktivan", "Tip članarine"};
		Object[][] info = new Object[sviNeobrisani.size()][imeKolona.length];
		
		for(int i=0; i<sviNeobrisani.size(); i++) {
			Clan clan = sviNeobrisani.get(i);
			info[i][0] = clan.getId();
			info[i][1] = clan.getBrClanskeKarte();
			info[i][2] = clan.getIme();
			info[i][3] = clan.getPrezime();
			info[i][4] = clan.getJMBG();
			info[i][5] = clan.getAdresa();
			info[i][6] = clan.getPol();
			info[i][7] = clan.getDatumPoslednjeUplate();
			info[i][8] = clan.getBrMeseciClanarine();
			if(clan.isAktivan())
				info[i][9] = "Aktivan";
			else
				info[i][9] = "Neaktivan";
			info[i][10] = clan.getTipClanarine();
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
		
		JButton IzmenaButton = new JButton("Izmena izabranog člana");
		IzmenaButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		IzmenaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite člana iz tabele za izmenu.", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					Clan izabraniClan = null;
					int clanId = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					for(Clan clan: sviNeobrisani) {
						if(clan.getId() == clanId)
							izabraniClan = clan;
					}
					IzmenaClanaFrame izmena = new IzmenaClanaFrame(biblioteka, izabraniClan);
					izmena.setVisible(true);
				}
			}
		});
		contentPane.add(IzmenaButton, BorderLayout.SOUTH);
		
	}

}
