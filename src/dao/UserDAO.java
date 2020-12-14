package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DBConnection;
import model.User;


public class UserDAO {
	// đăng ký user mới
		public static boolean insertUser(User user) throws NoSuchAlgorithmException {
			Connection connection;
			PreparedStatement statement = null;
			try {
				connection = DBConnection.getConnection();
				String sql = "INSERT INTO [users] (first_name, last_name, email, phone, cmnd, password"
						+ ") VALUES (N'" +user.getFirstName() + "', N'" + user.getLastName()
						+ "', N'" + user.getEmail()+  "', N'" + user.getPhone() + "', N'" + user.getCmnd() + "', N'"+ user.getPassword() + "')";
				statement = connection.prepareStatement(sql);
				return statement.executeUpdate() > 0;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
			
		}
	// kiểm tra user đã tồn tại chưa
		public static boolean checkUser(String email) {
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "SELECT email FROM [users] WHERE email = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, email);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					email = resultSet.getString("email");
				}
				return true;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
	// Kiểm tra login
		public static int checkLogin(String email, String pass) {
			Connection connection;
			int id = 0;
			try {
				connection = DBConnection.getConnection();
				String sql = "SELECT * FROM [users] WHERE email = ? AND password = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, email);
				statement.setString(2, pass);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					id = resultSet.getInt("user_id");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return id;
			

		}
		public static User getThongTinUser(int idUser) {
			User user = new User();
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "SELECT * FROM [users] WHERE user_id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, idUser);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					user.setId(resultSet.getInt("user_id"));
					user.setFirstName(resultSet.getString("first_name"));
					user.setLastName(resultSet.getString("last_name"));
					user.setEmail(resultSet.getString("email"));
					user.setPhone(resultSet.getInt("phone"));
					user.setCmnd(resultSet.getInt("cmnd"));
					user.setPassword(resultSet.getString("password"));
					user.setRole(resultSet.getInt("role_id"));
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
		public static void main(String[] args) {
			System.out.println(checkLogin("tuanthanh@gmail.com", "123"));
			System.out.println(getThongTinUser(1).toString());
		}
}
