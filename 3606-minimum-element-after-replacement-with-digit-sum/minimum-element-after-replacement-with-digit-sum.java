public class Solution {
    public int minElement(int[] nums) {
        
        int n = nums.length;
        int[] digitSums = new int[n];
        
      
        for (int i = 0; i < n; i++) {
            int currentNumber = nums[i];
            int sum = 0;
            
          
            while (currentNumber > 0) {
                int lastDigit = currentNumber % 10;
                sum = sum + lastDigit;             
                currentNumber = currentNumber / 10;
            }
            
           
            digitSums[i] = sum;
        }
        
       
        int minElement = digitSums[0]; 
        
        for (int i = 1; i < digitSums.length; i++) {
            
            if (digitSums[i] < minElement) {
                minElement = digitSums[i];
            }
        }
        
        
        return minElement;
    }
}