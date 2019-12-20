
	package Automobiliai;

	import java.io.*;
	
	public class DasAuto {
			
		public static void main ( String[] args ) {
		
			
			String s;
			Auto [] Automobiliai = new Auto[ 50 ];
			Auto Automobilis_1;
			Auto Automobilis_2;
			double nuvaziotas_atstumas = 0.0;
			double greitis = 0.0;
			double laiko_intervalas = 0.0;
			double atstumas_tarp_automobiliu  = 0.0;
			double Judeti = 0.0;	
			int i = 0;
			int k = 0;
			double Atstumas = 0.0;
			
				InputStreamReader stream = new InputStreamReader(System.in);
					
				BufferedReader reader=new BufferedReader(stream);	
				
				System.out.println ( " Masinu aikstele:" );
			
							Automobilis_1 = new Auto ();		
				
							Automobilis_2 = new Auto ();
							
			try{
							
			
						//    Duomenu ivedimas      
				
					System.out.println ();
			
					System.out.println ( " ivesti laika automobiliams" );
					s= reader.readLine();
					laiko_intervalas = Double.parseDouble( s ); 
				
					System.out.println ( " ivesti automobiliu atstuma" );
					s= reader.readLine();
					Atstumas = Double.parseDouble( s ); 
				

						
						System.out.println ( "ivesti greiti 1 automobiliui" );
						s= reader.readLine();
						greitis = Double.parseDouble( s ); 	
					
						Automobilis_1.keistiGreiti (greitis);
						
						System.out.println ( Automobilis_1.present () );
						
						System.out.println ( Automobilis_1.nuvaziotas_atstumas());
					
					//System.out.println (" ivesti matmenys: ..\n Automobilis_1 " + " greitis: " + greitis ); 
					
					
						
						
						
						System.out.println ( "ivesti greiti 2 automobiliui" );
						s= reader.readLine();
						greitis = Double.parseDouble( s ); 	
						
						Automobilis_2.keistiGreiti (greitis);
						
						System.out.println ( Automobilis_2.present () );
						
						System.out.println ( Automobilis_2.nuvaziotas_atstumas());
				
					//System.out.println (" ivesti matmenys: ..\n Automobilis_2 " + " greitis: " + greitis ); 
					
				
			} catch ( IOException e ) {
				
			System.out.println ( "Skaitymo klaida" );
				
			}
			
			
			i=0;

			System.out.println ( "----------------------------------------" );
			System.out.println ( "|   Laikas     |  Nuvaziuotas atstumas |" );
			System.out.println ( "|   	     |   Auto1  |    Auto 2  |" );
			System.out.println ( "----------------------------------------" );
			
			
			while ( 
				
					( Automobilis_1.nuvaziotas_atstumas() < Atstumas )  
				||  
					( Automobilis_2.nuvaziotas_atstumas() < Atstumas ) 
			) {
				
				Automobilis_1.judeti ( laiko_intervalas );
				
				Automobilis_2.judeti ( laiko_intervalas );
				
				System.out.println ( 
				
					String.format( "| %10.2f |  %10.2f | %10.2f |", laiko_intervalas, Automobilis_1.nuvaziotas_atstumas(), Automobilis_2.nuvaziotas_atstumas() )
				);
				
			}
			System.out.println ( "---------------------------------------" );
			// atstumas_tarp_automobiliu
		}	
			
	}