package pkg;
import java.sql.*;
public class Auth {

public static int func(String username,String password)
		{
	try {
//get connection
Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","student");
//create statement
String query ="SELECT * FROM db1.students where "
		+" roll_no = ?" ;
PreparedStatement ps = myconn.prepareStatement(query);
ps.setString(1,username);

ResultSet rs = ps.executeQuery();
while (rs.next())
{   String p,x,y;
	 p = rs.getString("password");
	 x = rs.getString("fname");
     y = rs.getString("lname");
	if(p.equals(password))
	{
		System.out.println("Welcome "+x+" "+y+" !!!");
		ps.close();
		return 1;
	}
	else
	{
		ps.close();
		return 0;
	}
}
/*
Statement st = myconn.createStatement();
//execute query
String query ="SELECT * FROM db1.students" ;
//process resultset
ResultSet rs = st.executeQuery(query);
while (rs.next())
{
  String u = rs.getString("roll_no");
  String p = rs.getString("password");
  if(username.equals(u) && password.equals(p))
  {
	String x = rs.getString("fname");
    String y = rs.getString("lname");
    System.out.println("Welcome "+x+" "+y+" !!!");
    st.close();
    return 1;
  }
}
st.close();*/
		}
catch(Exception E)
{
System.out.println(E+" Occured");
}
	
return 0;
	}
}


