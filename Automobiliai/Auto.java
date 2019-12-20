
	package Automobiliai;

	public class Auto {
		
		public String Automobilis;
		public Double nuvaziotas_atstumas;
		public Double greitis;
		public Double laiko_intervalas;
		public Double atstumas_tarp_automobiliu;
		public Double judeti;
		
		public Auto() {
			
			this.Automobilis = "Nezinomas";
			this.judeti = 0.0;
			this.nuvaziotas_atstumas = 0.0;
			this.greitis = 0.0;
			this.laiko_intervalas = 0.0;
			this.atstumas_tarp_automobiliu  = 0.0;
			
		}
		
		public Auto (String Automobilis, Double nuvaziotas_atstumas, Double greitis, Double laiko_intervalas, Double atstumas_tarp_automobiliu, Double judeti ) {  //parametrai
			
			this.Automobilis = Automobilis;
			this.nuvaziotas_atstumas = nuvaziotas_atstumas;
			this.greitis = greitis;	
			this.laiko_intervalas = laiko_intervalas;	// parametrai vadinami savibemis ir priskiriama this
			this.atstumas_tarp_automobiliu = atstumas_tarp_automobiliu;
			this.judeti = judeti;
		}	
		
		public void keistiGreiti ( double greitis ){
			
			this.greitis =  greitis;
		}
		
		public void judeti ( double laiko_intervalas ) {
			
			this.laiko_intervalas += laiko_intervalas;
		}
		
		public String present () {  			//metodai - taip vadinamos funkcijos priklausancios klasei
							// metodai dirba su savybemis per kreipini this. savybes bendros visems metodams 
			
			return " Greitis: " +  this.greitis  + this.atstumas_tarp_automobiliu; 
			//return apraso ka turi grazint ir kaip veikt ir parodo front ende
		}
		
		public double nuvaziotas_atstumas () {
			
			return ( this.greitis * laiko_intervalas );
		}
		
		public double atstumas_tarp_automobiliu () {
			
			return (this.atstumas_tarp_automobiliu - nuvaziotas_atstumas);
		}
		
	}	