import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class ChampComite extends JTextField implements KeyListener {
	
	public ChampComite(){
		Font police = new Font("Arial",Font.BOLD,14);
		this.setFont(police);
		this.setPreferredSize(new Dimension(150,30));
		this.setForeground(Color.BLACK);
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
