
import java.io.*;

	public class trysskaic {
		
		public static void main ( String[] args ) {
			
			System.out.println ( "trysskaic" );
			String s;
			
			int a =1;
			int b =2;
			int c = 3;
			InputStreamReader stream=new InputStreamReader(System.in);
				
			//creating the buffered character input stream. The argument contains the InputSreamReader object as it is a child class of Reader class
			BufferedReader reader=new BufferedReader(stream);	
			
			try {
			
				System.out.print ( "Pirmas skaicius? " );
				s = reader.readLine();
				a = Integer.parseInt( s ); 		
				
				System.out.print ( "Antras skaicius? " );
				s = reader.readLine();		
				b = Integer.parseInt( s );
				
				System.out.print ( "Trecias skaicius? " );
				s = reader.readLine();		
				c = Integer.parseInt( s );
			
				System.out.println ( " Įvesti duomenys: a: " + a + " b: " + b + " c: " + c );
				
			} catch ( IOException e ) {
				
				a = 1;
				
				b = 2;
				
				c = 3;
			}
			
			
			if ( a > b ) {
				
				System.out.println ( a + ">" + b + ", c-a: " + ( c - a ) ); 
			}
			
			if ( a < b ) {
				
				System.out.println (  a + "<" + b + ", c-b: " + (c - b ) );
			}
			
			if ( a == b ) {
				
				System.out.println ( a + "==" + b + ", c^2: " + ( c * c ) );
			}
		} 
	}  

