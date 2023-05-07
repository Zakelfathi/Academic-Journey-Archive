package tp8;

class ppalThread extends Thread{
	String nom;
	public ppalThread(String nom) {
		super(nom);
		}
	
	public void run() {
		
		for(int i=0;i<20;i++) {
			try {sleep((int)Math.random()*200);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println("le nom du thread est :*****"+this.currentThread().getName()+"***** itere a l'etape :"+(i+1));

		}
	}
}


public class ex1 {

	public static void main(String[] args) {
		
		ppalThread t1=new ppalThread("thread_1");
		ppalThread t2=new ppalThread("thread_2");
		ppalThread t3=new ppalThread("thread_3");
		//priorite maximale
		t1.setPriority(10);
		//priorite minimale
		t3.setPriority(1);
		System.out.println("priorite de a :"+t1.getPriority());
		System.out.println("priorite de b :"+t2.getPriority());
		System.out.println("priorite de c :"+t3.getPriority());

		
		t1.start();
		// t2.start();
		t3.start();
		try {
			t1.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
		
	}

}
