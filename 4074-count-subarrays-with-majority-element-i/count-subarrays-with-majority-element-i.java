class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        
        int[] cnt = new int[2 * n + 1];
        
        
        int s = n; 
        cnt[s] = 1;
        
        int totalSubarrays = 0;
        int currentValidCount = 0; 
        
        for (int num : nums) {
            if (num == target) {
               
                currentValidCount += cnt[s];
                s++;
            } else {
                
                s--;
                currentValidCount -= cnt[s];
            }
            
            
            totalSubarrays += currentValidCount;
            
            
            cnt[s]++;
        }
        
        return totalSubarrays;
    }
}