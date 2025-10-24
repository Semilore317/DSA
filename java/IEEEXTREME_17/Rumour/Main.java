package IEEEXTREME_17.Rumour;

import java.util.*;

public class Main {
    public static int bfs(int start, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int neighbor : map.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());

            // a -> b, b -> a
            map.get(a).add(b);
            map.get(b).add(a);

            // compute largest group so far
            Set<Integer> visited = new HashSet<>();
            int largestGroup = 0;

            for (int person : map.keySet()) {
                if (!visited.contains(person)) {
                    int size = bfs(person, map, visited);
                    largestGroup = Math.max(largestGroup, size);
                }
            }

            System.out.println(largestGroup);
        }
    }
}
