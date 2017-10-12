//package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EventAnalyzer {
	
	private static HashMap<String, Integer> nInterest;
	private static HashMap<String, Integer> outAndAbout;
	private static HashMap<String, String> temp;
	
	private static HashMap<String, ArrayList<Event>> personsEvents;
	private static HashMap<String, ArrayList<String>> personsNbs;
	private static HashMap<String, Integer> nbsNums;
	
	// Implement solution here
	public static String mostInterestedNeighborhood(ArrayList<Event> events) 
	{
		createPersonsEvents(events);
		createnbsNums();
		
		String result = null;
		int high = -1;
		
		for(String n: nbsNums.keySet())
		{
			if(nbsNums.get(n) > high)
			{
				result = n;
				high = nbsNums.get(n);
			}
		}
		
		
		return result;
	}
	
	private static void createnbsNums() 
	{
		
		if(nbsNums == null)
		{
			nbsNums = new HashMap<>();
			
			for(String s : personsNbs.keySet())
			{
				for(String n: personsNbs.get(s))
				{
					if(nbsNums.get(s) == null)
					{
						nbsNums.put(n, 0);
					}
					
					nbsNums.put(n, nbsNums.get(n) + 1);
				}
			}
		}
		
	}

	//Implement solution here
	public static String leastInterestedNeighborhood(ArrayList<Event> events) 
	{
		createPersonsEvents(events);
		createnbsNums();
		
		String result = null;
		int high = Integer.MAX_VALUE;
		
		for(String n: nbsNums.keySet())
		{
			if(nbsNums.get(n) < high)
			{
				result = n;
				high = nbsNums.get(n);
			}
		}
		
		
		return result;
	}
	
	//Implement solution here
	public static String [] topIndividualsInterestedInLocations(ArrayList<Event> events) 
	{
		createPersonsEvents(events);
		
		String[] ans = new String[4];
		
		for(String s: personsNbs.keySet())
		{
			int numNbs = personsNbs.get(s).size();
			
			int index = 0;
			
			while(index < 4)
			{
				if(ans[index] == null)
				{
					ans[index] = s;
					index = 4;
				}
				else
				{
					if(personsNbs.get(ans[index]).size() < numNbs)
					{
						for(int i = 3; i > index; i--)
						{
							ans[i] = ans[i - 1];
							
						}
						
						ans[index] = s;
						index = 4;
					}
				}
				
				index++;
			}
			
		}
		
		return ans;
	}
	
	//Implement solution here
	public static String [] wheresWaldo (ArrayList<Event> events) 
	{
		return null;

	}
	
	public static void createPersonsEvents(ArrayList<Event> events)
	{
		
		final String ENTER = "enter";
		final String EXIT = "exit";
		
		if(personsEvents == null)
		{
			personsEvents = new HashMap<>();
			
			for(Event e: events)
			{
				if(!(personsEvents.containsKey(e.getUserID())))
				{
					personsEvents.put(e.getUserID(), new ArrayList<>());
				}
				
				personsEvents.get(e.getUserID()).add(e);
			}
			
		}
		
		createPersonsnbs();
	
	}

	private static void createPersonsnbs() 
	{
		if(personsNbs == null)
		{
			personsNbs = new HashMap<>();
			
			for(String s : personsEvents.keySet())
			{
				long ts = 0;
				String nb = null;
				for(Event e: personsEvents.get(s))
				{
					if(e.getEventType().equals("enter"))
					{
						ts = e.getTimeStamp();
						nb = e.getNeighborhood();
					}
					
					if(nb != null)
					{
						long diff = e.getTimeStamp() - ts;
						
						if(diff >= 30)
						{
							if(personsNbs.get(s) == null)
								personsNbs.put(s, new ArrayList<>());
							
							if(!(personsNbs.get(s).contains(nb)))
								personsNbs.get(s).add(nb);
							
							nb = null;
						}
					}
						
				}
			}
		}
		
	}
}
