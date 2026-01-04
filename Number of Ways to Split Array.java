class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] left=new long[n];
        long[] right=new long[n];

        left[0]=nums[0];
        for(int i=1;i<n;i++){
            left[i]=left[i-1]+nums[i];
        }
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]+nums[i+1];

        } 
         int count=0; 
         //compare left[i]>right[i]--->count++      
        for(int i=0;i<n-1;i++){
            if(left[i]>=right[i]){
                count++;
            }
        }
        return count;   
    }
}
