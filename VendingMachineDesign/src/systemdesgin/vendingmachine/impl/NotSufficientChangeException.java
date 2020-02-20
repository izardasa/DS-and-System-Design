package systemdesgin.vendingmachine.impl;

public class NotSufficientChangeException extends RuntimeException{

	private String message;

	public NotSufficientChangeException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
