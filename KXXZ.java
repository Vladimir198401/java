import java.sql.*;

public class KXXZ {
																																										// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/prekyba";

																																										//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		
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
			
			System.out.println ( "----------------------------------------------------------------------------------------------------------------------------------------------" );
			System.out.println ( "| id |     menuo  |   id_prekes   |  id_grupes  |   id_rinkos  |   kiekis_gauta   | suma_gauta | kiekis_parduota | suma_parduota |" );
			System.out.println ( "----------------------------------------------------------------------------------------------------------------------------------------------" );

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
				float kiekies_parduota = rs.getFloat ("kiekis_parduota");
				float suma_parduota = rs.getFloat ("suma_parduota");
																																										//Display values
				System.out.println ( 

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
			}
																																										//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

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
}																																									//end FirstExample