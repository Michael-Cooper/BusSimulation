
public class Stop 
{
	
	Q1 riderQ = new Q1();
	int stopNumber;
	
	public Stop(int num) //constructor, initiates the ArrivalEvent for this stop
	{
		this.stopNumber = num;
		Simulation.agenda.add(new ArrivalEvent(this.stopNumber), 0);
	}
	
	public Q1 getRiderQ()
	{
		return this.riderQ;
	}
	
	public void addRider(Rider r)
	{
		riderQ.add(r);
	}
	
	public int qLength()
	{
		return riderQ.length();
	}





	

}
