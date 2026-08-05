import java.io.*;
import java.util.*;

public class Solution {
  private static class Graph {
    private final List<List<Integer>> adj;
    private final static int EDGE_DISTANCE = 6;

    public Graph(int size) {
      adj = new ArrayList<>(size);
      for (int i = 0; i < size; i++)
        adj.add(new ArrayList<>());
    }

    public void addEdge(int first, int second) {
      adj.get(first - 1).add(second - 1);
      adj.get(second - 1).add(first - 1);
    }

    public int[] shortestReach(int startId) {
      int start = startId - 1;
      int[] distances = new int[adj.size()];
      Arrays.fill(distances, -1);
      distances[start] = 0;

      ArrayDeque<Integer> queue = new ArrayDeque<>();
      queue.add(start);

      while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int neighbour : adj.get(node)) {
          if (distances[neighbour] == -1) {
            distances[neighbour] = distances[node] + EDGE_DISTANCE;
            queue.add(neighbour);
          }
        }
      }

      return distances;
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int q = Integer.parseInt(br.readLine().trim());

    while (q-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      Graph graph = new Graph(n);

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph.addEdge(u, v);
      }

      int s = Integer.parseInt(br.readLine().trim());
      int[] distances = graph.shortestReach(s);

      StringBuilder line = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (i == s - 1)
          continue;
        if (line.length() > 0)
          line.append(' ');
        line.append(distances[i]);
      }
      out.append(line).append('\n');
    }

    System.out.print(out);
  }
}
