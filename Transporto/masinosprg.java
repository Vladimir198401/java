
	package Transporto;

	import java.io.*;
		
	public static void main ( String[] args ) {
					
			
			boolean has_header = true;			
			String s;
			Masina [] masinos = new Masina [ 100 ];
			int k = 0;	
			int i;
			Double sanaudu_proc_mieste = 0.0;
						
			InputStreamReader stream = new InputStreamReader(System.in);
				
			BufferedReader reader=new BufferedReader(stream);	
			
			System.out.println ( " Masinu aikstele:" );
			
			try {
				
				FileReader fr=new FileReader( "masinu_sarasas.csv" );
				BufferedReader frx = new BufferedReader ( fr );

				while ( ( s = frx.readLine() ) != null ) {
					
					if ( ! has_header ) { 
						
						String[] ss = s.split ( "," );
						
						System.out.println ( ss [ 0 ] + ":" + ss[ 1 ] + ":" + ss [ 2 ] ); 
						masinos [ k ] = new Masina ( ss [ 0 ], Double.parseDouble ( ss [ 1 ] ), Double.parseDouble ( ss [ 2 ] ) );

						k++;
					
					} else {

						has_header = false;						
					}
				}
				fr.close();  
				
				System.out.println ( "Nuskaityta automobiliu: " + k ); 
				
				System.out.println ( "sanaudos_mieste? " );
				s= reader.readLine();
				sanaudu_proc_mieste = Double.parseDouble( s ); 					
				
				i = 0;
				System.out.println ( " Nuskaitytos masinas is failo: " );

				while ( i < k ) {
					
					System.out.println ( masinos [ i ].present( sanaudu_proc_mieste )  );
					i++;
				}	
				
				System.out.println ();
							

			} catch ( IOException e ) {
				
				System.out.println ( "Skaitymo klaida" );
			}
			
			boolean flag_pasiimti_min = true;
			
			int t_masinos = -1; // reiksme -1 uztikrina kad perrenkant dezes, tokios nebus , tai bus mums tinkama deze
		
			for ( i = 0; i < k; i++ ) {
			
				if ( flag_pasiimti_min )  {
				
					t_masinos = i;

					flag_pasiimti_min = false;
					
				} else {
				
					if ( masinos [ t_masinos ].vidurkis( sanaudu_proc_mieste ) > masinos [ i ].vidurkis( sanaudu_proc_mieste ) ) {
					
						t_masinos = i;
					}
				
				}
				masinos [ i ].nustatyti ( true );
			}
			
			System.out.println ( "Pertikrintas sąrašas" );
			 
			for ( i = 0; i < k; i++ ) {			
				
					System.out.print ( masinos [ i ].present( sanaudu_proc_mieste ) );
					
					if ( masinos [ i ].kokia ()  ) {
				
					if ( i == t_masinos ) {
						
						System.out.print ( " maziausia " );
					}
					System.out.println();
				}
			}
			
			System.out.println ( "Tinkamiausias automobilis (jis pažymėtas sąraše):\n" + masinos [ t_masinos ].present ( sanaudu_proc_mieste ) );
			
			// rikiuojam Burbuliukas - Akmenukas 
			
			System.out.println ( "Automobiliai surikiuoti pagal tinkamumą\n" );
			
			boolean netvarka = true;  // ! tegyvuoja chaosas
			
			while ( netvarka ) {
				
				netvarka = false; // ! o gal vis tik yra tvarka?
			
				for ( i = 0; i < k - 1; i++ ) {
		
					if ( masinos [ i ].vidurkis( sanaudu_proc_mieste ) > masinos [ i  + 1 ].vidurkis( sanaudu_proc_mieste ) ) {
						
						Masina tarp = masinos [  i  ];
						masinos [ i ] = masinos [ i + 1 ];
						masinos [ i + 1 ] = tarp;
					
						netvarka = true; // ne vis tik dar yra netvarka .. :(
					}
				}
			}

			for ( i = 0; i < k; i++ ) {			
				
				System.out.println ( masinos [ i ].present( sanaudu_proc_mieste ) );
			}			
			
		}
	}