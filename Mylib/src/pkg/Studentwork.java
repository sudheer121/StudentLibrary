package pkg;
import java.sql.*;
public class Studentwork{
	String uname,b1,b2;
	DatabaseConnection db;
	Studentwork(String username){   
		try {
			//bkname = s;
			uname  = username;
		    db=DatabaseConnection.getInstance();
		    String query = "SELECT * FROM db1.students where  roll_no ="+uname ;
			ResultSet rs = db.getQuery(query);
			while (rs.next())
			{   
				 b1 = rs.getString("book_1");
				 b2 = rs.getString("book_2");
			}
		}catch(Exception e){
			S.sop("Error....."+e);
		}
	}
	int issue(String bkname){
	try {
		if(b1!=null && b2!=null) { 
			S.sop("You have exceeded book limit"); 
		}else if(b1==null){
			String sqlUpdate = "UPDATE db1.students "
		            + "SET book_1 = "+bkname
		            + "WHERE roll_no ="+uname;
			
			if(db.executeUpdate(sqlUpdate)) {
				return 1;
			}else {
				return 0;
			}
		}else{   
			S.sop("Erer");
			String sqlUpdate = "UPDATE db1.students "
		            + "SET book_2 = "+bkname
		            + "WHERE roll_no ="+uname;
			if(db.executeUpdate(sqlUpdate)) {
				return 1;
			}else {
				return 0;
			}
		}
	
	}catch(Exception e){
		;}
		return 0;
	}//issue function ends here
	
	void Returnbook(String bkname){
	try {
		if(bkname.equals(b1)){
			String sqlUpdate = "UPDATE db1.students "
		            + "SET book_1 = null "
		            + "WHERE roll_no ="+uname;
		    if(db.executeUpdate(sqlUpdate)) {
		    	S.sop("Done");
		    }
		    
		}
		else if(bkname.equals(b2))
		{
			String sqlUpdate = "UPDATE db1.students "
		            + "SET book_2 = null "
		            + "WHERE roll_no = "+uname;
			if(db.executeUpdate(sqlUpdate)) {
		    	S.sop("Done");
		    }
		    
		   
		}
		else
		{ 
			S.sop("No such book");
		}
		
	}catch(Exception e) { 
		S.sop(e + "Occured "); 
		} 
	} //returnbook function ends here
	void Issuedbks(){
		if(b1 == null && b2 == null) { 
			S.sop("No books issued"); 
			}
		else{ 
			S.sop("Issued Boook(s) :");
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

