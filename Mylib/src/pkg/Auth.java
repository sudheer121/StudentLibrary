package pkg;
import java.sql.*;

public class Auth {
		
	public static int func(String username,String password){
		try {
			//get connection
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","student");
			//create statement
			String query ="SELECT * FROM db1.students where "
					+" roll_no = ?" ;
			PreparedStatement ps = myconn.prepareStatement(query);
			ps.setString(1,username);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()){   
				String p,x,y;
				p = rs.getString("password");
				x = rs.getString("fname");
			    y = rs.getString("lname");
				if(p.equals(password)){
					System.out.println("Welcome "+x+" "+y+" !!!");
					ps.close();
					return 1;
				}else{
					ps.close();
					return 0;
				}
			}
		}catch(Exception E){
			System.out.println(E+" Occured");
		}
		
			return 0;
		}
}


