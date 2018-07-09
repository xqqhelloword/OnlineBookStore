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
	
	private static String url = "jdbc:mysql://localhost/bookstore?characterEncoding=UTF-8&useSSL=true";

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

	public static void frees( Statement st, ResultSet rs) {
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

	public static void update(String sql, Object... args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
		}finally {
			connDB.freeAll(conn, ps, null);
		}

	}


	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}
