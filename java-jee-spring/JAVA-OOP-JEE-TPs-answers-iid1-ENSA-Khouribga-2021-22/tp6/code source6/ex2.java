package tp6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ex2 {

	public static void main(String[] args) {

// remplissage de treeSet!
		TreeSet<String> couleurs=new TreeSet();
		
		couleurs.add("bleu");
		couleurs.add("vert");
		couleurs.add("rouge");
		couleurs.add("gris");
		couleurs.add("blanc");
		
		HashSet<String> hashset1 = new HashSet<>();
		hashset1.addAll(couleurs);
// suppression de la 1ere liste
		couleurs.clear();
		
// on verifier que couleurs est vide!
		System.out.println("l'etat de couleurs est(si true alors elle est vide):"+couleurs.isEmpty());
		
// on affiche les element de HashSet!
		System.out.println("la nouvelle liste de type HashSet est: "+hashset1);
}
}
