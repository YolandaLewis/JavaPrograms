package assignment6;

import java.sql.*;
import java.io.*;

public class Age_and_OccupationTables {
	public static void main(String[] args) {
		
		//Create global strings for Table Names
				String ageTable = "age_Description";
				String occupTable = "occupation_Description";
				
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

			         conn = DriverManager.getConnection("jdbc:oracle:thin:@acadoradbprd01.dpu.depaul.edu:1521:ACADPRD0", "userName", "Password");


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
			         String dropString = "DROP TABLE " + ageTable;
			         stmt.executeUpdate(dropString);
			         
			         String dropString2 = "DROP TABLE " + occupTable;
			         stmt.executeUpdate(dropString2);
			         
			         }
			      catch (SQLException se) {/*do nothing*/} // table doesn't exist

			      try {
			         /***********************************************************************
			         *  create the age and occupation tables...
			         ***********************************************************************/
			         System.out.print( "Building new " + ageTable + " table...\n\n" );
			         String createString ="CREATE TABLE " + ageTable +  
			         		"    (AGE INTEGER," + 
			         		"     DESCRIPTION VARCHAR2(20))";
			         stmt.executeUpdate(createString);
			         System.out.print("AGE description table successfully created..\n\n");	
			         
			         
			         System.out.print( "Building new " + occupTable + " table...\n\n" );
			         String createString2 ="CREATE TABLE " + occupTable +  
			         		"    (OccupationID INTEGER," + 
			         		"     Occupation_DESCRIPTION VARCHAR2(50))";
			         stmt.executeUpdate(createString2);
			         
			         System.out.print("Occupation table successfully created..\n\n");	
			         
			         /***********************************************************************
			         *  now populate the age table...
			         ***********************************************************************/
			     
			       //insert data into age Table
			         
			         PreparedStatement updateAgeTable = conn.prepareStatement( "INSERT INTO " + ageTable + " Values (?, ? )");
						conn.setAutoCommit(false);
			         
					System.out.print( "Inserting rows into age_Description table...\n\n" );
				  	BufferedReader ageFileReader = new BufferedReader(new FileReader("src/assignment6/age_Decoder.txt")); 
				  	String fileLine = ageFileReader.readLine();
						
				  		while (fileLine != null){
				  				String[] fileStr = fileLine.split(",");
				  				String v_Age = fileStr[0];  
				  				String v_Description = fileStr[1];
				  				
				  				System.out.println(v_Age + "\t" + v_Description );
				  			
				  				updateAgeTable.setString(1, v_Age);
				  				updateAgeTable.setString(2, v_Description);
				  				updateAgeTable.executeUpdate();
				  				fileLine = ageFileReader.readLine();		  				
				  			}
				  		conn.commit();
				  	
					
				  	System.out.print("Data sucessfully loaded into the Age table..\n\n" );	
				  	
				  	/**************************************************************************************
			         *  now populate the Occupation table...
			         ***********************************************************************/
				  	
				  	PreparedStatement updateOccupationTable = conn.prepareStatement( "INSERT INTO " + occupTable + " Values (?, ? )");
					conn.setAutoCommit(false);
		         
				System.out.print( "Inserting rows into Occupation table...\n\n" );
			  	BufferedReader OccupationFileReader = new BufferedReader(new FileReader("src/assignment6/occupation_Decoder.txt")); 
			  	String fileLine2 = OccupationFileReader.readLine();
					
			  		while (fileLine2 != null){
			  				String[] fileStr2 = fileLine2.split(",");
			  				String v_OccupationID = fileStr2[0];  
			  				String v_OccupationDescription = fileStr2[1];
			  				
			  				System.out.println(v_OccupationID + "\t" + v_OccupationDescription );
			  			
			  				updateOccupationTable.setString(1, v_OccupationID);
			  				updateOccupationTable.setString(2, v_OccupationDescription);
			  				updateOccupationTable.executeUpdate();
			  				fileLine2 = OccupationFileReader.readLine();		  				
			  			}
			  		conn.commit();
			  		System.out.print("Data sucessfully loaded into the Occupation table..\n\n" );
			  		
			         /***********************************************************************
			         *  finally, display all the rows in the databases...
			         ***********************************************************************/
			         System .out.println("Querying Age table to display all rows..\n\n");
			         ResultSet rset = stmt.executeQuery( "SELECT * FROM " + ageTable );
			         
			         while( rset.next() ){
			            System.out.println( rset.getString("AGE") + ": " +
			               rset.getString("Description"));
			         }
			         
			         System.out.println("Querying the Occupation Table to display all rows..\n\n");
			         ResultSet rset2 = stmt.executeQuery( "SELECT * FROM " + occupTable );
			         
			         while( rset2.next() ){
			            System.out.println( rset2.getString("OccupationID") + ": " +
			               rset2.getString("Occupation_DESCRIPTION"));
			         }
		
			         
			         System.out.println("creating and updating Age and Ocuupation tables completed sucessfully!");
			                
			        
			         OccupationFileReader.close();
			         ageFileReader.close();
			         rset.close();
			         stmt.close();
			         conn.close();
			         
			         }
			     
			      catch (SQLException se) {System.out.println( "SQL ERROR: " + se );} 
			      catch (NullPointerException e) {System.out.println(" End of File Reached.. All values inserted into user table.");}
			      catch (FileNotFoundException e) {e.printStackTrace();} 
			      catch (IOException e) {e.printStackTrace();}
			      

			   } // end main

} //end class
