package systemdesing.moviebooking.impl;

public class Person {
private String name;
private String email;
private String phone;
private Location address;
private Account account;
public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Location getAddress() {
	return address;
}
public void setAddress(Location address) {
	this.address = address;
}
}
