package dao;

import com.Signup;
import com.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class SignupDao {

	Connection conn = ConnectionManager.getConnection();
	PreparedStatement ps = null;
	Statement st = conn.createStatement();
	{
		ResultSet rs = null;
try {
   Signup sgn = new Signup(null, null, null, null, null, null, null, null, null, null);
   rs = st.executeQuery("SELECT ACCOUNT_NO_GENERATOR.NEXTVAL FROM DUAL");
    Long accountNumber = null;
if(rs.next()) {
	accountNumber = rs.getLong(1);
}
rs.close();
rs = st.executeQuery("SELECT CUSTOMER_ID_GENERATOR.NEXTVAL FROM DUAL");
Integer customerId = null;
if(rs.next()) {
	customerId = rs.getInt(1);
}
rs.close();

ps = conn.prepareStatement("INSERT INTO T_XBBNHHG_PROFILE VALUES(?,?,?,?,?,?,?,?,?)");
//acc.setaccNumber(rs.getString(1));
sgn.setName(rs.getString(1));
sgn.setDob(rs.getString(2));
sgn.setPhone(rs.getString(3));
sgn.setEmail(rs.getString(4));
sgn.setProof(rs.getString(5));
sgn.setGender(rs.getString(6));
sgn.setAccountType(rs.getString(7));
sgn.setDouble(9, 500.00);
ps.executeUpdate();

ps = conn.prepareStatement("SELECT TRANSACTION_NO_GENERATOR.NEXTVAL FROM DUAL");
rs = ps.executeQuery();
String tid = "";
if(rs.next()) {
	tid = String.format("TID%016d", rs.getLong(1));
   }

ps = conn.prepareStatement("INSERT INTO T_XBBNHHG_TRANSACTIONDETAILS VALUES(?,?,?,?,?,SYSDATE)");
ps.setLong(1, accountNumber);
ps.setString(2, tid);
ps.setString(3, "deposit");
ps.setDouble(4, 500.00);
ps.setDouble(5, 500.00);
ps.executeUpdate();

ps = conn.prepareStatement("INSERT INTO T_XBBNHHG_TRANSACTION VALUES(?,?,?,?,?)");
ps.setLong(1, accountNumber);
ps.setInt(2, customerId);
ps.setString(3, password);
ps.setInt(4, pin);
ps.setString(5, bankingType);
ps.executeUpdate();

 } 
  catch(Exception e) {
      System.out.println(e);
    }
  }
}

