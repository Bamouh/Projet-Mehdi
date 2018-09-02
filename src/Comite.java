import java.util.ArrayList;

public class Comite {
	private String nomComite;
	private Speakers listeSpeakers;
	private Motion listeMotions;
	public Comite() throws ExceptionComite{
		this.setnomComite("Inconnu");
	}
	public Comite(String nc) throws ExceptionComite{
		this.setnomComite(nc);
		listeSpeakers = new Speakers();
		listeMotions = new Motion();
	}
	public String getnomComite(){
		return this.nomComite;
	}
	public void setnomComite(String nc) throws ExceptionComite{
		boolean b=true;
		for (ComitePossibles com : ComitePossibles.values()){
			if (nc.equals(com.toString())){
			this.nomComite=nc;
			b=true;
			break;
			}
			else b=false;
		}
		if (b==false) throw new ExceptionComite(nc);
	}
	public void setlisteSpeakers(Speakers sp){
		this.listeSpeakers=sp;
	}
	public Speakers getListeSpeakers(){
		return this.listeSpeakers;
	}
	public void setlisteMotions(Motion mo){
		this.listeMotions=mo;
	}
	public Motion getListeMotions(){
		return this.listeMotions;
	}
	public String toString(){
		return "Le nom du comité est: "+this.getnomComite();
	}
}
