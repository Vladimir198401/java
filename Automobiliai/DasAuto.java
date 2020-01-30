	package Automobiliai;

	import java.io.*;
	
	public class DasAuto {
			
		public static void main ( String[] args ) {
		
			String s;
			Auto Automobilis_1;
			Auto Automobilis_2;
			
			double greitis = 0.0;
			double laiko_intervalas = 0.0;
			double laiko_intervalas_x = 0.0;
			double liko_nuvaziuoti_1 = 0.0;
			double liko_nuvaziuoti_2 = 0.0;
			double maza_paklaida = 0.01;
			
			double atstumas_tarp_automobiliu  = 0.0;
			double atstumas_tarp_automobiliu_x = 0.0;
	
			double Atstumas = 0.0;
			double sveikas = 0.0;
			
			
				InputStreamReader stream = new InputStreamReader(System.in);
					
				BufferedReader reader=new BufferedReader(stream);	
				
				System.out.println ( " Masinu aikstele:" );
		
						Automobilis_1 = new Auto ();		
			
						Automobilis_2 = new Auto ();
							
			try{
					
					System.out.println ();
			
					System.out.println ( " ivesti laika Sekundem" );
					s= reader.readLine();
					laiko_intervalas = Double.parseDouble( s ); 

					System.out.println ( "ivesti greiti 1 automobiliui" );
					s= reader.readLine();
					greitis  = Double.parseDouble( s ); 	
					
						Automobilis_1.keistiGreiti (greitis);
						
					System.out.println ( "ivesti greiti 2 automobiliui" );
					s= reader.readLine();
					greitis = Double.parseDouble( s ); 	
						
						Automobilis_2.keistiGreiti (greitis);
				
					System.out.println ( " ivesti automobiliu atstuma Metrais" );
					s= reader.readLine();
					Atstumas = Double.parseDouble( s ); 
						
			} catch ( IOException e ) {
				
			System.out.println ( "Skaitymo klaida" );
				
			}
			
			System.out.println ( "------------------------------------------------------" );
			System.out.println ( "|   Laikas |  Nuvaziuotas atstumas Metrais           |" );
			System.out.println ( "|             |   Auto1   | Atstumas tarp |  Auto 2  |" );
			System.out.println ( "------------------------------------------------------" );
			
			
			while ( ( Automobilis_1.nuvaziotas_atstumas() <= ( Atstumas - maza_paklaida  ) ) || ( Automobilis_2.nuvaziotas_atstumas() <= ( Atstumas  - maza_paklaida ) ) )  {
				
					sveikas += laiko_intervalas;
			
				if ( Automobilis_1.nuvaziotas_atstumas() < Atstumas ) {
					
					liko_nuvaziuoti_1  =  Atstumas - Automobilis_1.nuvaziotas_atstumas();  
					
					laiko_intervalas_x = laiko_intervalas;
					
					if ( ( Automobilis_1.greitis * laiko_intervalas ) > liko_nuvaziuoti_1 ) {
												
						laiko_intervalas_x = liko_nuvaziuoti_1  / Automobilis_1.greitis;
						
							atstumas_tarp_automobiliu  =  Atstumas - (Automobilis_1.nuvaziotas_atstumas() + Automobilis_2.nuvaziotas_atstumas());
							
							if ( atstumas_tarp_automobiliu_x <= 0 ) {
							
							atstumas_tarp_automobiliu_x = (Automobilis_1.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)) + (Automobilis_2.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)))) - Atstumas;
					  
							}
							
							atstumas_tarp_automobiliu_x = (Automobilis_1.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)) + (Automobilis_2.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)))) - Atstumas;
						
							if(atstumas_tarp_automobiliu_x > Atstumas) {
								
							atstumas_tarp_automobiliu_x = Atstumas;
								
							}
						
						
						System.out.println (
							String.format(  "| %10.0f |  %10.0f | %10.0f | %10.0f |" , 
								(sveikas - ( laiko_intervalas - laiko_intervalas_x)),		
									Atstumas,
										atstumas_tarp_automobiliu_x,
											atstumas_tarp_automobiliu_x));
							
					}
				
					Automobilis_1.judeti ( laiko_intervalas_x );
														
				}
				
				if ( Automobilis_2.nuvaziotas_atstumas() < Atstumas ) {
					
					liko_nuvaziuoti_2  = Atstumas - Automobilis_2.nuvaziotas_atstumas();  
					
					laiko_intervalas_x = laiko_intervalas;
					
					if ( ( Automobilis_2.greitis * laiko_intervalas ) > liko_nuvaziuoti_2 ) {
						
						laiko_intervalas_x = (liko_nuvaziuoti_2  / Automobilis_2.greitis);
							
							atstumas_tarp_automobiliu  =  Atstumas - (Automobilis_1.nuvaziotas_atstumas() + Automobilis_2.nuvaziotas_atstumas());
							
							if ( atstumas_tarp_automobiliu_x <= 0 ) {
							
							atstumas_tarp_automobiliu_x = (Automobilis_1.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)) + (Automobilis_2.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)))) - Atstumas;
					  
							}
							
							atstumas_tarp_automobiliu_x = (Automobilis_1.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)) + (Automobilis_2.greitis * (sveikas - ( laiko_intervalas - laiko_intervalas_x)))) - Atstumas;
						
							if(atstumas_tarp_automobiliu_x > Atstumas) {
								
							atstumas_tarp_automobiliu_x = Atstumas;
								
							}
						System.out.println ( 
							String.format( "| %10.0f |  %10.0f | %10.0f | %10.0f |",
								(sveikas - ( laiko_intervalas - laiko_intervalas_x)),
									atstumas_tarp_automobiliu_x, // - ((laiko_intervalas_x * Automobilis_1.greitis) /2 ),  
										atstumas_tarp_automobiliu_x, //(laiko_intervalas_x * Automobilis_1.greitis),
											(laiko_intervalas_x + sveikas - laiko_intervalas)  * greitis));
						
					}	
				
					Automobilis_2.judeti ( laiko_intervalas_x );
					
				}
				
					atstumas_tarp_automobiliu  =  Atstumas - (Automobilis_1.nuvaziotas_atstumas() + Automobilis_2.nuvaziotas_atstumas());
				
				if ( atstumas_tarp_automobiliu <= 0 ) {
				
					atstumas_tarp_automobiliu = (Automobilis_1.nuvaziotas_atstumas() + Automobilis_2.nuvaziotas_atstumas() - Atstumas);
		  
				}
				
				System.out.println ( 
					String.format( "| %10.0f |  %10.0f | %10.0f | %10.0f |",
						sveikas,
							Automobilis_1.nuvaziotas_atstumas(),
								atstumas_tarp_automobiliu,
									Automobilis_2.nuvaziotas_atstumas())
				);
				
			}
			System.out.println ( "------------------------------------------------------" );
		
		}	
	}