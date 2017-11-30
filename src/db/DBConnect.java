package db;

import java.sql.*;
import static encryption.MD5Encryption.md5;
import static data.SQLData.*;

public class DBConnect {
	
	public boolean createUser(String username, String password){
		
		
		return false;
	}
	
	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/OldBook", "root", "mysqlfuckingpassword");
//						
//			Statement stmt = con.createStatement();
//			
//			String sql = "select * from app_user";
//			
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			while(rs.next()){
//				String username = rs.getString("username");
//				String first_name = rs.getString("first_name");
//				String last_name = rs.getString("last_name");
//				String password = rs.getString("password");
//
//				System.out.println("Username: " + username + "\nPassword: " + password + "\nFirst name: " + first_name + "\nLast name: " + last_name);				
//			}
//			
//			String sql1 = "select * from advert";
//			
//			ResultSet rs1 = stmt.executeQuery(sql1);
//			
//			System.out.println("======================================");
//			
//			while(rs1.next()){
//				String title = rs1.getString("title");
//				String posted_by = rs1.getString("posted_by");
//				
//				System.out.println(title + " by " + posted_by);
//			}
//			
//			String username = "sivaji";
//			String password = "cool";
//			
//			String insertionSQL = "insert into app_user(username, password) values("
//					+ "'" + username + "', '" + md5(password) + "')";
//			
////			stmt.executeUpdate(insertionSQL);
////			System.out.println(insertionSQL);
//			
//		} catch (Exception ex) {
//			System.out.println("Error: " + ex);
//		}
		
	}
}
