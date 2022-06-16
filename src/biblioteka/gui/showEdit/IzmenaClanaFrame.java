package biblioteka.gui.showEdit;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.model.Biblioteka;
import biblioteka.model.Clan;
import java.awt.Toolkit;

public class IzmenaClanaFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public IzmenaClanaFrame(Biblioteka biblioteka, Clan clan) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/e.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
