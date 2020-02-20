package systemdesign.parkinglot.models;

import systemdesign.parkinglot.enums.AccountStatus;

public abstract class Account {
private String password;
private String username;
private AccountStatus accountStatus;
private Person person;

public void resetPassword(){};
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public AccountStatus getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(AccountStatus accountStatus) {
	this.accountStatus = accountStatus;
}
}
