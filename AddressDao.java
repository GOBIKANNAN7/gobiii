package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Account;
import com.Address;
import com.ConnectionManager;

public class AddressDao {
		
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 {
	   try {
		  System.out.println("Enter your door number : ");
		  String DoorNumber=br.readLine();
		  System.out.println("Enter your street : ");
		  String Street=br.readLine();
		  System.out.println("Enter your location : ");
	      String Location=br.readLine();
	      System.out.println("Enter your city : ");
		  String City=br.readLine();
		  System.out.println("Enter your state : ");
		  String State=br.readLine();
		  System.out.println("Enter your country : ");
	      String Country=br.readLine();
	      System.out.println("Enter your pincode : ");
	      int Pincode=Integer.parseInt(br.readLine());
		   		   
		   conn = ConnectionManager.getConnection();
		   Address add =null;	  	 		
			ps = conn.prepareStatement("INSERT INTO T_XBBNHHG_ADDRESS VALUES(?,?,?,?,?,?,?)");
	       
			ps.setString(1,DoorNumber);
			ps.setString(2,Street);
			ps.setString(3,Location);
			ps.setString(4,City);
			ps.setString(5,State);
			ps.setString(6,Country);
			ps.setInt(7,Pincode);
			ps.executeUpdate();
		     
	   }catch(SQLException | IOException e) {	
			e.printStackTrace();
		}				
		
		finally {
			try {
				rs.close();
				//if(ps!=null) 
			  ps.close();
				conn.commit();
				//if(conn!=null)
					conn.close();
			  }		
			catch (SQLException e) {				
				e.printStackTrace();
		      } 
		   
		}
		
	   }
}

