package FirsttestNG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class  ICDBConnection {				
	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
            String dbUrl = " ";					

			//Database Username		
			String username = " ";	
            
			//Database Password		
			String password = " ";				

			//Query to Execute		
			String query = " ";	
            
     	    //Load mysql jdbc driver		
       	    Class.forName("org.postgresql.Driver");			
       
       		//Create Connection to DB		
        	Connection con = DriverManager.getConnection(dbUrl,
        			username, password);
      
      		//Create Statement Object		
    	   Statement stmt = con.createStatement();					
   
   			// Execute the SQL Query. Store results in ResultSet		
     		ResultSet rs= stmt.executeQuery(query);							
     
     		// While Loop to iterate through all data and print results		
			while (rs.next()){
		        		String phone = rs.getString(7);								        
                        String name = rs.getString(6);
                        String email = rs.getString(8);
                        String address = rs.getString(9);
                        String otp = rs.getString(19);
                        String sap_code = rs.getString(13);
                        
                       // String websales_id = rs.getString(7);
                        
                        
                        System. out.println("Name is "+name);
                        System. out.println("Phone Number is "+phone);
                        System.out.println("Email id is "+email);
                        System.out.println("Address is "+address);
                        System.out.println("Sap code is "+sap_code);
                        System.out.println("OTP is "+otp);
                    //    System.out.println("Digital Status "+websales_id);
                }		
  			 // closing DB Connection		
  			con.close();			
	}
}
