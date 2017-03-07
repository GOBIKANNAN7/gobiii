package dao;
import com.Account;
import com.ConnectionManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {	
	    Account acc =null;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps;
		ResultSet rs = null;
		
		public void accountDetails() throws IOException{
		try {
			   System.out.println("Login Details");
			   System.out.println("enter the user name : ");
			   String userName = br.readLine(); 
			   System.out.println("enter account number : ");
			   int accountNumber = Integer.parseInt(br.readLine());
			   System.out.println("enter password : ");
			   int passWord = Integer.parseInt(br.readLine());
			   System.out.println("enter account type : ");
			   String accountType = br.readLine();  
			   System.out.println("enter the amount : ");
			   double amount = Double.parseDouble(br.readLine()); 
			   System.out.println("enter PAN number : ");
			   int panNumber = Integer.parseInt(br.readLine());
			   acc =new Account(userName,accountNumber,passWord,accountType,amount,panNumber);
		       String qry="insert into T_XBBNHHG_account values(?,?,?,?,?,?)";
		       ps=conn.prepareStatement(qry);
               ps.setString(1,userName);
               ps.setInt(2,accountNumber);
               ps.setInt(3,passWord);
               ps.setString(4,accountType);
               ps.setDouble(5,amount);
               ps.setInt(6,panNumber);              
               ps.executeUpdate();    	
               System.out.println(" User added successfully ");
	        	} catch (SQLException e) {			
           			e.printStackTrace();
		      }				
		
		finally{
			try {
				if(rs!=null) 
				rs.close();
				if(ps!=null) 
			  ps.close();
				conn.commit();
				if(conn!=null)
					conn.close();
			}		
			catch (SQLException e) {				
				e.printStackTrace();
		      }
	    	}
			
	}
}

