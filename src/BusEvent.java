
public class BusEvent implements Event
{
	Bus b;
	double stopNum;
	double time;
	
	public BusEvent(Bus b, double stopNumber)
	{
		this.b = b;
		this.stopNum = stopNumber;
	}
	

	@Override
	public void run() //look in the bus's array, check each person's destination against the stopnumber passed in
	{		
		
		Rider[] riders = this.b.getRiders();
		int ridersOnBoard = this.b.getRidersOnBoard();
		
		
		
		
		//removes riders who want to get off at this stop
		for (int i = 0; i < riders.length; i++)
		{
			if (riders[i] != null)
			{
				if (riders[i].getStopExitNumber() == this.stopNum)
				{
					Stats.finishedRiders.add(riders[i]);//when riders "leave" the sim, they go into a queue in Stats for later analysis
					
					
					riders[i] = null;
					ridersOnBoard--;
					this.b.setRidersOnBoard(ridersOnBoard);
					System.out.println(this.b.getRidersOnBoard());     //comment in/out to see how full buses are getting/staying///////////////////////
					
					this.time += 2;//2 seconds for passenger to exit
				}
			}
		}
		
		
		
		
		
		//boards passengers waiting at stop
		for (int i = 0; i < riders.length; i++)
		{
			if(Simulation.stopArray[(int)this.stopNum-1].getRiderQ().length() != 0)//if there are people waiting at the busstop, do:
			{
				if(riders[i] == null)
				{
					riders[i] = (Rider) Simulation.stopArray[(int)this.stopNum-1].getRiderQ().remove();
					riders[i].setBoardingTime((int)Simulation.agenda.getCurrentTime());
					ridersOnBoard++;
					this.b.setRidersOnBoard(ridersOnBoard);

					Stats.averageQueueLength+= Simulation.stopArray[(int)this.stopNum-1].qLength();
					Stats.queueCnt++;

					this.time += 5;//5 seconds for passenger to board
				}
			}
		}


		
		
		//generates another BusEvent.  The if/else deals with looping from stop 18 back to 1
		if(this.stopNum-1 < 17)
			Simulation.agenda.add(new BusEvent(this.b,this.stopNum+1),24+time);
		else
			Simulation.agenda.add(new BusEvent(this.b,1),24+time);		
	}

}
