package tp8;

class Compte{
	private float solde;
	public Compte() {
		super();
		this.solde=100;
	}
	
	public Compte(float solde) {
		super();
		this.solde=solde;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	public void retirer(float montant) {
			this.solde-=montant;
	}
}
	class Person implements Runnable{
		Compte comp;
		String proprietaire;
		public Person(Compte compte,String proprietaire ) {
			super();
			this.comp=compte;
			this.proprietaire=proprietaire;
		}
		
		public void Retrait(float montant) {
			if(montant <= comp.getSolde()) {
			System.out.println("------Solde suffisant!(wait 2 seconds please!)------");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			comp.retirer(montant);
			System.out.println("------retrait effectue avec succes par: "+ proprietaire +"------");

			}

			else System.out.println(" ------Solde insuffisant pour cette operation !-------");
		}
		
		@Override
		public void run() {
			System.out.println("***********operation commencee!**********");
		for(int i=0;i<10;i++) {
					this.Retrait(200);	
					System.out.println("total de retrait a cet instant:"+(200*(i+1))+"Dh!");
			}
		System.out.println("\n\n-----------votre solde maintenant est de :"+comp.getSolde()+"\n\n");

		}
		
	}
	
	
	class SoldeCompte{
		float solde;
		public SoldeCompte(float solde) {
			super();
			this.solde=solde;
		}
		
		
		public synchronized void RetirerArgent(float montant) {
			System.out.println("------Verification de solde!-----");
			if(montant>this.solde ) {
				System.out.println("Loading..\n------montant non disponible!------");
				try {
					//on attend 
					wait(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("\n\n***retrait  en cours de "+montant+"***");
			this.solde-=montant;

		//	this.solde-=montant;
			System.out.println("\n----- solde actuel: \t"+solde);
		notifyAll();
		
		}
		
		public synchronized void DeposerArgent(float montant) {
			
			System.out.println("\n***depot en cours de "+montant+"***");
			this.solde+=montant;
			System.out.println("\n\n ----solde actuel: \t"+solde);
		//notify();	
		}
	}//closing class
	
	class depotRetraitClass implements Runnable  {
		SoldeCompte solde;
		public depotRetraitClass(SoldeCompte sold) {
			solde=sold;
		}
		
		
		
		@Override
		public void run() {
		   
			  
				float n=1000;
			    float m=1500;
			    
			    solde.RetirerArgent(m);
				solde.DeposerArgent(n);
				
			
		}
		} 
		
	

public class ex2 {

	public static void main(String[] args) {
	
		
		//on cree deux compte pour les attribuer a Amal et Ahmed
		Compte compte1 =new Compte(20000);
		Compte compte2 =new Compte(52300);
		
		// on instancie deux personnes Ahmed et AMAL avec les deux comptes
		Person Ahmed =new Person(compte1,"Ahmed");
		Person Amal =new Person(compte2,"Amal");

		//lancement
	    Thread Ahmed1=new Thread(Ahmed);
	    Thread Amal1= new Thread(Amal);
		Ahmed1.start();
		try {
			Ahmed1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Amal1.start();
	
		/*
	SoldeCompte s=new SoldeCompte(1000);
	depotRetraitClass dr= new 	depotRetraitClass(s);
	Thread DR =new Thread(dr);
	
	System.out.println("-------------------------Debut!----------------");
	DR.start();
	try {
		DR.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("-------------------------fin!----------------");
	*/	
}

}
