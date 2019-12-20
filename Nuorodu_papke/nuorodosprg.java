
	package Nuorodu_papke;

	import java.io.*;

	public class nuorodosprg {	
		
		public static void main ( String[] args ) {
				
			boolean has_header = true;	
			String s;
			Nuoroda [] nuorodos = new Nuoroda[ 50 ];
			
			int i;
			int k = 0;
			int nuoroda;
			
			String pav;
			String url;
			String aprasas;
			
			InputStreamReader stream = new InputStreamReader(System.in);
				
			BufferedReader reader=new BufferedReader(stream);	
				
			System.out.println ( " Nuoruodu skaicius:" );                                                   
			try {
				
				FileReader fr=new FileReader( "nuorodu_sarasas.csv" );
				BufferedReader frx = new BufferedReader ( fr );
				
				while ( ( s = frx.readLine() ) != null ) {
						
					if ( ! has_header ) { 
						
						String[] ss = s.split ( "," );
													// System.out.println ( ss [ 0 ] + " " + ss [ 1 ] +  " " + ss [ 2 ] + " "  +  ss [ 3 ] + " " + ss.length );
						
						nuorodos [ k ] = new Nuoroda ( ss [ 0 ],  ( ss [ 1 ] ),  ( ss [ 2 ] ));
						k++;
	
					} else {

						has_header = false;						
					}
				}
					
				fr.close();  
					
				i = 0;
				System.out.println ( " Nuskaitytos nuorodas is failo: " ); 
				
				while ( i < k ) {
						
					System.out.println ( nuorodos [ i ].present()  );
					i++;
				}
				
						//System.out.println ( " Susikuriam nuorodu manedzeri ..\n " ); 

				NuorodosMan nuorodu_menedzeris = new NuorodosMan();
				
						//System.out.println ( " Perkeliam nuorodas is masyvo i nuorodu manedzeri ..\n " ); 				
				
				i = 0;
						
				while ( i < k ) {
						
					nuorodu_menedzeris.prideti ( nuorodos [ i ]  );
					i++;
				}

				System.out.println ( " Ivedam nauja nuoroda ..\n " ); 								
						
				System.out.println ( "url" );
				s= reader.readLine();
				url = s ; 		
				
				System.out.println ( "pav? " );
				s= reader.readLine();
				pav = s; 
				
				System.out.println ( "aprasas? " );
				s= reader.readLine();
				aprasas =s; 

				System.out.println (  "ivesti nuorodos: \n url: " + url + " pav: " + pav + " aprasas: " + aprasas );		
						
												//System.out.println ( " Sukuriam nauja nuorodos objekta ..\n " ); 								
				
				Nuoroda nuoroda_nauja = new Nuoroda ( url, pav, aprasas );
				
												//System.out.println ( " Ir nauja nuorodos objekta perduodam nuorodu menedzeriui ..\n " ); 												
	
				nuorodu_menedzeris.prideti ( nuoroda_nauja );
				
												//System.out.println ( " Nuorodu menedzeris pateikia turimas nuorodas ..\n " ); 												
				
				System.out.println ( nuorodu_menedzeris.present() );
				

			} catch ( IOException e ) {
					
					System.out.println ( "Skaitymo klaida" );
			}
			
				
		}
	
	}
	