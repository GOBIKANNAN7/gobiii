package com;

import java.sql.*;
import java.util.*;


public class ConnectionManager {

   static Connection con;     
   public static Connection getConnection()
   {
      try
      {  
    	 //Class.forName("org.apache.derby.jdbc.ClientDriver");
     	Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
		  con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
				
		 //con=DriverManager.getConnection("jdbc:derby://10.78.233.58:1527/inewton","user","pwd");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
         
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}