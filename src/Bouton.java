import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener{
	private String name;
	public Bouton(String name){
		super(name);
		this.name=name;
		this.addMouseListener(this);
	}
	public Bouton(ImageIcon img){
		//super(img);
		this.setIcon(img);
		this.setPreferredSize(new Dimension(100,40));
		this.setBackground(Color.WHITE);
		this.setBorderPainted(false);
		this.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
