	
	package Nuorodu_papke;
	
	public class NuorodosMan {
		
		public int k;
		
		public Nuoroda[] nuorodos_man;	

		public void NuorodosMan( ) {
			
			this.nuorodos_man = new Nuoroda [ 100 ];
			this.k = 0;

		}

		public void prideti ( Nuoroda nuoroda ) {

			this.nuorodos_man [ this.k ] = nuoroda;
			this.k++;
			
		}
		
		public String present() {
		
			String res_str = "";
		
			for (int i = 0; i < this.k; i++ ) {
			
				res_str += this.nuorodos_man[ i ] .present() + "\n";
			}
			return res_str;
		}
	}
	
	/**
		atitinka :
	
	
	class NuorodosMan {
	
		contructor ( nuorodu_sar ) {
	
			this.man_nuorodos = [];

			for ( i = 0; i < nuorodu_sar.length; i++ ) {
			
				this.man_nuorodos.push ( new Nuoroda ( nuorodu_sar [ i ] ) );
			}
		}
		
		present() {
			
			res_str = '';
		
			for ( i = 0; i < this.man_nuorodos.length; i++ ) {
			
				res_str += this.man_nuorodos [ i ] .present() + '<br>';
			}
			return res_str;
		}
		
	}
	*/