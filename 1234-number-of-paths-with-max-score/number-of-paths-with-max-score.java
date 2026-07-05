class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][][] dp = new int[n][n][2];

        
        dp[n - 1][n - 1][1] = 1; 

        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        
        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                
                if (board.get(r).charAt(c) == 'X' || (r == n - 1 && c == n - 1)) {
                    continue;
                }

                int maxScore = -1;
                int pathCount = 0;

                
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    
                    if (nr < n && nc < n && dp[nr][nc][1] > 0) {
                        int prevScore = dp[nr][nc][0];
                        
                        if (prevScore > maxScore) {
                            maxScore = prevScore;
                            pathCount = dp[nr][nc][1];
                        } else if (prevScore == maxScore) {
                            pathCount = (pathCount + dp[nr][nc][1]) % MOD;
                        }
                    }
                }

                
                if (maxScore != -1) {
                    
                    int currentVal = (board.get(r).charAt(c) == 'E') ? 0 : (board.get(r).charAt(c) - '0');
                    dp[r][c][0] = maxScore + currentVal;
                    dp[r][c][1] = pathCount;
                }
            }
        }

        
        return new int[]{dp[0][0][0], dp[0][0][1]};
    }
}