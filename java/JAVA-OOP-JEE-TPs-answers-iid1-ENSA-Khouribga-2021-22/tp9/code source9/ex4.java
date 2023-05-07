package tp9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		
		System.out.println("entre l'endroit:");
		Scanner sc=new Scanner(System.in);
		String path=sc.nextLine();
		
		System.out.println("entre le nom du fichier:");
		String nom=sc.nextLine();
		
		System.out.println("entre le nouveau endroit:");
		String endroit=sc.nextLine();
		// appel de la fonction
		fct(nom,path,endroit);
	}
	
	static public void fct(String file,String path, String endroit) {
		int o;
		try {
		
			FileInputStream input =new FileInputStream(path+file);
			FileOutputStream out= new FileOutputStream(endroit+file);
		
	
			while((o=input.read())!=-1) {
				out.write(o);
			}
		
		
			input.close();
			out.close();
			System.out.println("---------fichier cree avec succes!---------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}


