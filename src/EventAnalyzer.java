import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EventAnalyzer {
		
	private static void checkIfMax(Map<String, Integer> maxInterests, String userId, Integer numInterests) {
		if (maxInterests.size() < 4) {
			maxInterests.put(userId, numInterests);
		}
		else {
			String minId = "";
			int minNum = Integer.MAX_VALUE;
			for (String key: maxInterests.keySet()) {
				int value = maxInterests.get(key);
				if (value < minNum) {
					minNum = value;
					minId = key;
				}
			}
			
			if (minNum < numInterests) {
				maxInterests.remove(minId);
				maxInterests.put(userId, numInterests);
			}
		}
	}

	//Implement solution here
	public static String [] topIndividualsInterestedInLocations(ArrayList<Event> events) {
		String [] result = new String[4];
		Map<String, Integer> interests = new TreeMap<>();
		Map<String, Integer> maxInterests = new TreeMap<>();
		Map<String, Long> entrances = new TreeMap<>();
		for (Event event: events) {
			if (event.getEventType().equals("enter")) {
				entrances.put(event.getUserID(), event.getTimeStamp());
			}
			if (event.getEventType().equals("exit")) {
				String userId = event.getUserID();
				if (event.getTimeStamp() - entrances.get(userId) >= 30) {
					if (interests.containsKey(userId)) {
						interests.put(userId, interests.get(userId) + 1);
					}
					else {
						interests.put(userId, 1);
					}
				}
			}
		}
		for (String key: interests.keySet()) {
			checkIfMax(maxInterests, key, interests.get(key));
		}
		int count = 0;
		for (String key: maxInterests.keySet()) {
			result[count] = key;
			count++;
		}
		return result;
	}
	
	public static String con(String uid,String loc){
		return uid+"_"+loc;
	}
	//Implement solution here
	public static String [] wheresWaldo (ArrayList<Event> events) {
		ArrayList<String> pu=new ArrayList<String>();
		HashSet<String> u=new HashSet<String>();
		HashSet<String> lo=new HashSet<String>();
		HashMap<String,Long> un= new HashMap<String,Long>();
		for(int i=0;i<events.size();i++){
			Event e=events.get(i);
			if(e!=null && (e.getEventType().equals("enter")||e.getEventType().equals("exit"))){
				lo.add(e.getNeighborhood());
				String id=con(e.getUserID(),e.getNeighborhood());
				u.add(e.getUserID());
				if(un.containsKey(id)){
					if(un.get(id)>-1){
						if(e.getEventType().equals("exit")){
							if(e.getTimeStamp()-un.get(id)>=30){
								un.put(id,(long)-2);
							}else{
								un.remove(id);
							}
						}else{
							System.out.println("er");
						}
					}
				}else{
					if(e.getEventType().equals("enter")){
					un.put(id, e.getTimeStamp());
					}
				}
			}
		}
		for(String s:u){
			int cn=0;
			for(String n :lo){
				String id=con(s,n);
				if((un.get(id)==null)||(un.get(id)!=-2)){
					break;
				}else{
					cn++;
				}
			}
			if(cn==lo.size()){
				pu.add(s);
			}
		}
		String[] dos=pu.toArray(new String[pu.size()]);
		return dos;
		

	}
	
	
	static HashMap<String, HashSet<String>> interests;
	// Implement solution here
	public static String mostInterestedNeighborhood(ArrayList<Event> events) {
		int max = 0;
		String ans = "";
		for (String key: interests.keySet()){
			if (interests.get(key).size() > max){
				max = interests.get(key).size();
				ans = key;
			}
		}
		
		return ans;
	}
	
	//Implement solution here
	public static String leastInterestedNeighborhood(ArrayList<Event> events) {
		HashMap<String, Long> starts = new HashMap<String, Long>();
		interests = new HashMap<String, HashSet<String>>();
		
		for (Event event: events){
			if (event.getEventType().equals("enter")){
				starts.put(event.getUserID(), event.getTimeStamp());
			} else if (event.getEventType().equals("exit")){
				if (event.getTimeStamp() - starts.get(event.getUserID()) >= 30){
					if (!interests.containsKey(event.getNeighborhood())){
						interests.put(event.getNeighborhood(), new HashSet<String>());
					}
					
					interests.get(event.getNeighborhood()).add(event.getUserID());
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		String ans = "";
		for (String key: interests.keySet()){
			if (interests.get(key).size() < min){
				min = interests.get(key).size();
				ans = key;
			}
		}
		
		return ans;
	}
	
}
