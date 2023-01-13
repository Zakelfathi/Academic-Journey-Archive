package tp6;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ex1 {

	public static void main(String[] args) {
		//instanciation de l'objet Couleur de type TreeSet()
		TreeSet couleurs=new TreeSet();
		//Ajout des element couleur dans la liste
		couleurs.add("bleu");
		couleurs.add("vert");
		couleurs.add("rouge");
		couleurs.add("gris");
		couleurs.add("blanc");
		//parcours des elements en utilisant l'iterator
		   System.out.println("le contenu de la liste en utilisant l'iterator:");
		Iterator<String> it = couleurs.iterator();
		
		while (it.hasNext()) {
		   System.out.print(it.next()+",");
		}
	}

}
