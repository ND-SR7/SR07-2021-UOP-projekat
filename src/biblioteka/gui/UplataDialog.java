package biblioteka.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import biblioteka.model.Biblioteka;
import biblioteka.model.Clan;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class UplataDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblPopust;
	private JSpinner brMeseciClanarine;
	private JLabel lblUkupnaCena;
	private JLabel lblCena;

	public UplataDialog(Biblioteka biblioteka, Clan clan) {
		setSize(540, 360);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new MigLayout("", "[524px]", "[][33px][][][][][][][]"));
		
		JLabel lblClan = new JLabel("Član:");
		lblClan.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblClan, "flowx,cell 0 0,alignx center");
		
		JLabel lblImePrezime = new JLabel(clan.getIme() + " " + clan.getPrezime());
		lblImePrezime.setFont(new Font("Courier New", Font.PLAIN, 12));
		getContentPane().add(lblImePrezime, "cell 0 0");
		
		JLabel lblClanskaKarta = new JLabel("Broj članske karte:");
		lblClanskaKarta.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblClanskaKarta, "flowx,cell 0 1,alignx center");
		
		JLabel lblbrClanskeKarte = new JLabel(clan.getBrClanskeKarte());
		lblbrClanskeKarte.setFont(new Font("Courier New", Font.PLAIN, 12));
		getContentPane().add(lblbrClanskeKarte, "cell 0 1");
		
		JLabel lblClanarina = new JLabel("Tip članarine:");
		lblClanarina.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblClanarina, "flowx,cell 0 2,alignx center");
		
		JLabel lblTipClanarine = new JLabel(clan.getTipClanarine().toString());
		lblTipClanarine.setFont(new Font("Courier New", Font.PLAIN, 12));
		getContentPane().add(lblTipClanarine, "cell 0 2");
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		getContentPane().add(rigidArea, "cell 0 3");
		
		JLabel lblBrojMeseciUplate = new JLabel("Broj meseci uplate:");
		lblBrojMeseciUplate.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblBrojMeseciUplate, "flowx,cell 0 4,alignx center");
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		getContentPane().add(rigidArea_1, "cell 0 5");
		
		JLabel lblOsnovnaCena = new JLabel("Osnovna cena:");
		lblOsnovnaCena.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblOsnovnaCena, "flowx,cell 0 6,alignx right");
		
		JLabel lblVelicinaPopusta = new JLabel("Popust:");
		lblVelicinaPopusta.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblVelicinaPopusta, "flowx,cell 0 7,alignx right");
		
		JLabel lblCenaSaPopustom = new JLabel("Ukupna cena:");
		lblCenaSaPopustom.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblCenaSaPopustom, "flowx,cell 0 8,alignx right");
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, "cell 0 9,growx,aligny top");
			
		JButton naplatiButton = new JButton("Naplati");
		naplatiButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		naplatiButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opcije = new String[2];
				opcije[0] = "Da";
				opcije[1] = "Ne";
						
				int sacuvaj = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da naplatite članarinu?", "Potvrda", 0, JOptionPane.INFORMATION_MESSAGE, null, opcije, null);
						
				if(sacuvaj == 0) {
					JOptionPane.showMessageDialog(null, "Članarina je uspešno naplaćena.", "Izvršeno", JOptionPane.INFORMATION_MESSAGE);
					int temp = clan.getBrMeseciClanarine();
					temp += (int) brMeseciClanarine.getValue();
					clan.setBrMeseciClanarine(temp);
					clan.setAktivan(true);
					biblioteka.upisiSveClanove();
					dispose();
				}
			}
		});
		buttonPane.add(naplatiButton);
		getRootPane().setDefaultButton(naplatiButton);
			
		JButton odustaniButton = new JButton("Odustani");
		odustaniButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		odustaniButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		buttonPane.add(odustaniButton);
		
		brMeseciClanarine = new JSpinner();
		brMeseciClanarine.setModel(new SpinnerNumberModel(1, 1, null,1));
		brMeseciClanarine.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				izracunajPopustUkupnuCenu();
			}
		});
		getContentPane().add(brMeseciClanarine, "cell 0 4");
		
		lblCena = new JLabel();
		lblCena.setFont(new Font("Courier New", Font.PLAIN, 12));
		int tipClanarine = clan.getTipClanarine().ordinal();
		switch(tipClanarine) {
		case 0:
			lblCena.setText("100");
			break;
		case 1:
			lblCena.setText("150");
			break;
		case 2:
			lblCena.setText("250");
		}
		getContentPane().add(lblCena, "cell 0 6");
		
		lblPopust = new JLabel();
		lblPopust.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblPopust, "cell 0 7");
		
		lblUkupnaCena = new JLabel();
		lblUkupnaCena.setFont(new Font("Courier New", Font.BOLD, 14));
		getContentPane().add(lblUkupnaCena, "cell 0 8");
	}
	
	public void izracunajPopustUkupnuCenu() {
		int brojMeseci = (int) brMeseciClanarine.getValue();
		double popust = 1;
		int popustInt = 0;
		if(brojMeseci >= 12) {
			popustInt = 2;
			popust = 0.8;
		} else if(brojMeseci >= 6) {
			popustInt = 1;
			popust = 0.9;
		}
		
		switch(popustInt) {
		case 1:
			lblPopust.setText("10%");
			break;
		case 2:
			lblPopust.setText("20%");
			break;
		default:
			lblPopust.setText(" 0%");
		}
		
		double ukupnaCena = brojMeseci * Integer.parseInt(lblCena.getText()) * popust;
		lblUkupnaCena.setText(Double.toString(ukupnaCena));
	}

}
