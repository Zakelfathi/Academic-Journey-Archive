package tp7;

public class mainEx1 {

	public static void main(String[] args) {
		
		ENTIER n1= new ENTIER(6);
		ENTIER n2= new ENTIER(10);
		ENTIER d= new ENTIER(1);
		System.out.println("la division de "+n1.A +" par "+d.A+" est : "+(n1.division(d)));
		System.out.println("la division de "+n2.A +" par "+d.A+" est : "+(n2.division(d)));
		d= new ENTIER(0);
		System.out.println("la division de "+n2.A +" par "+d.A+" est : "+(n2.division(d)));

	}

}
