package week7;

public class pathofdeer {

    public static class Grid {

        static int SolvePathWithObstacles(int[][] Actual) {
            int m = Actual.length; // stores the length of the grid.
            int n = Actual[0].length; // stores the length of the grid.
            int[][] grid = new int[m][n]; // creates a new grid.
            for (int i = 0; i < m; i++) { // loops through the grid.
                for (int j = 0; j < n; j++) { // loops through the grid.
                    if (Actual[i][j] == 1) { // if the grid has an obstacle, we set the value to 0.
                        grid[i][j] = 0;
                    } else if (i == 0 && j == 0) { // if we are at the start of the grid, we set the
                                                   // value to 1.
                        grid[i][j] = 1;
                    } else if (i == 0) { // if we are at the start of the grid, we set the value to
                                         // the value of the grid to the left.
                        grid[i][j] = grid[i][j - 1];
                    } else if (j == 0) { // if we are at the start of the grid, we set the value to
                                         // the value of the grid above.
                        grid[i][j] = grid[i - 1][j];
                    } else { // if we are not at the start of the grid, we set the value to the
                             // value of the grid to the left and the value of the grid above.
                        grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                    }
                }
            }
            return grid[m - 1][n - 1]; // we return the value of the grid at the end.
        }

    }

    public static void main(String[] args) {
        int[][] Actual = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(Grid.SolvePathWithObstacles(Actual));
    }
}
