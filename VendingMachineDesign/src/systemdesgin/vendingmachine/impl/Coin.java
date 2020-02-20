package systemdesgin.vendingmachine.impl;

public enum Coin {
ONE(1),FIVE(5), TWO(2);
	
	private int denomination;
	
	public int getDenomination(){
		return denomination;
	}

	private Coin(int denomination) {
		this.denomination = denomination;
	}


}
