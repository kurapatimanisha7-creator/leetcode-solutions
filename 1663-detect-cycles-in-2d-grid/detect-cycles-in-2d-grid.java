class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                   
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc, char charToMatch) {
        visited[r][c] = true;
        int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == charToMatch) {
                if (visited[nr][nc]) {
                 
                    if (nr != pr || nc != pc) return true;
                } else {
                    if (dfs(grid, visited, nr, nc, r, c, charToMatch)) return true;
                }
            }
        }
        return false;
    }
}