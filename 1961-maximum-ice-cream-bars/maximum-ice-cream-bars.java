import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);
        
        int iceCreamCount = 0;
        
        
        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                iceCreamCount++;
            } else {
                
                break;
            }
        }
        
        return iceCreamCount;
    }
}