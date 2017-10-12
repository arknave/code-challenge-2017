import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventAnalyzer {
	private static Map<String, Integer> interest;
	private static Map<String, Long> eventMap;
	
	// Implement solution here
	public static String mostInterestedNeighborhood(ArrayList<Event> events) {
		interest = new HashMap<String, Integer> ();
		eventMap = new HashMap<String, Long> ();
		for (Event e : events) {
			if (e.getEventType().compareTo("enter") == 0) {
				eventMap.put(e.getUserID(), e.getTimeStamp());
				if (!interest.containsKey(e.getNeighborhood()))
					interest.put(e.getNeighborhood(), 0);
			}
			else if (e.getEventType().compareTo("exit") == 0) {
				String userID = e.getUserID();
				long time = e.getTimeStamp();
				if (time - eventMap.get(userID) >= 30) {
					interest.put(e.getNeighborhood(), interest.get(e.getNeighborhood()) + 1);
				}
			}
		}
		String neighborhood = "";
		int max = 0;
		for (String e : interest.keySet()) {
			if (interest.get(e) > max) {
				max = interest.get(e);
				neighborhood = e;
			}
		}
		return neighborhood;
	}
	
	//Implement solution here
	public static String leastInterestedNeighborhood(ArrayList<Event> events) {
		interest = new HashMap<String, Integer> ();
		eventMap = new HashMap<String, Long> ();
		for (Event e : events) {
			if (e.getEventType().compareTo("enter") == 0) {
				eventMap.put(e.getUserID(), e.getTimeStamp());
				if (!interest.containsKey(e.getNeighborhood()))
					interest.put(e.getNeighborhood(), 0);
			}
			else if (e.getEventType().compareTo("exit") == 0) {
				String userID = e.getUserID();
				long time = e.getTimeStamp();
				if (time - eventMap.get(userID) >= 30) {
					interest.put(e.getNeighborhood(), interest.get(e.getNeighborhood()) + 1);
				}
			}
		}
		String neighborhood = "";
		int min = Integer.MAX_VALUE;
		for (String e : interest.keySet()) {
			if (interest.get(e) < min) {
				min = interest.get(e);
				neighborhood = e;
			}
		}
		return neighborhood;
	}
	
	//Implement solution here
	public static String [] topIndividualsInterestedInLocations(ArrayList<Event> events) {
		String[] topFour = new String[4];
		interest = new HashMap<String, Integer> ();
		eventMap = new HashMap<String, Long> ();
		for (Event e : events) {
			if (e.getEventType().compareTo("enter") == 0) {
				eventMap.put(e.getUserID(), e.getTimeStamp());
				interest.put(e.getUserID(), 0);
			}
			else if (e.getEventType().compareTo("exit") == 0) {
				String userID = e.getUserID();
				long time = e.getTimeStamp();
				if (time - eventMap.get(userID) >= 30) {
					interest.put(e.getUserID(), interest.get(e.getUserID()) + 1);
				}
			}
		}
		String userID = "";
		int max = 0;
		for (String e : interest.keySet()) {
			if (interest.get(e) > max) {
				max = interest.get(e);
				userID = e;
			}
		}
		topFour[0] = userID;
		
		String userID2 = "";
		int max2 = 0;
		for (String e : interest.keySet()) {
			if (interest.get(e) > max2 && e != userID) {
				max2 = interest.get(e);
				userID2 = e;
			}
		}
		topFour[1] = userID2;
		
		String userID3 = "";
		int max3 = 0;
		for (String e : interest.keySet()) {
			if (interest.get(e) > max3 && e != userID && e != userID2) {
				max3 = interest.get(e);
				userID3 = e;
			}
		}
		topFour[2] = userID3;
		
		String userID4 = "";
		int max4 = 0;
		for (String e : interest.keySet()) {
			if (interest.get(e) > max4 && e != userID && e != userID2 && e != userID3) {
				max4 = interest.get(e);
				userID4 = e;
			}
		}
		topFour[3] = userID4;
		return topFour;
	}
	
	//Implement solution here
	public static String [] wheresWaldo (ArrayList<Event> events) {
		return null;

	}
}
