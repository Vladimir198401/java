
	package Automobiliai;

	import java.io.*;
	
	public class DasAuto {
			
		public static void main ( String[] args ) {
		
			String s;
			Auto [] Automobiliai = new Auto[ 10 ];
			Auto Automobilis_1;
			Auto Automobilis_2;
			double nuvaziotas_atstumas = 0.0;
			double greitis = 0.0;
			double laiko_intervalas = 0.0;
			double atstumas_tarp_automobiliu  = 0.0;
			double judeti = 0.0;	
			double Atstumas = 0.0;
			double keistiGreiti = 0.0;
			//String akva;
			//double praejeslaikas = 0;
			
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
						
						// judeti.laiko_intervalas;  ?

					System.out.println ( "ivesti greiti 1 automobiliui" );
					s= reader.readLine();
					greitis = Double.parseDouble( s ); 	
					
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
			
			
			while ( Automobilis_1.nuvaziotas_atstumas() <= Atstumas  &&  Automobilis_2.nuvaziotas_atstumas() <= Atstumas ) {
				/*
				if (nuvaziotas_atstumas() > Atstumas  ){
				
					nuvaziotas_atstumas() = Atstumas;
				}
				*/
				Automobilis_1.judeti ( laiko_intervalas );
				
				Automobilis_2.judeti ( laiko_intervalas );
				
				judeti += laiko_intervalas; 																// arba galima apseit be klases ir aprasyt tik cia praejeslaikas += laiko_intervalas;
				
				/*
				atstumas_tarp_automobiliu  = akva(Atstumas - (Automobilis_1.nuvaziotas_atstumas() + Automobilis_2.nuvaziotas_atstumas()));
				
				Atstumas / 2 = susitikimo_taskas;
				
				susitikimo_taska = 0
				
				susitikimo_taskas  = akva(Atstumas - (Automobilis_1.nuvaziotas_atstumas() + Automobilis_2.nuvaziotas_atstumas()));
				*/
				
				System.out.println ( 
				
				String.format( "| %10.0f |  %10.0f | %10.0f | %10.0f |",
					judeti,
						Automobilis_1.nuvaziotas_atstumas(),
							Atstumas - (Automobilis_1.nuvaziotas_atstumas() + Automobilis_2.nuvaziotas_atstumas()),
								Automobilis_2.nuvaziotas_atstumas())
				);
				
			}
			System.out.println ( "------------------------------------------------------" );
		
		}	
	}