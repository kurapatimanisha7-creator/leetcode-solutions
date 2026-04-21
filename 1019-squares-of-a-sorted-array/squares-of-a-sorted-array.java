class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int pointer=n-1;
        int[]res=new int[n];
        while(left<=right){
            int leftsq=nums[left]*nums[left];
            int rightsq=nums[right]*nums[right];
            if(leftsq>rightsq){
                res[pointer]=leftsq;
                pointer--;
                left++;
            }
            else{
                res[pointer]=rightsq;
                pointer--;
                right--;
            }
        }
        return res;
    }
}