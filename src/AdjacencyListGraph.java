import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class AdjacencyListGraph {

    private ArrayList<Vertex> vertices;

    public AdjacencyListGraph() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void newEdge(Vertex from, Vertex to, Integer distance) {
        if (!(vertices.contains(from)) && (vertices.contains(to))) {
            System.out.println("Vertex not found");
            return;
        }
        Edge newEdgeOneWay = new Edge(from, to, distance);
        Edge newEdgeTheOtherWay = new Edge(to, from, distance);
    }

    public void printGraph() {
        Vertex currentVertex;
        for (int i = 0; i < vertices.size(); i++) {
            currentVertex = vertices.get(i);
            System.out.println("Edges from " + currentVertex.getCity() + " (" + currentVertex.getID() + "):");
            for (int j = 0; j < currentVertex.getOutEdges().size(); j++) {
                Edge currentEdge = currentVertex.getOutEdges().get(j);
                System.out.println("   To: " + currentEdge.getToVertex().getCity() + " (" + currentEdge.getToVertex().getID() + ")" + ", distance: " + currentEdge.getWeight());
            }
        }
    }

    public void PrimsMstAlgorithm() {
        int[] distance = new int[vertices.size()]; /*-*/ Arrays.fill(distance, Integer.MAX_VALUE);
        int[] predecessor = new int[vertices.size()]; /*-*/ Arrays.fill(predecessor, -1);
        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        Vertex currentVertex;
        int counter = 0;
        int mst = 0;

        /* Starting logic */
        if (vertices.size() > 0) {
            distance[0] = 0;
            que.offer(new Pair(0, 15)); //Tree start vertex
            vertices.get(que.peek().index).setPrevious(vertices.get(que.peek().index)); //Setting the previous vertex for start vertex to it self
        }

        /* Tree traversal logic */
        while (!que.isEmpty() && counter < vertices.size()) {

            Pair currentPair = que.poll();

            currentVertex = vertices.get(currentPair.index);

            /* If vertex has not been visited then... */
            if (!currentVertex.isVisited()){

                /* Set current vertex to visited */
                currentVertex.setVisited(true);

                    /* Traverse all outEdges from vertex */
                    for (int i = 0; i < currentVertex.getOutEdges().size(); i++) {

//System.out.println("Edge: " + i + " from: " + currentVertex.getCity() + " to: " + currentVertex.getOutEdge(i).getToVertex().getCity() + " with weight: " + currentVertex.getOutEdge(i).getWeight());

                        int currentEdgeWeight = currentVertex.getDistance();
                        int tempEdgeWeight = currentVertex.getOutEdge(i).getWeight();
                        int tempNextVertexID = currentVertex.getOutEdge(i).getToVertex().getID();

                        /* Save all edges from vertex as pairs (index = the connecting vertexID), and add them to the PriorityQueue */
                        Pair tempPair = new Pair(tempEdgeWeight,tempNextVertexID);
                        que.offer(tempPair);

                        /* Save the edge with the smallest weight to vertex object */
                        if (tempEdgeWeight < currentEdgeWeight) {
                            currentVertex.setDistance(tempEdgeWeight);
                            distance[counter] = tempEdgeWeight;
                        }
                    }
                /* Saves the current vertexID in predecessor array and increments counter by 1 */
                predecessor[counter] = currentPair.index;

                if(counter < 0){
                    break;
                } else if(counter > 0){
                    Vertex previousVertex = vertices.get(predecessor[counter-1]);
                    currentVertex.setPrevious(previousVertex);
                }
                counter++;
            }
        }

        for(int i = 0 ; i < distance.length; i++){
            mst += distance[i];
        }

//        System.out.println("Minimum spanning tree distance: " + mst);
//        System.out.println("Minimum spanning tree cost: " + mst*1000000);
//
//        printMST(predecessor, distance); //Method for printing the steps in tree

        tree(predecessor); //Method for printing the edges in the tree
    }

    public void printMST(int[] pred, int[] dist){
        for(int i = 0; i < vertices.size(); i++){
            System.out.println("step: " + i + " parent: " + pred[i] + " edge Weight: " + dist[i]);
        }
    }

    public void tree(int[] pred){
        for(int j = 0; j < pred.length; j++){
            System.out.print(vertices.get(pred[j]).getCity() + " -> ");
        }

        System.out.println();


        for(int i = 1; i < pred.length; i++){
            Vertex current = vertices.get(pred[i]);
            Vertex previous = vertices.get(pred[i]).getPrevious();
            System.out.println("Edge from: " + previous.getCity() + " to: " + current.getCity());
        }
    }
}