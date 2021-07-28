package application;

import java.sql.*;

public class main 
{
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/emylogin";
	
	
	public static void main(String[] args) 
	{
		example2();
	}
	
	
	public static void example1() {
		
		Connection conn = null;
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,"favour", "favour");
			Statement stm = conn.createStatement();
			String sql = "SELECT userID, user_name, user_email FROM users";
			System.out.println(sql);
			ResultSet val = stm.executeQuery(sql);
		
			while(val.next()) {
				int userID = val.getInt("userID");
				String name = val.getString("user_name");
				String email = val.getString("user_email");
				
				System.out.print("userID: " + userID);
				System.out.print(", user name: " + name);
				System.out.println(", email: " + email);
			}
			
			val.close();
			stm.close();
			conn.close();
		}
		
		catch(SQLException s){
			s.printStackTrace();
		}
		
		catch(Exception es) {
			es.printStackTrace();
		}
	}
	
	public static void example2() {
		
		try
		{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "favour", "favour");
			
			PreparedStatement pst = null;
			String mysql = "INSERT into users(?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(mysql);
			
			pst.setInt(1, 1003);
			pst.setString(2, "Mbah");
			pst.setString(3, "Leticia");
			pst.setString(4, "Mbah Leticia");
			pst.setString(5, "mbaleti@gmail.com");
			pst.setInt(6, 20);
			
			pst.executeUpdate(mysql);
		}
		
		catch(SQLException s){
			s.printStackTrace();
		}
		
		catch(Exception es) {
			es.printStackTrace();
		}
	}
}
