package dao;
import java.io.*;
import java.util.*;

import com.ConnectionManager;
import com.User;
import java.sql.*;

public class EmployeeDao {
	
	 double amt,amt1,amt2,sum,difference;	 
	 public  EmployeeDao(){
		super();
    	}
	
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// List adl=new ArrayList();
     Connection c = ConnectionManager.getConnection();
     PreparedStatement ps = null;
   //  AdminDao ad=null;
	
     public boolean validate(int empId,int password) throws SQLException{    	
    	 ResultSet rs=null;
    	// try {   		 
    		 String squery="select * from T_XBBNHHG_employees where empid="+empId;
    	     ps=c.prepareStatement(squery);
              rs=ps.executeQuery();
             int f=0;           
    		 while(rs.next()) {
    			 if(password==rs.getInt(2)) {    
    				 System.out.println("\n *Login Successfull* \n");
    				 f=1;    				
    	    		 return true;    			
    			 }
    			 if(f==0)
    		    	 return false; 
    		 }    	 
    /*  }
       catch(SQLException e){
    		 
    	 }   	 
    	 finally {
    		 try {
 				if(rs != null)
 				rs.close();		
 				c.commit();
 				if(c != null)
 				c.close();
 			}			
 			 catch (SQLException e) {
 				
 					e.printStackTrace();
 				}
    	 }
           */
		return false;           
             }	   
				
}