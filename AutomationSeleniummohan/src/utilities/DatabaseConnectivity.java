package utilities;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DatabaseConnectivity {

	/*
	 * public static String username = "UsersDeveloper";
	 * 
	 * public static String password = "%tHkL58uFT^1^l)#4";
	 */

	ResultSet rs = null;
     public static List<String>  selectQueryforcolumn(String Testquery, String Columnname) throws SQLException, ClassNotFoundException { 
    	 
    	
    	 List<String> results = new ArrayList<String>();
    	 
    	 
    	 try {
			
    		
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Creating connection to the database
     
        //Connection con = DriverManager.getConnection("jdbc:sqlserver://BUIDTP-111;database=LevelsPES; IntegratedSecurity=True" );
        Connection con = DriverManager.getConnection("jdbc:sqlserver://10.20.1.45;database=PESHKDEMO; User=demo_support; Password=L!ghj$supp#nJ98;");

      // Connection con = DriverManager.getConnection("jdbc:sqlserver://10.10.1.101;database=PESHKDEMO; User=UsersDeveloper; Password=%tHkL58uFT^1^l)#4;");
        //Creating statement object
     Statement st = con.createStatement();
        //Executing the SQL Query and store the results in ResultSet
     ResultSet rs = st.executeQuery(Testquery);
     //While loop to iterate through all data and print results
     while (rs.next()) {
    	 
    	 results.add(rs.getString(Columnname));
  
     }
	 //Closing DB Connection
  


    	 }
    	 
    	
    	 catch(Exception sqlException) {
             sqlException.printStackTrace();
             System.out.println("Failed to create the database connection."); 
         }
    	 
    	 
    	 return results;  
    	    
 }
     
     
     
     public static String selectStringQueryforcolumn(String Testquery, String Columnname) throws SQLException, ClassNotFoundException { 
    	 
		 String Results = new String();

    	 try {
			
    		
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Creating connection to the database
        
       // Connection con = DriverManager.getConnection("jdbc:sqlserver://BUIDTP-111;database=LevelsPES; IntegratedSecurity=True" );
       Connection con = DriverManager.getConnection("jdbc:sqlserver://10.20.1.45;database=PESHKDEMO; User=demo_support; Password=L!ghj$supp#nJ98;");
        //Creating statement object
     Statement st = con.createStatement();
     
     
        //Executing the SQL Query and store the results in ResultSet
     ResultSet rs = st.executeQuery(Testquery);
     
 while (rs.next()) {
    	 
     Results = rs.getString(Columnname);
  
     }
     //While loop to iterate through all data and print results
    

	 //Closing DB Connection
  


    	 }
    	 
    	
    	 catch(Exception sqlException) {
             sqlException.printStackTrace();
             System.out.println("Failed to create the database TestConnection."); 
         }
    	return Results;  
    	    
 }
   
     	
     
     }