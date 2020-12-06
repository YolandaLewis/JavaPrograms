package assignment6;

import java.sql.*;
import java.io.*;

public class MovieDatabase {

	public static void main(String[] args) {
	
//Create global strings for Table Names
		String moviesTable = "MOVIES";
		
	     Connection conn = null;
	      Statement stmt = null;
	      

	      /***********************************************************************
	      *  determine if the JDBC driver exists and load it...
	      ***********************************************************************/
	      System.out.print( "\nLoading JDBC driver...\n\n" );
	      try {
	         Class.forName("oracle.jdbc.OracleDriver");
	         }
	      catch(ClassNotFoundException e) {
	         System.out.println(e);
	         System.exit(1);
	         }

	      /***********************************************************************
	      *  establish a connection to the database...
	      ***********************************************************************/
	      try {
	         System.out.print( "Connecting to ACADPRD0 database...\n\n" );
	         //String url = dataSource + dbName;

	         conn = DriverManager.getConnection("jdbc:oracle:thin:@acadoradbprd01.dpu.depaul.edu:1521:ACADPRD0", "ylewis4", "cdm1871263");


	         /*conn = dbms.equals("localAccess") ? DriverManager.getConnection(url)
	            : DriverManager.getConnection(url, userName, password );*/
	         System.out.println( "Connected to database ACADPRD0..." );

	         /***********************************************************************
	         *  create an object by which we will pass SQL stmts to the database...
	         ***********************************************************************/
	         stmt = conn.createStatement();
	         }
	      catch (SQLException se) {
	         System.out.println(se);
	         System.exit(1);
	         }
	      

	      /***********************************************************************
	      *  in the event that this table already exists, we want to delete it
	      *  and build a new table from scratch... if the table doesn't exist,
	      *  an SQLException would be thrown when the DROP TABLE stmt below is
	      *  executed. We catch that exception, but we don't need to do anything
	      *  because we expect the error to occur if the table doesn't exist...
	      ***********************************************************************/
	      try {
	         String dropString = "DROP TABLE " + moviesTable;
	         stmt.executeUpdate(dropString);
	         }
	      catch (SQLException se) {/*do nothing*/} // table doesn't exist

	      try {
	         /***********************************************************************
	         *  create the movies table and the movies category table...
	         ***********************************************************************/
	         System.out.print( "Building new " + moviesTable + " table...\n\n" );
	         String createString =
	            "CREATE TABLE " + moviesTable +
	            "  (MOVIEID INTEGER PRIMARY KEY," +
	            "   TITLE VARCHAR(128)," +
	            "   GENRE VARCHAR(128))";
	         stmt.executeUpdate(createString);
	         
	         System .out.print("The Movie Table was successfully created..\n\n");
	         
	         System.out.print("The Movie Table is being altered. A year Column is being added to the movies table.\n\n");
	         String alterString= "ALTER TABLE " + moviesTable + " ADD (YEAR VARCHAR2(200))";
	         stmt.executeUpdate(alterString);
	         
	                
	         /***********************************************************************
	         *  now populate the movies table...
	         ***********************************************************************/
	         PreparedStatement updateMovies = conn.prepareStatement( "INSERT INTO " + moviesTable + " Values (?, ?, ?, ? )");
				conn.setAutoCommit(false);
	         
			System.out.print( "Inserting rows in movies table...\n\n" );
		  	BufferedReader movieFileReader = new BufferedReader(new FileReader("src/assignment6/movies.dat")); 
		  	String fileLine = movieFileReader.readLine();
				
		  		while (fileLine != null){
		  				String[] fileStr = fileLine.split("::");
		  				String v_movieID = fileStr[0];  
		  				String v_Title = fileStr[1].substring(0, fileStr[1].length()-7);
		  				String v_Genre = fileStr[2];
		  				String v_year = fileStr[1].substring(fileStr[1].length()-6);
		  				
		  				//System.out.println(v_movieID + "\t" + v_Title + "\t" + v_Genre);
		  			
		  				updateMovies.setString(1, v_movieID);
		  				updateMovies.setString(2, v_Title);
		  				updateMovies.setString(3, v_Genre);
		  				updateMovies.setString(4, v_year);
		  				updateMovies.executeUpdate();
		  				fileLine = movieFileReader.readLine();		  				
		  			}
		  		conn.commit();
		  	
			
		  		System.out.print("Data successfully loaded into the Movies table.\n\n");	  		    
	         /***********************************************************************
	         *  finally, display all the rows in the database...
	         ***********************************************************************/
		  	
		  		System.out.print("Querying the Movies table.\n\n");
		  		
		  	 ResultSet rset = stmt.executeQuery( "SELECT * FROM " + moviesTable );
	         
	         while( rset.next() ){
	            System.out.println( rset.getString("MOVIEID") + ": " +
	               rset.getString("TITLE") + ": " + rset.getString("GENRE") );
	         }
	         
	         System.out.print("Program to insert data and remove year from title completed sucessfully..\n\n ");
	         rset.close();
	         stmt.close();
	         conn.close();
	         movieFileReader.close();
	         }
	      catch (SQLException se) {System.out.println( "SQL ERROR: " + se );} 
	      
	      catch (FileNotFoundException e) {e.printStackTrace();} 
	      catch (IOException e) {e.printStackTrace();}

	   } // end main


	  }  // end class

