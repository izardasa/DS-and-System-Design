package systemdesign.parkinglot.models;

public class ExitPanel {
private String id;

public void scanTicket(){};
public void processPayment(String ticketNumber){}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
};
}
