package pkg;
import java.sql.*;
public class Viewbooks {
protected static void func()
{
try {
Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","student");
Statement st = myconn.createStatement();
String query ="SELECT * FROM db1.contents" ;
ResultSet rs = st.executeQuery(query);
while (rs.next())
{
  String u = rs.getString("name");
  String p = rs.getString("author");
  S.sop("Name : "+u+"\nAuthor : "+p);
}
st.close();
}
catch(Exception e)
{
	S.sop("Exception occured :"+e);
}
}
}