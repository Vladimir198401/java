import java.io.*;

public class morzecezoriu {	       
	/**
	* Skaiciu paieska vartotojo nurodytame intervale i_nuo .. i_iki
	*/
	
	public static String[] ltRaides() {
		
		String[] lt_raides = { "Ą", "Č", "Ę", "Ė", "Į", "Š", "Ų", "Ū", "Ž" };
		
		return lt_raides;
	}
	
	public static String[] rMorzes() {

		String[] morzes = { "·-", "-···", "-·-·", "-··", "·", "··-·", "--·", "····", "··", "·---", "-·-", "·-··", "--", "-·", "---", "·--·", "--·-", "·-·", "···", "-", "··-", "···-", "·--", "-··-", "-·--", "--··",  
					
				"-----", "·----", "··---", "···--", "····-", "·····", "-····", "--···", "---··", "----·",
				"·-·-·-", "--··--", "··--··", "·----·", "-·-·--", "-··-·", "-·--·", "-·--·-", "·-···", "---···", "-·-·-·", "-···-", "-····-", "··-- ·-", "·-··-·", "···-··-", "·--·-·"
		};	
		return morzes;
	}

	public static String strArr2Str ( String[] str2join, int kiekis ) {
		
		String s = "";
		
		for ( int i = 0; i < kiekis; i++ ) {
			
			s += str2join [ i ]; 
		}
		return s;
	}
	
	public static int skaitytiIsFailo ( String[] tekstas ) {
		
		String s;
		int k = 0;		
	
		try {
			
			FileReader fr=new FileReader( "textas.txt" );
			BufferedReader frx = new BufferedReader ( fr );
		

			while  ( ( s = frx.readLine() ) != null ) {
			
				tekstas [ k ] = s;
				k++;
			}
			fr.close(); 
			
		} catch ( Exception e ) {
			
			System.out.println ( "Skaitymo iš failo klaida" );
		}	
		return k;
	}
	
	public static void parodytiKaipAtrodo( String[] tekstas, int kiekis ) {
	
		for ( int t = 0; t < kiekis; t++ ) {
		
			for( int j = 0; j< tekstas[ t ].length(); j++) {
			
				System.out.println ( "t: " + t + " j: " + " tekstas [ t ] [ j ]: " + tekstas [ t ].substring( j, j +1 ) );
			}
		}	
	}
	
	public static String sukeisti ( String eilute, int i )	 {
	
		return eilute.substring( 0, i )  +  eilute.substring( i + 1, i + 2 ) + eilute.substring( i,  i + 1 ) + eilute.substring ( i +  2 );
	}	
	
	/**
	* Keičiam į morzės abėcėlę
	*/
	public static String translateToMorse( String[] tekstas, int kiekis_eil ) {
	
		int num_raides;		
		int num_lot_raides;
		String simbolis;
		String morzes_simb;
		String tekstas_res = "";		
		
		String[] raides = { 
			
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",   // kintamasis masivas
				
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			".", ",", "?", "'", "!", "/", "(", ")", " &", ":", ";", "=", "–", "_", "\"", "$", "@"
		};

		String[] morzes = rMorzes();			
			
		String[] lot_raides = { "A", "C", "E", "E", "I", "S", "U", "U", "Z" };
		
		String[] lt_raides = ltRaides();
		
		for ( int t = 0; t < kiekis_eil; t++) {
			
			for( int j = 0; j < tekstas[ t ].length(); j++) {
		
	
				if ( 
						(  
								num_lot_raides 
							= 
								java.util.Arrays.asList ( lt_raides ).indexOf (
					
									tekstas [ t ].substring( j, j +1 ).toUpperCase() 
								) 
						) 
					!= 
						- 1 
				) { 
					
					simbolis = lot_raides [ num_lot_raides ];
						
				} else {
					
					simbolis = tekstas [ t ].substring( j, j +1 ).toUpperCase();
				}
					
				if ( ( num_raides = java.util.Arrays.asList ( raides ).indexOf ( simbolis ) ) != -1 ) {  							
																					//num_raides = priskiriamas eilutes simbolis
					morzes_simb = morzes [ num_raides ];
					tekstas_res += morzes_simb + ' ';
			
				} else {
					
					tekstas_res += simbolis;
				}
			}
			tekstas_res += "\n";
		}
		return tekstas_res;
	}
	
	public static String[] changeToCesar ( String[] tekstas, int k ) {
			
			String[] nesukeisti = { " " , "\t", "\n" };
						
			for( int t = 0; t< k; t++) {
					
				int iki = tekstas[ t ].length();
				
				boolean liko_vienisas_simbolis_gale = false;
					
				if ( ( tekstas [ t ].length() % 2 ) != 0 ) {
					
					iki = tekstas [ t ].length() - 1;
					liko_vienisas_simbolis_gale = true;
				}
				
				for (int i = 0; i< iki; i+=2 ) {
				
					if ( 
							( java.util.Arrays.asList(nesukeisti).indexOf ( tekstas [ t ].substring( i, i + 1 ) ) == - 1 )  
						&& 
							(  java.util.Arrays.asList(nesukeisti).indexOf ( tekstas [ t ].substring( i + 1, i + 2 ) ) == -1 ) 
					) { 
						
						tekstas [ t ] = sukeisti ( tekstas[ t ], i );
					}
				}
				/*
				if ( liko_vienisas_simbolis_gale ) {
					
					tekstas [ t ] += tekstas [ t ].substring ( iki, 1 ); 
				}
				*/
			}
			return tekstas;
	}	
	public static void surasytiFaile ( String tekstas_res ) {
	
		String[] morzes = rMorzes();		
		String[] lt_raides = ltRaides();		
		
		for (int l = 0; l < lt_raides.length; l++ ) {
			
			System.out.println ( lt_raides [ l ] + " " );
		}
		
		try { 
			
			FileWriter fw=new FileWriter ( "testout.txt" );    
			fw.write( "Welcome to java.\n" ); 
			fw.write( "Lietuviškos raidės keičiamos taip:\n" ); 

			for (int l = 0; l < lt_raides.length; l++ ) {
			
				fw.write( lt_raides [ l ] + " " + morzes [ l ] + " " );
			}
			fw.write( "\n" );
			
			// for (int m = 0; m < tekstas_res.length(); m++ ) {
			
			fw.write( tekstas_res /* ( m ) */ );
			// }
			
			fw.close();    
			
		} catch ( Exception e ) {
			
			System.out.println(e);
		} 	
	}
	
	public static void main ( String[] args ) {
		
		int k = 0;	

		String[] tekstas = new String [ 100 ];
		String[] tekstas_res_ces;
		String tekstas_res;
																		// String lt_simb = {};
		int sukeisti;
																		// String[] tekstas; // = new String [ 100 ];		
		int iki;
		int num_lt_simb;
																		// String[] nesukeisti = { ' ','\t','\n' };
		// morzecezoriu mc = new morzecezoriu();
		k = skaitytiIsFailo( tekstas );
		
		/**
		* Duomenų išvedimas pasitikrinimui, kaip tai atrodo
		*/
		parodytiKaipAtrodo ( tekstas, k );		
		
		tekstas_res_ces = changeToCesar ( tekstas, k ); 
		
		/**
		* Keičiam į morzės abėcėlę
		*/		
		// tekstas_res = translateToMorse( tekstas_res_ces, k );
		
		tekstas_res = strArr2Str ( tekstas_res_ces, k );
		
		surasytiFaile ( tekstas_res );
		
		System.out.println( "Success..." );
	}
}			