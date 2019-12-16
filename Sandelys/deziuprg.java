
	package Sandelys;

	import java.io.*;

	public class deziuprg {	
		
		public static void main ( String[] args ) {
					
			
			boolean has_header = true;			
			String s;
			Deze[] dezes = new Deze [ 100 ];
			int k = 0;	
			int i;
			
			int daikto_ilgis = 0; 		
			int daikto_plotis = 0; 
			int daikto_aukstis = 0; 			
			
			InputStreamReader stream = new InputStreamReader(System.in);
				
			BufferedReader reader=new BufferedReader(stream);	
			
			System.out.println ( " Sandelio dezes:" );
			/*                                                                      Duomenų įvedimas                                                               */
			try {
				
				FileReader fr=new FileReader( "dezes.csv" );
				BufferedReader frx = new BufferedReader ( fr );

				while ( ( s = frx.readLine() ) != null ) {
					
					if ( ! has_header ) { 
						
						String[] ss = s.split ( "," );
						
																				// System.out.println ( ss [ 0 ] + " " + ss [ 1 ] +  " " + ss [ 2 ] + " "  +  ss [ 3 ] + " " + ss.length );
						
						dezes [ k ] = new Deze ( ss [ 0 ], Integer.parseInt ( ss [ 1 ] ), Integer.parseInt ( ss [ 2 ] ), Integer.parseInt ( ss [ 3 ] ) );

						k++;
	
					} else {

						has_header = false;						
					}
				}
				fr.close();  
				
				i = 0;
				System.out.println ( " Nuskaitytos dezes is failo: " );

				while ( i < k ) {
					
					System.out.println ( dezes [ i ].present()  );
					i++;
				}	
				
				System.out.println ();
			
				System.out.println ( "Daikto ilgis? " );
				s= reader.readLine();
				daikto_ilgis = Integer.parseInt( s ); 		
				
				System.out.println ( "Daikto plotis? " );
				s= reader.readLine();
				daikto_plotis = Integer.parseInt( s ); 
				
				System.out.println ( "Daikto aukstis? " );
				s= reader.readLine();
				daikto_aukstis = Integer.parseInt( s ); 				
				
				System.out.println (  "įvesti daikto matmenys: \n ilgis: " + daikto_ilgis + " plotis: " + daikto_aukstis + " aukstis: " + daikto_aukstis );
							

			} catch ( IOException e ) {
				
				System.out.println ( "Skaitymo klaida" );
			}
			
			boolean flag_pasiimti_min = true;
			
			int t_dezes = -1; // reiksme -1 uztikrina kad perrenkant dezes, tokios nebus , tai bus mums tinkama deze
			
			for ( i = 0; i < k; i++ ) {
			
				if ( dezes [ i ].arTilps ( daikto_ilgis, daikto_plotis, daikto_aukstis )  ) {

					if ( flag_pasiimti_min )  {
					
						t_dezes = i;
						flag_pasiimti_min = false;
					
					} else {
					
						if ( dezes [ t_dezes ].turis() > dezes [ i ].turis() ) {
						
							t_dezes = i;
						}
					
					}
					dezes [ i ].nustatyti ( true );
				}
			}			
			
			
			for ( i = 0; i < k; i++ ) {			
			
				System.out.print ( dezes [ i ].present() );
				
				if ( dezes [ i ].kokia ()  ) {
				
					System.out.print ( " tinkama " );
					
				} else {
					
					System.out.print ( " netinkama " );				
				}
			
				if ( i == t_dezes ) {
					
					System.out.print ( " maziausia " );
				}
				System.out.println();
			}
		}
		
	}