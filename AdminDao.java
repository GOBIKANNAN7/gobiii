package dao;
import java.io.*;
import java.util.*;

import com.ConnectionManager;
import com.User;
import java.sql.*;

public class AdminDao {
	
	 double amt,amt1,amt2,sum,difference;	 
	 public  AdminDao(){
		super();
    	}
	
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     Connection c = ConnectionManager.getConnection();
     PreparedStatement ps = null;  
     ResultSet rs = null;
     AccountDao accountdao = new  AccountDao(); 
                
   //  try {  	 
    
     public boolean validate(String userName,int password) throws IOException,SQLException{    	   		 
    		 String squery="select * from T_XBBNHHG_admin where adminname='"+userName+"'";
    	     ps=c.prepareStatement(squery);
             ResultSet rs=ps.executeQuery();
             int f=0;           
    		 while(rs.next()) {
    			 if(password==rs.getInt(2)) {    
    				 System.out.println("\n **Login Successfull** \n");
    				 f=1;    				
    	    		 return true;    			
    			 }
    			 if(f==0)
    		    	 return false; 
    		 }    	 
   
		return false;           
             }
  
     
	public void addEmployee() throws  NumberFormatException, IOException,SQLException {
		   System.out.println("---------Add Employee---------");
		   System.out.println(" 1> add new employee  2> modify the employee details\n Enter your choice:");
		   int choice= Integer.parseInt(br.readLine());
		   switch(choice) {
		   
		   case 1:   
			   System.out.println("add details of new employee");
			   System.out.println("enter the employee name");
			   String employeeName = br.readLine(); 
			   System.out.println("assign password : ");
			   int passWord = Integer.parseInt(br.readLine());
			   System.out.println("assign employee id :");
			   int employeeId = Integer.parseInt(br.readLine());  
			   System.out.println("enter employee phone number :");
			   int phoneNumber = Integer.parseInt(br.readLine()); 
			   System.out.println("enter employee email id :");
			   String emailId = br.readLine(); 
		       String squery="insert into T_XBBNHHG_employees values(?,?,?,?,?)";
               ps=c.prepareStatement(squery);
               ps.setString(1,employeeName);
               ps.setInt(2,passWord);
               ps.setInt(3,employeeId);
               ps.setInt(4,phoneNumber);
               ps.setString(5,emailId);
               ps.executeUpdate();  
               System.out.println("employee details added successfully");
               break;
            
		   case 2:    
			  System.out.println("Modify details of employee");
			  System.out.println("enter the employee id : ");
			  employeeId = Integer.parseInt(br.readLine()); 
			  System.out.println("enter the employee phone number : ");
			  phoneNumber = Integer.parseInt(br.readLine()); 
			  System.out.println("enter the employee email id : ");
		      emailId = br.readLine(); 
              ps = c.prepareStatement("update T_XBBNHHG_employees set phone="+phoneNumber+",email='"+emailId+"' where empid="+employeeId);           
              ps.executeUpdate();
              System.out.println("employee details modified successfully");
              break;
          
		      default :System.out.println(" Enter a valid choice ");
              break; 
        	   
		   }
		  
	    }
	
	   public void manageEmployee() throws IOException,SQLException{		   
		   System.out.println("---------Manage employee---------");
		   int empFound=0;
		   System.out.println("1> view employee  2> remove employee\n Enter your choice:");
		   int choice= Integer.parseInt(br.readLine());
		   System.out.println("enter the employee id");
		   int employeeId = Integer.parseInt(br.readLine());  
		   
		   
		   switch(choice) {		   
		   case 1:   
		       System.out.println("View  Employee");
		       System.out.println( String.format("%-15s %-8s %-10s %-20s ", "EmployeeName", "employeeId", "PhoneNumber","EmailId") );
		       ps=c.prepareStatement("select * from T_XBBNHHG_employees where empid="+employeeId);
		      rs = ps.executeQuery();
		       while (rs.next()) {
			       System.out.println(String.format("%-15s %-8d %-10d %-20s", rs.getString(1), rs.getInt(3),rs.getInt(4),rs.getString(5)));
			       empFound=1;
		        }
		       if(empFound==0)
			    	  System.out.println("user not exist");
			    
		       break;
		   case 2: 
			   System.out.println("Remove Employee");
		       String squery="delete from T_XBBNHHG_employees where empid="+employeeId;
               ps=c.prepareStatement(squery);
               ps.executeUpdate();     
               System.out.println("employee details deleted successfully");
               break;
            default : System.out.println("enter valid choice");
                    break;
		   }
		   
	   }
	
	   public void addUser()throws IOException,SQLException {
		   System.out.println("---------Add User---------");
		   System.out.println(" 1> add new user\n 2> modify the user details\n Enter your choice:");
		   int choice= Integer.parseInt(br.readLine());
		   switch(choice) {
		   
		   case 1:              
               accountdao.accountDetails();
               break;
               
		   case 2:    
			  System.out.println("Modify details of user");
			  System.out.println("enter the user name : ");
			  String userName1 = br.readLine(); 
			  System.out.println("enter the user phone number : ");
			  int phoneNumber = Integer.parseInt(br.readLine()); 
			  System.out.println("enter the user email id : ");
			  String emailId = br.readLine(); 		      
              ps = c.prepareStatement("update T_XBBNHHG_userdetails set phone="+phoneNumber+",email='"+emailId+"' where userName='"+userName1+"'");           
              ps.executeUpdate();
              System.out.println(" user details modified successfully ");
              break;
          
		   default :System.out.println(" enter a valid choice ");
              break;   
		   }
        
	}
	  
	   public void manageUser() throws IOException, NumberFormatException,SQLException {
		   System.out.println("---------Manage User---------");
		   System.out.println(" 1> view user  2> remove user\n Enter your choice:");
		   int choice= Integer.parseInt(br.readLine());
		   System.out.println("Enter the account number : ");
		   int accNumber=Integer.parseInt(br.readLine());
		   int userFound=0;
		   switch(choice) {		   
		   case 1:   
		   System.out.println( String.format("%-15s %-15s %-8s %-15s %-10s %-10s", "UserName", "AccountNumber", "Password","AccountType","Amount","PanNumber") );
		   ps=c.prepareStatement("select * from T_XBBNHHG_account where accountnumber="+accNumber);
		   rs = ps.executeQuery();
		   while (rs.next()) {
			   System.out.println(String.format("%-15s %-15d %-8d %-15s %.02f %-10d", rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
			   userFound=1;
		   }
		    if(userFound==0)
		    	  System.out.println(" username doesnot exist ");
		      break;
		          
		   case 2:
              			   
		      ps=c.prepareStatement("delete from T_XBBNHHG_account where accountnumber="+accNumber);
		      ps.executeUpdate();
		      System.out.println("User Account Closed Successfully");	
		      break;
		      
		  default:
			  System.out.println(" Invalid choice ");
		      break;  
             
		   }
		}			
	   
}






/*	}
 catch(SQLException e) {
	e.printStackTrace();
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
}*/