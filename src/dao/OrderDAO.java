package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import controller.DBConnection;
import model.Order;
import model.Product;

public class OrderDAO {
	public static boolean addOrder(Order order) {
		Connection connection;
		PreparedStatement statement = null;
		try {
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO [orders] ([createAt], [price], [status], [user_id]"
					+ ") VALUES (N'" +order.getCreateAt() + "', N'" + order.getPrice()
					+ "', N'" + 1 +  "', N'" + order.getUser_id()+ "')";
			statement = connection.prepareStatement(sql);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
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
	public static void main(String[] args) {
//		Date now = new Date();
//		Timestamp timestamp = new Timestamp(now.getTime());
//		Order o = new Order(1, timestamp, 100000, 1, 13);
//		System.out.println(addOrder(o));
		System.out.println(deleteOrder(2));
	}
	
}
