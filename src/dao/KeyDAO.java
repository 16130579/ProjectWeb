package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DBConnection;
import model.Key;
import model.Product;

public class KeyDAO {
	public static boolean addKey(Key key) {
		Connection connection;
		PreparedStatement statement = null;
		try {
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO [productKey] ([key_code], [product_id], [key_status]"
					+ ") VALUES (N'" +key.getKey_code() + "', N'" + key.getProduct_id()
					+ "', N'" + key.getKey_status() + "')";
			statement = connection.prepareStatement(sql);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateKey(Key key,int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "UPDATE productKey SET key_code = ?, key_status = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setNString(1, key.getKey_code());
			preparedStatement.setInt(2, key.getKey_status());
			preparedStatement.setInt(3, id);
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteKey(int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "DELETE FROM [productKey] where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Key> getKeyByProductId(int id) {
		ArrayList<Key> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM productKey where product_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Key key = new Key();
				key.setId(resultSet.getInt("id"));
				key.setKey_code(resultSet.getNString("key_code"));
				key.setProduct_id(resultSet.getInt("product_id"));
				key.setKey_status(resultSet.getInt("key_status"));
				
				list.add(key);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	public static int countProductById(int id) {
		Connection connection;
		int count = 0;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM productKey where product_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
//			count = resultSet.getInt(1);
			while (resultSet.next()) {
				count = resultSet.getRow();
				
			}
				
				
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public static ArrayList<Key> getKeyByProductIdAmount(int id,int amount) {
		ArrayList<Key> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT TOP (?) * FROM productKey where product_id = ? and key_status = 1";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, amount);
			preparedStatement.setInt(2, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Key key = new Key();
				key.setId(resultSet.getInt("id"));
				key.setKey_code(resultSet.getNString("key_code"));
				key.setProduct_id(resultSet.getInt("product_id"));
				key.setKey_status(resultSet.getInt("key_status"));
				
				list.add(key);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	public static boolean updateKeyStatus(int status,int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "UPDATE productKey SET key_status = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, id);
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static Key getKeyByKeyId(int id) {
		Key key = new Key();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM productKey where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				key.setId(resultSet.getInt("id"));
				key.setKey_code(resultSet.getNString("key_code"));
				key.setProduct_id(resultSet.getInt("product_id"));
				key.setKey_status(resultSet.getInt("key_status"));
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return key;
	}
	public static void main(String[] args) {
		Key key = new Key();
		key.setKey_code("tuan");
		key.setKey_status(1);
//		System.out.println(addKey(key));
//		System.out.println(updateKey(key,3));
//		System.out.println(deleteKey(4));
//		System.out.println(getKeyByProductId(1).toString());
//		System.out.println(countProductById(1));
//		System.out.println(getKeyByProductIdAmount(1, 3).toString());
//		ArrayList<Key> list = getKeyByProductIdAmount(1, 3);
		
//		System.out.println(list.size()<1);
		System.out.println(updateKey(key, 2));
		
	}
}
