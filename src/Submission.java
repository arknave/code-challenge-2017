import java.util.Arrays;

public class Submission {
	
	private String mostInterestedNeighborhood;
	private String leastInterestedNeighborhood;
	private String [] topIndividualsInterestedInLocations;
	private String [] whereIswaldo;
	
	public Submission() {
		this.mostInterestedNeighborhood = null;
		this.leastInterestedNeighborhood = null;
		this.topIndividualsInterestedInLocations = null;
		this.whereIswaldo = null;
	}
	
	public String getMostInterestedNeighborhood () {
		return this.mostInterestedNeighborhood;
	}
	
	public void setMostInterestedNeighborhood (String answer) {
		this.mostInterestedNeighborhood = answer;
	}
	
	public String getLeastInterestedNeighborhood () {
		return this.leastInterestedNeighborhood;
	}
	
	public void setLeastInterestedNeighborhood (String answer) {
		this.leastInterestedNeighborhood = answer;
	}
	
	public String [] getTopIndividualsInterestedInLocations () {
		return this.topIndividualsInterestedInLocations;
	}
	
	public void setTopIndividualsInterestedInLocations(String [] answer) {
		this.topIndividualsInterestedInLocations = answer;
	}
	
	public String [] getWhereIsWaldo () {
		return this.whereIswaldo;
	}
	
	public void setWhereIsWaldo (String [] answer) {
		this.whereIswaldo = answer;
	}
	
	public String toString() {
		return String.format("Most Interested Neighborhood: %s %nLeast Interested Neighborhood: %s %nTop Individual Interested Locations: %s %nWhere is Waldo: %s %n", 
				mostInterestedNeighborhood, leastInterestedNeighborhood,Arrays.toString(topIndividualsInterestedInLocations), Arrays.toString(whereIswaldo));
		
	}

}
