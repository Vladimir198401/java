
import stud.Lentelex;

import java.sql.*;
import java.awt.*;        // Using AWT containers and components
import java.awt.event.*;  // Using AWT events classes and listener interfaces
import java.io.*;

public class KXXZ extends Frame
implements KeyListener, ActionListener, WindowListener {
																																										// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/prekyba";
	
	private TextField tfInput;
	private TextArea taDisplayTekstas;  // Declare a TextField component
	static String isvedami_duomenys = "";
	private Button btnNuskaityti;    // Declare a Button component	
	private int ta_simboliu = 0;
																																					//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		
		new KXXZ ();
		try{
																																							//STEP 2: Register JDBC driver
			// Class.forName( "com.mysql.jdbc.Driver" );																				 // .newInstance();
																																						//STEP 3: Open a connection
			System.out.println( "Connecting to database..." );
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
																															//STEP 4: Execute a query
			System.out.println( "Creating statement..." );
			stmt = conn.createStatement();
			String sql;
			sql = 
				"SELECT "
					+ "`id`"
					+ ", `menuo`"
					+ ", `id_prekes`"
					+ ", `id_grupes`"
					+ ", `id_rinkos`"
					+ ", `kiekis_gauta` "
					+ ", `suma_gauta` "
					+ ", `kiekis_parduota` "
					+ ", `suma_parduota` "
				+ "FROM " 
					+ "`prekiu_balansas`"
					;
			ResultSet rs = stmt.executeQuery(sql);
			
			String[] proceso_antr = { 
					"|   id   |"
					, "  menuo  |"
					, " prekes |"
					, " grupes |"
					, " rinkos |"
					, " kiekis |"
					, "      suma    |"
					, " kiekis |"
					, "     suma     |" 
			}; 
			String[] reiksmes = { "", "", "", "", "", "", "", "", "" };
			
			String kepure =  "|        |         |             id           |       gauta           |       parduota        |\n"; //  "     menuo  |   id_prekes   |  id_grupes  |   id_rinkos  |   kiekis_gauta   | suma_gauta | kiekis_parduota | suma_parduota |" );
			Lentelex lent = new Lentelex ( proceso_antr, kepure );
			

			lent.antraste();
			
			//System.out.println ( "----------------------------------------------------------------------------------------------------------------------------------------------" );
			//System.out.println ( "| id |     menuo  |   id_prekes   |  id_grupes  |   id_rinkos  |   kiekis   | suma | kiekis_parduota | suma_parduota |" );
			//System.out.println ( "----------------------------------------------------------------------------------------------------------------------------------------------" );
			
			

																																										//STEP 5: Extract data from result set
			while ( rs.next() ) {
				
																																										//Retrieve by column name
				int id  = rs.getInt ("id");
				int menuo = rs.getInt ( "menuo" );
				int id_prekes = rs.getInt ( "id_prekes" );
				int id_grupes = rs.getInt ( "id_grupes" );
				int id_rinkos = rs.getInt ("id_rinkos");
				int kiekis_gauta = rs.getInt ( "kiekis_gauta" );
				double suma_gauta = rs.getDouble ( "suma_gauta" );
				int kiekis_parduota = rs.getInt ("kiekis_parduota");
				double suma_parduota = rs.getDouble ("suma_parduota");
																																										//Display values
				/*System.out.println ( 

					String.format (

						"| %10d | %10d | %10d | %10d | %10d | %10d | %10.2f | %10.2f | %10.2f |"
						, id 
						, menuo
						, id_prekes
						, id_grupes
						, id_rinkos
						, kiekis_gauta
						, suma_gauta
						, kiekies_parduota
						, suma_parduota
					) 
				);
				System.out.println ( "----------------------------------------------------------------------------------" );
				*/
				
				//reiksmes [ 0 ] = laikas ( t );
				//reiksmes [ 1 ] = String.format ( " %7.2f", s );
				reiksmes [ 0 ] = String.format ( " %5d", id );
				reiksmes [ 1 ] = String.format ( " %6d", menuo );
				reiksmes [ 2 ] = String.format ( " %5d", id_prekes );
				reiksmes [ 3 ] = String.format ( " %5d", id_grupes );
				reiksmes [ 4 ] = String.format ( " %5d", id_rinkos );
				reiksmes [ 5 ] = String.format ( " %5d", kiekis_gauta );
				reiksmes [ 6 ] = String.format ( " %11.2f", suma_gauta );
				reiksmes [ 7 ] = String.format ( " %5d", kiekis_parduota );
				reiksmes [ 8 ] = String.format ( " %11.2f", suma_parduota );
				
				lent.iLentele ( reiksmes );
			}
																																										//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			
			isvedami_duomenys += lent.atiduok();	

		} catch ( SQLException se ) {
																																										//Handle errors for JDBC
			se.printStackTrace();
		} catch ( Exception e ) {
																																										//Handle errors for Class.forName
			e.printStackTrace();

		} finally {
																																										//finally block used to close resources
			try{
					if (stmt != null) {

						stmt.close();
					}

			}catch ( SQLException se2 ){

			}																																							// nothing we can do
			
			try{

				if ( conn!=null ) {

					conn.close();
				}

			} catch ( SQLException se ) {

				se.printStackTrace();
			}																																							//end finally try
		}																																								//end try
		System.out.println( "Goodbye!" );
	}																																								//end main
	

