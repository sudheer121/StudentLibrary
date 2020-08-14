package pkg;

public class Adminwork {
	DatabaseConnection db;
	
	Adminwork(){
		
	}
	
	void newStudent(String uname,String pass,String fname,String lname){ 
		try {
			//write query string
			String sqlquery = "INSERT INTO db1.students " +
			        "VALUES ("+uname+","+pass+","+fname+","+lname+",null, null)";
			if(db.executeUpdate(sqlquery)) {
				S.sop("Ok");
			}
		}catch(Exception e) { 
			S.sop("Oops "+e); 
			}
	}
}
