import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Fenetre2 extends JFrame implements ActionListener{
	
	private static int i=0;
	private static int j=0;
	private static int k=13;
	private static int l=0;
	private static int c=0;
	private static int b=0;
	private static String paysupp=""; 
	private JPanel titre = new JPanel();
	
	private JPanel speakers= new JPanel();
	private JLabel labsp = new JLabel();
	private JTextField jtf = new JTextField();
	ImageIcon icon = new ImageIcon("confirm.png");
	private Bouton conf = new Bouton(icon);
	private Curseur cur = new Curseur();
	
	private JPanel chrono= new JPanel();
	private JButton play = new JButton(new ImageIcon("newPlay.PNG"));
	private JButton stop = new JButton(new ImageIcon("newStop.PNG"));
	private JButton replay = new JButton(new ImageIcon("newReset.PNG"));
	Chronometre chr = new Chronometre();
	
	
	private JPanel motions= new JPanel();
	private Bouton labmo = new Bouton(icon);
	private JTextField listeDerMo = new JTextField();
	private JLabel motionsOnTheFloor = new JLabel();
	private confMotion cm = new confMotion();
	
	
	private UNImage symbol= new UNImage();
	private JLabel lab=new JLabel();
	private Comite C;
	
	public Fenetre2(String name){
		try {
			C = new Comite(name);
		} catch (ExceptionComite e) {
			e.printStackTrace();
		}
		this.setSize(1350, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(name);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		titre.setBackground(Color.WHITE);
		chrono.setBackground(Color.WHITE);
		motions.setBackground(Color.WHITE);
		symbol.setBackground(Color.WHITE);
		speakers.setBackground(Color.WHITE);
		
		
		Font police = new Font("Arial",Font.BOLD,20);
		lab.setFont(police);
		lab.setText(name);
		titre.add(lab);
		
		speakers.setLayout(new BorderLayout());
		labsp.setText(C.getListeSpeakers().toString());
		labsp.setHorizontalAlignment(JLabel.CENTER);
		speakers.add(labsp,BorderLayout.WEST);
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		
		speakers.add(p, BorderLayout.CENTER);
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150,30));
		jtf.setForeground(Color.BLACK);
		JPanel confetjtf=new JPanel();
		confetjtf.setBackground(Color.WHITE);
		confetjtf.add(jtf);
		confetjtf.add(conf);
		speakers.add(confetjtf,BorderLayout.SOUTH);
		p.add(cur);
		
		play.setPreferredSize(new Dimension(74,74));
		play.setBorderPainted(false);
		stop.setPreferredSize(new Dimension(74,74));
		stop.setBorderPainted(false);
		replay.setPreferredSize(new Dimension(74,74));
		replay.setBorderPainted(false);
		chrono.add(play);
		chrono.add(stop);
		chrono.add(replay);
		JPanel chretlab= new JPanel();
		chretlab.setBackground(Color.WHITE);
		chrono.setLayout(new BorderLayout());
		chretlab.add(play);
		chretlab.add(stop);
		chretlab.add(replay);
		chrono.add(chretlab,BorderLayout.SOUTH);
		chr.lab.setFont(police);
		chr.lab.setText("<html>"+"<center>"+C.getListeSpeakers().getPaysAt(l).replaceAll("<br>", "")+"</center>"+" <br> "+"00 : 00 : 00"+"</html>");
		chr.lab.setHorizontalAlignment(JLabel.CENTER);
		chrono.add(chr.lab,BorderLayout.NORTH);
		play.addActionListener(this);
		stop.addActionListener(this);
		replay.addActionListener(this);
		conf.addActionListener(this);
		
		motions.setLayout(new BorderLayout());
		listeDerMo.setBackground(Color.WHITE);
		listeDerMo.setFont(police);
		listeDerMo.setPreferredSize(new Dimension(150,30));
		listeDerMo.setForeground(Color.BLACK);
		JPanel ListeDeroulante = new JPanel();
		labmo.addActionListener(this);
		ListeDeroulante.setBackground(Color.WHITE);
		ListeDeroulante.add(listeDerMo);
		ListeDeroulante.add(labmo);
		cm.indiff.addActionListener(this);
		cm.ok.addActionListener(this);
		cm.non.addActionListener(this);
		
		//motionsOnTheFloor.setHorizontalAlignment(JLabel.VERTICAL);
		motions.add(ListeDeroulante,BorderLayout.SOUTH);
		motions.add(motionsOnTheFloor,BorderLayout.CENTER);
		motions.add(cm, BorderLayout.NORTH);
		
		this.getContentPane().add(titre, BorderLayout.NORTH);
		this.getContentPane().add(speakers, BorderLayout.WEST);
		this.getContentPane().add(chrono, BorderLayout.SOUTH);
		this.getContentPane().add(motions, BorderLayout.EAST);
		this.getContentPane().add(symbol, BorderLayout.CENTER);
		titre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		speakers.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		chrono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		motions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	/*class ItemAction implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println(listeDerMo.getSelectedItem());
			C.getListeMotions().addMotionChoisie(listeDerMo.getSelectedItem().toString());
			//System.out.println(C.getListeMotions().getMotionsChoisies());
			motionsOnTheFloor.setText(C.getListeMotions().getMotionsChoisies());
		}
		}*/
	private Timer timer;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==labmo){
			C.getListeMotions().addMotionChoisie(listeDerMo.getText());
			motionsOnTheFloor.setText(C.getListeMotions().getMotionsChoisies());
			if(c<9){
				c++;
			}
			else{
				C.getListeMotions().getListeMotionChoisies().clear();
				C.getListeMotions().getListeMotion().clear();
				C.getListeMotions().getListeMotionAcceptees().clear();
				C.getListeMotions().getListeMotionNonAcceptees().clear();
				c=0;
				motionsOnTheFloor.setText(C.getListeMotions().getMotionsChoisies());
			}
			j=0;
			this.cm.lab.setText("<html><center>Motion "+(j+1)+"</center></html>");
			/*
			if(c>7){
					C.getListeMotions().getListeMotionChoisies().remove(0);
				try {
					C.getListeMotions().getListeMotionAcceptees().remove(0);
					C.getListeMotions().getListeMotionNonAcceptees().remove(0);
					C.getListeMotions().getListeMotion().remove(0);
				} catch (Exception e) {}
			}
			else{
				c++;
			}
			*/
		}
		if(arg0.getSource()==play){
			Chronometre chr2 = new Chronometre();
			timer = new Timer();
			chr2.setSeconde(chr2.getSeconde());
			chr.s=C.getListeSpeakers().getPaysAt((cur.getPosY()-38)/32).replaceAll("<br>","");
			timer.scheduleAtFixedRate(chr2, 1000, 1000);
		}
		if(arg0.getSource()==stop){
			Chronometre chr3 = new Chronometre();
			chr.lab.setText("<html>"+"<center>"+C.getListeSpeakers().getPaysAt((cur.getPosY()-38)/32).replaceAll("<br>","")+"</center>"+" <br> "+"<center>"+chr3.stohms(chr3.getSeconde())+"</center>"+"</html>");
			timer.cancel();
		}
		if(arg0.getSource()==replay){
			Chronometre chr4 = new Chronometre();
			chr4.setSeconde(0);
			timer.cancel();
			if (cur.getPosY()<=38+31*12) {cur.move();chr.lab.setText("<html>"+"<center>"+C.getListeSpeakers().getPaysAt((cur.getPosY()-38)/32).replaceAll("<br>","")+"</center>"+" <br> "+"<center> 00 : 00 : 00</center></html>");l++;}
			else {cur.reinitialiseCursor(); l=0; chr.lab.setText("<html>"+"<center>"+C.getListeSpeakers().getPaysAt((cur.getPosY()-38)/32).replaceAll("<br>", "")+"</center>"+" <br> "+"<center> 00 : 00 : 00</center></html>");}
		}
		if(arg0.getSource()==conf){
			C.getListeSpeakers().addPays(jtf.getText());
			i++;
			if(cur.getPosY()>=38+32*1){
				cur.moveMeta();
			}
			paysupp=C.getListeSpeakers().getPaysAt(0);
			if(i==1) {C.getListeSpeakers().removePays(paysupp);i=0;}
			labsp.setText(C.getListeSpeakers().toString());
		}
		if(arg0.getSource()==cm.ok){
			if(j<C.getListeMotions().getListeMotionChoisies().size()){
				C.getListeMotions().addMotionAcceptee(C.getListeMotions().getMotionChoisiesAt(j));
				C.getListeMotions().removeMotionNonAcceptee(C.getListeMotions().getMotionChoisiesAt(j));
				motionsOnTheFloor.setText(C.getListeMotions().getMotionsChoisies());
				j++;
			}
			else j=0;
			if(j==C.getListeMotions().getListeMotionChoisies().size()) j=0;
			this.cm.lab.setText("<html><center>Motion "+(j+1)+"</center></html>");
		}
		if(arg0.getSource()==cm.indiff){
			if(j<C.getListeMotions().getListeMotionChoisies().size()){
				j++;
			}
			else j=0;
			if(j==C.getListeMotions().getListeMotionChoisies().size()) j=0;
			this.cm.lab.setText("<html><center>Motion "+(j+1)+"</center></html>");
		}
		if(arg0.getSource()==cm.non){
			if(j<C.getListeMotions().getListeMotionChoisies().size()){
				C.getListeMotions().addMotionNonAcceptee(C.getListeMotions().getMotionChoisiesAt(j));
				C.getListeMotions().removeMotionAcceptee(C.getListeMotions().getMotionChoisiesAt(j));
				motionsOnTheFloor.setText(C.getListeMotions().getMotionsChoisies());
				j++;
			}
			else j=0;
			if(j==C.getListeMotions().getListeMotionChoisies().size()) j=0;
			this.cm.lab.setText("<html><center>Motion "+(j+1)+"</center></html>");
		}
		}
	
}
