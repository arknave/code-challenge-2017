package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EventAnalyzer {

	// Implement solution here
	public static String mostInterestedNeighborhood(ArrayList<Event> events) {
		HashMap<String, HashSet<String>> data = new HashMap<>();
		for (Event e : events) {
			if (e.getTimeStamp() >= 30 && e.getNeighborhood() != null) {
				String hood = e.getNeighborhood();
				if (!data.containsKey(hood))
					data.put(hood, new HashSet<String>());
				data.get(hood).add(e.getUserID());
			}
		}
		int cmp = -1;
		String largest = "";
		for (String s : data.keySet()) {
			if (data.get(s).size() > cmp) {
				cmp = data.get(s).size();
				largest = s;
			}
		}
		return largest;
	}

	// Implement solution here
	public static String leastInterestedNeighborhood(ArrayList<Event> events) {
		HashMap<String, HashSet<String>> data = new HashMap<>();
		for (Event e : events) {
			if (e.getTimeStamp() >= 30 && e.getNeighborhood() != null) {
				String hood = e.getNeighborhood();
				if (!data.containsKey(hood))
					data.put(hood, new HashSet<String>());
				data.get(hood).add(e.getUserID());
			}
		}
		int cmp = -1;
		String smallest = "";
		for (String s : data.keySet()) {
			if (cmp == -1 || data.get(s).size() < cmp) {
				cmp = data.get(s).size();
				smallest = s;
			}
		}
		return smallest;
	}

	// Implement solution here
	public static String[] topIndividualsInterestedInLocations(ArrayList<Event> events) {
		HashMap<String, HashSet<String>> data = new HashMap<>();
		for (Event e : events) {
			if (e.getTimeStamp() >= 30) {
				String user = e.getUserID();
				if (!data.containsKey(user))
					data.put(user, new HashSet<String>());
				data.get(user).add(e.getUUID());
			}
		}
		HashMap<String, Integer> res = new HashMap<>();
		for (String s : data.keySet()) {
			int time = data.get(s).size();
			int flag = 0;
			for (Integer i : res.values())
				if (i < time)
					flag = 1;
			if (flag == 1) { // found a min
				int smallest = -1;
				String sml = "";
				for (String str : res.keySet()) {
					if (smallest == -1 || res.get(str) < smallest) {
						smallest = res.get(str);
						sml = str;
					}
				}
				res.put(sml, time);
			}
		}
		return res.keySet().toArray(new String[res.keySet().size()]);
	}

	// Implement solution here
	public static String[] wheresWaldo(ArrayList<Event> events) {
		HashMap<String, HashSet<String>> data = new HashMap<String, HashSet<String>>();
		for (Event e : events) {
			if (e.getNeighborhood() == null)
				continue;
			if (e.getTimeStamp() >= 30) {
				if (!(data.containsKey(e.getUserID())))
					data.put(e.getUserID(), new HashSet<String>());
				data.get(e.getUserID()).add(e.getNeighborhood());
			}
		}
		int count = 0;
		ArrayList<String> t = new ArrayList<String>();
		for (String k : data.keySet()) {
			int i = data.get(k).size();
			if (i == count) {
				t.add(k);
			} else if (i > count) {
				count = i;
				t.clear();
				t.add(k);
			}
		}
		return t.toArray(new String[t.size()]);
	}
}
