package tp9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


public class ex5Main {

	public static void main(String[] args) {
		/*
		sauvegarde("fichier1.dat");
		tabNom("C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/fichier1.dat");
	 */
		 ex5Threads T1 = new ex5Threads("fich1.dot","C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/");
		 ex5Threads T2 = new ex5Threads("fich2.dot","C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/");
		    T1.start();
		    try {
				T1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    T2.start();
		   
	}
		
	
	
	static public void sauvegarde(String file) {
		//code qui initialise 3 clients 
		Scanner sc=new Scanner(System.in);
		Client C1,C2,C3;
		System.out.println("Client C1:\n");
		C1=new Client(sc.nextLine(),sc.nextLine(),sc.nextLine());
	
		System.out.println("Client C2:\n");
		C2=new Client(sc.nextLine(),sc.nextLine(),sc.nextLine());
		
		System.out.println("Client C3:\n");
		C3=new Client(sc.nextLine(),sc.nextLine(),sc.nextLine());
	//sauvegarde dans un fichier binaire file.dat
		String path="C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/"+file;
		ObjectOutputStream outObj;
		try {
			outObj=new ObjectOutputStream(new FileOutputStream(path));
			outObj.writeObject(C1);
			outObj.writeObject(C2);
			outObj.writeObject(C3);
			
			outObj.close();
		} catch (IOException e) {
						e.printStackTrace();
		} 
		
	}
	
	static public void tabNom(String pathFichier) {
		//recharger des noms des clients et les mettre dans un tableau
		
		ObjectInputStream inputObj=null;
		try {
			try {
				inputObj=new ObjectInputStream(new FileInputStream(pathFichier));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Client c=null;
			String [] tab = new String[3];
			int i=0;
			
				try {
					System.out.println("-------les noms dans votre tableau-------");

					while((c=(Client) inputObj.readObject())!=null) {
						tab[i]=c.getNom();
						System.out.println(tab[i]);
						i++;
					}
					
					inputObj.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	

}
