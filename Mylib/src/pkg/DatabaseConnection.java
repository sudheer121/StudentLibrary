package pkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static DatabaseConnection instance=null;
	private Connection connection;
	
	private DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","student");	
		}catch(ClassNotFoundException c) {
			System.out.println(c);
		}
		catch(SQLException s) {
			System.out.println(s);		
		}
		
	}
	
	public static DatabaseConnection getInstance() {
		if(instance==null) {
			instance=new DatabaseConnection();
			return instance;
		}
		return instance;
	}
	
	
	public ResultSet getQuery(String query) {
		ResultSet rs=null;
		try {
			Statement statement=connection.createStatement();
			rs=statement.executeQuery(query);
		}catch(SQLException i) {
			System.out.println(i);
		}
		return rs;
	}
	
	public boolean executeUpdate(String query) {
		PreparedStatement prepared=null;
		try {
			prepared=connection.prepareStatement(query);
			int result=prepared.executeUpdate();
			return (result > 0);
		}catch(SQLException s) {
			System.out.println(s);	
		}
		
		return false;
	}
	
	public boolean closeConnection() {
		try {
			connection.close();
			return true;
		}catch(SQLException s) {
			System.out.println(s);
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
