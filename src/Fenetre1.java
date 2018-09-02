import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre1 extends JFrame implements ActionListener{
	Panneau pan= new Panneau();
	JPanel container= new JPanel();
	JLabel label=new JLabel("Welcome. Enter comitee's name :");
	private ChampComite jtf= new ChampComite();
	private Bouton bouton;
	
	public Fenetre1(){
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("United ESCP Europe");
		this.setResizable(false);
		
		this.setLayout(new BorderLayout());
		ImageIcon i = new ImageIcon("confirm.png");
		bouton=new Bouton(i);
		
		container.setBackground(Color.WHITE);
		
		container.add(label);
		container.add(jtf);
		container.add(bouton);
		
		
		this.getContentPane().add(container,BorderLayout.SOUTH);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		
		this.setVisible(true);
		jtf.addActionListener(this);
		bouton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==bouton){
			Comite C;
			Fenetre2 fen;
			try{
				C = new Comite(jtf.getText().toUpperCase());
				fen =new Fenetre2(jtf.getText().toUpperCase());
			}catch(ExceptionComite e) {JOptionPane jop = new JOptionPane();jop.showMessageDialog(null,"Comité inexistant","Erreur",JOptionPane.ERROR_MESSAGE); }
		}
	}
			
	
	
}
