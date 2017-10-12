public class PersonData implements Comparable<PersonData> {
    private String userId;
    private int uniqueNeighborhoods;

    public PersonData(String userId, int uniqueNeighborhoods) {
        this.userId = userId;
        this.uniqueNeighborhoods = uniqueNeighborhoods;
    }

    public String getUserID() {
        return userId;
    }

    public int getUniqueNeighborhoods() {
        return uniqueNeighborhoods;
    }

    public int compareTo(PersonData other) {
        return Integer.compare(uniqueNeighborhoods, other.uniqueNeighborhoods);
    }
}
