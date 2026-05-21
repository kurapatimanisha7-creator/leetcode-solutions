class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();

        // Step 1: Add all possible prefixes from arr1 into the HashSet
        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10; // Mathematical way to "strip" the last digit
            }
        }

        int maxLen = 0;

        // Step 2: Check all possible prefixes from arr2
        for (int val : arr2) {
            while (val > 0) {
                if (prefixes.contains(val)) {
                    // Step 3: Calculate the digit count of the match
                    // Using Math.log10 is faster than String.valueOf().length()
                    int currentLen = (int) (Math.log10(val) + 1);
                    maxLen = Math.max(maxLen, currentLen);
                    
                    // Optimization: Once we find the longest prefix for 
                    // this specific number, smaller prefixes won't help.
                    break; 
                }
                val /= 10;
            }
        }

        return maxLen;
    }
}