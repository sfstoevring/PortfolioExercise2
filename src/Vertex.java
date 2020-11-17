import java.util.ArrayList;

class Vertex implements Comparable<Vertex> {

    private int ID;
    private String city;
    private ArrayList<Edge> outEdges;
    private int numberOfEdges;
    private Integer distance = Integer.MAX_VALUE;
    private Vertex previous;
    private boolean isVisited;



    public Vertex (int id, String city){
        this.ID = id;
        this.city = city;
        outEdges = new ArrayList<Edge>();
        isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getID() {
        return ID;
    }

    public String getCity() { return city;}

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }

    public Edge getOutEdge(int index){

        return outEdges.get(index);

    }

    public int getNumberOfEdges() {
        numberOfEdges = outEdges.size();
        return numberOfEdges;
    }

    public Integer getDistance() {
        return distance;
    }

    public void addOutEdge(Edge outEdge){
        outEdges.add(outEdge);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOutEdges(ArrayList<Edge> outEdges) {
        this.outEdges = outEdges;
    }

    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    public int compareTo(Vertex o) {
        if(this.distance < o.distance){
            return -1;
        }
        else if (this.distance > o.distance){
            return 1;
        }
        else {
            return 0;
        }
    }
}