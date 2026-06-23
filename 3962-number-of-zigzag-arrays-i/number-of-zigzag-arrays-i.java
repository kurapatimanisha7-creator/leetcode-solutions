class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int m = r - l; // Total range length offset (0 to m)
        
        // dp[0][v]: number of ways to end at value `v` moving UP (increasing) to reach here
        // dp[1][v]: number of ways to end at value `v` moving DOWN (decreasing) to reach here
        long[] dpInc = new long[m + 1];
        long[] dpDec = new long[m + 1];
        
        // Base case: For the second element (i = 1)
        // dpInc[v] means prev < v (values 0 to v-1 are valid -> v choices)
        // dpDec[v] means prev > v (values v+1 to m are valid -> m-v choices)
        for (int v = 0; v <= m; v++) {
            dpInc[v] = v;
            dpDec[v] = m - v;
        }
        
        // Transition for indices 2 to n-1
        for (int i = 2; i < n; i++) {
            long[] nextInc = new long[m + 1];
            long[] nextDec = new long[m + 1];
            
            // For nextInc[v]: we need previous to be DECREASING and strictly less than v.
            // It equals the sum of dpDec[0 ... v-1]
            long runningDecSum = 0;
            for (int v = 0; v <= m; v++) {
                nextInc[v] = runningDecSum;
                runningDecSum = (runningDecSum + dpDec[v]) % MOD;
            }
            
            // For nextDec[v]: we need previous to be INCREASING and strictly greater than v.
            // It equals the sum of dpInc[v+1 ... m]
            long runningIncSum = 0;
            for (int v = m; v >= 0; v--) {
                nextDec[v] = runningIncSum;
                runningIncSum = (runningIncSum + dpInc[v]) % MOD;
            }
            
            dpInc = nextInc;
            dpDec = nextDec;
        }
        
        // Sum up all valid arrays ending at the last position
        long totalWays = 0;
        for (int v = 0; v <= m; v++) {
            totalWays = (totalWays + dpInc[v] + dpDec[v]) % MOD;
        }
        
        return (int) totalWays;
    }
}