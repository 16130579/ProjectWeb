package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controller.DBConnection;
import model.Category;
import model.Order;
import model.OrderItem;
import model.Product;

public class OrderDAO {
	public static int addOrder(Order order) {
		Connection connection;
		PreparedStatement statement = null;
		int key = 0;
		try {
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO [orders] ([createAt], [price], [status], [user_id]"
					+ ") VALUES (N'" +order.getCreateAt() + "', N'" + order.getPrice()
					+ "', N'" + 1 +  "', N'" + order.getUser_id()+ "')";
			statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    key =  rs.getInt(1);
			}
			return key;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int getIdOrder(Order order){
		
		Connection connection;
		int id = 0;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [orders] where [createAt] = ?, [price]=?, [status] = ? , [user_id] = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setTimestamp(1, order.getCreateAt(), Calendar.getInstance());
			preparedStatement.setInt(2, order.getPrice());
			preparedStatement.setInt(3, order.getStatus());
			preparedStatement.setInt(4, order.getUser_id());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt("order_id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	public static ArrayList<Order> getListOrderById(int id){
		ArrayList<Order> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [orders] where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("order_id"));
				order.setCreateAt(resultSet.getTimestamp("createAt"));
				order.setPrice(resultSet.getInt("price"));
				list.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static boolean deleteOrder(int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "DELETE FROM orders where [order_id] = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Order> getListOrder(){
		ArrayList<Order> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [orders]";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("order_id"));
				order.setUser_id(resultSet.getInt("user_id"));
				order.setCreateAt(resultSet.getTimestamp("createAt"));
				order.setStatus(resultSet.getInt("status"));
				order.setPrice(resultSet.getInt("price"));
				list.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		Date now = new Date();
		Timestamp timestamp = new Timestamp(now.getTime());
//		Order o = new Order(1, timestamp, 100000, 1, 13);
//		System.out.println(addOrder(o));
//		System.out.println(deleteOrder(2));
//		Order o2 = new Order(1, timestamp, 100000, 1, 13);
//		System.out.println(getIdOrder(o2));
//		ArrayList<Order> list = getListOrder();
//		for (Order order : list) {
//			System.out.println(order.toString());
//		}
		System.out.println(deleteOrder(6));
	}
	
}
