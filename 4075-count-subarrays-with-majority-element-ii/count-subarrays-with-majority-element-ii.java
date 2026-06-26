class Solution {
    
    private class FenwickTree {
        private int[] tree;
        private int size;

        public FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        
        public void update(int index, int delta) {
            while (index <= size) {
                tree[index] += delta;
                index += index & (-index);
            }
        }

        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
   
        FenwickTree bit = new FenwickTree(2 * n + 2);
        
        
        int offset = n + 1;
        int currentPrefixSum = 0;
        
        
        bit.update(currentPrefixSum + offset, 1);
        
        long totalSubarrays = 0;
        
        for (int num : nums) {
         
            currentPrefixSum += (num == target) ? 1 : -1;
            
           
            totalSubarrays += bit.query(currentPrefixSum + offset - 1);
            
            
            bit.update(currentPrefixSum + offset, 1);
        }
        
        return totalSubarrays;
    }
}