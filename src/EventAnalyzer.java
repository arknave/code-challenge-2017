import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EventAnalyzer {
	
	// Implement solution here
	public static String mostInterestedNeighborhood(ArrayList<Event> events) {
		
		HashMap<String, Integer> lol = new HashMap<>();
		HashMap<String, Event> firstEnter = new HashMap<String, Event>();
		
		for (Event event : events) {
			
			Event e2 = firstEnter.remove(event.getUserID());
			
			if (e2 == null) {
				
				firstEnter.put(event.getUserID(), event);
			}
			else {
				//System.out.println((e2.getTimeStamp() - event.getTimeStamp()));
				if (Math.abs(e2.getTimeStamp() - event.getTimeStamp()) >= 30) {
					
					Integer pop = lol.get(e2.getNeighborhood());
					if (pop == null) {
						
						lol.put(e2.getNeighborhood(), 1);
					}
					else {
						
						lol.put(e2.getNeighborhood(), pop + 1);
					}
				}
			}
		}
		
		String neigh = null;
		int visit = 0;
		
		//System.out.println(lol.size());
		
		for (Map.Entry<String, Integer> e : lol.entrySet()) {
			System.out.println(e.getKey());
		System.out.println(e.getValue());	
			if (e.getValue() > visit) {
				visit = e.getValue();
				neigh = e.getKey();
			}
				
		}
		
		return neigh;
	}
	
	//Implement solution here
	public static String leastInterestedNeighborhood(ArrayList<Event> events) {
		HashMap<String, Integer> lol = new HashMap<>();
		HashMap<String, Event> firstEnter = new HashMap<String, Event>();
		
		for (Event event : events) {
			
			Event e2 = firstEnter.remove(event.getUserID());
			
			if (e2 == null) {
				
				firstEnter.put(event.getUserID(), event);
			}
			else {
				//System.out.println((e2.getTimeStamp() - event.getTimeStamp()));
				if (Math.abs(e2.getTimeStamp() - event.getTimeStamp()) >= 30) {
					
					Integer pop = lol.get(e2.getNeighborhood());
					if (pop == null) {
						
						lol.put(e2.getNeighborhood(), 1);
					}
					else {
						
						lol.put(e2.getNeighborhood(), pop + 1);
					}
				}
			}
		}
		
		String neigh = null;
		int visit = Integer.MAX_VALUE;
		
		//System.out.println(lol.size());
		
		for (Map.Entry<String, Integer> e : lol.entrySet()) {
			System.out.println(e.getValue());
			if (e.getValue() < visit) {
				visit = e.getValue();
				neigh = e.getKey();
			}
				
		}
		
		return neigh;
	}
	
	//Implement solution here
	public static String [] topIndividualsInterestedInLocations(ArrayList<Event> events) {
		return null;
	}
	
	//Implement solution here
	public static String [] wheresWaldo (ArrayList<Event> events) {
		
		HashMap<String, Integer> lol = new HashMap<>();
		HashMap<String, Event> firstEnter = new HashMap<String, Event>();
		
		for (Event event : events) {
			
			Event e2 = firstEnter.remove(event.getUserID());
			
			if (e2 == null) {
				
				firstEnter.put(event.getUserID(), event);
			}
			else {
				//System.out.println((e2.getTimeStamp() - event.getTimeStamp()));
				if (Math.abs(e2.getTimeStamp() - event.getTimeStamp()) >= 30) {
					
					Integer pop = lol.get(e2.getUserID());
					if (pop == null) {
						
						lol.put(e2.getUserID(), 1);
					}
					else {
						
						lol.put(e2.getUserID(), pop + 1);
					}
				}
			}
		}
		
		ArrayList<String>sillyresult = new ArrayList<>();
		int neighborVisit = 0;
		
		//System.out.println(lol.size());
		/*
		for (Map.Entry<String, Integer> e : lol.entrySet()) {
			System.out.println(e.getValue());
			if (e.getValue() > neighborVisit) {
				visit = e.getValue();
				sillyresult = e.getKey();
			}
				
		}*/
		
		return sillyresult.toArray(new String[sillyresult.size()]);

	}
}
