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
        int[] distance = new int[vertices.size()]; Arrays.fill(distance, Integer.MAX_VALUE);
        int[] predecessor = new int[vertices.size()]; Arrays.fill(predecessor, -1);
        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        Vertex currentVertex;
        int counter = 0;
        int mst = 0;

        /* Starting logic */
        if (vertices.size() > 0) {
            distance[0] = 0;
            que.offer(new Pair(0, 11)); //Tree start vertex
        }

        /* Tree traversal logic */
        while (!que.isEmpty() && counter < vertices.size()) {

            Pair currentPair = que.poll();

            currentVertex = vertices.get(currentPair.index);

            if(counter > 0){
                distance[counter] = currentPair.distance;
            }

            /* If currentVertex has not been visited then... */
            if (!currentVertex.isVisited()){

                /* Set current vertex to visited */
                currentVertex.setVisited(true);

                    /* Traverse all outEdges from vertex */
                    for (int i = 0; i < currentVertex.getNumberOfEdges(); i++) {//System.out.println("Edge: " + i + " from: " + currentVertex.getCity() + " to: " + currentVertex.getOutEdge(i).getToVertex().getCity() + " with weight: " + currentVertex.getOutEdge(i).getWeight());

                        /* Make easier to read variables */
                        int tempEdgeWeight = currentVertex.getOutEdge(i).getWeight();
                        int tempNextVertexID = currentVertex.getOutEdge(i).getToVertex().getID();

                        /* Save all edges from vertex as pairs (index = the next vertexID), and add them to the PriorityQueue */
                        Pair tempPair = new Pair(tempEdgeWeight,tempNextVertexID);
                        que.offer(tempPair);
                    }

                    Vertex tempVertex = vertices.get(que.peek().index);
                    if(!tempVertex.isVisited()){
                        tempVertex.setPrevious(currentVertex);
                        if(counter == 0) {
                            distance[counter] = 0;
                        }
                    }

                /* Saves the current vertexID in predecessor array and increments counter by 1 */
                predecessor[counter] = currentPair.index;
                counter++;
            }
        }

        for(int i = 0 ; i < distance.length; i++){
            mst += distance[i];
        }

        System.out.println();
        System.out.println("Minimum spanning tree distance: " + mst);
        System.out.println();
        System.out.println("Minimum spanning tree cost: " + mst*1000000);
        System.out.println();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        tree(predecessor, distance);
    }

    public void tree(int[] pred, int[] dist){
        /* Prints content of predecessor array */
        System.out.println("Printing content of predecessor array...");
        for(int j = 0; j < pred.length; j++) {
            if (j == 0) {
                System.out.print(vertices.get(pred[j]).getCity());
            } else {
                System.out.print(" -> " + vertices.get(pred[j]).getCity());
            }
        }
        System.out.println("\n");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        /* Prints content of distance array */
        System.out.println("Printing content of distance array...");
        for(int l = 0; l < dist.length; l++){
            if (l == 0) {
                System.out.print(dist[l]);
            } else {
                System.out.print(" -> " + dist[l]);
            }
        }

        System.out.println("\n");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");

        /* Prints edges between vertices */
        System.out.println("Printing edges between vertices...");
        for(int k = 0; k < pred.length; k++) { //traverserer pred array

            Vertex currentVertex = vertices.get(pred[k]);
            Vertex previousVertex = null;

            if(k > 0){

                for (int h = 0; h < currentVertex.getNumberOfEdges(); h++) { // traverserer outEdges fra currentVertex
                    if (dist[k] == currentVertex.getOutEdge(h).getWeight()) {
                        if(dist[k] == 0){
                            currentVertex.setPrevious(currentVertex);
                            break;
                        } else {
                            previousVertex = currentVertex.getOutEdge(h).getToVertex();
                            currentVertex.setPrevious(previousVertex);
                            previousVertex = currentVertex.getPrevious();
                        }
                    }
                }
                System.out.println("Edge from: " + previousVertex.getCity() + " to: " + currentVertex.getCity());
            }
        }
    }
}