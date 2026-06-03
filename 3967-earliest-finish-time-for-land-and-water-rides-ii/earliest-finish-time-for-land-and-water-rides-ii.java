class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int landThenWater = calculateEarliestFinish(landStartTime, landDuration, waterStartTime, waterDuration);
        
        int waterThenLand = calculateEarliestFinish(waterStartTime, waterDuration, landStartTime, landDuration);
        
        return Math.min(landThenWater, waterThenLand);
    }
    
    private int calculateEarliestFinish(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
       
        int minFirstCategoryFinish = Integer.MAX_VALUE;
        for (int i = 0; i < firstStart.length; i++) {
            int currentFinish = firstStart[i] + firstDuration[i];
            if (currentFinish < minFirstCategoryFinish) {
                minFirstCategoryFinish = currentFinish;
            }
        }
        
  
        int minTotalFinish = Integer.MAX_VALUE;
        for (int j = 0; j < secondStart.length; j++) {
            
            int actualStart = Math.max(minFirstCategoryFinish, secondStart[j]);
            int totalFinishTime = actualStart + secondDuration[j];
            
            if (totalFinishTime < minTotalFinish) {
                minTotalFinish = totalFinishTime;
            }
        }
        
        return minTotalFinish;
    }
}