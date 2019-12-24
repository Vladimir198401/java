
	package Automobiliai;

	public class Auto {

		public Double greitis;
		public Double laiko_intervalas;
		public Double Atstumas;
		public Double nuvaziotas_atstumas;
		public Auto() {
			
			this.greitis = 0.0;
			this.laiko_intervalas = 0.0;
		}
		
		public void keistiGreiti ( double greitis ){
			
			this.greitis = greitis;
		}
		
		public void judeti ( double laiko_intervalas ) {
			
			this.laiko_intervalas += laiko_intervalas;			
		}
	
		public double nuvaziotas_atstumas () {
			/*
			Skaiciojamas_atstumas = ( this.greitis * laiko_intervalas );
	
			this.Atstumas = Atstumas;
			
			if (Skaiciojamas_atstumas > this.Atstumas) {
				
				Skaiciojamas_atstumas = this.Atstumas;
			}
			return (Skaiciojamas_atstumas);
				*/
			return ( this.greitis * laiko_intervalas );
		}
		
	}	
			