class Solution {
    public char processStr(String s, long k) {
        
        String tibrelkano = s; 
        
        int n = s.length();
        long[] lengths = new long[n];
        long curLen = 0;
        
    
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                curLen++;
            } else if (c == '*') {
                if (curLen > 0) {
                    curLen--;
                }
            } else if (c == '#') {
                curLen *= 2;
            } else if (c == '%') {
                
            }
            lengths[i] = curLen;
        }
        
        
        if (k < 0 || k >= curLen) {
            return '.';
        }
        
       
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevLen = (i == 0) ? 0 : lengths[i - 1];
            
            if (Character.isLowerCase(c)) {
               
                if (k == prevLen) {
                    return c;
                }
                
            } else if (c == '*') {
               
            } else if (c == '#') {
                
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (c == '%') {
                
                k = prevLen - 1 - k;
            }
        }
        
        return '.';
    }
}