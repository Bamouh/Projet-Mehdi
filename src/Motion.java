import java.util.ArrayList;
import java.util.ListIterator;

public class Motion{
	private ArrayList<String> listeMotion;
	private ArrayList<String> listeMotionChoisies;
	private ArrayList<String> listeMotionAcceptees;
	private ArrayList<String> listeMotionNonAcceptees;
	ListIterator<String> it;
	
	public Motion(){
		listeMotion= new ArrayList<String>();
		listeMotionChoisies= new ArrayList<String>();
		listeMotionAcceptees= new ArrayList<String>();
		listeMotionNonAcceptees= new ArrayList<String>();
		it=listeMotion.listIterator();
		//this.addMotionChoisie(" ");this.addMotionChoisie(" ");this.addMotionChoisie(" ");this.addMotionChoisie(" ");this.addMotionChoisie(" ");this.addMotionChoisie(" ");this.addMotionChoisie(" ");this.addMotionChoisie(" ");
	}

	public ArrayList<String> getListeMotion() {
		return this.listeMotion;
	}
	public ArrayList<String> getListeMotionChoisies() {
		return this.listeMotionChoisies;
	}
	public ArrayList<String> getListeMotionAcceptees() {
		return this.listeMotionAcceptees;
	}
	public ArrayList<String> getListeMotionNonAcceptees() {
		return this.listeMotionNonAcceptees;
	}
	public void addMotion(String M) {
		this.getListeMotion().add(M);
	}
	public void removeMotion(String M) {
		this.getListeMotion().remove(M);
	}
	public void addMotionChoisie(String M) {
		this.getListeMotionChoisies().add(M);
	}
	public void removeMotionChoisie(String M) {
		this.getListeMotionChoisies().remove(M);
	}
	public void addMotionAcceptee(String M) {
		this.getListeMotionAcceptees().add(M);
	}
	public void removeMotionAcceptee(String M) {
		while(this.isInMotionAcceptees(M)){
			this.getListeMotionAcceptees().remove(M);
		}
	}
	public void addMotionNonAcceptee(String M) {
		this.getListeMotionNonAcceptees().add(M);
	}
	public void removeMotionNonAcceptee(String M) {
		while(this.isInMotionNonAcceptees(M)){
			this.getListeMotionNonAcceptees().remove(M);
		}
	}
	public String getMotionAt(int i){
		String s = this.getListeMotion().get(i);
		String s1 ="";
		String s2 ="";
		String S="";
		if(s.length()>=24){
			try{
				s1 = "<br>" + s.substring(0,s.length()/2);
				s2 = "<br>" + s.substring(s.length()/2, s.length()-1);
			}catch(StringIndexOutOfBoundsException e){}
			S = s1+s2;
		}
		else{
			S=s;
		}
		return S;
	}
	public String getMotionChoisiesAt(int i){
		String s = this.getListeMotionChoisies().get(i);
		String s1 ="";
		String s2 ="";
		String S="";
		if(s.length()>=24){
			try{
				s1 = "<br>" + s.substring(0,s.length()/2);
				s2 = "<br>" + s.substring(s.length()/2, s.length()-1);
			}catch(StringIndexOutOfBoundsException e){}
			S = s1+s2;
		}
		else{
			S=s;
		}
		return S;
	}
	public String getMotionAccepteesAt(int i){
		String s = this.getListeMotionAcceptees().get(i);
		String s1 ="";
		String s2 ="";
		String S="";
		if(s.length()>=24){
			try{
				s1 = "<br>" + s.substring(0,s.length()/2);
				s2 = "<br>" + s.substring(s.length()/2, s.length()-1);
			}catch(StringIndexOutOfBoundsException e){}
			S = s1+s2;
		}
		else{
			S=s;
		}
		return S;
	}
	public String getMotionNonAccepteesAt(int i){
		String s = this.getListeMotionNonAcceptees().get(i);
		String s1 ="";
		String s2 ="";
		String S="";
		if(s.length()>=24){
			try{
				s1 = "<br>" + s.substring(0,s.length()/2);
				s2 = "<br>" + s.substring(s.length()/2, s.length()-1);
			}catch(StringIndexOutOfBoundsException e){}
			S = s1+s2;
		}
		else{
			S=s;
		}
		return S;
	}
	public boolean isInMotionAcceptees(String M){
		if (this.getListeMotionAcceptees().contains(M)) return true;
		else return false;
	}
	public boolean isInMotionNonAcceptees(String M){
		if (this.getListeMotionNonAcceptees().contains(M)) return true;
		else return false;
	}
	public String getMotionsChoisies(){
		String S="<html>Motions on the Floor :<br>";
		for(int k=0;k<this.getListeMotionChoisies().size();k++){
			if(this.isInMotionAcceptees(this.getMotionChoisiesAt(k))){
				S+="<br>"+"<font color=green>"+") "+(k+1)+" : "+this.getMotionChoisiesAt(k)+"</font>"+"<br>";
			}
			else if (this.isInMotionNonAcceptees(this.getMotionChoisiesAt(k))){
				S+="<br>"+"<font color=red>"+") "+(k+1)+" : "+this.getMotionChoisiesAt(k)+"</font>"+"<br>";
			}
			else if( !(this.isInMotionAcceptees(this.getMotionChoisiesAt(k))) && !(this.isInMotionNonAcceptees(this.getMotionChoisiesAt(k))) ){
				S+="<br>"+"<font color=blue>"+") "+(k+1)+" : "+this.getMotionChoisiesAt(k)+"</font>"+"<br>";
			}
		}
		S+="</html>";
		return S;
	}
	public String getMotionsAcceptees(){
		String S="<html>Motions on the Floor :";
		for(int l=0;l<this.getListeMotionAcceptees().size();l++){
			S+="<br> "+l+" : "+this.getMotionAccepteesAt(l)+"<br>";
		}
		S+="</html>";
		return S;
	}
	public String toString(){
		String S="<html>Motions on the Floor :";
		for(int m=0;m<this.getListeMotion().size();m++){
			S+="<br> "+m+" : "+this.getMotionAt(m)+"<br>";
		}
		S+="</html>";
		return S;
	}
}
