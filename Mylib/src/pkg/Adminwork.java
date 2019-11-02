package pkg;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Adminwork {
Connection myconn;

Adminwork()
{
	try
	{
		//create connection
		myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","student");
	}
	catch(Exception e)
	{
    S.sop("Oops !! Error occured "+e);
	}
}
void newStudent(String uname,String pass,String fname,String lname)
{ 
try {
//write query string
String sqlquery = "INSERT INTO db1.students " +
        "VALUES (?, ?,?,?, ?, ?)";
//write the prepared statement 
PreparedStatement pstmt = myconn.prepareStatement(sqlquery);
// plugin ? values in sql query

pstmt.setString(1, uname);
pstmt.setString(2, pass);
pstmt.setString(3, fname);
pstmt.setString(4, lname);
pstmt.setNull(5,Types.VARCHAR);
pstmt.setNull(6,Types.VARCHAR);
//write update statement and close
pstmt.executeUpdate();
pstmt.close();
}
catch(Exception e) { S.sop("Oops "+e); }
}
}
