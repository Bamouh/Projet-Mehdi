
public class ExceptionComite extends Exception {
	public ExceptionComite(){
		System.out.println("Erreur de comité.");
	}
	public ExceptionComite(String s){
		System.out.println("Erreur de comité, vous avez tapé "+s);
	}
}
