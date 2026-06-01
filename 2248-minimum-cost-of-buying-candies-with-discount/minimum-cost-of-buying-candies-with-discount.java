class Solution {
    public int minimumCost(int[] cost) {
        // Sort the array (ascending: 2, 2, 5, 6, 7, 9)
        Arrays.sort(cost);
        
        int totalCost = 0;
        // Start from the end (the most expensive candies)
        for (int i = cost.length - 1; i >= 0; i--) {
            // Add the 1st candy to cost
            totalCost += cost[i];
            
            // Add the 2nd candy to cost (if it exists)
            if (i - 1 >= 0) {
                totalCost += cost[i - 1];
            }
            
            // Skip the 3rd candy (the free one)
            i -= 2; 
        }
        
        return totalCost;
    }
}