class Solution {
    public int rotatedDigits(int n) {
        String s = String.valueOf(n);
        
        Integer[][][] memo = new Integer[s.length()][2][2];
        return dp(s, 0, 1, 0, memo);
    }

    private int dp(String s, int idx, int isLess, int isDiff, Integer[][][] memo) {
        if (idx == s.length()) {
            return isDiff; // Returns 1 if we found at least one 2, 5, 6, or 9
        }
        if (memo[idx][isLess][isDiff] != null) {
            return memo[idx][isLess][isDiff];
        }

        int count = 0;
        int limit = (isLess == 1) ? s.charAt(idx) - '0' : 9;

        for (int d = 0; d <= limit; d++) {
            
            if (d == 3 || d == 4 || d == 7) continue;

           
            int nextDiff = (isDiff == 1 || d == 2 || d == 5 || d == 6 || d == 9) ? 1 : 0;
            
            count += dp(s, idx + 1, 
                        (isLess == 1 && d == limit) ? 1 : 0, 
                        nextDiff, 
                        memo);
        }

        return memo[idx][isLess][isDiff] = count;
    }
}