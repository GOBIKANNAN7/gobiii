package dao;
import java.io.*;
import java.util.*;

import com.ConnectionManager;
import com.User;
import java.sql.*;

public class UserDao {
	
	 double amt,amt1,amt2,sum,difference;
	 int flag=1;
	 public  UserDao(){
		super();
    	}
	
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
     Connection c = ConnectionManager.getConnection();
     PreparedStatement ps = null;
     ResultSet rs=null;
     
     public boolean validate(int accountNumber,int password) throws SQLException {   
    	  
    	 String squery="select * from T_XBBNHHG_account where accountnumber="+accountNumber;
    	     ps=c.prepareStatement(squery);
    	    // ps.setInt(1, accountNumber);
    	     ResultSet rs=ps.executeQuery();
             int f=0;
            
    		 while(rs.next()) {
    			 if(password==rs.getInt(3)) {    
    				 System.out.println("\n **Login Successfull** \n");
    				 f=1;    				
    	    		 return true;    			
    			 }
    			 if(f==0)
    		    	 return false; 
    		 }    	 
   		
	    	 return false; 
             }
  
     
	public void balanceEnquiry(int accountNumber) throws SQLException {
		   System.out.println("---------Balance Enquiry---------");
               String squery="select * from T_XBBNHHG_account where accountnumber="+accountNumber;
               ps=c.prepareStatement(squery);
               rs=ps.executeQuery();               
               	
              while(rs.next()){            	
              System.out.println(" YOUR ACCOUNT BALANCE IS : Rs"+ rs.getDouble(5));        
             }             
              
              ps=c.prepareStatement("insert into T_XBBNHHG_transaction values(?,?,?,sysdate)");
              ps.setInt(1, accountNumber);
              ps.setString(2, "balance");
              ps.setDouble(3,0.0);
              ps.executeUpdate();    
              
	    }
	
	   public void deposit(int accountNumber) throws IOException,SQLException{		   
		   System.out.println("---------Deposit---------");
		   do{
		    try{
		   System.out.println("enter the amount : ");
		   amt = Double.parseDouble(br.readLine());		
		    } catch(NumberFormatException e) {
		    	System.out.println("!!!!!! enter amount in numbers");
		    	flag=0;
		     }
		    }while(flag==0);
           
		       String squery="select * from T_XBBNHHG_account where accountnumber="+accountNumber;
               ps=c.prepareStatement(squery);
               rs=ps.executeQuery();     
           
               while(rs.next()){
                       amt1=rs.getDouble(5); 
                       break;
                    }             
               sum = amt+amt1;
		       ps = c.prepareStatement("update T_XBBNHHG_account set amount="+sum+" where accountnumber="+accountNumber);
		       ps.executeUpdate(); 
		       System.out.println("Amount Deposited successfully");	      
		       
		          ps=c.prepareStatement("insert into T_XBBNHHG_transaction values(?,?,?,sysdate)");
	              ps.setInt(1,accountNumber);
	              ps.setString(2,"deposit");
	              ps.setDouble(3,amt);
	              ps.executeUpdate();   
	            
		}
		
	
	   public void withdraw(int accountNumber)throws IOException,SQLException {
		   System.out.println("---------Withdraw---------");
		   do {
		    try {
		   System.out.println(" enter the amount :");
		   amt = Double.parseDouble(br.readLine());	 
	        } catch(NumberFormatException e) {
	    	    System.out.println("!!!!!! enter amount in numbers");
	    	    flag=0;
	            }
	          }while(flag==0);
              
	          String squery="select * from T_XBBNHHG_account where accountnumber="+accountNumber;
               ps=c.prepareStatement(squery);
               rs=ps.executeQuery();   
           
               while(rs.next()){
                        amt1=rs.getDouble(5);        
                    }
               difference=amt1-amt;
               ps = c.prepareStatement("update T_XBBNHHG_account set amount="+ difference +" where accountnumber="+accountNumber);
               ps.executeUpdate();      		   
		     System.out.println("Amount Withdrawn successfully");
		     
		     ps=c.prepareStatement("insert into T_XBBNHHG_transaction values(?,?,?,sysdate)");
             ps.setInt(1, accountNumber);
             ps.setString(2,"withdraw");
             ps.setDouble(3,amt);
             ps.executeUpdate(); 
    
	}
		

	   public void transfer(int accountNumber) throws IOException, NumberFormatException,SQLException {
		   System.out.println("---------Money Transfer---------");
		   int retry=0;ResultSet rs1=null;int destAccount=0;
		   do{
			 try {
				 do{
				 flag=1;
		   System.out.println("enter the destination accountnumber :");
		   destAccount=Integer.parseInt(br.readLine());
		   System.out.println("Enter the amount :");
		   amt = Double.parseDouble(br.readLine());
		   
		   
		   int accFound=0;
		   String squery2="select accountnumber from T_XBBNHHG_account";               
           ps=c.prepareStatement(squery2);
           rs=ps.executeQuery();                      
           while(rs.next()){
                          if(destAccount==rs.getInt(1))   
                          {
                        	 // System.out.println("Account number exist");
                        	  accFound=1;
                        	  retry=0;
                        	  break;
                          }
           }
		   if(accFound==0)
		   {
			   System.out.println("Account number doesnot exist");
			   retry=1;
			 }
		 }while(retry==1);
		   
               String squery="select * from T_XBBNHHG_account where accountnumber="+accountNumber;               
               ps=c.prepareStatement(squery);
               rs=ps.executeQuery();              
            
               while(rs.next()){
                              amt1=rs.getDouble(5);        
                    }
               difference=amt1-amt;
               ps = c.prepareStatement("update T_XBBNHHG_account set amount="+ difference +" where accountnumber="+accountNumber);
               ps.executeUpdate();    
                           
    		   String squery1="select * from T_XBBNHHG_account where accountnumber="+destAccount;
               ps=c.prepareStatement(squery1);
                rs1=ps.executeQuery();   
               while(rs1.next()){
                 amt2=rs1.getDouble(5);                
                }
               sum=amt2+amt;
               ps = c.prepareStatement("update T_XBBNHHG_account set amount="+ sum +" where accountnumber="+destAccount);
               ps.executeUpdate();  
		     System.out.println("Amount transfered successfully");
			 } catch(NumberFormatException e) {
	    	      System.out.println("!!!!!! enter accountnumber and amount in numbers ");
	    	      flag=0;
	           }
	         }while(flag==0);
		     ps=c.prepareStatement("insert into T_XBBNHHG_transaction values(?,?,?,sysdate)");
             ps.setInt(1,accountNumber);
             ps.setString(2,"transfer");
             ps.setDouble(3,amt);
             ps.executeUpdate();  
	 
           
		}
		
	   
	   public void viewReport(int accountNumber) throws SQLException{
		   System.out.println("---------view Report---------");		                           
               System.out.println( String.format("%-15s %-15s %-8s %-6s", "accountnumber", "transactiontype", "amount","transactiondate") );
               String squery="select * from T_XBBNHHG_transaction";
               ps=c.prepareStatement(squery);
               rs=ps.executeQuery();  
          
               while(rs.next()){
                System.out.println( String.format("%-15d %-15s %.02f %-6s", rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getString(4)));       
                  }
		      System.out.println("\n *** THANK YOU FOR BANKING ***");
	   }
	   
		      
	   public void closeAccount(int accountNumber) throws SQLException{		  
		   System.out.println("---------Close Account---------");	
		   ps=c.prepareStatement("delete from T_XBBNHHG_account where accountnumber="+accountNumber);
		   ps.executeUpdate();
		   System.out.println("Account Closed Successfully");	
	   }
	   		
}