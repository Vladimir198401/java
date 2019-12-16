
	package Nuorodu_papke;
	
	public class Nuoroda {
		
		public String url;
		public String pav;
		public String aprasas;
		
		public  Nuoroda () {

			this.url = "";
			this.pav = "";
			this.aprasas = "";
		}
		
		public Nuoroda ( String url, String pav, String aprasas ) {  //parametrai

			this.url = url;
			this.pav = pav;		
			this.aprasas = aprasas;	// parametrai vadinami savibemis ir priskiriama this
		
		}	

		
		public String present() {
			
			//return apraso ka turi grazint ir kaip veikt ir parodo
			return  "url: " +  this.url + "pav: "+ this.pav + "aprasymas: " +  this.aprasas;
		}
	}