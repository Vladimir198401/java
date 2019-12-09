import java.io.*;

public class skaiciusekosextra {	
	/**
	* Skaičių paieška vartotojo nurodytame intervale i_nuo .. i_iki
	*/
	
	public static void main ( String[] args ) {
				
		String s;
		// String[] ss = new String[100]; 
		
		int[] skaiciai = new int [ 100 ];
		int i;
		int k = 0;		
		
		InputStreamReader stream=new InputStreamReader(System.in);
			
		//creating the buffered character input stream. The argument contains the InputSreamReader object as it is a child class of Reader class
		
		BufferedReader reader=new BufferedReader(stream);	
		
		System.out.println ( " Skaičių paieška nurodytame intervale " );
		/*                                                                      Duomenų įvedimas                                                               */
		try {
			
			FileReader fr=new FileReader( "skaiciai.txt" );
			BufferedReader frx = new BufferedReader ( fr );
			
			while ( ( s = frx.readLine() ) != null ) {
				
				String[] ss = s.split ( " " );
				
				for (int t = 0; t< ss.length; t++ ) {
				
					skaiciai [ k ]  = Integer.parseInt(  ss [ t ] );
					k++;
				}

			}
			fr.close();  
			
			i = 1;
			System.out.print ( " Nuskaityti skaičiai iš failo: " );
			
			while ( i < k ) {
				
				if (skaiciai [ i ] > skaiciai [ i -1 ] && skaiciai [ i ] > skaiciai [ i + 1 ] ) {
				
					System.out.print (skaiciai [ i ]  + " "); 
				}
				
				else if (skaiciai [ i ] < skaiciai [ i -1 ] && skaiciai [ i ] < skaiciai [ i + 1 ] ) {
				
					System.out.print (skaiciai [ i ]  +  " " ) ;
				}
				
				
				i++;
			}	
			System.out.println ();
			
		} catch ( IOException e ) {
			
			System.out.print ( " failo klaida: " );
			
		}
		/*                                                        Skaičiavimai ir rezultatų išvedimas                                                      */
		
      
		}
		
	}