
class Solution {
    public int numberOfSpecialChars(String word) {
        
        char[] charArray = word.toCharArray();
        
        HashSet<Character> set = new HashSet<>();
        for (char ch : charArray) {
            set.add(ch);
        }
        
        int specialCount = 0;
       
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char lower = ch;
            char upper = Character.toUpperCase(ch);
            
           
            if (set.contains(lower) && set.contains(upper)) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}