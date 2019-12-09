import java.io.*;

public class skaiciusekos {	
	/**
	* Skaičių paieška vartotojo nurodytame intervale i_nuo .. i_iki
	*/
	
	public static void main ( String[] args ) {
				
		String s;
		// String[] ss = new String[100]; 
		int i_nuo;
		int i_iki;
		int[] skaiciai = new int [ 100 ];
		int i;
		int k = 0;		
		
		InputStreamReader stream=new InputStreamReader(System.in);
			
		//creating the buffered character input stream. The argument contains the InputSreamReader object as it is a child class of Reader class
		BufferedReader reader=new BufferedReader(stream);	
		
		System.out.println ( " Skaičių paieška vartotojo nurodytame intervale i_nuo .. i_iki" );
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
			
			i = 0;
			System.out.print ( " Nuskaityti skaičiai iš failo: " );
			
			while ( i < k ) {
				
				System.out.print ( skaiciai [ i ]   + " " );
				i++;
			}	
			System.out.println ();
		
			System.out.println ( "Intervalo pradžia? " );
			s = reader.readLine();
			i_nuo = Integer.parseInt( s ); 		
			
			System.out.println ( "Intervalo pabaiga? " );
			s = reader.readLine();		
			i_iki = Integer.parseInt( s );
			
			System.out.println (  "įvestas intervalas i_nuo: " + i_nuo + " i_iki: " + i_iki );
			
		} catch ( IOException e ) {
			
			i_nuo = -10;
			
			i_iki = 10;
		}
		/*                                                        Skaičiavimai ir rezultatų išvedimas                                                      */
		
		i = 0;
		System.out.println ( " Skaičiai intervale nuo  " + i_nuo + " iki " + i_iki );
		
		while ( i < k ) {

			if ( ( i_nuo <= skaiciai [ i ] ) && ( skaiciai [ i ] <= i_iki ) ) {
				
				System.out.println ( skaiciai [ i ] + " " );
			}
			i++;			
		}
		
	}
	
}