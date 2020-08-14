package pkg;
import java.sql.*;
public class Viewbooks {
	protected static void func(){
		try {
			DatabaseConnection db=DatabaseConnection.getInstance();
			String query ="SELECT * FROM db1.contents" ;
			ResultSet rs = db.getQuery(query);
			while (rs.next()){
			  String u = rs.getString("name");
			  String p = rs.getString("author");
			  S.sop("Name : "+u+"\nAuthor : "+p);
			}
		}catch(Exception e){
			S.sop("Exception occured :"+e);
			}
	}
}