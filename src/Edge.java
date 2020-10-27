public class Edge {

    private Vertex fromVertex;
    private Vertex toVertex;
    private Integer weight;

    public Edge(Vertex from, Vertex to, Integer distance) {
        this.fromVertex = from;
        this.toVertex = to;
        this.weight = distance;
        from.addOutEdge(this);
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public Integer getWeight() {
        return weight;
    }
}