public class Pair implements Comparable<Pair>{
    Integer distance;
    Integer index;
    public Pair(Integer distance, Integer vertex){
        this.distance = distance;
        this.index = vertex;
    }

    @Override
    public int compareTo(Pair o) {
        return this.distance.compareTo(o.distance);
    }
}