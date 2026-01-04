class Solution {
    public int[] productExceptSelf(int[] nums) {
    int n=nums.length;
    int[] LP=new int[n];
    int[] RP=new int[n];
    int[] res=new int[n];
    LP[0]=1;
    for(int i=1;i<=n-1;i++){
    LP[i]=LP[i-1]*nums[i-1];
    }
    RP[n-1]=1;
    for(int i=n-2;i>=0;i--){
    RP[i]=RP[i+1]*nums[i+1];
    }
    for( int i=0;i<=n-1;i++){
    res[i]=LP[i]*RP[i]; 
    } 
    return res;
    }
}
    
