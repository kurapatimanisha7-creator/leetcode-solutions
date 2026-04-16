import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // 1. Pre-process: Store all indices for each unique number
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // 2. Process each query
        for (int qIdx : queries) {
            int targetVal = nums[qIdx];
            List<Integer> indices = map.get(targetVal);
            
            // If the element appears only once, no "other" equal element exists
            if (indices.size() <= 1) {
                result.add(-1);
                continue;
            }
            
            // 3. Find the position of the query index in our sorted list
            int pos = Collections.binarySearch(indices, qIdx);
            
            int m = indices.size();
            // Neighbor to the left (with circular wrap-around)
            int leftIdx = indices.get((pos - 1 + m) % m);
            // Neighbor to the right (with circular wrap-around)
            int rightIdx = indices.get((pos + 1) % m);
            
            // 4. Calculate circular distances
            int distLeft = (qIdx - leftIdx + n) % n;
            int distRight = (rightIdx - qIdx + n) % n;
            
            result.add(Math.min(distLeft, distRight));
        }
        
        return result;
    }
}