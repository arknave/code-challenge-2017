//Event object class for the 2017 Dante Code Challenge

public class Event {
	private final String eventType;
	private final String uuid;
	private final String userId;
	private final long timeStamp;
	private final String neighborhood;
	
	public Event (String eventType, String uuid, String userId, long timeStamp, String neighborhood) {
		this.eventType = eventType;
		this.uuid = uuid;
		this.userId = userId;
		this.timeStamp = timeStamp;
		this.neighborhood = neighborhood;
	}
	
	public String getEventType () {
		return this.eventType;
	}
	
	public String getUUID () {
		return this.uuid;
	}
	
	public String getUserID() {
		return this.userId;
	}
	
	public long getTimeStamp() {
		return this.timeStamp;
	}
	
	public String getNeighborhood() {
		return this.neighborhood;
	}
	
	public String toString() {
		return String.format("Event type: %s UUID: %s UserID: %s TimeStamp: %d Neighborhood: %s", eventType, uuid, userId, timeStamp, neighborhood);
	}
}
