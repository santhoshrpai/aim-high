package interview.graphs;

/**
 * @author rajasan
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] g = { { 'Y', 'Y', 'N', 'N' }, { 'Y', 'Y', 'Y', 'N' }, { 'N', 'Y', 'Y', 'N' },
                { 'N', 'N', 'N', 'Y' } };

        char[][] g1 = { { 'Y', 'N', 'N', 'N', 'N' }, { 'N', 'Y', 'N', 'N', 'N' }, { 'N', 'N', 'Y', 'N', 'N' },
                { 'N', 'N', 'N', 'Y', 'N' }, { 'N', 'N', 'N', 'N', 'Y' } };

        //        char[][] g1 = {};

        System.out.println(numIslands(g1));
    }

    public static int numIslands(char[][] grid) {

        if (grid == null) {
            return 0;
        }

        int count = 0;

        int m = grid.length;

        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;

        char[][] g = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'Y') {
                    dfs(g, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 'Y') {
            return;
        }
        grid[i][j] = 'N';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}