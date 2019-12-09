import java.io.*;

public class skaiciutarpai {	
	/**
	* Skaičių paieška vartotojo nurodytame intervale i_nuo .. i_iki
	*/
	
	public static void main ( String[] args ) {
				
		String s;
		
		int[] skaiciai = new int [ 100 ];
		int i;
		int k = 0;		
		int vnt;
		
		System.out.println ( " Skaiciu paieska nurodytame intervale " );
		/*                                                                      Duomenu vedimas                                                               */
		try {
			
			FileReader fr=new FileReader( "skaiciai.txt" );
			BufferedReader frx = new BufferedReader ( fr );
			
			while ( ( s = frx.readLine() ) != null ) {
				
				String[] ss = s.split ( " " );
				
				for (int t = 0; t< ss.length; t++ ) { // keicia skaiciu eilutes i pavenius skaicius
				
					skaiciai [ k ]  = Integer.parseInt(  ss [ t ] );
					
					k++;
				}
				
			}
			fr.close();  
			
			i = 1; 
			vnt = 1;
			
			
			System.out.print ( " tarpai tarp skaiciu: " ); //zodziu isvedimas i comander konsole
			
			while ( i < k -1 ) {		//i tai vienas (einamasis) , k tai visu esamu kiekis  
			 
				if (skaiciai [ i ] > skaiciai [ i -1 ] && skaiciai [ i ] > skaiciai [ i + 1 ] ) {	 // skaiciai [ i ]   eiliskumas 
				
					System.out.print ( vnt  + " ");  // vnt skaiciau venetas tarp skaiciai [ i ]
					vnt = 0; // priskiriamas skaiciavimas nuo nulio po if paskaiciavimo, kaskart nuo sekancio skaiciaus imant nuo 0..
				}
				
				else if (skaiciai [ i ] < skaiciai [ i -1 ] && skaiciai [ i ] < skaiciai [ i + 1 ] ) {
				
					System.out.print ( vnt  +  " " ) ;  //  rezultatu isvedimas
					vnt = 0;
					
				}else {
					vnt++;  // pridedam i eilute isvestus skaicius
				}
				
				i++;  // pridedam i eilute isvestus skaicius
			}	
			System.out.println ();
			
		} catch ( IOException e ) {
			
			System.out.print ( " failo klaida: " );
			
		}
		/*                                                        Skaičiavimai ir rezultatų išvedimas                                                      */
			
      
		}
		
	}			