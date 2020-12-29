package model;

public class Cart {
String name;
String img;
int price;
int amount;
int total;
public Cart() {
	super();
}
public Cart(String name, String img, int price, int amount,int total) {
	super();
	this.name = name;
	this.img = img;
	this.price = price;
	this.amount = amount;
	this.total = total;
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
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}

public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
@Override
public String toString() {
	return "Cart [name=" + name + ", img=" + img + ", price=" + price + ", amount=" + amount + "]";
}

}
