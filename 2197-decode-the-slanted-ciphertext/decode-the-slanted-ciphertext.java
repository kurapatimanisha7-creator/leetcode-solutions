class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
     
        if (rows == 0) return "";
        
        int n = encodedText.length();
        int cols = n / rows;
        
        StringBuilder result = new StringBuilder();
        
       
        for (int c = 0; c < cols; c++) {
            int i = 0, j = c;
            
            while (i < rows && j < cols) {
                int index = i * cols + j;
                result.append(encodedText.charAt(index));
                i++;
                j++;
            }
        }
        
        
        return result.toString().stripTrailing();
    }
}
        
