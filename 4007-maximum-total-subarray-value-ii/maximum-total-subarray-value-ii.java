import java.util.*;

class Solution {
    private int[][] maxST;
    private int[][] minST;
    private int[] lg;
    private int[] nums;

    public long maxTotalValue(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;

        // 1. Precompute logs for Sparse Table
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int maxLog = lg[n] + 1;
        maxST = new int[maxLog][n];
        minST = new int[maxLog][n];

        for (int i = 0; i < n; i++) {
            maxST[0][i] = i;
            minST[0][i] = i;
        }

        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                int lMax = maxST[j - 1][i];
                int rMax = maxST[j - 1][i + (1 << (j - 1))];
                maxST[j][i] = nums[lMax] >= nums[rMax] ? lMax : rMax;

                int lMin = minST[j - 1][i];
                int rMin = minST[j - 1][i + (1 << (j - 1))];
                minST[j][i] = nums[lMin] <= nums[rMin] ? lMin : rMin;
            }
        }

        // 2. Max-Heap to hold segments
        // We track: { value, L, R }
        // To avoid processing duplicate intervals, we keep track of visited interval signatures.
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        Set<Long> visited = new HashSet<>();

        // Helper to safely encode L and R into a single unique long
        long initialKey = ((long) 0 << 32) | (n - 1);
        long initialVal = (long) nums[queryMaxIdx(0, n - 1)] - nums[queryMinIdx(0, n - 1)];
        
        pq.offer(new long[]{initialVal, 0, n - 1});
        visited.add(initialKey);

        long totalValue = 0;

        // 3. Process exactly k subarrays
        for (int iter = 0; iter < k && !pq.isEmpty(); iter++) {
            long[] curr = pq.poll();
            totalValue += curr[0];

            int L = (int) curr[1];
            int R = (int) curr[2];

            // Generate next state by shrinking either left boundary or right boundary
            if (L + 1 <= R) {
                // Shrink left
                long leftKey = ((long) (L + 1) << 32) | R;
                if (!visited.contains(leftKey)) {
                    long val = (long) nums[queryMaxIdx(L + 1, R)] - nums[queryMinIdx(L + 1, R)];
                    pq.offer(new long[]{val, L + 1, R});
                    visited.add(leftKey);
                }

                // Shrink right
                long rightKey = ((long) L << 32) | (R - 1);
                if (!visited.contains(rightKey)) {
                    long val = (long) nums[queryMaxIdx(L, R - 1)] - nums[queryMinIdx(L, R - 1)];
                    pq.offer(new long[]{val, L, R - 1});
                    visited.add(rightKey);
                }
            }
        }

        return totalValue;
    }

    private int queryMaxIdx(int L, int R) {
        int k = lg[R - L + 1];
        int idx1 = maxST[k][L];
        int idx2 = maxST[k][R - (1 << k) + 1];
        return nums[idx1] >= nums[idx2] ? idx1 : idx2;
    }

    private int queryMinIdx(int L, int R) {
        int k = lg[R - L + 1];
        int idx1 = minST[k][L];
        int idx2 = minST[k][R - (1 << k) + 1];
        return nums[idx1] <= nums[idx2] ? idx1 : idx2;
    }
}