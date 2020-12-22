package model;

import sun.util.calendar.BaseCalendar.Date;

public class User {
	int id;
	String firstName;
	String lastName;
	String email;
	int phone;
	int cmnd;
	String password;
	int role;
	int balance;
	String key;
	Date keyDate;
	public User(int id, String firstName, String lastName, String email, int phone, int cmnd, String password,
			int role, int balance, String key) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.cmnd = cmnd;
		this.password = password;
		this.role = role;
		this.balance = balance;
		this.key = key;
	}
	
	public User() {
		super();
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCmnd() {
		return cmnd;
	}
	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", cmnd=" + cmnd + ", password=" + password + ", role=" + role + "]";
	}
	
	public static void main(String[] args) {
		
	}
}
