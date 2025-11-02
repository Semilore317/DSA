import java.util.ArrayList;

public class Graph {
    // a graph is basically a list of vertices
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    // constructor
    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    // adding weighted edges
    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if(!this.isWeighted) {
            weight = null; // main reasson for using Integer and not int
        }

        vertex1.addEdge(vertex2, weight);
        if(!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if(!this.isWeighted) {
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public boolean isDirected(Vertex vertex) {
        return this.isDirected;
    }

    public Vertex getVertexByValue(String value) {
        for (Vertex v: this.vertices){
            if(v.getData().equals(value)){
                return v;
            }
        }
        return null;
    }

    public void print() {
        for (Vertex v : this.vertices) {
           v.print(isWeighted);
        }
    }

    public static void main(String[] args) {
        // create graph data structure and map it out
        // bus routes have distance -> weight
        // they also have directions
        Graph busNetwork = new Graph(true, false);

        Vertex cliftonStation = busNetwork.addVertex("Clifton");
        Vertex capeMayStation = busNetwork.addVertex("Cape May");
        busNetwork.addEdge(cliftonStation, capeMayStation, 1000); // 1000 miles between both stations

        busNetwork.print();
    }
}