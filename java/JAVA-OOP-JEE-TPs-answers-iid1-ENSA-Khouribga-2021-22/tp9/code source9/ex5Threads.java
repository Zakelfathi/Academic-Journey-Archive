package tp9;

public class ex5Threads extends Thread {

	String f, pathFichier;
	public ex5Threads(String F,String pathFile) {
		super();
		pathFichier=pathFile;
		f=F;
	}
	
	// la fonction run()
	public void run() {
		ex5Main.sauvegarde(f);
		pathFichier+=f;
		ex5Main.tabNom(pathFichier);
	   }
	   
	}
	

