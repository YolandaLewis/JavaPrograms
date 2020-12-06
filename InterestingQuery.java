package assignment6;

import java.sql.*;

public class InterestingQuery {
	public static void main( String[] args ) {

	      String tableName = "MOVIES";

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

	      
	      try {
	         /***********************************************************************
	         *  QUERY THE TABLE
	         ***********************************************************************/
	         System.out.print( "Querying " + tableName + " and ratings tables...\n\n" );
	         String queryString1 = 
	        		"SELECT MOVIES.MOVIEID, MOVIES.TITLE, MOVIES_RATINGS.MOVIE_RATING \r\n" +
	        		 "From (MOVIES Join MOVIES_RATINGS ON MOVIES.MOVIEID = MOVIES_RATINGS.RATING_MOVIEID) \r\n" + 
	         		"    where MOVIE_RATING = 4 OR MOVIE_RATING = 5\r\n" + 
	         		"    ORDER BY MOVIES_RATINGS.MOVIE_RATING ASC";
	        		 
	         stmt.executeUpdate(queryString1);
	         

	         /***********************************************************************
	         *  Display Part Numbers and their average days in shipment
	         ***********************************************************************/
	         System.out.println("Now printing all movies that have a rating on 4 or 5 :");
	         ResultSet rset = stmt.executeQuery( queryString1 );
	         
	         while( rset.next() ){
	            System.out.println( rset.getString("MOVIEID") + ": " +
	               rset.getString("TITLE") + ": " + rset.getString("MOVIE_RATING") );
	         }
	         
	         rset.close();
	         stmt.close();
	         conn.close();
	         }
	      catch (SQLException se) {
	         System.out.println( "SQL ERROR: " + se );
	         }

	   } // end main


	  }  // end class

