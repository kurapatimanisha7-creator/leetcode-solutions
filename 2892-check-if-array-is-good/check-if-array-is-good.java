class Solution {
    public boolean isGood(int[] nums) {
        int n = 0;
        
        for (int num : nums) {
            if (num > n) n = num;
        }

        
        if (nums.length != n + 1) {
            return false;
        }

      
        int[] counts = new int[n + 1];
        for (int num : nums) {
            counts[num]++;
        }

       
        for (int i = 1; i < n; i++) {
            if (counts[i] != 1) return false;
        }

      
        return counts[n] == 2;
    }
}