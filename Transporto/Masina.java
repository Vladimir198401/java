package Transporto;
	  
	public class Masina {
		
		public String Automobilis;
		public Double kuro_san_mieste;
		public Double kuro_san_uzmiestij;
		public boolean tinkama;
		public int vidurkis;
		
		public Masina() {
		
			this.kuro_san_mieste = 0.0;
			this.kuro_san_uzmiestij = 0.0;
			this.tinkama = false;			
		}		

		
		public Masina (String Automobilis, Double kuro_san_mieste, Double kuro_san_uzmiestij ) {  //parametrai
			
		
			this.Automobilis = Automobilis;
			this.kuro_san_mieste = kuro_san_mieste;	
			this.kuro_san_uzmiestij = kuro_san_uzmiestij;	// parametrai vadinami savibemis ir priskiriama this
			this.tinkama = false;
		}	

		public void nustatyti ( boolean tinkama ) {
			
			this.tinkama = tinkama;
		}
		
		public boolean kokia () {
			
			return this.tinkama;
		} 
		
		public String present ( Double san_proc_mieste ) {  			//metodai - taip vadinamos funkcijos priklausancios klasei
							// metodai dirba su savybemis per kreipini this. savybes bendros visems metodams 
			
			return " - Automobilis: " + this.Automobilis + " - kuro_san_uzmiestij: " + this.kuro_san_uzmiestij + " - kuro_san_mieste: " +  this.kuro_san_mieste +  " - vidurkis:"  + this.vidurkis( san_proc_mieste );    //return apraso ka turi grazint ir kaip veikt ir parodo front ende
		}
		
		public Double vidurkis ( Double san_proc_mieste) {
		
			return ( this.kuro_san_mieste *  san_proc_mieste  /100.0 + (this.kuro_san_uzmiestij * (100.0 -   san_proc_mieste ) /100.0));
		}
	}	