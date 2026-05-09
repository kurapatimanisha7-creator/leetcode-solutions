class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int i = 0; i < layers; i++) {
           
            List<Integer> layerList = new ArrayList<>();
            
            
            for (int j = i; j < n - 1 - i; j++) layerList.add(grid[i][j]);
           
            for (int j = i; j < m - 1 - i; j++) layerList.add(grid[j][n - 1 - i]);
           
            for (int j = n - 1 - i; j > i; j--) layerList.add(grid[m - 1 - i][j]);
           
            for (int j = m - 1 - i; j > i; j--) layerList.add(grid[j][i]);

            int L = layerList.size();
            int netRotation = k % L;

           
            int idx = netRotation; 
            
            for (int j = i; j < n - 1 - i; j++) grid[i][j] = layerList.get(idx++ % L);
            for (int j = i; j < m - 1 - i; j++) grid[j][n - 1 - i] = layerList.get(idx++ % L);
            for (int j = n - 1 - i; j > i; j--) grid[m - 1 - i][j] = layerList.get(idx++ % L);
            for (int j = m - 1 - i; j > i; j--) grid[j][i] = layerList.get(idx++ % L);
        }
        
        return grid;
    }
}