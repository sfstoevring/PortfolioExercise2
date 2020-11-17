public class Main {

    public static void main(String[] args) {

        /* Creating vertices */
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph();
        Vertex eskilstrup = new Vertex(0, "Eskilstrup");
        adjacencyListGraph.addVertex(eskilstrup);
        Vertex haslev = new Vertex(1, "Haslev");
        adjacencyListGraph.addVertex(haslev);
        Vertex holbæk = new Vertex(2, "Holbæk");
        adjacencyListGraph.addVertex(holbæk);
        Vertex jægerspris = new Vertex(3, "Jægerspris");
        adjacencyListGraph.addVertex(jægerspris);
        Vertex kalundborg = new Vertex(4, "Kalundborg");
        adjacencyListGraph.addVertex(kalundborg);
        Vertex korsør = new Vertex(5, "Korsør");
        adjacencyListGraph.addVertex(korsør);
        Vertex køge = new Vertex(6, "Køge");
        adjacencyListGraph.addVertex(køge);
        Vertex maribo = new Vertex(7, "Maribo");
        adjacencyListGraph.addVertex(maribo);
        Vertex næstved = new Vertex(8, "Næstved");
        adjacencyListGraph.addVertex(næstved);
        Vertex ringsted = new Vertex(9, "Ringsted");
        adjacencyListGraph.addVertex(ringsted);
        Vertex slagelse = new Vertex(10, "Slagelse");
        adjacencyListGraph.addVertex(slagelse);
        Vertex nykøbingF = new Vertex(11, "Nykøbing Falster");
        adjacencyListGraph.addVertex(nykøbingF);
        Vertex vordingborg = new Vertex(12, "Vordingborg");
        adjacencyListGraph.addVertex(vordingborg);
        Vertex roskilde = new Vertex(13, "Roskilde");
        adjacencyListGraph.addVertex(roskilde);
        Vertex sorø = new Vertex(14, "Sorø");
        adjacencyListGraph.addVertex(sorø);
        Vertex nakskov = new Vertex(15, "Nakskov");
        adjacencyListGraph.addVertex(nakskov);

        /* Assigning edges to vertices */
        adjacencyListGraph.newEdge(eskilstrup,maribo,28);
        adjacencyListGraph.newEdge(eskilstrup,nykøbingF,13);
        adjacencyListGraph.newEdge(eskilstrup,vordingborg,24);
        adjacencyListGraph.newEdge(haslev,korsør,60);
        adjacencyListGraph.newEdge(haslev,køge,24);
        adjacencyListGraph.newEdge(haslev,næstved,25);
        adjacencyListGraph.newEdge(haslev,ringsted,19);
        adjacencyListGraph.newEdge(haslev,roskilde,47);
        adjacencyListGraph.newEdge(haslev,slagelse,48);
        adjacencyListGraph.newEdge(haslev,sorø,34);
        adjacencyListGraph.newEdge(haslev,vordingborg,40);
        adjacencyListGraph.newEdge(holbæk,jægerspris,34);
        adjacencyListGraph.newEdge(holbæk,kalundborg,44);
        adjacencyListGraph.newEdge(holbæk,korsør,66);
        adjacencyListGraph.newEdge(holbæk,ringsted,36);
        adjacencyListGraph.newEdge(holbæk,roskilde,32);
        adjacencyListGraph.newEdge(holbæk,slagelse,46);
        adjacencyListGraph.newEdge(holbæk,sorø,34);
        adjacencyListGraph.newEdge(jægerspris,korsør,95);
        adjacencyListGraph.newEdge(jægerspris,køge,58);
        adjacencyListGraph.newEdge(jægerspris,ringsted,56);
        adjacencyListGraph.newEdge(jægerspris,roskilde,33);
        adjacencyListGraph.newEdge(jægerspris,slagelse,74);
        adjacencyListGraph.newEdge(jægerspris,sorø,63);
        adjacencyListGraph.newEdge(kalundborg,ringsted,62);
        adjacencyListGraph.newEdge(kalundborg,roskilde,70);
        adjacencyListGraph.newEdge(kalundborg,slagelse,39);
        adjacencyListGraph.newEdge(kalundborg,sorø,51);
        adjacencyListGraph.newEdge(korsør,næstved,45);
        adjacencyListGraph.newEdge(korsør,slagelse,20);
        adjacencyListGraph.newEdge(køge,næstved,45);
        adjacencyListGraph.newEdge(køge,ringsted,28);
        adjacencyListGraph.newEdge(køge,roskilde,25);
        adjacencyListGraph.newEdge(køge,vordingborg,60);
        adjacencyListGraph.newEdge(maribo,nakskov,27);
        adjacencyListGraph.newEdge(maribo,nykøbingF,26);
        adjacencyListGraph.newEdge(næstved,roskilde,57);
        adjacencyListGraph.newEdge(næstved,ringsted,26);
        adjacencyListGraph.newEdge(næstved,slagelse,37);
        adjacencyListGraph.newEdge(næstved,sorø,32);
        adjacencyListGraph.newEdge(næstved,vordingborg,28);
        adjacencyListGraph.newEdge(ringsted,roskilde,31);
        adjacencyListGraph.newEdge(ringsted,sorø,15);
        adjacencyListGraph.newEdge(ringsted,vordingborg,58);
        adjacencyListGraph.newEdge(slagelse,sorø,14);

        //adjacencyListGraph.printGraph();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        adjacencyListGraph.PrimsMstAlgorithm();
    }
}
