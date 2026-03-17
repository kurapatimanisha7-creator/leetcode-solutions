class Solution {
    public boolean canJump(int[] nums) {
        int lp=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            
            if(i+nums[i]>=lp){
                lp=i;
                

            }
        }
            
        if(lp==0){
            return true;
        }
        else{
            return false;
        }
         

      

    }   
    
}