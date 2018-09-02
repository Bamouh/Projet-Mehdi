import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Curseur extends JPanel {
	private int posX=40;
	private int posY=38;
	
	public Curseur(){
		this.setPosX(40);
		this.setPosY(38+32*13);
	}
	
	public void paintComponent(Graphics g){
		Image img=null;
		try {
			img = ImageIO.read(new File("newFleche.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(img, this.getPosX(), this.getPosY(), 20, 20, this);
	}
	public int getPosX() {
		return this.posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return this.posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public void move(){
		int y=this.getPosY();
		for(int i=0;i<32;i++){
			y++;
			this.setPosY(y);
			this.repaint();
		}
	}
	public void moveMeta(){
		int y=this.getPosY();
		this.setPosY(y-32);
		this.repaint();
	}
	public void reinitialiseCursor(){
		this.setPosY(38);
		this.repaint();
	}
}
