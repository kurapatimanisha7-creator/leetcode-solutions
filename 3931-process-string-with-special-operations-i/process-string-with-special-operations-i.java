class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isLowerCase(c)) {
                // Append lowercase letter
                sb.append(c);
            } else if (c == '*') {
                // Remove the last character if it exists
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (c == '#') {
                // Duplicate the current content
                sb.append(sb.toString());
            } else if (c == '%') {
                // Reverse the current content
                sb.reverse();
            }
        }
        
        return sb.toString();
    }
}