package GraphTraversal;

import fundamentals.Array;

import java.util.*;


public class Djikstra {
    public static Dictionary[] djikstra(Graph g, Vertex startingVertex) {
        Dictionary<String, Integer> distances = new Hashtable<String, Integer>();
        Dictionary<String, Vertex> previous = new Hashtable<>();

        // Implement a priority Queue
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        queue.add(new QueueObject(startingVertex, 0));
        for(Vertex v : g.getVertices()) {
            if( v != startingVertex ) {
                distances.put(v.getData(), Integer.MAX_VALUE);
            }
            previous.put(v.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);

        // fun part
        while(!queue.isEmpty()) {
            Vertex current = queue.poll().vertex;
            for (Edge e : current.getEdges()) {
                Integer alternative = distances.get(current.getData()) + e.getWeight();
                String neighbourValue = e.getEnd().getData();
                if(alternative < distances.get(neighbourValue)) {
                    distances.put(neighbourValue, alternative);
                    previous.put(neighbourValue, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighbourValue)));

                }
            }
        }
        return new Dictionary[]{distances, previous};
    }

    public static void djikstraResultPrinter(Dictionary[] d){
        System.out.println("Distances \n");
        for(Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println("\nPrevious: \n");
        for(Enumeration keys = d[1].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ":" + nextVertex.getData());
        }
    }

    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex) {
        Dictionary[] djikstraDictionaries = djikstra(g, startingVertex);
        Dictionary distances = djikstraDictionaries[0];
        Dictionary previous = djikstraDictionaries[1];

        Integer distance = (Integer) distances.get(targetVertex.getData());
        System.out.println("Shortest Path Between " + startingVertex.getData() + "and " + targetVertex.getData());
        System.out.println(distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;

        while(!v.getData().equals("Null")) {
            path.add(0, v);
            v = (Vertex) previous.get(v.getData());
        }
        System.out.println("Shortest Path");
        for (Vertex pathVertex : path) {
            System.out.println(pathVertex.getData());
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

        testGraph.addEdge(a,c, 100);
        testGraph.addEdge(a,b,3);
        testGraph.addEdge(a,d,4);
        testGraph.addEdge(d,c,3);
        testGraph.addEdge(d,e,8);
        testGraph.addEdge(e,b,2);
        testGraph.addEdge(e,f,10);
        testGraph.addEdge(b,g,9);
        testGraph.addEdge(e,g,50);

        djikstraResultPrinter(djikstra(testGraph,a));
        shortestPathBetween(testGraph,a,g);
    }
}