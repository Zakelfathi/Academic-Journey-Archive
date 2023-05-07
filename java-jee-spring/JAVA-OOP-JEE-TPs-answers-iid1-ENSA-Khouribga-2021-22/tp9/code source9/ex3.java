package tp9;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;

public class ex3 {
		float valeur;
		//constructeur avec parametre
		public ex3(float V) {
			this.valeur=V;
		}
	
		@Override
		public String toString() {
			return "ex3 [valeur=" + valeur + "]";
		}



		//methode de remplissage
		static public void remplir(float d,String file) {
			DataOutputStream out;
	 
	        try {
	            out = new DataOutputStream( 
	            				new FileOutputStream("C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/"+file));
	 
	            for (int i = 1; i < 7; i++) {
	               out.writeFloat( (float)(i*d));
	            } 
	 
	            out.close();
	        } catch (IOException e) {
	         e.printStackTrace();
	        }
		}
			
		
	        
	        
		//methode d'analyse
		static public void analyser(String file) throws IOException {
			float ch;
			int i=1;
			DataInputStream Input;
			try {
				Input=new DataInputStream( new FileInputStream("C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/"+file) );
				// le contenu
			    while ( (ch=Input.readFloat())!=0) {
			    //   System.out.println(ch);
			    	System.out.println(i+",\t"+ch);
			        i++;
			    }

			    Input.close();
				 } catch (IOException e) {
			        // e.printStackTrace();
			        }
}
		static public int nbrLignes(String file) {
			
			int i=0;
			DataInputStream Input;
			try {
				Input=new DataInputStream( new FileInputStream("C:/Users/EliteBooK/Desktop/tp9 java worksheet/output/"+file) );
			
			float ch;
			while ( (ch=Input.readFloat())!=0) {
			        i++;
			    }

		}  catch (IOException e) {
	        // e.printStackTrace();
	        }
			return i;
			}
		
}