package pkg;
import java.sql.*;
public class Studentwork{
String uname,b1,b2;
Connection myconn;
Studentwork(String username)
{   try {
	//bkname = s;
	uname  = username;
    myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","student");
    String query = "SELECT * FROM db1.students where  roll_no = ?" ;
   	PreparedStatement ps = myconn.prepareStatement(query);
	ps.setString(1,uname);
	ResultSet rs = ps.executeQuery();
	while (rs.next())
	{   
		 b1 = rs.getString("book_1");
		 b2 = rs.getString("book_2");
	}
	ps.close();
		   }
			catch(Exception e){
				S.sop("Error....."+e);
			}
}
int issue(String bkname)
{
try {
if(b1!=null && b2!=null) { S.sop("You have exceeded book limit"); }
else if(b1==null)
{
	String sqlUpdate = "UPDATE db1.students "
            + "SET book_1 = ? "
            + "WHERE roll_no = ?";
    PreparedStatement pstmt = myconn.prepareStatement(sqlUpdate);
    pstmt.setString(1, bkname);
    pstmt.setString(2, uname);
    pstmt.executeUpdate();
    return 1;
}
else
{   S.sop("Erer");
	String sqlUpdate = "UPDATE db1.students "
            + "SET book_2 = ? "
            + "WHERE roll_no = ?";
    PreparedStatement pstmt = myconn.prepareStatement(sqlUpdate);
    pstmt.setString(1, bkname);
    pstmt.setString(2, uname);
    pstmt.executeUpdate();
    return 1;
}

}
catch(Exception e){;}
return 0;
}//issue function ends here
void Returnbook(String bkname)
{
try {
if(bkname.equals(b1))
{
	String sqlUpdate = "UPDATE db1.students "
            + "SET book_1 = ? "
            + "WHERE roll_no = ?";
    PreparedStatement pstmt = myconn.prepareStatement(sqlUpdate);
    pstmt.setNull(1, Types.VARCHAR);
    pstmt.setString(2, uname);
    pstmt.executeUpdate();
    pstmt.close();
    S.sop("Done");
}
else if(bkname.equals(b2))
{
	String sqlUpdate = "UPDATE db1.students "
            + "SET book_2 = ? "
            + "WHERE roll_no = ?";
    PreparedStatement pstmt = myconn.prepareStatement(sqlUpdate);
    pstmt.setNull(1,Types.VARCHAR);
    pstmt.setString(2, uname);
    pstmt.executeUpdate();
    pstmt.close();
    S.sop("Done");
}
else
{ 
	S.sop("No such book");
}

}
catch(Exception e) { S.sop(e + "Occured "); } 
} //returnbook function ends here
void Issuedbks()
{
if(b1 == null && b2 == null) { S.sop("No books issued"); }
else
{ S.sop("Issued Boook(s) :");
  if(b1!=null) { S.sop(b1); }
  if(b2!=null) { S.sop(b2); }
}
}
}
/*
static void issue(String s,String username)
{
	
}
*/

