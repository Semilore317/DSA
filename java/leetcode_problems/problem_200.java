package leetcode_problems;

public class problem_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int column = grid[0].length;

        // iterate through every cell
        int islandCount = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    sinkIsland(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    public void sinkIsland(char[][] grid, int row, int column){
        int r = grid.length;
        int c = grid[0].length;

        // BASE CASE

        //1. out of bound
        if(row < 0 || row >= r || column < 0 || column >= c || grid[row][column] == '0') return;

        // mark as visited
        grid[row][column] = '0';


        // explore neighbours
        sinkIsland(grid, row + 1, column);
        sinkIsland(grid, row - 1, column);
        sinkIsland(grid, row, column + 1);
        sinkIsland(grid, row, column - 1);
    }
}