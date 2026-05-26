class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        
        
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        
        boolean[] dp = new boolean[n];
        dp[0] = true; 

        
        int reachableWindowCount = 0;

        for (int i = 1; i < n; i++) {
            
            if (i >= minJump && dp[i - minJump]) {
                reachableWindowCount++;
            }

            
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachableWindowCount--;
            }

           
            if (s.charAt(i) == '0' && reachableWindowCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}