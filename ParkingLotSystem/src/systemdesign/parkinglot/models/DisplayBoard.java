package systemdesign.parkinglot.models;

public class DisplayBoard {
	private String id;
	private CompactSpot freeCompactSpot;
	private LargeSpot freeLargeSpot;
	private ElectricSpot freeElectricSpot;
	private HandicappedSpot freeHandicappedSpot;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CompactSpot getFreeCompactSpot() {
		return freeCompactSpot;
	}

	public void setFreeCompactSpot(CompactSpot freeCompactSpot) {
		this.freeCompactSpot = freeCompactSpot;
	}

	public LargeSpot getFreeLargeSpot() {
		return freeLargeSpot;
	}

	public void setFreeLargeSpot(LargeSpot freeLargeSpot) {
		this.freeLargeSpot = freeLargeSpot;
	}

	public ElectricSpot getFreeElectricSpot() {
		return freeElectricSpot;
	}

	public void setFreeElectricSpot(ElectricSpot freeElectricSpot) {
		this.freeElectricSpot = freeElectricSpot;
	}

	public HandicappedSpot getFreeHandicappedSpot() {
		return freeHandicappedSpot;
	}

	public void setFreeHandicappedSpot(HandicappedSpot freeHandicappedSpot) {
		this.freeHandicappedSpot = freeHandicappedSpot;
	}

	public void showFreeSpots() {
		String message = "";
		if (freeCompactSpot.isFree())
			message += " Compact spot " + freeCompactSpot.getNumber() + " is available";
		else
			message += " Compace spot is not available";

		if (freeLargeSpot.isFree())
			message += " Large spot " + freeLargeSpot.getNumber() + " is available.";
		else
			message += " Large spot is not avialble.";

		if (freeElectricSpot.isFree())
			message += " Electric spot " + freeElectricSpot.getNumber() + " is available.";
		else
			message += " Electric spot is not available";

		if (freeHandicappedSpot.isFree())
			message += " Handicapped spot " + freeHandicappedSpot.getNumber() + " is available.";
		else
			message += "Handicapped spot is not available.";

		show(message);
	}

	private void show(String message) {
		System.out.println(message);
	}
}
