import java.util.ArrayList;


class GraphTraverser {
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        System.out.println(start.getData());

        for (Edge e : start.getEdges()) {
            Vertex neighbor = e.getEnd();

            if (!visitedVertices.contains(neighbor)) {
                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }

    // Use Generics (<Vertex>) on the Queue and for better type safety
    public static void breadFirstSearch(Vertex start, ArrayList<Vertex> visitedVertices) {

        // 1. Syntax Fix: new Queue()
        Queue<Vertex> visitQueue = new Queue<>();

        // 1. Initialization
        visitQueue.enqueue(start);
        visitedVertices.add(start); // Mark the start node as visited immediately

        // 2. Main Traversal Loop
        while (!visitQueue.isEmpty()) {

            // a. Dequeue the current vertex
            Vertex current = visitQueue.dequeue();
            System.out.println("Visiting: " + current.getData());

            // b. LOGIC FIX: Check all neighbors of 'current' inside the loop
            for (Edge e : current.getEdges()) {
                Vertex neighbor = e.getEnd();

                if (!visitedVertices.contains(neighbor)) {
                    // c. Mark as visited AND enqueue
                    visitedVertices.add(neighbor);
                    visitQueue.enqueue(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices1 = new ArrayList<Vertex>();
        ArrayList<Vertex> visitedVertices2 = new ArrayList<Vertex>();
        visitedVertices1.add(startingVertex);
        visitedVertices2.add(startingVertex);
        System.out.println("DFS: ");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices1);
        System.out.println("BFS: ");
        GraphTraverser.breadFirstSearch(startingVertex, visitedVertices2);
    }
}
