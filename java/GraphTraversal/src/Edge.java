public class Edge {
    private Vertex start;
    private Vertex end;
    private Integer weight;

    //constructor
    public Edge(Vertex startVertex, Vertex endVertex, Integer inputWeight) {
        this.start = startVertex;
        this.end = endVertex;
        this.weight = inputWeight;
    }

    public Vertex getStart() {
        return this.start;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
