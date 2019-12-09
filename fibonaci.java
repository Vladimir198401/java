
import java.io.*;

public class fibonaci {
	
	public static void main ( String[] args ) {
		
		System.out.println ( "Fibonačio seka:" );
		String s;
		int i_pries2;
		int i_pries1;
		InputStreamReader stream=new InputStreamReader(System.in);
			
		//creating the buffered character input stream. The argument contains the InputSreamReader object as it is a child class of Reader class
		BufferedReader reader=new BufferedReader(stream);	
		
		try {
		
			System.out.println ( "Pirmas skaičius? " );
			s = reader.readLine();
			i_pries2 = Integer.parseInt( s ); 		
			
			System.out.println ( "Antras skaičius? " );
			s = reader.readLine();		
			i_pries1 = Integer.parseInt( s );
			
			System.out.print ( i_pries2 + " " + i_pries1 );
			
		} catch ( IOException e ) {
			
			i_pries2 = 1;
			
			i_pries1 = 1;
		}
		
		int i = 3;

		while ( i < 30 ) {
			
			int naujas = i_pries2 + i_pries1;
			
			System.out.print ( " " + naujas );			
			
			i_pries2 = i_pries1;
			i_pries1 = naujas;
			i++;
		}
		System.out.println();
	}
}