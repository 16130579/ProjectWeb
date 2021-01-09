package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DBConnection;
import model.Category;
import model.Key;
import model.OrderItem;
import model.Product;

public class OrderItemDAO {
	public static boolean addOrderItem(OrderItem orderItem) {
		Connection connection;
		
		PreparedStatement statement = null;
		try {
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO [orderDetail] ([order_id], [product_id], [product_name], [product_key], [product_price], [amount]"
					+ ") VALUES (N'" +orderItem.getOrder_id() + "', N'" + orderItem.getProduct_id()
					+ "', N'" + orderItem.getProduct_name()+  "', N'" + orderItem.getProduct_key() + "', N'" + orderItem.getProduct_price() + "', N'"+ orderItem.getAmount() + "')";
			statement = connection.prepareStatement(sql);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateOrderItem(OrderItem orderItem,int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "UPDATE orderDetail SET order_id = ?, product_id = ?, product_name = ?, product_key = ?, product_price= ?, amount = ?  where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderItem.getOrder_id());
			preparedStatement.setInt(2, orderItem.getProduct_id());
			preparedStatement.setNString(3, orderItem.getProduct_name());
			preparedStatement.setNString(4, orderItem.getProduct_key());
			preparedStatement.setInt(5, orderItem.getProduct_price());
			preparedStatement.setInt(6, orderItem.getAmount());
			preparedStatement.setInt(7, id);
			
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteOrderItem(int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "DELETE FROM [orderDetail] where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<OrderItem> getListOrderItemByOrder(int orderId){
		ArrayList<OrderItem> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [orderDetail] where [order_id] = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setProduct_key(resultSet.getNString("product_key"));
				orderItem.setProduct_name(resultSet.getNString("product_name"));
				orderItem.setProduct_price(resultSet.getInt("product_price"));
				orderItem.setAmount(resultSet.getInt("amount"));
				list.add(orderItem);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args) {
		OrderItem orderItem = new OrderItem(0, 6, 1, "thanh", "aaaa", 30000, 3);
		System.out.println(addOrderItem(orderItem));
	}
}
