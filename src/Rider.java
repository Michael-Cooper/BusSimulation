
public class Rider 
{
	int arrivalTime;
	int boardingTime;
	int stopBoardingNumber;
	int stopExitNumber;
	int blocksTraveled;
	
	
	public Rider(int arrivalTime, int exit, int stop, int blocksTraveled)
	{
		this.arrivalTime = arrivalTime;
		this.stopExitNumber = exit;
		this.stopBoardingNumber = stop;
		this.blocksTraveled = blocksTraveled;
		
		
	}
	
	
	public int getStopExitNumber()
	{
		return stopExitNumber;
	}
	
	public void setBoardingTime(int n)
	{
		this.boardingTime = n;
	}


	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	
	public int getBoardingTime()
	{
		return this.boardingTime;
	}


	

}
