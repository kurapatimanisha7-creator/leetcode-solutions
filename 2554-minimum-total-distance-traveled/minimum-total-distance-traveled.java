import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        // dp[i][j] = min distance for robots from index i using factories from index j
        long[][] dp = new long[n + 1][m + 1];

        // Base case: if no more factories, distance is infinity (except for 0 robots)
        for (int i = 0; i < n; i++) {
            dp[i][m] = (long) 1e15; 
        }

        // Iterate through factories from right to left
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n; i >= 0; i--) {
                // Option 1: Skip the current factory
                long res = dp[i][j + 1];

                // Option 2: Assign 'k' robots to the current factory
                long currentFactoryDist = 0;
                for (int k = 1; i + k <= n && k <= factory[j][1]; k++) {
                    currentFactoryDist += Math.abs(robot.get(i + k - 1) - factory[j][0]);
                    res = Math.min(res, currentFactoryDist + dp[i + k][j + 1]);
                }
                dp[i][j] = res;
            }
        }

        return dp[0][0];
    }
}