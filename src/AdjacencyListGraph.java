import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class AdjacencyListGraph {
    private ArrayList<Vertex> vertices;

    public AdjacencyListGraph() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void newEdge(Vertex from, Vertex to, Integer distance) {
        if (!(vertices.contains(from)) && (vertices.contains(to))) {
            System.out.println("Vertex not found");
            return;
        }
        Edge newEdge = new Edge(from, to, distance);
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


    public void PrimsMST() {
        int[] distance = new int[vertices.size()]; //Used for printing tree and for calculating the weight total for the tree
        int[] predecessor = new int[vertices.size()]; //Used for printing the tree
        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        int currentVertexID;
        if (vertices.size() > 0) {
            distance[0] = 0;
            que.offer(new Pair(0, 0));
        }

        int counter = 0;
        int mst = 0;


        while (!que.isEmpty() && counter < vertices.size()) {

            Pair u = que.poll();
            currentVertexID = u.index;

            /* Has vertex been visited? */
            if (!vertices.get(currentVertexID).isVisited()){
                /* Sets vertex to visited */
                vertices.get(currentVertexID).setVisited(true);


                /* Traverses all outEdges from vertex */
                for (int i = 0; i < vertices.get(u.index).getOutEdges().size(); i++) {


                    /* Saving all edges from vertex as pairs (index = next vertexID) and adds them to the PriorityQueue */
                    Pair tempPair = new Pair(vertices.get(currentVertexID).getOutEdges().get(i).getWeight(), vertices.get(currentVertexID).getOutEdges().get(i).getToVertex().getID());
                    que.offer(tempPair);

                    int tempEdgeDistance = vertices.get(currentVertexID).getOutEdges().get(i).getWeight();

                    /* Saves the edge with the smallest weight in vertex object */
                    if (tempEdgeDistance < vertices.get(currentVertexID).getDistance()) {
                        vertices.get(currentVertexID).setDistance(tempEdgeDistance);
                        distance[counter] = tempEdgeDistance;
                    }
                }



                predecessor[counter] = u.index;
                counter++;
            }

        }

        for(int i = 0 ; i < distance.length; i++){
            mst += distance[i];
        }

        System.out.println("Minimum spanning tree distance: " + mst);
        System.out.println("Minimum spanning tree kost: " + mst*1000000);
        printMST(predecessor, distance);
    }

    public void printMST(int[] pred, int[] dist){
        for(int i = 0; i < vertices.size(); i++){
            System.out.println("step: " + i + " parent: " + pred[i] + " edge Weight: " + dist[i]);
        }
    }
}