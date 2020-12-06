package assignment6;

import java.sql.*;
import java.io.*;

public class LoadRatingsTable {

	public static void main(String[] args) {
		
	//Create global strings for Table Names
			String ratingsTable = "movies_RATINGS";
			
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
		         String dropString = "DROP TABLE " + ratingsTable;
		         stmt.executeUpdate(dropString);
		         }
		      catch (SQLException se) {/*do nothing*/} // table doesn't exist

		      try {
		         /***********************************************************************
		         *  create the movies table and the movies category table...
		         ***********************************************************************/
		         System.out.print( "Building new " + ratingsTable + " table...\n\n" );
		         String createString ="CREATE TABLE " + ratingsTable + 
		         		" (rating_USERID INTEGER," + 
		         		"  rating_MOVIEID INTEGER," + 
		         		"  movie_RATING INTEGER," + 
		         		"  rating_TIMESTAMP INTEGER," + 
		         		"  primary key(rating_USERID,rating_MOVIEID))";
		         stmt.executeUpdate(createString);
		         
		         
		         
		           System.out.print("Movie rating table updated sucessfully..\n\n");     
		         /***********************************************************************
		         *  now populate the movies table...
		         ***********************************************************************/
		         PreparedStatement updateRATINGS = conn.prepareStatement( "INSERT INTO " + ratingsTable + " Values (?, ?, ?, ? )");
					conn.setAutoCommit(false);
		         
				System.out.print( "Inserting rows in RATINGS table...\n\n" );
			  	BufferedReader ratingsFileReader = new BufferedReader(new FileReader("src/assignment6/ratings-Oracle.dat")); 
			  	String fileLine = ratingsFileReader.readLine();
					
			  		while (fileLine != null){
			  				String[] fileStr = fileLine.split(",");
			  				String v_USERID = fileStr[0];  
			  				String v_MOVIEID = fileStr[1];
			  				String v_RATING = fileStr[2];
			  				String v_TIMESTAMP = fileStr[3];
			  				
			  				System.out.println(v_USERID + "\t" + v_MOVIEID + "\t" + v_RATING + "\t" + v_TIMESTAMP);
			  			
			  				updateRATINGS.setString(1, v_USERID);
			  				updateRATINGS.setString(2, v_MOVIEID);
			  				updateRATINGS.setString(3, v_RATING);
			  				updateRATINGS.setString(4, v_TIMESTAMP);
			  				updateRATINGS.executeUpdate();
			  				fileLine = ratingsFileReader.readLine();		  				
			  			}
			  		conn.commit();
			  	
				
			  	System.out.print("Data sucessfully loaded into the movie ratings table..\n\n");
			  	
		         /***********************************************************************
		         *  finally, display all the rows in the database...
		         ***********************************************************************/
		        System.out.print("Now Querying the database for the rows loaded into the ratings table....\n\n");
			  	
			  	ResultSet rset = stmt.executeQuery( "SELECT * FROM " + ratingsTable );
		         
		         while( rset.next() ){
		            System.out.println( rset.getString("rating_USERID") + ": " +
		               rset.getString("rating_MOVIEID") + ": " + rset.getString("movie_RATING") + ": " + rset.getString("rating_TIMESTAMP"));
		         }
		         
		         stmt.executeQuery("SELECT COUNT (*) FROM " + ratingsTable);
		         
		         System.out.print("Loading Data into Ratings table sucessfully completed!\n\n");
		         rset.close();
		         stmt.close();
		         conn.close();
		         ratingsFileReader.close();
		         }
		      catch (SQLException se) {System.out.println( "SQL ERROR: " + se );} 
		      
		      catch (FileNotFoundException e) {e.printStackTrace();} 
		      catch (IOException e) {e.printStackTrace();}

		   } // end main


		  }  // end class

