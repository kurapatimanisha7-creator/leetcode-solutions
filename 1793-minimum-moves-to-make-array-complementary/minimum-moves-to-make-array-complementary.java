class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        
        int[] delta = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            
            int low = Math.min(a, b) + 1;       
            int high = Math.max(a, b) + limit;  
            int sum = a + b;                    
            
            
            
            
            delta[low]--;
            
            
            delta[sum]--;
            
            
            delta[sum + 1]++;
            
           
            delta[high + 1]++;
        }

        int minMoves = n; 
        int currentMoves = n; 
        
        
        for (int i = 2; i <= 2 * limit; i++) {
            currentMoves += delta[i];
            minMoves = Math.min(minMoves, currentMoves);
        }
        
        return minMoves;
    }
}