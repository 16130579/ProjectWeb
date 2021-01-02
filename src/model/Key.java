package model;

public class Key {
int id;
String key_code;
int product_id;
int key_status;
public Key(int id, String key_code, int product_id, int key_status) {
	super();
	this.id = id;
	this.key_code = key_code;
	this.product_id = product_id;
	this.key_status = key_status;
}
public Key() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getKey_code() {
	return key_code;
}
public void setKey_code(String key_code) {
	this.key_code = key_code;
}
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public int getKey_status() {
	return key_status;
}
public void setKey_status(int key_status) {
	this.key_status = key_status;
}
@Override
public String toString() {
	return "Key [id=" + id + ", key_code=" + key_code + ", product_id=" + product_id + ", key_status=" + key_status
			+ "]";
}

}
