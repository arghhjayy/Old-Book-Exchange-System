package db;

import static data.SQLData.*;
import static encryption.MD5Encryption.md5;
import java.sql.*;

public class DBOperations {
	static{
		try {
			Class.forName(driverLocation);
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException occured. " +
												"Returning false...");
		}
	}
	
	public static void create_user(String username, String password){
		String sql = "INSERT INTO APPUSER(USERNAME, PASSWORD)"+
						" VALUES('" + username + "', '" + md5(password) + "')";
		
		System.out.println(sql);
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(databaseLocation,
							SQLServerUsername, SQLServerPassword);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally{
			try{
				if(stmt != null)
					stmt.close();
			} catch(SQLException ex){
				ex.printStackTrace();
			}
			
			try {
				if(con != null)
					con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void create_user(String username, String password, 
									String firstname, String lastname)
	{
		String sql = "INSERT INTO APPUSER"+
					" VALUES('" + username + "', " +
							"'" + firstname + "', " +
							"'" + lastname + "', " +
							"'" + md5(password) + "')";
		
		System.out.println(sql);
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(databaseLocation,
							SQLServerUsername, SQLServerPassword);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally{
			try{
				if(stmt != null)
					stmt.close();
			} catch(SQLException ex){
				ex.printStackTrace();
			}
			
			try {
				if(con != null)
					con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static boolean hasUser(String username){
		try {
			Connection con = DriverManager.getConnection(databaseLocation,
									SQLServerUsername, SQLServerPassword);
			
			Statement stmt = con.createStatement();
			
			String SQL = "SELECT * FROM appuser WHERE username='" + username + "'";
			
			ResultSet rs = stmt.executeQuery(SQL);
			
			return rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		create_user("posty", "postymalone");
		System.out.println(hasUser("posty"));
	}
}