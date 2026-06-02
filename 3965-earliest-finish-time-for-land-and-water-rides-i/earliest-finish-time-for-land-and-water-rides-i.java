class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
       
        long path1 = getEarliestTime(landStartTime, landDuration, waterStartTime, waterDuration);
      
        long path2 = getEarliestTime(waterStartTime, waterDuration, landStartTime, landDuration);
        
        // The optimal answer is the best of both paths
        return (int) Math.min(path1,path2);
    }
    
    private long getEarliestTime(int[] start1, int[] dur1, int[] start2, int[] dur2) {
        // 1. Find the earliest completion time for the first ride type
        long firstRideFinish = Long.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            firstRideFinish = Math.min(firstRideFinish, (long) start1[i] + dur1[i]);
        }
        
        // 2. Find the earliest completion time for the second ride type
        long absoluteFinish = Long.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            long actualStart = Math.max((long) start2[i], firstRideFinish);
            absoluteFinish = Math.min(absoluteFinish, actualStart + dur2[i]);
        }
        
        return absoluteFinish;
    }
}