class Solution {
    
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String q : queries) {
            
            char[] qChars = q.toCharArray();
            
            for (String d : dictionary) {
                if (isWithinTwoEdits(qChars, d)) {
                    result.add(q);
                  
                    break; 
                }
            }
        }
        return result;
    }

    private boolean isWithinTwoEdits(char[] q, String d) {
        int diffs = 0;
        int length = q.length;
        
        for (int i = 0; i < length; i++) {
            if (q[i] != d.charAt(i)) {
                diffs++;
            }
            
            if (diffs > 2) {
                return false;
            }
        }
  
        return true;
    }
}