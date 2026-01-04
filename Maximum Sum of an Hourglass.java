class Solution {
    public int maxSum(int[][] grid) {
        int nr=grid.length;
        int nc=grid[0].length;
        int max=0;
        //traverse through grid
        int cs;
        for(int i=1;i<nr-1;i++){
            for(int j=1;j<nc-1;j++){
                cs = grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] +
                                    grid[i][j]+
                      grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1];
                max = Math.max(max,cs);
            }
        }
        return max;
        
    }
}
