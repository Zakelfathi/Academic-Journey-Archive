package tp5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class PersonneService implements IPerson  {
	public ArrayList<Personne> personne =new ArrayList<Personne>();
	static Scanner sc=new Scanner(System.in);

	
	
	public void save(Personne P) {
		personne.add(P); 	
	}




	@Override
	public void delete(int Code) {
			for(int i=0;i< personne.size();i++) {
				if ((personne.get(i)).code==Code) personne.remove(i);
			}
					
	}




	@Override
	public void update(Personne P) {
		
		System.out.println("code: ");
			P.setCode(sc.nextInt());
		System.out.println("Nom:");	
			P.setNom(sc.next());
		System.out.println("Prenom: ");
			P.setPrenom(sc.next());
	}




	@Override
	public Personne findById(int Code) {
		for(int i=0;i<personne.size();i++) {
			if ((personne.get(i)).code==Code)	return personne.get(i);
		}
		return null;
	}




	@Override
	public String toString() {
		return "PersonneService [personne=" + personne + "]";
	}




	@Override
	public List<Personne> findAll() {
		
		return personne;
	}
	
	
	
}
