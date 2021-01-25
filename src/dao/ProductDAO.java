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
	public static ArrayList<Product> getListProductTop4(){
		ArrayList<Product> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT TOP 4 * FROM [product]";
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
	public static boolean addProduct(Product product) {
		Connection connection;
		PreparedStatement statement = null;
		try {
			connection = DBConnection.getConnection();
			String sql = "INSERT INTO [product] (product_name, product_price, product_sale, product_des, product_status, category_id, product_img"
					+ ") VALUES (N'" +product.getName() + "', N'" + product.getPrice()
					+ "', N'" + product.getSales()+  "', N'" + product.getDes() + "', N'" + 1 + "', N'"+ 1 +"', N'" + product.getImg() + "')";
			statement = connection.prepareStatement(sql);
			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static Product getProductById(int id) {
		Product product = new Product();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [product] where product_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				product.setId(resultSet.getInt("product_id"));
				product.setName(resultSet.getNString("product_name"));
				product.setImg(resultSet.getNString("product_img"));
				product.setPrice(resultSet.getInt("product_price"));
				product.setSales(resultSet.getInt("product_sale"));
				product.setDes(resultSet.getNString("product_des"));
				product.setStatus(resultSet.getInt("product_status"));
				product.setCategory_id(resultSet.getInt("category_id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return product;
	}
	public static boolean updateProduct(Product product,int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "UPDATE [product] SET product_name = ?, product_price = ?, product_sale = ?, product_des = ?, product_status = ?, category_id = ?, product_img = ? where product_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setNString(1, product.getName());
			preparedStatement.setInt(2, product.getPrice());
			preparedStatement.setInt(3, product.getSales());
			preparedStatement.setNString(4, product.getDes());
			preparedStatement.setInt(5, product.getStatus());
			preparedStatement.setInt(6, product.getCategory_id());
			preparedStatement.setNString(7, product.getImg());
			preparedStatement.setInt(8, product.getId());
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteProduct(int id) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "DELETE FROM product where product_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rowAffect = preparedStatement.executeUpdate();
			if (rowAffect == 1) return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Product> getListProductByName(String name){
		ArrayList<Product> list = new ArrayList<>();
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			String sql = "SELECT * FROM [product] where product_name LIKE '%"+name+"%'";
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
//		System.out.println(getListCategory().toString());
//		System.out.println(getListProduct().toString());
//		Product p = new Product(10, "aaaa", "/ssss", 100000, 15420, "sssssss", 1, 1);
//		System.out.println(addProduct(p));
//		System.out.println(getProductById(1).toString());
//		Product p = getProductById(17);
//		p.setName("update");
//		System.out.println(updateProduct(p,17));
		System.out.println(getListProductByName("us").toString());
	}
}
