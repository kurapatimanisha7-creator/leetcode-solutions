class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left=0;
        int currcnt=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                currcnt++;
            }
        }
        int mincnt=currcnt;
        for(int right=k;right<blocks.length();right++){
            if(blocks.charAt(left)=='W'){
                currcnt--;
            }
            left++;
            if(blocks.charAt(right)=='W'){
                currcnt++;
            }
            mincnt=Math.min(mincnt,currcnt);
        }
        return mincnt;
    }
}