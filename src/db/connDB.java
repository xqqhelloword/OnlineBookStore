package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connDB {
	
	private static String username = "root";
	
	private static String password = "123456789";
	
	private static String url = "jdbc:mysql://localhost/bookstore";
	
	private static String driver = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
		}
		return conn;
	}
	
	public static void freeAll(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
			}
		}

	}

	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}
