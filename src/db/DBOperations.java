package db;

import static data.SQLData.*;
import static encryption.MD5Encryption.md5;
import gui.Login;
import gui.Profile;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DBOperations {
	static{
		try {
			Class.forName(driverLocation);
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException occured. " +
												"Returning false...");
		}
	}
	
	public static void createUser(String username, String password){
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
			//JOptionPane.showMessageDialog(this, username);
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
	
	public static void createUser(String username, String password, 
									String firstname, String lastname)
	{
		String sql = "INSERT INTO APPUSER"+
					" VALUES('" + username + "', " +
							"'" + firstname + "', " +
							"'" + lastname + "', " +
							"'" + md5(password) + "')";
				
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
	
	public static String getLastName(String username){
		try {
			Connection con = DriverManager.getConnection(databaseLocation,
									SQLServerUsername, SQLServerPassword);
			
			Statement stmt = con.createStatement();
			
			String SQL = "SELECT lastname FROM appuser WHERE username='" + username + "'";
			
			System.out.println(SQL);
			
			ResultSet rs = stmt.executeQuery(SQL);
			
			rs.next();
			
			return rs.getString("lastname");
		} catch (SQLException ex) {
			ex.printStackTrace();
			return "error";
		}
	}
	
	public static String getFirstName(String username){
		try {
			Connection con = DriverManager.getConnection(databaseLocation,
									SQLServerUsername, SQLServerPassword);
			
			Statement stmt = con.createStatement();
			
			String SQL = "SELECT firstname FROM appuser WHERE username='" + username + "'";
			
			System.out.println(SQL);
			
			ResultSet rs = stmt.executeQuery(SQL);
			
			rs.next();
			
			return rs.getString("firstname");
		} catch (SQLException ex) {
			ex.printStackTrace();
			
			return "wow";
		}
	}
}