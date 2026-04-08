class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        
        // Process each query
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            
            int idx = l;
            while (idx <= r) {
                nums[idx] = (int)((long)nums[idx] * v % MOD);
                idx += k;
            }
        }
        
        // Compute XOR of final array
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}
