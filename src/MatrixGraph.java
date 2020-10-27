import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class MatrixGraph {
    int[][] matrixEdgeGraph;
    int[][] matrixWeigthGraph;

    MatrixGraph(int vertices){
        matrixEdgeGraph = new int[vertices][vertices];
        matrixWeigthGraph = new int[vertices][vertices];
    }

    public void addEdge(int from, int to, int weight){
        matrixEdgeGraph[from][to]=1;
        matrixWeigthGraph[from][to]=weight;
    }

    public void printGraph(){
        for(int from_i = 0; from_i < matrixEdgeGraph.length; from_i++){
            System.out.println("Edges from Vertex " + from_i);
            for(int to_j = 0; to_j < matrixEdgeGraph.length; to_j++){
                if(matrixEdgeGraph[from_i][to_j] == 1){
                    System.out.print("  To: " + to_j);
                    System.out.println(", weight: " + matrixWeigthGraph[from_i][to_j]);
                }
            }
            //System.out.println(" ");
        }
    }

    public void MSTPrims(){
        int[] distance = new int[matrixEdgeGraph.length];
        int[] predecessor = new int[matrixEdgeGraph.length];
        int[] visited = new int[matrixEdgeGraph.length];
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        Arrays.fill(visited, 0);

        if(matrixEdgeGraph.length > 0){
            distance[0] = 0;
            q.offer(new Pair(0,0));
        }

        int counter = 0;
        int MST = 0;
        while(!q.isEmpty() && counter < matrixEdgeGraph.length){
            Pair u = q.poll();
            if(visited[u.index] != 1) {
                for (int v = 0; v < matrixEdgeGraph.length; v++) {
                    if (matrixEdgeGraph[u.index][v] == 1 && matrixWeigthGraph[u.index][v] < distance[v]) {
                        distance[v] = matrixWeigthGraph[u.index][v];
                        predecessor[v] = u.index;
                        q.offer(new Pair(distance[v], v));
                    }
                }
                visited[u.index] = 1;
                counter++;
                MST += distance[u.index];
            }
        }
        System.out.println("Minimum spanning tree distance: " + MST);
        printMST(predecessor, distance);
    }

    public void printMST(int[] prede, int[] dist){
        for(int i = 0; i < matrixEdgeGraph.length; i++){
            System.out.println(i + " parent " + prede[i] + " edge Weight " + dist[i]);
        }
    }


    //shortest path method...
    public int[] shortestPath(int source){
        int[] distance = new int[matrixEdgeGraph.length];
        int[] predecessor = new int[matrixEdgeGraph.length];
        int[] visited = new int[matrixEdgeGraph.length];
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        Arrays.fill(visited, 0);

        if(matrixEdgeGraph.length > 0){
            distance[source] = 0;
            q.offer(new Pair(0,source ));
        }

        int counter = 0;
        while(!q.isEmpty() && counter< matrixEdgeGraph.length){
            Pair i = q.poll();
            for(int j = 0;  j < matrixEdgeGraph.length; j++){
                if(matrixEdgeGraph[i.index][j] == 1 && visited[j] != 1){
                    if(distance[i.index] + matrixWeigthGraph[i.index][j] < distance[j]){
                        //also check if it has been visited
                        distance[j] = distance[i.index] + matrixWeigthGraph[i.index][j];
                        predecessor[j] = i.index;
                        q.offer(new Pair(distance[j], j));
                    }
                }
            }
            counter++;
            visited[i.index] = 1;
        }

        return predecessor;
    }

    public void PrintPath(int[] prede, int target){
        Stack<Integer> reversePath = new Stack<Integer>();
        int current = target;
        while(current != -1){
            reversePath.push(current);
            current = prede[current];
        }
        int pathLength = 0;
        current = reversePath.pop();
        while(!reversePath.isEmpty()){
            int toVertex = reversePath.pop();
            System.out.println("From: " + current + ", to: " + toVertex + ", distance: " + matrixWeigthGraph[current][toVertex]);
            pathLength += matrixWeigthGraph[current][toVertex];
            current = toVertex;
        }
        System.out.println("Total distance " + pathLength);
    }
}