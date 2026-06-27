import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
    
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxVal = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxVal = Math.max(maxVal, num);
        }

        int maxLen = 0;
        if (countMap.containsKey(1)) {
            int countOne = countMap.get(1);
           
            maxLen = countOne % 2 == 0 ? countOne - 1 : countOne;
        } else {
            maxLen = 1; 
        }

        
        for (int num : countMap.keySet()) {
            if (num == 1) continue;

            int currentLen = 0;
            long x = num;

           
            while (x <= maxVal && countMap.containsKey((int) x) && countMap.get((int) x) >= 2) {
                currentLen += 2;
                x = x * x; 
            }

          
            if (x <= maxVal && countMap.containsKey((int) x)) {
                currentLen += 1;
            } else {
                currentLen -= 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}