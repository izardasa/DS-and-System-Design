package systemdesgin.vendingmachine.impl;

public class VendingMachineFactory {
public static VendingMachine getVendingMachine()
{
	return new VendingMachineImpl();
}
}
