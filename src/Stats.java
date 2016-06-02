
public class Stats 
{
	public static int totalRiders;
	public static int averageWait;
	public static int remainder;
	public static int averageQueueLength;
	public static int maxQueueLength;
	public static int queueCnt;
	
	
	public static double[] waitLengths = new double[7];
	public static Q1 finishedRiders = new Q1(); //when riders get off at a bus-stop, they enter this queue purgatory
	
	
	
	public static void calculate()
	{
		averageQueueLength = averageQueueLength/totalRiders;
		
		double average = 0;
		Q1 temp = new Q1();
		double cnt = 0;
		
		while(finishedRiders.length() != 0)
		{
			Rider rider = (Rider) finishedRiders.remove();
			double riderWait = rider.getBoardingTime() - rider.getArrivalTime();
			average += riderWait;
			
			
			
			//waitLengths[0] = rider waited for less than 2 minutes.  waitLengths[1] 2-5 minutes, [2] 5-10, [3]10-15, [4]15-20, [5]20-30, [6] >30 minutes
			if (riderWait < 121)
				waitLengths[0]++;
			else if(riderWait < 301)
				waitLengths[1]++;
			else if(riderWait < 601)
				waitLengths[2]++;
			else if(riderWait < 900)
				waitLengths[3]++;
			else if(riderWait < 1200)
				waitLengths[4]++;
			else if(riderWait < 1800)
				waitLengths[5]++;
			else
				waitLengths[6]++;
			
			
			
			cnt++;
			
			temp.add(rider);
			
		}
		
		//converting each number to a percentage of the total riders
		for (int i=0; i < 7; i++)
		{
			waitLengths[i] = waitLengths[i]/cnt *100;
		}
		


		finishedRiders = temp;
		averageWait = (int)(average/cnt);
		if(averageWait > 60)
		{
			remainder = averageWait%60;//converts average wait into x minutes x seconds
			averageWait = averageWait/60;
		}
	}
	
	
	
	

}
