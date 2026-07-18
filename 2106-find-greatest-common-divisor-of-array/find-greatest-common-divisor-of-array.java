import java.math.*;
class Solution {
    public int findGCD(int[] nums) {
       int small=nums[0];
       int great=nums[0];
       for(int i=0;i<nums.length;i++){
        if(nums[i]>great){
            great=nums[i];
        }
         if(nums[i]<small){
            small=nums[i];
        }
       }
       BigInteger a=BigInteger.valueOf(small);
       BigInteger b=BigInteger.valueOf(great);
       BigInteger c= a.gcd(b);
        return c.intValue();


        
        
    }
}