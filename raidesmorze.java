import java.io.*;

public class raidesmorze {	       
	/**
	* Skaiciu paieska vartotojo nurodytame intervale i_nuo .. i_iki
	*/
	
	public static void main ( String[] args ) {
		
		int i = 0;				//funkcines  kintameji  string eilutes  ir int zimejimai dalivaujanciu kode  
		int k = 0;
		int num_lot_raides;
		String simbolis;
		String morzes_simb;
		int num_raides;
		String tekstas_res = "";
				
		String s;
		String[] tekstas = new String [ 100 ];		
		
		
		String[] raides = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",   // kintamasis masivas
				
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				".", ",", "?", "'", "!", "/", "(", ")", " &", ":", ";", "=", "–", "_", "\"", "$", "@"
			};
				String[] morzes = { "·-", "-···", "-·-·", "-··", "·", "··-·", "--·", "····", "··", "·---", "-·-", "·-··", "--", "-·", "---", "·--·", "--·-", "·-·", "···", "-", "··-", "···-", "·--", "-··-", "-·--", "--··",  
					
				"-----", "·----", "··---", "···--", "····-", "·····", "-····", "--···", "---··", "----·",
				"·-·-·-", "--··--", "··--··", "·----·", "-·-·--", "-··-·", "-·--·", "-·--·-", "·-···", "---···", "-·-·-·", "-···-", "-····-", "··-- ·-", "·-··-·", "···-··-", "·--·-·"
			};

		String[] lot_raides = { "A", "C", "E", "E", "I", "S", "U", "U", "Z" };
		
		String[] lt_raides = { "Ą", "Č", "Ę", "Ė", "Į", "Š", "Ų", "Ū", "Ž" };
	
		try {
			
			FileReader fr=new FileReader( "textas.txt" );
			BufferedReader frx = new BufferedReader ( fr );
		
			k = 0;
			while  ( ( s = frx.readLine() ) != null ) {
			
				tekstas [ k ] = s;
				k++;
			}
			fr.close(); 	
	
			if ( (  num_lot_raides = java.util.Arrays.asList(lt_raides).indexOf ( tekstas [ i ].toUpperCase() ) ) != - 1 ) { 
				
				simbolis = lot_raides [ num_lot_raides ];
					
				} else {
				
					simbolis = tekstas [ i ].toUpperCase();
				}
				
				if ( ( num_raides = java.util.Arrays.asList(raides).indexOf( simbolis ) ) != -1 ) {  							
																				//num_raides = priskiriamas eilutes simbolis
					morzes_simb = morzes [ num_raides ];
					tekstas_res += morzes_simb + ' ';
		
				} else {
				
					tekstas_res += simbolis;
				}
				
			
		} catch ( Exception e ) {
			
			System.out.println ( "Skaitymo iš failo klaida" );
		}
		
		for ( int t = 0; t < k; t++ ) {
		
			for( int j = 0; j< tekstas[ t ].length(); j++) {
			
				System.out.println ( "t: " + t + " j: " + " tekstas [ t ] [ j ]: " + tekstas [ t ].substring( j, j +1 ) );
			}
		}
		
		for (int l = 0; l < lt_raides.length; l++ ) {
			
			System.out.println ( lt_raides [ l ] + " " );
		}
		
		try { 
			
			FileWriter fw=new FileWriter ( "testout.txt" );    
			fw.write( "Welcome to javaTpoint." ); 

			for (int l = 0; l < lt_raides.length; l++ ) {
			
				fw.write( lt_raides [ l ] + " " + morzes [ l ] + " " );
			}			
			fw.close();    
			
		} catch ( Exception e ) {
			
			System.out.println(e);
		}    
		System.out.println("Success...");    
   		
	}
}