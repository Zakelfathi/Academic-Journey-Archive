package tp7;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) throws negativeException,intException {
		//Q1
		 int n;
		  	do{
		  	System.out.println("entrer : " );
			Scanner sc=new Scanner(System.in);
			n=sc.nextInt();
			}while(n<0);
			System.out.println("la factoriel : "+ factoriel(n) );
		

		//Q2 Q3
		try{	
			int n;
			do {
			System.out.println("entrer : " );
			Scanner sc=new Scanner(System.in);
				n=sc.nextInt();
				if(n<0) throw new negativeException();
				}while(n < 0);
				System.out.println("la factoriel : "+ factoriel(n) );
			}catch(Exception e1) {
				System.out.println("vous avez entre un Non-entier !" );
				e1.printStackTrace() ;
			}
			
	// Q4
			
			
			
			System.out.println("entrer : " );
			Scanner sc=new Scanner(System.in);
				n=sc.nextInt();
				if (n<0) throw new negativeException();	
					System.out.println("la factoriel : "+ factoriel((int)n) );
				
	}
		
		
		
		
	
	
	
	
	
	//1
static public int factoriel(int n) {
	if(n==0 || n==1) return 1;
	return (n)*factoriel(n-1);
}



}
