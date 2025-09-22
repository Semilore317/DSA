package pre_extreme_problems;

import java.util.*;

public class GridMove {
    static class Positions {
        int r, c;
        Positions(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // read input and validate initial conditions
    public static class InputData {
        int N, M, H, W, Sr, Sc, Fr, Fc;
        int[][] grid;

        InputData(Scanner sc) {
            N = sc.nextInt();
            M = sc.nextInt();

            grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            H = sc.nextInt();
            W = sc.nextInt();
            Sr = sc.nextInt() - 1;
            Sc = sc.nextInt() - 1;
            Fr = sc.nextInt() - 1;
            Fc = sc.nextInt() - 1;
        }
    }

    // check if initial positions are valid given rectangle size
    private static boolean isValidPosition(InputData data) {
        int maxRow = data.N - data.H + 1;
        int maxCol = data.M - data.W + 1;

        return maxRow > 0 && maxCol > 0 &&
                data.Sr >= 0 && data.Sr < maxRow && data.Sc >= 0 && data.Sc < maxCol &&
                data.Fr >= 0 && data.Fr < maxRow && data.Fc >= 0 && data.Fc < maxCol;
    }

    // build prefix sum for fast range queries
    private static long[][] buildPrefixSum(int[][] grid, int N, int M) {
        long[][] prefix = new long[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] -
                        prefix[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return prefix;
    }

    // check if rectangle at position (tr, tc) contains any obstacles
    private static boolean isRectangleValid(long[][] prefix, int tr, int tc, int H, int W, int N, int M) {
        int r1 = tr + 1, c1 = tc + 1;
        int r2 = tr + H, c2 = tc + W;

        if (r2 > N || c2 > M) return false;

        long sum = prefix[r2][c2] - prefix[r2][c1 - 1] - prefix[r1 - 1][c2] + prefix[r1 - 1][c1 - 1];
        return sum == 0;
    }

    // precompute all valid positions for the rectangle's top-left corner
    private static boolean[][] computeValidPositions(long[][] prefix, int[][] grid,
                                                     int H, int W, int N, int M) {
        int maxRow = N - H + 1;
        int maxCol = M - W + 1;
        boolean[][] valid = new boolean[maxRow][maxCol];

        for (int tr = 0; tr < maxRow; tr++) {
            for (int tc = 0; tc < maxCol; tc++) {
                valid[tr][tc] = isRectangleValid(prefix, tr, tc, H, W, N, M);
            }
        }

        return valid;
    }

    // perform BFS to find shortest path between valid positions
    private static int findShortestPath(boolean[][] valid, int Sr, int Sc, int Fr, int Fc, int maxRow, int maxCol) {
        int[][] dist = new int[maxRow][maxCol];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<Positions> queue = new LinkedList<>();
        dist[Sr][Sc] = 0;
        queue.add(new Positions(Sr, Sc));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Positions current = queue.poll();
            int cr = current.r;
            int cc = current.c;

            if (cr == Fr && cc == Fc) {
                return dist[cr][cc];
            }

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr >= 0 && nr < maxRow && nc >= 0 && nc < maxCol &&
                        valid[nr][nc] && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cr][cc] + 1;
                    queue.add(new Positions(nr, nc));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read and validate input
        InputData data = new InputData(sc);

        if (!isValidPosition(data)) {
            System.out.println(-1);
            return;
        }

        // build prefix sum for fast obstacle checking
        long[][] prefix = buildPrefixSum(data.grid, data.N, data.M);

        // precompute valid positions
        boolean[][] valid = computeValidPositions(prefix, data.grid, data.H, data.W, data.N, data.M);

        // check if start and end positions are valid
        int maxRow = data.N - data.H + 1;
        int maxCol = data.M - data.W + 1;

        if (!valid[data.Sr][data.Sc] || !valid[data.Fr][data.Fc]) {
            System.out.println(-1);
            return;
        }

        // find shortest path using BFS
        int result = findShortestPath(valid, data.Sr, data.Sc, data.Fr, data.Fc, maxRow, maxCol);
        System.out.println(result);

        sc.close();
    }
}