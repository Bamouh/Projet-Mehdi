
public class ExceptionComite extends Exception {
	public ExceptionComite(){
		System.out.println("Erreur de comit�.");
	}
	public ExceptionComite(String s){
		System.out.println("Erreur de comit�, vous avez tap� "+s);
	}
}
