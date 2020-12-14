package controller;

import java.sql.*;

public class DBConnection {

	 public static Connection getConnection()
	         throws ClassNotFoundException, SQLException {
	     String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "Web2020";
	     String userName = "thanh";
	     String password = "thanh98thehepro";
	 
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	 
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
	 
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		if (DBConnection.getConnection() != null) {
			System.out.println("Ket noi thanh cong");
		} else System.out.println("Ket noi that bai");
	}
}
