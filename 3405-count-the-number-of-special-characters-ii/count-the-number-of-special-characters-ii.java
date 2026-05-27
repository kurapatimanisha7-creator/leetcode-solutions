class Solution {
    public int numberOfSpecialChars(String word) {
        // Arrays to store indices. Initialize with -1 to represent "not seen yet".
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        java.util.Arrays.fill(lastLower, -1);
        java.util.Arrays.fill(firstUpper, -1);
        
        // Single pass to record positions
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (Character.isLowerCase(ch)) {
                int idx = ch - 'a';
                lastLower[idx] = i; // Continually update to get the LAST occurrence
            } else {
                int idx = ch - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i; // Only update the FIRST time we see it
                }
            }
        }
        
        int specialCount = 0;
        
        // Check the rules for all 26 possible alphabet characters
        for (int i = 0; i < 26; i++) {
            // Must have seen both, and the last lowercase must be before the first uppercase
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}