import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] flat = new int[rows * cols];
        int mod = grid[0][0] % x;
        int k = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (grid[i][j] % x != mod) {
                    return -1;
                }
                flat[k++] = grid[i][j];
            }
        }

      
        Arrays.sort(flat);
        int median = flat[flat.length / 2];
        int operations = 0;

        for (int num : flat) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}