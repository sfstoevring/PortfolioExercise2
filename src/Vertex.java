import java.util.ArrayList;

class Vertex implements Comparable<Vertex>{
    private int ID;
    private String city;
    private ArrayList<Edge> outEdges;
    private int numberOfEdges;
    Integer distance = Integer.MAX_VALUE; //hint fra opg
    Vertex previous = null; //hint fra opg
    //private boolean isVisited = false;

    public Vertex (int id, String city){
        this.ID = id;
        this.city = city;
        outEdges = new ArrayList<Edge>();
    }

    public int getID() {
        return ID;
    }

    public String getCity() { return city;}

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
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