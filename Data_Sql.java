package klm;
import java.sql.*;
class Data_Sql
{
    public static void main(String args[]) throws  Exception
     {
    	Connection conn=null;
    	// Load the Driver class. 
       	   Class.forName("com.mysql.jdbc.Driver");
           // Create the connection using the static getConnection method 
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","lavanya");
           //Create a Statement class to execute the SQL statement 
           Statement stmt=conn.createStatement();
           //Execute the SQL statement and get the results in a Resultset 
           ResultSet rs=stmt.executeQuery("select * from studentinfo;");
           // Iterate through the ResultSet, displaying two values 
           // for each row using the getString method 
           while(rs.next())
            {
               System.out.println(rs.getString("Name")+"||"+rs.getString("Mobile")+"||"+rs.getString("Email"));
            }
    	
    	
        		 if(conn != null)
  	             conn.close();
        	 }
	         
                            
       }
  
