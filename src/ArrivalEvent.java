
public class ArrivalEvent implements Event
{
	int[] rideLength;
	int length;//this will be the stop they'll be getting off at, calculated by what stop they arrive at and how many blocks they want to ride for
	int stop;
	double arrivalTime;
	
	public ArrivalEvent(int stop)//the stop which corresponds to this arrivalEvent gets passed into the constructor
	{
		this.stop = stop;
	}

	
		
	

	@Override
	public void run() 
	{
		rideLength = new int[] {2, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10,
		                     11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 15, 15, 15, 16};//array to assign an end stop to new riders
		
		length = (int)(Math.random()*49 +1);
		length = rideLength[length];
		int blocksTraveled = length;
		
		if (length + stop > 18)
			length = (length + stop) - 18;//for case of looping from stop 18 back to 1
		else
			length = length + stop;
		
		
		
		
		
		Rider newRider = new Rider((int)Simulation.agenda.getCurrentTime(),length, this.stop, blocksTraveled);//set current time to rider's arrival time, length is rider's destination stop
		

		Stats.totalRiders++;//keeping track of the total number of riders created, or "arriving" in the sim



		Simulation.stopArray[stop-1].addRider(newRider);//add the newly arrived rider to the corresponding bus-stop queue

		System.out.println("Stop " + stop + " queue length: " + Simulation.stopArray[stop-1].qLength());//comment in/out to see Bus-stop queue lengths

		Stats.queueCnt++;
		Stats.averageQueueLength += Simulation.stopArray[stop-1].qLength();


		arrivalTime = (int)(Math.random()*100+1);//this block of code randomizes when the next rider will arrive at this stop

		if (arrivalTime < 11)
			arrivalTime = 17.5;
		else if(arrivalTime < 26)
			arrivalTime = 15;
		else if(arrivalTime < 46)
			arrivalTime = 12;
		else if (arrivalTime < 56)
			arrivalTime = 10;
		else if(arrivalTime < 76)
			arrivalTime = 8;
		else if(arrivalTime < 91)
			arrivalTime = 5;
		else
			arrivalTime = 2.5;
		
		Simulation.agenda.add(new ArrivalEvent(this.stop), arrivalTime + Simulation.riderFrequency);//set up another rider arriving at this stop in the future
	
		
		
		
		
	}

}
