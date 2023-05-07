package tp7;

public class intException  extends Exception{
	
	public intException(int n) {
		if (n<0) System.out.println("--------nombre inferieur a 0--------");
	}
	
}
