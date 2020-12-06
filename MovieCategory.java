package assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieCategory {
	public static void main(String[] args) {
		
				String movieCategory = "movie_Category";

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
			      *  establish a connection to   the database...
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
			         String dropString = "DROP TABLE " + movieCategory;
			         stmt.executeUpdate(dropString);
			         }
			      catch (SQLException se) {/*do nothing*/} // table doesn't exist

			      try {
			         /***********************************************************************
			         *  create the new table...
			         ***********************************************************************/
			         System.out.print( "Building new " + movieCategory + " table...\n\n" );
			         String createMovieCategoryString =
			 	            "CREATE TABLE " + movieCategory +
			 	            "  (CATEGORY_MOVIEID INTEGER," +
			 	            "   CATEGORY VARCHAR2(128)," +
			 	            "   FOREIGN KEY (CATEGORY_MOVIEID) references MOVIES (MOVIEID))";
			 	         stmt.executeUpdate(createMovieCategoryString);
			         
			 	        System.out.print("Movies Table successfully created.\n\n");
			         /***********************************************************************
			         *  now populate the movies table...
			         ***********************************************************************/
			 	        PreparedStatement updateMovies = conn.prepareStatement( "INSERT INTO " + movieCategory + " Values (?, ? )");
					  	 conn.setAutoCommit(false);
			 	         
			 	        System.out.print( "Inserting rows in movie Category table...\n\n" );
					  	BufferedReader movieFileReader = new BufferedReader(new FileReader("src/assignment6/movies.dat")); 
					  	String fileLine = movieFileReader.readLine();
					  	
					  	while (fileLine != null){
			  				String[] fileStr = fileLine.split("::");
			  				String v_movieID = fileStr[0];  
			  				String[] v_Genre1 = fileStr[2].split("\\|");
			  				
		
			  				for(int i = 0; i < v_Genre1.length; i++){
			  				updateMovies.setString(1, v_movieID);
			  				updateMovies.setString(2, v_Genre1[i] );
			  		
			  				updateMovies.executeUpdate();
			  				fileLine = movieFileReader.readLine();		  				
			  				}
					  	}
			  		conn.commit();
			  		
			  			System.out.print("Data movieID and genres with seperated pipe characters successfully loaded into the movie category table.\n\n");
				  		      
			 	        /***********************************************************************
			 	         *  finally, display all the rows in the database...
			 	         ***********************************************************************/
			  			System.out.print("Querying the Movie Category table for all data in the table.\n\n");    
			  		
			  			ResultSet rset = stmt.executeQuery( "SELECT * FROM " + movieCategory );
			 	         
			 	         while( rset.next() ){
			 	            System.out.println( rset.getString("CATEGORY_MOVIEID") + ": " +
			 	               rset.getString("CATEGORY"));
			 	            
			 	         }
			 	         
			 	         stmt.executeQuery("SELECT COUNT (*) FROM " + movieCategory);
			 	         System.out.print(" Create Seperate Movie Category Program Completed Sucessfully :-) \n\n " );
			 	         
			 	        movieFileReader.close();
			 	         rset.close();
			 	         stmt.close();
			 	         conn.close();
			 	         }
			      
			 	  catch (SQLException se) {System.out.println( "SQL ERROR: " + se );} 
			      catch (FileNotFoundException e) {e.printStackTrace();}
	              catch (IOException e) {e.printStackTrace();}
			 	      
			 	   } // end main


			 	 }  // end class



