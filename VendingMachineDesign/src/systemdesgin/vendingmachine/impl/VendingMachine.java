package systemdesgin.vendingmachine.impl;

import java.util.List;

public interface VendingMachine {
	public int selectItemAndGetPrice(Item item);

	public List<Coin> refund();

	public Bucket<Item, List<Coin>> collectItemAndChange();

	public void reset();

	public void insertCoin(Coin coin);
}
