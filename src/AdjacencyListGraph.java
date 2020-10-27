import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class AdjacencyListGraph {
    private ArrayList<Vertex> vertices;

    public AdjacencyListGraph() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v){
        vertices.add(v);
    }

    public void newEdge(Vertex from, Vertex to, Integer distance){
        if(! (vertices.contains(from)) && (vertices.contains(to)) ){
            System.out.println("Vertex not found");
            return;
        }
        Edge newEdge = new Edge(from, to, distance);
    }

    public void printGraph(){
        Vertex currentVertex;
        for(int i = 0; i < vertices.size(); i++){
            currentVertex = vertices.get(i);
            System.out.println("Edges from " + currentVertex.getCity() + " (" + currentVertex.getID() + "):");
            for(int j = 0; j < currentVertex.getOutEdges().size(); j++){
                Edge currentEdge = currentVertex.getOutEdges().get(j);
                System.out.println("   To: " + currentEdge.getToVertex().getCity() + " (" + currentEdge.getToVertex().getID() + ")" + ", distance: " + currentEdge.getWeight());
            }
        }
    }


public void newPrim(){
        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<Edge>();
        PriorityQueue<Vertex> vertexPriorityQueue = new PriorityQueue<Vertex>();
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<Pair>();

        int[] distance = new int[vertices.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int[] predecessor = new int[vertices.size()];
        Arrays.fill(predecessor,-1);

        int[] discoveredVertices = new int[vertices.size()];
        Arrays.fill(discoveredVertices, 0);

    /**
     * prints vertices, their number of connected edges and the edge lengths
     */
        for(int i = 0; i < vertices.size(); i++) {
                System.out.print(vertices.get(i).getCity() + ": ");
                System.out.println(vertices.get(i).getOutEdges().size());
                for(int j = 0; j < vertices.get(i).getOutEdges().size(); j++){
                    System.out.println("  " + vertices.get(i).getOutEdges().get(j).getWeight());
                }
            }



        //Setting start vertex
        if(0 < vertices.size()){
            distance[0] = 0;
            pairPriorityQueue.offer(new Pair(0,0));
        }

        int counter = 0; //traverses through the vertices
        int treeCost = 0; //sums up the total cost of three

        while(!pairPriorityQueue.isEmpty() && counter < vertices.size()) {

            //Taking the lowest value from priorityQueue
            Pair u = pairPriorityQueue.poll();

            if (discoveredVertices[counter] != 1) {

                //Traversal of the vertices
                for (int i = 0; i < vertices.size(); i++) {

                }
            }
            counter++;
        }



}











    public void MSTPrims2(){
        int[] distance = new int[vertices.size()];
        int[] predecessor = new int[vertices.size()];
        int[] visited = new int[vertices.size()];
        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        Arrays.fill(visited, 0);

        if(vertices.size() > 0){
            distance[0] = 0;
            que.offer(new Pair(0,0));
            System.out.println("start = 0");
        }

        int counter = 0;

        while(!que.isEmpty() && counter < vertices.size()){

            Pair u = que.poll();
            System.out.println("u.index: " + u.index);
            System.out.println(" ");


            if(visited[counter] != 1) {
                System.out.println("Vertex has not previously been visited: " + vertices.get(counter).getCity() );
                int internalCounter = 0;
                for (int v = 0; v < vertices.size(); v++) {
                    for(int w = 0; w < vertices.get(v).getOutEdges().get(w).getWeight(); w++){
                        //Gemme hver edge som et pair m. distance og vertex i Queue
                        Pair tempEdge = new Pair(vertices.get(v).getOutEdges().get(w).getWeight(), v);
                        que.offer(tempEdge);
                    }

                    //gemme den edge med mindst weight i distance[vertex]
                    //sætte visited[vertex] = 1

                    //Logik til at vælge det pair med mindst weight og gå til det vertex

//                    internalCounter++;
//                    System.out.println("<<<<<<<< internalCounter: " + internalCounter + ">>>>>>>>");
                    if (1==1) {
                        System.out.println("distance before: " + distance[v]);
                        distance[v] = vertices.get(counter).getOutEdges().get(v).getWeight();
                        predecessor[v] = u.index;
                        que.offer(new Pair(distance[v], v));
                        Pair a = que.peek();
                        System.out.println("distance after: " + distance[v]);
                    }
                    //Måske
                }
                visited[u.index] = 1;
                counter++;
                //husk at lægge værdier fra distance[] sammen til MST-totalen.
                System.out.println("_______________________\n\n");
            }

            //hvis der ikke er flere edges (fuck det) så skal kigge på pairs og finde den med mindst weight
            //til et nyt vertex vi ikke har mødt før endnu tidligere engang på dagen

        }
        System.out.println("Minimum spanning tree distance: ");
        printMST(predecessor, distance);
    }

    public void printMST(int[] prede, int[] dist){
        for(int i = 0; i < vertices.size(); i++){
            System.out.println(i + " parent " + prede[i] + " edge Weight " + dist[i]);
        }
    }
}