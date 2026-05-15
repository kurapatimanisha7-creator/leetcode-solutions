class Solution {
    public int findMin(int[] nums) {
        // we use binary serach
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return(nums[low]);

    }
}