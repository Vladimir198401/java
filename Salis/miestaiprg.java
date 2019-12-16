
package Salis;

import java.io.*;

public class miestaiprg {	
	/**
	* Skaiciu paieska vartotojo nurodytame intervale i_nuo .. i_iki
	*/
	public static void main ( String[] args ) {
				
		boolean has_header = true;	
		String s;
		Miestas[] miestai = new Miestas[ 50 ];
		
		int i;
		int k = 0;
		int gyventoju_skaicius = 0;
		int plotas = 0;
		int tankis_nuo;
		int tankis_iki;
		int Miestas;
		
		InputStreamReader stream = new InputStreamReader(System.in);
			
		BufferedReader reader=new BufferedReader(stream);	
			
		System.out.println ( " Miestu skaicius:" );
		/*                                                                      Duomenų įvedimas                                                               */
		try {
			
			FileReader fr=new FileReader( "miestai.csv" );
			BufferedReader frx = new BufferedReader ( fr );
			
			while ( ( s = frx.readLine() ) != null ) {
					
					if ( ! has_header ) { 
						
						String[] ss = s.split ( "," );
																		// System.out.println ( ss [ 0 ] + " " + ss [ 1 ] +  " " + ss [ 2 ] + " "  +  ss [ 3 ] + " " + ss.length );
						
						miestai [ k ] = new Miestas ( ss [ 0 ], Integer.parseInt ( ss [ 1 ] ), Integer.parseInt ( ss [ 2 ] ) );

						k++;
	
					} else {

						has_header = false;						
					}
				}
				fr.close();  
				
				i = 0;
				System.out.println ( " Nuskaitytos miestus is failo: " ); 
				
			while ( i < k ) {
					
					System.out.println ( miestai [ i ].present()  );
					i++;
				}	
				
				System.out.println ();
			
				System.out.println ( "gyventoju_skaicius? " );
				s= reader.readLine();
				gyventoju_skaicius = Integer.parseInt( s ); 		
				
				System.out.println ( "plotas? " );
				s= reader.readLine();
				plotas = Integer.parseInt( s ); 			
				
				System.out.println (  "įvesti daikto matmenys: \n gyventoju_skaicius: " + gyventoju_skaicius + " plotas: " + plotas );
							

			} catch ( IOException e ) {
				
				System.out.println ( "Skaitymo klaida" );
			}
			
			boolean flag_pasiimti_min = true;
			
			int t_miestai = -1; // reiksme -1 uztikrina kad perrenkant dezes, tokios nebus , tai bus mums tinkama deze
		
			for ( i = 0; i < k; i++ ) {
			
				if ( miestai [ i ]. arYraRibose (gyventoju_skaicius, plotas )){

					if ( flag_pasiimti_min )  {
					
						t_miestai = i;
						flag_pasiimti_min = false; // bandit be ir su..
						
					} else {
					
						if ( miestai [ t_miestai ].tankis() < miestai [ i ].tankis() ) {
						
							t_miestai = i;
							
						}
					
					}
					miestai [ i ].nustatyti ( true );
				}
			}
		
			for ( i = 0; i < k; i++ ) {
			
				System.out.print ( miestai [ i ].present() );
				
				if ( miestai [ i ].kokia ()  ) {
				
					System.out.print ( " tinkama " );
					
				} else {
					
					System.out.print ( " netinkama " );				
				}
			
				if ( i == t_miestai ) {
					
					System.out.print ( " maziausia " );
				}
				System.out.println();
			}
		}
		
	}
		