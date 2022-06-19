package biblioteka.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import biblioteka.model.Biblioteka;
import biblioteka.model.Zaposleni;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldKorisnickoIme;
	private JLabel lblLozinka;
	private JPasswordField passwordFieldLozinka;
	private JButton buttonLogin;

	
	public LoginFrame(Biblioteka biblioteka) {
		setTitle("Prijava");
		setName("LoginFrame");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/bi.png"));
		setFont(new Font("Courier New", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Courier New", Font.BOLD, 11));
		contentPane.setBorder(new TitledBorder(null, "Prijava na sistem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setName("LoginPane");
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow][][][]", "[][][][][][]"));
		
		JLabel lblKorisnickoIme = new JLabel("Korisničko ime:");
		lblKorisnickoIme.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblKorisnickoIme, "cell 3 2,alignx right,aligny center");
		
		textFieldKorisnickoIme = new JTextField();
		textFieldKorisnickoIme.setName("txtFKorisnickoIme");
		textFieldKorisnickoIme.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textFieldKorisnickoIme.setForeground(Color.WHITE);
		textFieldKorisnickoIme.setCaretColor(Color.WHITE);
		textFieldKorisnickoIme.setBackground(Color.BLACK);
		textFieldKorisnickoIme.setFont(new Font("Courier New", Font.PLAIN, 14));
		contentPane.add(textFieldKorisnickoIme, "cell 5 2,alignx left");
		textFieldKorisnickoIme.setColumns(15);
		
		lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Courier New", Font.BOLD, 14));
		contentPane.add(lblLozinka, "cell 3 3,alignx right,aligny center");
		
		passwordFieldLozinka = new JPasswordField();
		passwordFieldLozinka.setFont(new Font("Courier New", Font.PLAIN, 14));
		passwordFieldLozinka.setForeground(Color.WHITE);
		passwordFieldLozinka.setColumns(15);
		passwordFieldLozinka.setCaretColor(Color.WHITE);
		passwordFieldLozinka.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		passwordFieldLozinka.setBackground(Color.BLACK);
		contentPane.add(passwordFieldLozinka, "cell 5 3,alignx left");
		
		buttonLogin = new JButton("PRIJAVA");
		buttonLogin.setForeground(Color.BLACK);
		buttonLogin.setFont(new Font("Courier New", Font.BOLD, 14));
		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Zaposleni zaposleni = biblioteka.proveriLogin(textFieldKorisnickoIme.getText(), new String(passwordFieldLozinka.getPassword()));
				if(zaposleni != null) {
					JOptionPane.showMessageDialog(null, "Uspešno ste se prijavili na sistem.", "Uspešna prijava", JOptionPane.INFORMATION_MESSAGE);
					MainFrame main = new MainFrame(biblioteka, zaposleni);
					dispose();
					main.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Prijava na sistem nije uspela.", "Greška", JOptionPane.WARNING_MESSAGE);
			}
		});
		contentPane.add(buttonLogin, "cell 5 5,alignx left,aligny bottom");
		getRootPane().setDefaultButton(buttonLogin);
	}

}
