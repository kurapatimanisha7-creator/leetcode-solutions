class Solution {
    public int maxProduct(int n) {
        int firstmax=0;
        int secoundmax=0;
        while(n>0){
            int digit =n%10;
            if(digit >=firstmax){
                secoundmax=firstmax;
                firstmax=digit;
            }else if(digit>secoundmax){
                secoundmax=digit;
            }
            n/=10;

            }
        
       return firstmax*secoundmax;
        
    }
}