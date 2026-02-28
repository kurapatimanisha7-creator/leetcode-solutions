class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int [] doublearray=new int[2*n];
        for(int i=0;i<n;i++){
            doublearray[i]=nums[i];
            doublearray[i+n]=nums[i];
        }
        return doublearray;
    }
}