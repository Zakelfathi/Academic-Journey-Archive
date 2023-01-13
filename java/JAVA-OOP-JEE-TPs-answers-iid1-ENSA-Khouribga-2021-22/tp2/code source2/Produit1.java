package tp2;

import java.util.Objects;

public class Produit1 {
	private int Code; 
	String Marque;
	private float Prix;

/*	@Override
	public String toString() {
		return "Produit1 [Code=" + Code + ", Marque=" + Marque + ", Prix=" + Prix + "]";
	}
	*/
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit1 other = (Produit1) obj;
		return Code == other.Code && Objects.equals(Marque, other.Marque)
				&& Float.floatToIntBits(Prix) == Float.floatToIntBits(other.Prix);
	}
	
	
	public Produit1(){
		this.Code=0;
		this.Prix=3500;
		Marque = "H'MAMA";	
	}
  
	public Produit1(int Code ,String Marque,float Prix){
		this.Code=Code;
		this.Prix=Prix;
		Marque=Marque;
	}

	 public String toString() {
		 return this.Code+ "\n"+Marque+"\n"+this.Prix;
	 }


	public int getCode() {
		return this.Code;
	}


	public void setCode(int code) {
		this.Code = code;
	}


	public String getMarque() {
		return this.Marque;
	}


	public void setMarque(String marque) {
		this.Marque = marque;
	}


	public float getPrix() {
		return this.Prix;
	}


	public void setPrix(float prix) {
		this.Prix = prix;
	}




}