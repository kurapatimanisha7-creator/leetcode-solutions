class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIdx = -1; 
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        
      
        int defaultBest = 0;
        for (int i = 1; i < wordsContainer.length; i++) {
            if (isBetter(wordsContainer, i, defaultBest)) {
                defaultBest = i;
            }
        }
        root.bestIdx = defaultBest;

       
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            TrieNode curr = root;
            
            for (int j = word.length() - 1; j >= 0; j--) {
                int c = word.charAt(j) - 'a';
                if (curr.children[c] == null) {
                    curr.children[c] = new TrieNode();
                }
                curr = curr.children[c];
                
           
                if (curr.bestIdx == -1 || isBetter(wordsContainer, i, curr.bestIdx)) {
                    curr.bestIdx = i;
                }
            }
        }

        int[] result = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            TrieNode curr = root;
            int ans = root.bestIdx;

            for (int j = query.length() - 1; j >= 0; j--) {
                int c = query.charAt(j) - 'a';
                if (curr.children[c] == null) break;
                curr = curr.children[c];
                ans = curr.bestIdx;
            }
            result[i] = ans;
        }

        return result;
    }

   
    private boolean isBetter(String[] words, int newIdx, int oldIdx) {
        if (words[newIdx].length() != words[oldIdx].length()) {
            return words[newIdx].length() < words[oldIdx].length();
        }
        return newIdx < oldIdx;
    }
}