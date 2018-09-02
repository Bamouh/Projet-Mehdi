import java.util.ArrayList;
import java.util.ListIterator;

public class Speakers{
	private ArrayList<String> Pays;
	ListIterator<String> it;
	public Speakers(){
		Pays = new ArrayList<String>();
		it = Pays.listIterator();
		this.addPays(".");this.addPays(".");this.addPays(".");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");this.addPays(" ");
	}
	public ArrayList<String> getPays(){
		return this.Pays;
	}
	public void addPays(String P){
		Pays.add(P);
	}
	public void removePays(String P){
		Pays.remove(P);
	}
	//the United Kingdom of Great Britain and Northern Ireland
	public String getPaysAt(int i){
		String s = this.getPays().get(i);
		String s1 = "";
		String s2 = "";
		String S = "";
		if(s.length()>25){
			try{
				s1 = s.substring(0,s.length()/2);
				s2 = "<br>" + s.substring(s.length()/2, s.length()-1);
			}catch(StringIndexOutOfBoundsException e){}
			S = s1+s2;
		}
		else{
			S= s+"<br>"+s2;
		}
		return S;
	}
	public String toString(){
		String S="<html>Speakers List : <br>";
		this.Pays.remove(0);
		for(int i=0;i<13;i++){
			S+="<br>" + this.getPaysAt(i);
		}
		S+="</html>";
		return S;
	}
}
