package elevator.systemdesign.models;

public class Elevator {

	private int numFloors;
	private boolean[] floors;
	private Direction direction;
private int currentFloor;
	public Elevator(int numFloors) {
		if (numFloors < 0)
			throw new IllegalArgumentException();
		this.numFloors = numFloors;
		floors = new boolean[numFloors];
	}

	public Direction getDirection() {
		return direction;
	}
	
	public int getCurrentFloor()
	{
		return currentFloor;
	}
	
	public int getNextFloor()
	{
		if(direction.equals(Direction.UP))
		{
			while(currentFloor<=Constants.MAX_FLOOR)
			{
				if(floors[currentFloor]==true)
				{
					currentFloor++;
					break;
				}
			}	
		}
		else if(direction.equals(Direction.DOWN))
		{
			while(currentFloor>=Constants.MIN_FLOOR)
			{
				if(floors[currentFloor]==true)
					{
					currentFloor--;
					break;
					}
			}
		}
		return currentFloor;
	}
	
	public void pressFloorNo(int floorNo)
	{
		if(floorNo>Constants.MAX_FLOOR || floorNo<Constants.MIN_FLOOR)
			throw new IllegalArgumentException("Invalid floor number.");
		
		floors[floorNo]=true;
	}
	
	public void reset()
	{
		currentFloor = Constants.MIN_FLOOR;
		for(int i=Constants.MIN_FLOOR;i<=Constants.MAX_FLOOR;i++)
		{
			floors[i]=false;
		}
		direction = Direction.NONE;
	}

}
