class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int left = 0;
        int right = n - 1;

        
        while (colors[n - 1] == colors[left]) {
            left++;
        }
        int dist1 = n - 1 - left;

        
        while (colors[0] == colors[right]) {
            right--;
        }
        int dist2 = right;

        return Math.max(dist1, dist2);
    }
}