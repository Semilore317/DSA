package pre_extreme_problems;

import java.util.*;

public class MysteriousArchipelago {
    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
    };

    private static class Cell {
        int x, y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return x * 1001 + y;
        }
    }

    private static class State {
        Cell cell;
        int islandCrossings;

        State(Cell cell, int islandCrossings) {
            this.cell = cell;
            this.islandCrossings = islandCrossings;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        // read the map (0-based indexing for arrays)
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // identify islands using Union-Find or DFS/BFS
        int[][] islandId = new int[N][M];
        int islandCount = 0;

        // mark sea cells with -1, land cells will get positive IDs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                islandId[i][j] = (map[i][j] == '~') ? -1 : 0;
            }
        }

        // assign island IDs using DFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'O' && islandId[i][j] == 0) {
                    // new island found
                    assignIslandId(map, islandId, i, j, ++islandCount);
                }
            }
        }

        // process Q queries
        for (int q = 0; q < Q; q++) {
            int x1 = sc.nextInt() - 1; // convert to 0-based
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;

            // only run dijkstra if start and end are different sea cells
            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
                continue;
            }

            // run dijkstra from (x1,y1) to find minimum island crossings to (x2,y2)
            int minCrossings = dijkstra(map, islandId, x1, y1, x2, y2, N, M);
            System.out.println(minCrossings);
        }

        sc.close();
    }

    private static void assignIslandId(char[][] map, int[][] islandId, int x, int y, int islandNumber) {
        // DFS to mark all connected land cells with this island number
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(x, y));
        islandId[x][y] = islandNumber;

        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            int cx = current.x, cy = current.y;

            // explore all 8 neighbors
            for (int[] dir : DIRECTIONS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                // bounds check
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    // if it's land and not yet assigned
                    if (map[nx][ny] == 'O' && islandId[nx][ny] == 0) {
                        islandId[nx][ny] = islandNumber;
                        stack.push(new Cell(nx, ny));
                    }
                }
            }
        }
    }

    private static int dijkstra(char[][] map, int[][] islandId, int startX, int startY,
                                int targetX, int targetY, int N, int M) {

        // priority queue: (islandCrossings, x, y)
        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.islandCrossings, b.islandCrossings)
        );

        // distances: minimum island crossings to reach each cell
        int[][] minCrossings = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minCrossings[i], Integer.MAX_VALUE);
        }

        // start from sea cell, initial crossings = 0
        Cell start = new Cell(startX, startY);
        pq.offer(new State(start, 0));
        minCrossings[startX][startY] = 0;

        while (!pq.isEmpty()) {
            State current = pq.poll();
            Cell pos = current.cell;
            int cx = pos.x, cy = pos.y;
            int crossings = current.islandCrossings;

            // if we've reached target with optimal path, return
            if (cx == targetX && cy == targetY) {
                return crossings;
            }

            // if we've found a better path already, skip
            if (crossings > minCrossings[cx][cy]) {
                continue;
            }

            // explore all 8 neighbors
            for (int[] dir : DIRECTIONS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                // bounds check
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int additionalCost = 0;

                    // cost only when moving from sea to land
                    if (map[cx][cy] == '~' && map[nx][ny] == 'O') {
                        additionalCost = 1; // entering an island
                    }

                    int newCrossings = crossings + additionalCost;

                    // if this is a better path
                    if (newCrossings < minCrossings[nx][ny]) {
                        minCrossings[nx][ny] = newCrossings;
                        pq.offer(new State(new Cell(nx, ny), newCrossings));
                    }
                }
            }
        }

        // if unreachable (shouldn't happen per problem guarantee)
        return -1;
    }
}