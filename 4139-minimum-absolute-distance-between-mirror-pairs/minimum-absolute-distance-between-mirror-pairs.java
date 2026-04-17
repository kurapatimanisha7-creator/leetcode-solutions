import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (lastSeen.containsKey(nums[i])) {
                minDistance = Math.min(minDistance, i - lastSeen.get(nums[i]));
            }

            int reversedNum = reverse(nums[i]);
            lastSeen.put(reversedNum, i);
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}