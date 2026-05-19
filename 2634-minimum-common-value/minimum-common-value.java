class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        
        // This single loop keeps going until one pointer reaches the end
        while (i < nums1.length && j < nums2.length) {
            
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Found the minimum common element!
            } 
            else if (nums1[i] < nums2[j]) {
                i++; // nums1[i] is too small, move to the next number in nums1
            } 
            else {
                j++; // nums2[j] is too small, move to the next number in nums2
            }
        }
        
        return -1; // Swept through the arrays and found nothing
    }
}