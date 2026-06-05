class Solution {
   
    private Long[][][][][][] dp;
    private ArrayList<Integer> digits;

    public long totalWaviness(long num1, long num2) {
        return countWaviness(num2) - countWaviness(num1 - 1);
    }

    private long countWaviness(long x) {
        if (x <= 0) return 0;

        digits = new ArrayList<>();
        while (x > 0) {
            digits.add((int) (x % 10));
            x /= 10;
        }
        Collections.reverse(digits);

        int n = digits.size();

        dp = new Long[n][n + 1][11][11][2][2];

        return solve(0, 0, 10, 10, 0, 0);
    }

    private long solve(int pos, int sum, int prv2, int prv, int isLess, int isStarted) {
        
        if (pos == digits.size()) {
            return sum;
        }

        if (dp[pos][sum][prv2][prv][isLess][isStarted] != null) {
            return dp[pos][sum][prv2][prv][isLess][isStarted];
        }

        long totalWaviness = 0;
        int limit = (isLess == 1) ? 9 : digits.get(pos);

        for (int digit = 0; digit <= limit; digit++) {
            int nextLess = (isLess == 1 || digit < digits.get(pos)) ? 1 : 0;
            int nextStarted = (isStarted == 1 || digit > 0) ? 1 : 0;

            if (nextStarted == 1) {
                int nextSum = sum;
               
                if (prv2 != 10 && prv != 10) {
                    
                    if (prv > prv2 && prv > digit) {
                        nextSum++;
                    }
                    
                    else if (prv < prv2 && prv < digit) {
                        nextSum++;
                    }
                }
                
               
                if (isStarted == 0) {
                    totalWaviness += solve(pos + 1, nextSum, 10, digit, nextLess, nextStarted);
                } else {
                    totalWaviness += solve(pos + 1, nextSum, prv, digit, nextLess, nextStarted);
                }
            } else {
               
                totalWaviness += solve(pos + 1, sum, 10, 10, nextLess, 0);
            }
        }

        return dp[pos][sum][prv2][prv][isLess][isStarted] = totalWaviness;
    }
}