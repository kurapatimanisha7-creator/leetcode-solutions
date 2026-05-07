class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        int[] preMax = new int[n];

        // Step 1: Build prefix maximum array
        preMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        // Step 2: Traverse from right to left
        int sufMin = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            // If a smaller value exists on right,
            // then we can reach ans[i+1]
            if (preMax[i] > sufMin) {
                ans[i] = ans[i + 1];
            } else {
                ans[i] = preMax[i];
            }

            // Update suffix minimum
            sufMin = Math.min(sufMin, nums[i]);
        }

        return ans;
    }
}