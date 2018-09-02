import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	public Panneau(){
		super();
		this.setBackground(Color.BLUE);
	}
	public void paintComponent(Graphics g){
		    try {
		      Image img = ImageIO.read(new File("newLogo.jpg"));
		      g.drawImage(img, -150, 0, 950, 400, this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }              
}
