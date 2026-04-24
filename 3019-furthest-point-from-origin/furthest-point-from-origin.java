class Solution {
    public int furthestDistanceFromOrigin(String moves) {
    
        int leftCount = 0;
        int rightCount = 0;
        int blankCount = 0;

      
        for (char c : moves.toCharArray()) {
            if (c == 'L') leftCount++;
            else if (c == 'R') rightCount++;
            else blankCount++;
        }

        return Math.abs(leftCount - rightCount) + blankCount;
    }
}
        
