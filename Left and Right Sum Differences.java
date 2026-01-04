class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] lp=new int[n];
        int[] rp=new int[n];
        int[] res=new int[n];
        lp[0]=0;
        for(int i =1;i<=n-1;i++){
            lp[i]=lp[i-1]+nums[i-1];
        }
        rp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            rp[i]=rp[i+1]+nums[i+1];
        }
        for (int i=0;i<=n-1;i++){
            res[i]=Math.abs(lp[i]-rp[i]);
        }
        return res;
        
    }
}
