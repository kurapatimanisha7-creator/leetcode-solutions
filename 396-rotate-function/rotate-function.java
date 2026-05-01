class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long currentF = 0;
        
       
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            currentF += (long) i * nums[i];
        }
        
        long maxF = currentF;
        
        
        for (int i = 1; i < n; i++) {
            
            currentF = currentF + sum - (long) n * nums[n - i];
            maxF = Math.max(maxF, currentF);
        }
        
        return (int) maxF;
    }
}