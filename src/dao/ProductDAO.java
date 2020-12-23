package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.DBConnection;
import model.Category;
import model.Product;

public class ProductDAO {
// the loai
	public static ArrayList<Category> getListCategory(){
		ArrayList<Category> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [category]";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				list.add(category);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<Product> getListProduct(){
		ArrayList<Product> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [product]";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("product_id"));
				product.setName(resultSet.getNString("product_name"));
				product.setImg(resultSet.getNString("product_img"));
				product.setPrice(resultSet.getInt("product_price"));
				product.setSales(resultSet.getInt("product_sale"));
				product.setDes(resultSet.getNString("product_des"));
				product.setStatus(resultSet.getInt("product_status"));
				product.setCategory_id(resultSet.getInt("category_id"));
				list.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(getListCategory().toString());
		System.out.println(getListProduct().toString());
	}
}