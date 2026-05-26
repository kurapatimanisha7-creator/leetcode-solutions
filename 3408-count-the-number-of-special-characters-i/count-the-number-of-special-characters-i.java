class Solution {
    public int numberOfSpecialChars(String word) {
        // Convert the string to a character array
        char[] charArray = word.toCharArray();
        
        // Use a Set for fast lookup
        HashSet<Character> set = new HashSet<>();
        for (char ch : charArray) {
            set.add(ch);
        }
        
        int specialCount = 0;
        
        // Check each character in the alphabet
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char lower = ch;
            char upper = Character.toUpperCase(ch);
            
            // Check if BOTH uppercase and lowercase exist in our set
            if (set.contains(lower) && set.contains(upper)) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}