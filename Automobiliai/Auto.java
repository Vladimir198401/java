
	package Automobiliai;

	public class Auto {
		
		public String Automobilis;
		public Double nuvaziotas_atstumas;
		public Double greitis;
		public Double laiko_intervalas;
		public Double atstumas_tarp_automobiliu;
		public Double judeti;
		public Double Atstumas;
		
		public Auto() {
			
			this.Automobilis = "Nezinomas";
			this.judeti = 0.0;
			this.nuvaziotas_atstumas = 0.0;
			this.greitis = 0.0;
			this.laiko_intervalas = 0.0;
			this.atstumas_tarp_automobiliu  = 0.0;
			this.Atstumas = 0.0;
			
		}
		
		public Auto (String Automobilis, Double nuvaziotas_atstumas, Double greitis, Double laiko_intervalas, Double atstumas_tarp_automobiliu, Double judeti ) {  //parametrai
			
			this.Automobilis = Automobilis;
			this.nuvaziotas_atstumas = nuvaziotas_atstumas;
			this.greitis = greitis;	
			this.laiko_intervalas = laiko_intervalas;	// parametrai vadinami savibemis ir priskiriama this
			this.atstumas_tarp_automobiliu = atstumas_tarp_automobiliu;
			this.judeti = judeti;
			this.Atstumas = Atstumas;
			
		}	
		
		public void keistiGreiti ( double greitis ){
			
			this.greitis =  greitis;
		}
		
		public void judeti ( double laiko_intervalas ) {
			
			this.laiko_intervalas += laiko_intervalas;
		}
	
		public double nuvaziotas_atstumas () {
			
			return ( this.greitis * laiko_intervalas );
		}
		
		public double atstumas_tarp_automobiliu () {
			
			return ( Atstumas - nuvaziotas_atstumas());
		}
			 
	}	