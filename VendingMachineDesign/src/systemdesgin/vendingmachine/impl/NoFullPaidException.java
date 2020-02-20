package systemdesgin.vendingmachine.impl;

public class NoFullPaidException extends RuntimeException{

	private int balance;
	private String message;
	
	public NoFullPaidException(int balance, String message) {
		super();
		this.balance = balance;
		this.message = message;
	}
	
	public long getRemaining()
	{
		return balance;
	}
	
	@Override
	public String getMessage(){
		return message+balance;
	}
}
