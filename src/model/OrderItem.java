package model;

public class OrderItem {
int id;
int order_id;
int product_id;
String product_name;
String product_key;
String product_price;
int amount;

public OrderItem() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_key() {
	return product_key;
}
public void setProduct_key(String product_key) {
	this.product_key = product_key;
}
public String getProduct_price() {
	return product_price;
}
public void setProduct_price(String product_price) {
	this.product_price = product_price;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public OrderItem(int id, int order_id, int product_id, String product_name, String product_key, String product_price,
		int amount) {
	super();
	this.id = id;
	this.order_id = order_id;
	this.product_id = product_id;
	this.product_name = product_name;
	this.product_key = product_key;
	this.product_price = product_price;
	this.amount = amount;
}
@Override
public String toString() {
	return "OrderIteam [id=" + id + ", order_id=" + order_id + ", product_id=" + product_id + ", product_name="
			+ product_name + ", product_key=" + product_key + ", product_price=" + product_price + ", amount=" + amount
			+ "]";
}

}
