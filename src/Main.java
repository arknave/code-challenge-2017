import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	
	private static long averaqgeTime(ArrayList<Long> list) {
		ArrayList<Long> copy = new ArrayList<Long>(list);
		long sum = 0;
		list.remove(Collections.max(copy));
		list.remove(Collections.min(copy));
		for(Long element : copy) {
			sum += element;
		}
		return sum/copy.size();
	}
	
	private static ArrayList<Event> processInput() {
		JSONParser parser = new JSONParser();
		ArrayList<Event> events = new ArrayList<Event>(); 
		try {
			 Object input = parser.parse(new FileReader("input.json"));
			 JSONArray jsonInput = (JSONArray) input;
			 for(Object each : jsonInput) {
				 JSONObject element = (JSONObject) each;
				 Event event = new Event((String)element.get("eventType"), (String) element.get("uuid"), (String)element.get("userId"), (long) element.get("timestamp"), (String) element.get("neighborhood"));
				 events.add(event);
			 }
		}catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ParseException e) {
           e.printStackTrace();
       }
		return events;
	}
	
	private static void generateOutput(int numRuns, ArrayList<Event> events) {
		Submission submit = new Submission();
		ArrayList<Long> times = new ArrayList<Long>();
		for(int ctr = 0; ctr < 10; ctr++) {
			final long startTime = System.currentTimeMillis();
			submit.setLeastInterestedNeighborhood(EventAnalyzer.leastInterestedNeighborhood(events));
			submit.setMostInterestedNeighborhood(EventAnalyzer.mostInterestedNeighborhood(events));
			submit.setTopIndividualsInterestedInLocations(EventAnalyzer.topIndividualsInterestedInLocations(events));
			submit.setWhereIsWaldo(EventAnalyzer.wheresWaldo(events));
			final long duration = System.currentTimeMillis() - startTime;
			times.add(duration);
			System.out.println(submit);
			System.out.println(String.format("Elapsed time: %d ms %n", duration));
		}
		System.out.println(String.format("Max time: %d ms %nMin Time: %d ms %nAverage Time: %d ms %n", Collections.max(times), Collections.min(times), averaqgeTime(times)));
	}
	
	public static void main(String[] args) {
		
		ArrayList<Event> events = processInput();
		generateOutput(10, events);
			
			
	}

}
