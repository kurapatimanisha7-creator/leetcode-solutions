class Solution {
    public int maximumAmount(int[][] coins) {
       
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    
                    if (i == 0 && j == 0) {
                        dp[i][j][0] = coins[i][j];
                        if (coins[i][j] < 0) {
                            dp[i][j][1] = 0;
                            dp[i][j][2] = 0;
                        } else {
                            dp[i][j][1] = coins[i][j];
                            dp[i][j][2] = coins[i][j];
                        }
                        continue;
                    }

                    int fromUp = (i > 0) ? dp[i - 1][j][k] : Integer.MIN_VALUE;
                    int fromLeft = (j > 0) ? dp[i][j - 1][k] : Integer.MIN_VALUE;
                    int bestPrev = Math.max(fromUp, fromLeft);

                    if (bestPrev != Integer.MIN_VALUE) {
                        dp[i][j][k] = bestPrev + coins[i][j];
                    } else {
                        dp[i][j][k] = Integer.MIN_VALUE;
                    }

                    if (k > 0 && coins[i][j] < 0) {
                        int skipUp = (i > 0) ? dp[i - 1][j][k - 1] : Integer.MIN_VALUE;
                        int skipLeft = (j > 0) ? dp[i][j - 1][k - 1] : Integer.MIN_VALUE;
                        int bestSkip = Math.max(skipUp, skipLeft);
                        
                        if (bestSkip != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], bestSkip);
                        }
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
        
       