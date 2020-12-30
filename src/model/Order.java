package model;

import java.sql.Timestamp;

public class Order {
int id;
Timestamp createAt;
int price;
int status;
int user_id;
public Order(int id, Timestamp createAt, int price, int status, int user_id) {
	super();
	this.id = id;
	this.createAt = createAt;
	this.price = price;
	this.status = status;
	this.user_id = user_id;
}

public Order() {
	super();
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Timestamp getCreateAt() {
	return createAt;
}
public void setCreateAt(Timestamp createAt) {
	this.createAt = createAt;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
@Override
public String toString() {
	return "Oder [id=" + id + ", createAt=" + createAt + ", price=" + price + ", status=" + status + ", user_id="
			+ user_id + "]";
}

}
