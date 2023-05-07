package tp9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class ex2 {
	String source, destination;
	// constructeur avec parametres
	public ex2(final String source,final String destination) {
		this.source=source;
		this.destination=destination;
		
	}

	
	
	//caractere par caractere
	static public void caractereParCaractere(String file) throws FileNotFoundException {
		
		int o;
		
		FileInputStream input =new FileInputStream("C:/Users/EliteBooK/Desktop/tp9 java worksheet/"+file);
		FileOutputStream out= new FileOutputStream("C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/"+file);
		try {
		while((o=input.read())!=-1) {
				out.write(o);
			}
	
		//fermeture des deux fichiers
			input.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
			
			
	}
		//appel de la fonction d'affichage et compteur
		AffichageContenu(file);
	}
	
	
	//ligne par ligne!
	static public void lignEParLigne(String file) {
		// inititialisation dee objets
			BufferedReader br = null;
	        PrintWriter pw = null;

	      try {
	    	  // ouverture de deux fichier; un en ecriture et l'autre en lecture
					br = new BufferedReader(new FileReader("C:/Users/EliteBooK/Desktop/tp9 java worksheet/"+file));	
					pw = new PrintWriter(new FileWriter("C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/"+file));
					
			

	            String ligne;
	            
					while ((ligne = br.readLine()) != null) {
					    pw.println(ligne);
					}
				
						br.close();
						pw.close();
	            
	        }
		
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	      
			//appel de la fonction d'affichage et compteur

			AffichageContenu(file);

	}
	
	static public void AffichageContenu(String file) {
	// maintenant on compte le nombre de lignes
		try {
	ArrayList lignes =new ArrayList ();
	BufferedReader br=new BufferedReader(new FileReader("C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/"+file));
	String ligne;
	
	
	
	int i=0;
	
		while((ligne=br.readLine())!=null) {
			lignes.add(ligne);
			i++;
		}
	
		
	System.out.println("---------le fichier contient "+i+ " lignes son contenu est ---------\n");
	// affichage du contenu
	Iterator<Integer> it = lignes.iterator();
	while (it.hasNext()) {
	  System.out.println(it.next());}
		br.close();// fermeture de lecteur de caracteres
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	}

