import java.util.TimerTask;

import javax.swing.JLabel;

public class Chronometre extends TimerTask{
	private static long seconde=0;
	private static String time=" 00 : 00 : 00 ";
	public static JLabel lab = new JLabel();
	static String s;
	@Override
	public void run() {
		this.setSeconde(this.getSeconde() + 1);
		this.setTime();
		lab.setText("<html>"+"<center>"+s+"</center>"+" <br> "+"<center>"+this.getTime()+"</center>"+"</html>");
	}
	public void stop(){
		this.cancel();
	}
	public long getSeconde() {
		return seconde;
	}
	public void setSeconde(long seconde) {
		Chronometre.seconde = seconde;
	}
	public String getTime() {
		return time;
	}
	public void setTime() {
		String T;
		T=this.stohms(this.getSeconde());
		this.time=T;
	}
	public String stohms(long sec){
		long h = (int) (sec / 3600);
        long m = (int) ((sec % 3600) / 60);
        long s = (int) (sec % 60);

        String r="";

        if(h>=0) {r+=h+" : ";}
        if(m>=0) {r+=m+" : ";}
        if(s>=0) {r+=s;}
        if(h<0 && m<0 && s<0) {r="00 : 00 : 00 ";}

        return r;
	}
}