public KXXZ() {
		
		setLayout(new FlowLayout()); // "super" Frame sets to FlowLayout
		add(new Label("Iveskite barkoda: "));
		tfInput = new TextField(12);
		add(tfInput);
		btnNuskaityti = new Button("Nuskaityti duomenu baze");  // Construct the Button
		add(btnNuskaityti);                   // "super" Frame adds Button
		taDisplayTekstas = new TextArea(50, 80); // Construct the TextField
		taDisplayTekstas.setFont(new Font("monospaced", Font.PLAIN, 11));	
		taDisplayTekstas.setEditable(false);       // read-only
		add(taDisplayTekstas);                     // "super" Frame adds TextField
		tfInput.addKeyListener(this);
		// tfInput TextField (source) fires KeyEvent.
		// tfInput adds "this" object as a KeyEvent listener.
		
		btnNuskaityti.addActionListener(this);
		// btnCount (source object) fires ActionEvent upon clicking
		// btnCount adds "this" object as an ActionEvent listener

		addWindowListener(this);
		// "super" Frame (source object) fires WindowEvent.
		// "super" Frame adds "this" object as a WindowEvent listener.kvailai
	 
		setTitle("Balanso lentele"); // "super" Frame sets title
		setSize(700, 750);            // "super" Frame sets initial size
		setVisible(true);             // "super" Frame shows
	}	
	//end main
	
	/** KeyEvent handlers */
	@Override public void keyTyped(KeyEvent evt) {
		taDisplayTekstas.append("" +evt.getKeyChar());
		ta_simboliu += 1;
	}
	
	// Not Used, but need to provide an empty body for compilation
	@Override public void keyPressed(KeyEvent evt) { }
	@Override public void keyReleased(KeyEvent evt) { }
	
	/* ActionEvent handler */
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getActionCommand().equals("Nuskaityti duomenu baze")){
			
			ta_simboliu += "Belekas".length();
			taDisplayTekstas.append("Belekas");
			// Dimension dim = taDisplayTekstas.getPreferredSize();
			taDisplayTekstas.replaceRange(isvedami_duomenys, 0, ta_simboliu );
			ta_simboliu = isvedami_duomenys.length();			
			
		}
	}

	@Override public void windowClosing(WindowEvent evt) {
		System.exit(0);  // Terminate the program
	}
 
	// Not Used, BUT need to provide an empty body to compile.
	@Override public void windowOpened(WindowEvent evt) { }
	@Override public void windowClosed(WindowEvent evt) { }
	// For Debugging
	@Override public void windowIconified(WindowEvent evt) { System.out.println("Window Iconified"); }
	@Override public void windowDeiconified(WindowEvent evt) { System.out.println("Window Deiconified"); }
	@Override public void windowActivated(WindowEvent evt) { System.out.println("Window Activated"); }
	@Override public void windowDeactivated(WindowEvent evt) { System.out.println("Window Deactivated"); }

}	//end program