
	package Salis;
	
	public class Miestas {
		
		public String pav;
		public int gyventoju_skaicius;
		public int plotas;
		public boolean tinkama;

		public Miestas() {
			
			this.gyventoju_skaicius = 0;
			this.plotas = 0;
			this.tinkama = false;			
		}
		
		public Miestas ( String pav, int gyventoju_skaicius, int plotas) {  //parametrai

			this.pav = pav;
			this.gyventoju_skaicius = gyventoju_skaicius;		
			this.plotas = plotas;	// parametrai vadinami savibemis ir priskiriama this
			this.tinkama = false;
		}	

		public void nustatyti ( boolean tinkama ) {
			
			this.tinkama = tinkama;
		}
		
		public boolean kokia () {
			
			return this.tinkama;
		}
		
		public String present() {
			
			return "plotas: " + this.plotas + "gyventoju_skaicius: " + this.gyventoju_skaicius	+ "tankis:" + this.tankis();    //return apraso ka turi grazint ir kaip veikt ir parodo front ende
		}
		
		public int tankis() {
		
			return this.plotas / this.gyventoju_skaicius;  //  return this sujungia padauginant visus matmenis, suskaiciojant turi
		}
		
		public boolean arYraRibose(int tankis_nuo, int tankis_iki ) {		//paimamos reiksmes
			
			boolean ar_yraRybose = false;   // kintamajam ar_tilps suteikiama klaidos reiksme to atveju jai ar tilps neatitinka dotus parametrus
			
			if ( ( tankis_nuo <= this.tankis() ) && ( tankis_iki >= this.tankis() ) ) { // paimamos reiksmes
			//suteikiama parametru pozicija nustatitose reiksmese / bus kartojama keleta kartu keiciant reiksmiu pozicijas.
			
				
					ar_yraRybose = true;	// kintamajam ar_tilps suteikiama tesos reiksme to atveju jai ar_tilps atitinka dotus parametrus
			
		 
			}
			
			return ar_yraRybose; 			// uzdaromas ciklas
		}
	}