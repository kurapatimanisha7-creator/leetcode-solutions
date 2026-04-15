class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Only calculate if the word matches our target
            if (words[i].equals(target)) {
                // Standard linear distance
                int forwardDist = Math.abs(i - startIndex);
                
                // Circular distance (the long way around)
                int backwardDist = n - forwardDist;
                
                // Get the minimum of these two, then update our global minimum
                int currentMin = Math.min(forwardDist, backwardDist);
                minDistance = Math.min(minDistance, currentMin);
            }
        }

        // If minDistance was never updated, the target wasn't found
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}