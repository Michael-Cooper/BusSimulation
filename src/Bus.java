
public class Bus 
{
	int nextStop;
	int ridersOnBoard;
	Rider[] riders = new Rider[68];
	
	
	public Bus()
	{
		
	}
	
	
	
	
	
	
	
	public Rider[] getRiders()
	{
		return riders;
	}
	
	public int getRidersOnBoard()
	{
		return ridersOnBoard;
	}
	
	public void setRidersOnBoard(int num)
	{
		this.ridersOnBoard = num;
	}


	

}
