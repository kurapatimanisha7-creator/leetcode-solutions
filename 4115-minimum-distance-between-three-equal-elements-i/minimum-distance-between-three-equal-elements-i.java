import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> positions = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int result = Integer.MAX_VALUE;
        
        for (List<Integer> indices : positions.values()) {
            if (indices.size() < 3) continue;
            
            for (int i = 0; i <= indices.size() - 3; i++) {
                int dist = 2 * (indices.get(i + 2) - indices.get(i));
                result = Math.min(result, dist);
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}