package tp7;

import java.util.Scanner;

// Q1
public class Ex3 {
	static public int fct(int n) throws infA1, tailleDepassee {
		System.out.println("--------entree un nombre-------");
		int a = 0;
		Scanner scan=new Scanner(System.in);
		
			a = Integer.parseInt(scan.nextLine());
			if (a<=1) throw new infA1();
			else if(a > n) throw new tailleDepassee();
		return a;
		
	}
	
	
	
	static public void tabInitialise(int n) throws nullTableau,infA1, tailleDepassee{
			
		int [] t= new int[fct(n)];
		System.out.println("-------\ntableau cree!\n---------");
		if(t==null) throw new nullTableau();
		
	
			
			
			
			
			
		
	}
	public static void main(String[] args) {

		
			
				try {
					System.out.println("------ L'ENTREE EST :"+fct(20)+"-------");
				} catch (infA1 | tailleDepassee e) {
					//e.printStackTrace();
				}
		
				
				// tableau
				try {
					tabInitialise(17);
				} catch (nullTableau |infA1| tailleDepassee e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
	}
	
	
	
	
	
	
	}

	


