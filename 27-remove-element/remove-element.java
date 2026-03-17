class Solution {
    public int removeElement(int[] num, int val) {
        int k=0;
        for(int i=0;i<num.length;i++){
            if(num[i]!=val){
                num[k]=num[i];
                k++;
            }
        }
        return k;

        
    }
}