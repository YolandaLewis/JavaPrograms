package assignment6;

import java.sql.*;
import java.io.*;

public class UserTable {

		public static void main(String[] args) {
			
		//Create global strings for Table Names
				String UserTable = "USERS";
				
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
			         String dropString = "DROP TABLE " + UserTable;
			         stmt.executeUpdate(dropString);
			         }
			      catch (SQLException se) {/*do nothing*/} // table doesn't exist

			      try {
			         /***********************************************************************
			         *  create the movies table and the movies category table...
			         ***********************************************************************/
			         System.out.print( "Building new " + UserTable + " table...\n\n" );
			         String createString ="CREATE TABLE " + UserTable +  
			         		"       (USERID INTEGER," + 
			         		"        GENDER VARCHAR2(3)," + 
			         		"        AGE INTEGER, " + 
			         		"        OCCUPATION INTEGER, " + 
			         		"        ZIPCODE VARCHAR2(10), " + 
			         		"        PRIMARY KEY (USERID))";
			         stmt.executeUpdate(createString);
			         
			         System.out.print("User table successfully created..\n\n");		                
			         /***********************************************************************
			         *  now populate the movies table...
			         ***********************************************************************/
			     
			         
			         PreparedStatement updateRATINGS = conn.prepareStatement( "INSERT INTO " + UserTable + " Values (?, ?, ?, ?, ? )");
						conn.setAutoCommit(false);
			         
					System.out.print( "Inserting rows in USERS table...\n\n" );
				  	BufferedReader ratingsFileReader = new BufferedReader(new FileReader("src/assignment6/users.dat")); 
				  	String fileLine = ratingsFileReader.readLine();
						
				  		while (fileLine != null){
				  				String[] fileStr = fileLine.split("::");
				  				String v_USERID = fileStr[0];  
				  				String v_GENDER = fileStr[1];
				  				String v_AGE = fileStr[2];
				  				String v_OCCUPATION = fileStr[3];
				  				String v_ZIPCODE = fileStr[4];
				  				
				  				
				  				//System.out.println(v_USERID + "\t" + v_GENDER + "\t" + v_AGE + "\t" + v_OCCUPATION);
				  			
				  				updateRATINGS.setString(1, v_USERID);
				  				updateRATINGS.setString(2, v_GENDER);
				  				updateRATINGS.setString(3, v_AGE);
				  				updateRATINGS.setString(4, v_OCCUPATION);
				  				updateRATINGS.setString(5, v_ZIPCODE);
				  				updateRATINGS.executeUpdate();
				  				fileLine = ratingsFileReader.readLine();		  				
				  			}
				  		conn.commit();
				  	
					
				  	System.out.print("Data sucessfully loaded into the user table..\n\n" );	  		    
			         /***********************************************************************
			         *  finally, display all the rows in the database...
			         ***********************************************************************/
			         System .out.println("Querying User table to display all rows..\n\n");
			         
				  	 ResultSet rset = stmt.executeQuery( "SELECT * FROM " + UserTable );
			         
			         while( rset.next() ){
			            System.out.println( rset.getString("USERID") + ": " +
			               rset.getString("GENDER") + ": " + rset.getString("AGE") + ": " + rset.getString("OCCUPATION")+ 
			               ": " + rset.getString("ZIPCODE"));
			         }
			         
			         
			         System.out.println("creating and updating user table completed sucessfully!\n\n");
			         rset.close();
			         stmt.close();
			         conn.close();
			         ratingsFileReader.close();
			         }
			     
			      catch (SQLException se) {System.out.println( "SQL ERROR: " + se );} 
			      catch (NullPointerException e) {System.out.println(" End of File Reached.. All values inserted into user table.");}
			      catch (FileNotFoundException e) {e.printStackTrace();} 
			      catch (IOException e) {e.printStackTrace();}
			      

			   } // end main


			  }  // end class

