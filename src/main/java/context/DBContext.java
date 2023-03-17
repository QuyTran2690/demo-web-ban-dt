package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBContext {
	public Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://" + serverName + " : " + portNumber + "\\" + instance + ";databaseName=" + dbName
				+ ";integrationSecurity=true;encrypt=true;trustServerCertificate=true;";
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
					+ ";integrationSecurity=true;encrypt=true;trustServerCertificate=true;";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, userID, password);
	}
	
	private final String serverName = "ADMIN";
	private final String dbName = "ShoppingDB";
	private final String portNumber="1466";
	private final String instance = "";
	private final String userID = "sa";
	private final String password="0987046562";
	
	
//	public static void main(String[] args) throws Exception {
//		Connection conn = null;
//		// get list product
//		try {
//			conn = new DBContext().getConnection();
//			// System.out.println("Ket noi thanh cong");
//
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery("select * from Products");
//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4)
//						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
//			}
//			conn.close();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			System.out.println("Ngoai le sql");
//			System.err.println(e.getMessage() + "/n" + e.getClass() + "/n" + e.getCause());
//		}
//	}
	
}
