package systemdesgin.vendingmachine.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {
	private Inventory<Coin> coinInventory = new Inventory<Coin>();
	private Inventory<Item> itemInventory = new Inventory<Item>();
	private int totalSales;
	private int currentBalance;
	private Item currentItem;

	public VendingMachineImpl() {
		// initialize 5 coins and 5 Items
		for (Coin c : Coin.values())
			coinInventory.put(c, 5);

		for (Item item : Item.values())
			itemInventory.put(item, 5);

	}

	@Override
	public int selectItemAndGetPrice(Item item) {
		if (itemInventory.hasItem(item)) {
			currentItem = item;
			return currentItem.getPrice();
		}

		throw new SoldoutException("Sold out, please buy another item");
	}

	@Override
	public List<Coin> refund() {
		List<Coin> change = getChange(currentBalance);
		updateCoinInventory(change);
		currentBalance = 0;
		currentItem = null;
		return change;
	}

	@Override
	public Bucket<Item, List<Coin>> collectItemAndChange() {
		Item item = collectItem();
		List<Coin> change = collectChange();
		totalSales += currentItem.getPrice();
		Bucket<Item, List<Coin>> itemAndChange = new Bucket<>(item, change);
		return itemAndChange;
	}

	private Item collectItem() {
		if (isFullPaid()) {
			if (hasSufficientChange()) {
				itemInventory.deduct(currentItem);
				return currentItem;
			}
			throw new NotSufficientChangeException("Not sufficient change in inventory.");
		}

		int remainingBalance = currentItem.getPrice() - currentBalance;
		throw new NoFullPaidException(remainingBalance, "Price not full paid , remaning: ");
	}

	private List<Coin> collectChange() {
		int amount = currentBalance - currentItem.getPrice();
		List<Coin> change = getChange(amount);
		updateCoinInventory(change);
		currentBalance = 0;
		currentItem = null;
		return change;
	}

	@Override
	public void reset() {
		coinInventory.clear();
		itemInventory.clear();
		totalSales = 0;
		currentBalance = 0;
		currentItem = null;

	}

	private void updateCoinInventory(List<Coin> coins) {
		for (Coin coin : coins)
			coinInventory.deduct(coin);
	}

	private int getTotalSales() {
		return totalSales;
	}

	@Override
	public void insertCoin(Coin coin) {
		currentBalance += coin.getDenomination();
		coinInventory.addItem(coin);

	}

	private List<Coin> getChange(int amount) throws NotSufficientChangeException {
		List<Coin> changes = Collections.EMPTY_LIST;
		if (amount > 0) {
			int balance = amount;
			changes = new ArrayList<Coin>();
			while (balance > 0) {
				if (balance >= Coin.FIVE.getDenomination() && coinInventory.hasItem(Coin.FIVE)) {
					balance = balance - Coin.FIVE.getDenomination();
					changes.add(Coin.FIVE);
					continue;
				} else if (balance >= Coin.TWO.getDenomination() && coinInventory.hasItem(Coin.TWO)) {
					balance = balance - Coin.TWO.getDenomination();
					changes.add(Coin.TWO);
					continue;
				} else if (balance >= Coin.ONE.getDenomination() && coinInventory.hasItem(Coin.ONE)) {
					balance = balance - Coin.ONE.getDenomination();
					changes.add(Coin.ONE);
					continue;
				} else {
					throw new NotSufficientChangeException("Not sufficient change, please try other item.");
				}
			}
		}

		return changes;
	}

	private boolean hasSufficientChange() {
		return hasSufficientChageForAmount(currentBalance - currentItem.getPrice());
	}

	private boolean hasSufficientChageForAmount(int amount) {
		boolean hasChange = true;
		try {
			getChange(amount);
		} catch (NotSufficientChangeException exception) {
			hasChange = false;
		}

		return hasChange;
	}

	private boolean isFullPaid() {
		if (currentBalance >= currentItem.getPrice())
			return true;

		return false;
	}

}
