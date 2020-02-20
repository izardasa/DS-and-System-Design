package systemdeisgn.linkedin.impl;

import java.util.List;

import systemdeisgn.linkedin.model.Location;

public class Company {
private String name;
private Location address;
private int strength;
private String type;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Location getAddress() {
	return address;
}
public void setAddress(Location address) {
	this.address = address;
}
public int getStrength() {
	return strength;
}
public void setStrength(int strength) {
	this.strength = strength;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

private List<Job> jobs;
public boolean postJobs(List<Job> jobs){return true;}
}
