package tp9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) throws IOException {

		System.out.println("entrer le nom : ");
		Scanner sc=new Scanner(System.in);
		String var= sc.nextLine();//on prend le nom du fichier
//creation d'un fichier dans le repertoire indique
		FileWriter writer =new FileWriter("C:/Users/EliteBooK/Desktop/tp9 java worksheet/"+var);		
		BufferedWriter out= new BufferedWriter(writer);// ouverture du fichier en ecriture

		String n;
		System.out.println("input sth: ");
		n=sc.nextLine();
		
		while(n != "Stop") { //iterer tant que l'entree est differente de 'Stop'
			out.write(n);
			System.out.println("input sth: ");
			n=sc.nextLine();
			out.newLine();
			if (n.equals("Stop")) break;//condition d'arret du programme
		}
		
		out.close();// fermeture du fichier
	}

}
