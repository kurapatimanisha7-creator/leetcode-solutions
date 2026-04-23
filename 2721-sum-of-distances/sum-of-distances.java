class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Group indices by their values
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Process each group
        for (int num : map.keySet()) {
            List<Integer> indices = map.get(num);
            long totalSum = 0;
            for (int index : indices) {
                totalSum += index;
            }

            long prefixSum = 0;
            int m = indices.size();
            for (int i = 0; i < m; i++) {
                long currentIdx = indices.get(i);
                
                // Elements to the right sum
                long suffixSum = totalSum - prefixSum - currentIdx;
                
                // Calculate left and right absolute differences
                long leftSide = (long) i * currentIdx - prefixSum;
                long rightSide = suffixSum - (long) (m - 1 - i) * currentIdx;
                
                res[(int) currentIdx] = leftSide + rightSide;
                
                prefixSum += currentIdx;
            }
        }

        return res;
    }
}