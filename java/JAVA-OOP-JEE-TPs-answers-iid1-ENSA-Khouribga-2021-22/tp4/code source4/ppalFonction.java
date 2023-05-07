package tp4;

public class ppalFonction {

	public static void main(String[] args) {
// instenciation
		Vendeur vend1 = new Vendeur("zaid", "med", 40, "vente en ligne","10/12/2013" , 50029);
		Agent agent1 = new Agent("fathi", "zakaria", 22, "chef de projet","22/03/2016", 4, 244, 40);
		Agent agent2 = new Agent("hamama", "fati", 20, "ingenieur","03/04/2010", 3, 400, 80);
		Agent agent3 = new Agent("Essaid", "Marwa", 20, "technicien","20/04/2018", 2, 340, 30);
// appel
		System.out.println(vend1.getNom()+"\nle salaire : "+vend1.CalSalaire()+"\nil s'agit de : "+vend1.Statut+"\nPrime:"+vend1.CalcPrime(vend1.CalSalaire()));
		System.out.println("------------------------------------");
		System.out.println(agent1.getNom()+"\nle salaire : "+agent1.CalSalaire()+"\nil s'agit de : "+agent1.Statut+"\nPrime:" + agent1.CalcPrime(agent1.CalSalaire()));
		System.out.println("------------------------------------");
		System.out.println(agent2.getNom()+"\nle salaire : "+agent2.CalSalaire()+"\nil s'agit de: "+agent2.Statut+"\nPrime:" + agent2.CalcPrime(agent2.CalSalaire()));
		System.out.println("------------------------------------");
		System.out.println(agent3.getNom()+"\nle salaire : "+agent3.CalSalaire()+"\nil s'agit de : "+agent3.Statut+"\nPrime:" + agent3.CalcPrime(agent3.CalSalaire()));
	}}
