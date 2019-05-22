package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class shopDao {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String Url = "jdbc:mysql://localhost:3306/shopcar?serverTimezone=GMT%2B8&userSSL=false";
	private static String User = "root";
	private static String Password = "2018";
	public static PreparedStatement pstet = null;
	public static ResultSet rs = null;
	public static Connection conn = null;
	public static PreparedStatement getPreparedStatement(String sql, Object[] parmes) {
		try {
			Class.forName(Driver);
			System.out.println("pre - driver -ok");
			conn = DriverManager.getConnection(Url, User, Password);
			System.out.println("pre - conn -ok");
			pstet = conn.prepareStatement(sql);
			if(parmes != null) {
				pstet.clearParameters();
				for(int i = 0; i < parmes.length; i++) {
					pstet.setObject(i+1, parmes[i]);
				}
			}
			System.out.println("pre- pstet -ok");
			return pstet;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static boolean isConnection(String sql, Object[] parmes) {
		pstet = getPreparedStatement(sql, parmes);
		try {
			int cnt = pstet.executeUpdate();
			if(cnt > 0) return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll();
		}
		return false;
	}
	public static ResultSet getResultSet(String sql, Object[] parmes) {
		pstet = getPreparedStatement(sql, parmes);
		System.out.println("rs - psts - ok");
		try {
			rs = pstet.executeQuery();
			System.out.println("rs -ok");
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static boolean closeAll() {
		try {
			if(rs != null)
				rs.close();
			if(pstet != null)
				pstet.close();
			if(conn != null)
				conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
