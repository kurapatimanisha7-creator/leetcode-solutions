class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;
        
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int)((1L * nums[idx] * v) % MOD);
            }
        }
        
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}