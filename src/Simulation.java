import java.text.DecimalFormat;


public class Simulation 
{
	public static PQ agenda;
	public static Stop[] stopArray;
	public static Bus[] busArray;
	public static int riderFrequency = 0;
	
	public static void main(String[] args)
	{
		agenda = new PQ();
		
		stopArray = new Stop[18];
		busArray = new Bus[10];
		
		for (int i = 0; i < stopArray.length; i++)//creating the 18 stops
		{
			stopArray[i] = new Stop(i+1);
		}
		
		
		
		////////////////////////////////////  T    H    E         C     O     N     T     R     O     L     S  /////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		busArray[0] = new Bus();//1       to add or remove busses from the sim, comment out/in BOTH corresponding lines creating the Bus/BusEvent///
		busArray[1] = new Bus();//2
		busArray[2] = new Bus();//3
		busArray[3] = new Bus();//4
		busArray[4] = new Bus();//5
		busArray[5] = new Bus();//6
		busArray[6] = new Bus();//7
//		busArray[7] = new Bus();//8
//		busArray[8] = new Bus();//9
//		busArray[9] = new Bus();//10

		
		agenda.add(new BusEvent(busArray[0], 1),agenda.getCurrentTime()); //1
		agenda.add(new BusEvent(busArray[1], 3),agenda.getCurrentTime()); //2
		agenda.add(new BusEvent(busArray[2], 5),agenda.getCurrentTime()); //3
		agenda.add(new BusEvent(busArray[3], 7),agenda.getCurrentTime());//4
		agenda.add(new BusEvent(busArray[4], 9),agenda.getCurrentTime());//5
		agenda.add(new BusEvent(busArray[5], 11),agenda.getCurrentTime());//6
		agenda.add(new BusEvent(busArray[6], 13),agenda.getCurrentTime());//7
//		agenda.add(new BusEvent(busArray[7], 15),agenda.getCurrentTime());//8
//		agenda.add(new BusEvent(busArray[8], 17),agenda.getCurrentTime());//9
//		agenda.add(new BusEvent(busArray[9], 18),agenda.getCurrentTime());//10
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////change rider frequency here. Bigger number means less frequent riders appearing////////////////////////////////////////////
		riderFrequency = 20;//(this number adds X seconds in between each rider being added)////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		while (agenda.getCurrentTime() < 18000)//set length of sim time here. 18,000 = 5 hours
		{
			agenda.remove().run();
		}
		
		
		
		
		
		
		
		System.out.println("\n" + Stats.totalRiders + " total riders");
		System.out.println(Stats.finishedRiders.length() + " total riders moved completely through the system and exited");
		
		Stats.calculate();
		
		System.out.println("\nAverage queue length: " + Stats.averageQueueLength + "\n");
		
		System.out.println("Average wait time until boarding: " + Stats.averageWait + " minutes " + Stats.remainder + " seconds\n");
		
		System.out.println("Riders waiting <2 minutes: " + new DecimalFormat("0.##").format(Stats.waitLengths[0]) + "%");
		System.out.println("Riders waiting 2-5 minutes: " + new DecimalFormat("0.##").format(Stats.waitLengths[1]) + "%");
		System.out.println("Riders waiting 5-10 minutes: " + new DecimalFormat("0.##").format(Stats.waitLengths[2]) + "%");
		System.out.println("Riders waiting 10-15 minutes: " + new DecimalFormat("0.##").format(Stats.waitLengths[3]) + "%");
		System.out.println("Riders waiting 15-20 minutes: " + new DecimalFormat("0.##").format(Stats.waitLengths[4]) + "%");
		System.out.println("Riders waiting 20-30 minutes: " + new DecimalFormat("0.##").format(Stats.waitLengths[5]) + "%");
		System.out.println("Riders waiting 30+ minutes: " + new DecimalFormat("0.##").format(Stats.waitLengths[6]) + "%");


		
	}
	
	//run 7 simulations for 1-7 busses, starting at beyond worst-case scenario busy, dialing down until equilebrium is found.
	//then put together a final recommendation for # of busses for 0-some number of riders(the upper limit of sim #7)

}
