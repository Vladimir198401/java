
	package Sandelys;
	
	public class Deze {
		
		public String pav;
		public int ilgis;
		public int plotis;
		public int aukstis;
		public boolean tinkama;

		public Deze() {
			
			this.ilgis = 0;
			this.plotis = 0;
			this.aukstis = 0;
			this.tinkama = false;			
		}
		
		public Deze ( String pav, int ilgis, int plotis, int aukstis ) {  //parametrai

			this.pav = pav;
			this.ilgis = ilgis;		
			this.plotis = plotis;	// parametrai vadinami savibemis ir priskiriama this
			this.aukstis = aukstis;
			this.tinkama = false;
		}	

		public void nustatyti ( boolean tinkama ) {
			
			this.tinkama = tinkama;
		}
		
		public boolean kokia () {
			
			return this.tinkama;
		}
		
		public String present() {  			//metodai - taip vadinamos funkcijos priklausancios klasei
							// metodai dirba su savybemis per kreipini this. savybes bendros visems metodams 
			
			return  "pavadinimas: " + this.pav + " ilgis: " +  this.ilgis + " aukštis: " +  this.aukstis + " plotis: " + this.plotis + " tūris: " + this.turis();    //return apraso ka turi grazint ir kaip veikt
		}
		
		public int turis() {
		
			return this.ilgis * this.plotis * this.aukstis;  //  return this sujungia padauginant visus matmenis, suskaiciojant turi
		}
		
		public boolean arTilps( int daikto_ilgis, int daikto_plotis, int daikto_aukstis ) {		//paimamos reiksmes

			boolean ar_tilps = false;   // kintamajam ar_tilps suteikiama klaidos reiksme to atveju jai ar tilps neatitinka dotus parametrus
			
			if ( ( daikto_ilgis * daikto_plotis * daikto_aukstis ) < this.turis() ) { // paimamos reiksmes
			
				if (  
						( ! ar_tilps )
					&& 
						( 
								( daikto_ilgis < this.ilgis )
							&& 
								( daikto_plotis < this.plotis )			//suteikiama parametru pozicija nustatitose reiksmese / bus kartojama keleta kartu keiciant reiksmiu pozicijas.
							&&
								( daikto_aukstis < this.aukstis )
						)
				) {
				
					ar_tilps = true;	// kintamajam ar_tilps suteikiama tesos reiksme to atveju jai ar_tilps atitinka dotus parametrus
				}
						
				if (  
						( ! ar_tilps )
					&& 
						( 
								( daikto_aukstis < this.aukstis )
							&& 
								( daikto_plotis < this.plotis )
							&&
								( daikto_ilgis < this.ilgis )
						)
				) {
				
					ar_tilps = true;
				}				
				if (  
						( ! ar_tilps )
					&& 
						( 
								( daikto_plotis < this.plotis )
							&& 
								( daikto_aukstis < this.aukstis )
							&&
								( daikto_ilgis < this.ilgis )
						)
				) {
				
					ar_tilps = true;
				}				
				if (  
						( ! ar_tilps )
					&& 
						( 
								( daikto_ilgis < this.ilgis )
							&& 
								( daikto_aukstis < this.aukstis )
							&&
								( daikto_plotis < this.plotis )
						)
				) {
				
					ar_tilps = true;
				}				
				if (  
						( ! ar_tilps )
					&& 
						( 
								( daikto_ilgis < this.aukstis )
							&& 
								( daikto_ilgis < this.ilgis )
							&&
								( daikto_plotis < this.plotis )
						)
				) {
				
					ar_tilps = true;
				}				
				if (  
						( ! ar_tilps )
					&& 
						( 
								( daikto_plotis < this.plotis )
							&& 
								( daikto_ilgis < this.ilgis )
							&&
								( daikto_aukstis < this.aukstis )
						)
				) {
				
					ar_tilps = true;
				}				
				
			}
			
			return ar_tilps; 			// uzdaromas ciklas
		}		
		
	}