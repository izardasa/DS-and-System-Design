package systemdesgin.vendingmachine.impl;

public class SoldoutException extends RuntimeException {
	private String message;

	public SoldoutException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
