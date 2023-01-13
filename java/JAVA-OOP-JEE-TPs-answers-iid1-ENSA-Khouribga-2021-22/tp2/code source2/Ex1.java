package tp2;
import java.util.Scanner;
import java.lang.String;

public class Ex1{
	public static void main(String[] args) {
				String mot;
				String text;
				System.out.println("-------entrer un texte-------");
				Scanner T= new Scanner(System.in);
				text=T.nextLine();
				do {
					System.out.println("-------(pour quitter taper '0')-------");
					System.out.println("-------entrer un mot-------");
					Scanner A = new Scanner(System.in);
					mot = A.nextLine();
					int z = mot.length();
					int l = text.length();
					switch(mot) {
						case "ENSA":
							
							StringBuffer i = new StringBuffer(text);
							String e="ENSA";
							int pos=text.indexOf(e);
							i.delete(pos , pos +z);
							System.out.println("---------le nouveau texte est " +i);
							
							break;
							
						case "FST":
							String s2 = text.replace("FST" , "ENSA");
							System.out.println("--------le nouveau texte est " +s2);
							break;
							
						case "ENCG":
							StringBuffer m = new StringBuffer(text);
							m.append("ENCG");
							System.out.println("--------le nouveau texte est " +m);
							break;
							
						default: 
							System.out.println("--------vous avez entre un '0' ou ERREUR !-------- ");
							break;
							
				}
					
					}while(mot.equals("0")!=true);
				}}


