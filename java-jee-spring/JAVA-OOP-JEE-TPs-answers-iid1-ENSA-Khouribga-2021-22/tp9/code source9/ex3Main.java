package tp9;

import java.io.IOException;

public class ex3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex3.remplir(0.1f,"ex3File");
		System.out.println("********\nle nombre de lignes est :"+ex3.nbrLignes("ex3File")+"\n********");
		try {
			ex3.analyser("ex3File");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
