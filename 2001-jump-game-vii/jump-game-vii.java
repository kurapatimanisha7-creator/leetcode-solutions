class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        
        // Quick boundary check: if the last character is '1', it can never be reached
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        // dp[i] will store whether index i is reachable from index 0
        boolean[] dp = new boolean[n];
        dp[0] = true; // Base case: we start at index 0

        // Tracks how many reachable indices ('true' in dp) currently exist 
        // within the valid jumping window for the current index i.
        int reachableWindowCount = 0;

        for (int i = 1; i < n; i++) {
            // 1. Expand the window from the right:
            // The index (i - minJump) has just become close enough to jump to i.
            if (i >= minJump && dp[i - minJump]) {
                reachableWindowCount++;
            }

            // 2. Shrink the window from the left:
            // The index (i - maxJump - 1) is now too far away to jump to i.
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachableWindowCount--;
            }

            // 3. Evaluate the current index:
            // If the character is '0' and there's at least one true DP value 
            // inside our window, then index i is reachable.
            if (s.charAt(i) == '0' && reachableWindowCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}