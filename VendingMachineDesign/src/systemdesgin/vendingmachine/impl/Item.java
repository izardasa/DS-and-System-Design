package systemdesgin.vendingmachine.impl;

public enum Item {
COKE("Coke",25), PEPSI("Pepsi",30), SODA("Soda",45);
	
	private String name;
	private int price;
	
	private Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String getName()
	{
		return name;
	}
}
