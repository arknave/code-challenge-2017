import java.util.*;

public class EventAnalyzer {
    public static int INTEREST = 30;
    public static int TOP_K = 4;

    private static Map<String, Set<String>> parseNeighborhood(List<Event> events) {
        Map<String, List<Event>> byPerson = new HashMap<>();
        for (Event event : events) {
            if (event.getNeighborhood() == null) continue;

            if (!byPerson.containsKey(event.getUserID())) {
                byPerson.put(event.getUserID(), new ArrayList<>());
            }

            byPerson.get(event.getUserID()).add(event);
        }

        Map<String, Set<String>> neighborhoodInterests = new HashMap<>();
        for (String person : byPerson.keySet()) {
            List<Event> personEvents = byPerson.get(person);
            int numEvents = personEvents.size();
            for (int i = 1; i < numEvents; i += 2) {
                Event event = personEvents.get(i);
                Event prevEvent = personEvents.get(i - 1);
                long delta = event.getTimeStamp() - prevEvent.getTimeStamp();

                String neighborhood = event.getNeighborhood();
                assert neighborhood.equals(prevEvent.getNeighborhood());

                if (delta >= INTEREST) {
                    if (!neighborhoodInterests.containsKey(neighborhood)) {
                        neighborhoodInterests.put(neighborhood, new HashSet<>());
                    }

                    neighborhoodInterests.get(neighborhood).add(person);
                }
            }
        }


        return neighborhoodInterests;
    }
	
    private static Map<String, Set<String>> parseUsers(List<Event> events) {
        Map<String, List<Event>> byPerson = new HashMap<>();
        for (Event event : events) {
            if (event.getNeighborhood() == null) continue;

            if (!byPerson.containsKey(event.getUserID())) {
                byPerson.put(event.getUserID(), new ArrayList<>());
            }

            byPerson.get(event.getUserID()).add(event);
        }

        Map<String, Set<String>> personInterests = new HashMap<>();
        for (String person : byPerson.keySet()) {
            List<Event> personEvents = byPerson.get(person);
            int numEvents = personEvents.size();
            for (int i = 1; i < numEvents; i += 2) {
                Event event = personEvents.get(i);
                Event prevEvent = personEvents.get(i - 1);
                long delta = event.getTimeStamp() - prevEvent.getTimeStamp();

                String neighborhood = event.getNeighborhood();
                assert neighborhood.equals(prevEvent.getNeighborhood());

                if (delta >= INTEREST) {
                    if (!personInterests.containsKey(person)) {
                        personInterests.put(person, new HashSet<>());
                    }

                    personInterests.get(person).add(neighborhood);
                }
            }
        }

        return personInterests;
    }
	

	// Implement solution here
	public static String mostInterestedNeighborhood(ArrayList<Event> events) {
        Map<String, Set<String>> neighborhoodInterests = parseNeighborhood(events);
        String bestHood = "";
        int mostVisits = Integer.MIN_VALUE;
        for (Map.Entry<String, Set<String>> entry : neighborhoodInterests.entrySet()) {
            int uniqueVisits = entry.getValue().size();
            if (uniqueVisits > mostVisits) {
                mostVisits = uniqueVisits;
                bestHood = entry.getKey();
            }
        }

        return bestHood;
	}
	
	//Implement solution here
	public static String leastInterestedNeighborhood(ArrayList<Event> events) {
        Map<String, Set<String>> neighborhoodInterests = parseNeighborhood(events);
        String worstHood = "";
        int leastVisits = Integer.MAX_VALUE;
        for (Map.Entry<String, Set<String>> entry : neighborhoodInterests.entrySet()) {
            int uniqueVisits = entry.getValue().size();
            if (uniqueVisits < leastVisits) {
                uniqueVisits = uniqueVisits;
                worstHood = entry.getKey();
            }
        }

        return worstHood;
	}
	
	//Implement solution here
	public static String [] topIndividualsInterestedInLocations(ArrayList<Event> events) {
		Map<String, Set<String>> byPerson = parseUsers(events);
        PriorityQueue<PersonData> priorityQueue = new PriorityQueue();
        for (Map.Entry<String, Set<String>> entry : byPerson.entrySet()) {
            PersonData personData = new PersonData(entry.getKey(), entry.getValue().size());
            priorityQueue.add(personData);
        }

        int topK = Math.min(TOP_K, priorityQueue.size());
        String[] answer = new String[topK];
        for (int i = 0; i < topK; i++) {
            PersonData data = priorityQueue.remove();
            answer[i] = data.getUserID();
        }

        return answer;
	}
	
	//Implement solution here
	public static String [] wheresWaldo (ArrayList<Event> events) {
		Map<String, Set<String>> byPerson = parseUsers(events);

        Set<String> topUsers = new HashSet<>();
        int topVisited = Integer.MIN_VALUE;

        for (Map.Entry<String, Set<String>> entry : byPerson.entrySet()) {
            int uniqueVisited = entry.getValue().size();
            if (uniqueVisited > topVisited) {
                topUsers.clear();
                topVisited = uniqueVisited;
            }

            if (uniqueVisited == topVisited) {
                topUsers.add(entry.getKey());
            }
        }

        String[] answer = new String[topUsers.size()];
        int i = 0;
        for (String s : topUsers) {
            answer[i++] = s;
        }

        return answer;
	}
}
