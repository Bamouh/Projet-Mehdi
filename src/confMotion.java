import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class confMotion extends JPanel {
	JLabel lab;
	Bouton ok;
	Bouton indiff;
	Bouton non;
	public confMotion(){
		this.setBackground(Color.WHITE);
		lab = new JLabel("<html><center>Motion 1</center></html>");
		ok = new Bouton(new ImageIcon("pass.png"));
		indiff = new Bouton(new ImageIcon("ignore3.png"));
		non = new Bouton(new ImageIcon("reject.png"));
		this.setLayout(new BorderLayout());
		this.add(lab,BorderLayout.NORTH);
		this.add(ok,BorderLayout.WEST);
		this.add(indiff,BorderLayout.CENTER);
		this.add(non,BorderLayout.EAST);
		}
}
