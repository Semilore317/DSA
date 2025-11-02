import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Djisktra {
    public class Djisktra{
        public static Dictionary[] djisktra(Graph g, Vertex startingVertex){
            Dictionary<String, Integer> distances = new Hashtable<String, Integer>();
            Dictionary<String, Vertex> previous = new Hashtable<>();

            // Implement a priority Queue
            PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();
        }
    }
    public static void main(String[] args) {
        Graph testGraph = new Graph(true, false);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");
    }
}
