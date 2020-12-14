package model;

public class Product {
int id;
String name;
String img;
int price;
int sales;
String des;

public Product() {
	
}

public Product(int id, String name, String img, int price, int sales, String des) {
	super();
	this.id = id;
	this.name = name;
	this.img = img;
	this.price = price;
	this.sales = sales;
	this.des = des;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getSales() {
	return sales;
}

public void setSales(int sales) {
	this.sales = sales;
}

public String getDes() {
	return des;
}

public void setDes(String des) {
	this.des = des;
}

}
