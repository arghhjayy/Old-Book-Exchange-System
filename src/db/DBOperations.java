package db;

import static data.SQLData.*;
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
						"VALUES(" + username + ", " + password + ")";
		
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
			Connection con = DriverManager.getConnection(databaseLocation, SQLServerUsername, SQLServerPassword);
			
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
		System.out.println("Fuck");
		create_user("sivaji", "theboss");
		System.out.println(hasUser("sivaji"));
	}
}