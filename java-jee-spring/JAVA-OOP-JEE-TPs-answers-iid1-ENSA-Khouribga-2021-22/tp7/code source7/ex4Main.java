package tp7;

import java.util.Scanner;

public class ex4Main {

	static public void fLogin() {
		
		Scanner sc=new Scanner(System.in);
		
		String user, pwd;
		// entree du login
					System.out.println("---------\nlogin: ");
					user=sc.next();
					System.out.println("---------\npwd: ");
					pwd=sc.next();
		while(!user.equals("scott") && !pwd.equals("tiger")) {
	
			System.out.println("**********************\nlogin incorrect! \n\n\n entrer a nouveau!:\n");
			
			// entree du login
			System.out.println("---------\nlogin: ");
			user=sc.next();
			System.out.println("---------\npwd: ");
			pwd=sc.next();
		
		};
		System.out.println("---connection reussie---");
		
	}
	
	
static public void fLoginAvecException() throws LoginException, pwdException,InputLength {
		
		Scanner sc=new Scanner(System.in);
		
		String user, pwd;
		
		do  {			
			// entree du login
			System.out.println("---------\nlogin: ");
				user=sc.next();
					if (!user.equals("scott")) { 
						throw new LoginException();
						
						}
					
			System.out.println("---------\npwd: ");
				pwd=sc.next();
					if (!pwd.equals("tiger")) {
						throw new pwdException();	
						}	
			if(user.length()>10 || pwd.length()>10)	{
						throw new InputLength();
										
			}
			if(!user.equals("scott") && !pwd.equals("tiger"))
				System.out.println("---------entrer a nouveau!---------");
		}while(!user.equals("scott") && !pwd.equals("tiger"));
		System.out.println("---connection reussie---");	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			fLoginAvecException();
		} catch (LoginException |pwdException|InputLength e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
	}

}
