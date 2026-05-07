class Solution {
    public int countNegatives(int[][] grid) {
        //Brue force method
        int count=0;
        int n=grid.length;
        for(int i=0;i<n;i++){
            int m=grid[i].length;
            for(int j=0;j<m;j++){
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
}