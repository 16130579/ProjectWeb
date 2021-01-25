package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import controller.DBConnection;
import model.Category;
import model.Role;
import model.User;


public class UserDAO {
	// đăng ký user mới
		public static boolean insertUser(User user) throws NoSuchAlgorithmException {
			Connection connection;
			PreparedStatement statement = null;
			try {
				connection = DBConnection.getConnection();
				String convertPass = convertHashToString(user.getPassword());
				String sql = "INSERT INTO [users] (first_name, last_name, email, phone, cmnd, password, role_id"
						+ ") VALUES (N'" +user.getFirstName() + "', N'" + user.getLastName()
						+ "', N'" + user.getEmail()+  "', N'" + user.getPhone() + "', N'" + user.getCmnd() + "', N'"+ convertPass +"', N'" + 1 + "')";
				statement = connection.prepareStatement(sql);
				return statement.executeUpdate() > 0;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
			
		}
		// list role
		public static ArrayList<Role> getListRole(){
			ArrayList<Role> list = new ArrayList<>();
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "SELECT * FROM [role]";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Role u = new Role();
					u.setId(resultSet.getInt("id"));
					u.setName(resultSet.getNString("name"));
					list.add(u);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//list user
		public static ArrayList<User> getListUser(){
			ArrayList<User> list = new ArrayList<>();
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "SELECT * FROM [users]";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					User u = new User();
					u.setId(resultSet.getInt("user_id"));
					u.setFirstName(resultSet.getNString("first_name"));
					u.setLastName(resultSet.getNString("last_name"));
					u.setEmail(resultSet.getNString("email"));
					u.setPhone(resultSet.getInt("phone"));
					u.setCmnd(resultSet.getInt("cmnd"));
					u.setRole(resultSet.getInt("role_id"));
					u.setBalance(resultSet.getInt("balance"));
					u.setPassword(resultSet.getNString("password"));
					list.add(u);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
	// kiểm tra user đã tồn tại chưa
		public static boolean checkUser(String email) {
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "SELECT * FROM [users] WHERE email = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, email);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					email = resultSet.getString("email");
					return true;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
	// Kiểm tra login
		public static int checkLogin(String email, String pass) throws NoSuchAlgorithmException {
			Connection connection;
			int id = 0;
			try {
				String convertPass = convertHashToString(pass);
				connection = DBConnection.getConnection();
				String sql = "SELECT * FROM [users] WHERE email = ? AND password = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, email);
				statement.setString(2, convertPass);
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
					user.setBalance(resultSet.getInt("balance"));
					user.setRole(resultSet.getInt("role_id"));
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		// mã hóa passowrd
		public static String convertHashToString(String text) throws NoSuchAlgorithmException {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    }
		//Nạp tiền (lưu số tiền người dùng nạp xuống database)
		public static boolean napTien(int idUser, int soTienNap) {
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "UPDATE [users] SET balance = balance + ? WHERE user_id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, soTienNap);
				preparedStatement.setInt(2, idUser);
				int rowAffect = preparedStatement.executeUpdate();
				if (rowAffect == 1) return true;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		// gửi mail
		public static boolean sendMail(String to, String subject, String text) {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("tuanthanh.11a6tp@gmail.com", "penjreddbipqepch");
				}
			});
			try {
				Message message = new MimeMessage(session);
				message.setHeader("Content-Type", "text/plain; charset=UTF-8");
				message.setFrom(new InternetAddress("tuanthanh.11a6tp@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(text);
				Transport.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		//đổi mật khẩu
		public static boolean changePassword(String email, String password) throws NoSuchAlgorithmException {
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String convertPass = convertHashToString(password);
				String sql = "UPDATE [users] SET password = ? WHERE email = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setNString(1, convertPass);
				preparedStatement.setNString(2, email);
				int rowAffect = preparedStatement.executeUpdate();
				if (rowAffect == 1) return true;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		//kiểm tra pass
		public static boolean checkPass(String pass, String email) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
			Connection connection;
			User user = new User();
			
			connection = DBConnection.getConnection();
			String convertPass = convertHashToString(pass);
			String sql = "SELECT password FROM [users] WHERE email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setNString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user.setPassword(resultSet.getString("password"));	
			}
			if (user.getPassword().equals(convertPass)) {
				return true;
			}
			return false;
		}
		//update user
		public static boolean updateUser(int idUser, User user) {
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "UPDATE [users] SET first_name = ?, last_name = ?, email = ?, phone = ?, cmnd = ?, role_id = ? WHERE user_id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setNString(1, user.getFirstName());
				preparedStatement.setNString(2, user.getLastName());
				preparedStatement.setNString(3, user.getEmail());
				preparedStatement.setInt(4, user.getPhone());
				preparedStatement.setInt(5, user.getCmnd());
				preparedStatement.setInt(6, user.getRole());
				preparedStatement.setInt(7, idUser);
				int rowAffect = preparedStatement.executeUpdate();
				if (rowAffect == 1) return true;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean deleteUser(int id) {
			Connection connection;
			try {
				connection = DBConnection.getConnection();
				String sql = "DELETE FROM [users] where user_id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				int rowAffect = preparedStatement.executeUpdate();
				if (rowAffect == 1) return true;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		public static void main(String[] args) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException {
//			System.out.println(checkLogin("tuanthanh@gmail.com", "123"));
//			System.out.println(convertHashToString("123"));
//			System.out.println(getThongTinUser(1).toString());
//			System.out.println(insertUser(new User(4, "tuấn", "thành", "thanh@gmail.com", 84203910, 251131359, "123", 1,0,"")));
//			System.out.println(checkUser("thanh@gmail.com"));
//			System.out.println(napTien(13, 100000));
//			System.out.println(sendMail("16130579@st.hcmuaf.edu.vn", "New", "Success"));
//			System.out.println(changePassword("thanh@gmail.com", "thanh98thehepro"));
//			System.out.println(checkPass("thanh98thehepro", "thanh@gmail.com"));
//			ArrayList<User> list = getListUser();
//			for (User user : list) {
//				System.out.println(user.toString());
//			}
			User u = new User(13, "tuan", "thanh", "thanh@gmail.com", 384203910 , 1, "", 2, 100000, "");
			System.out.println(updateUser(13, u));
		}
}
