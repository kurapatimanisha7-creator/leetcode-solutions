class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int left=0;
        int right=0;
        while(left<n){
            int count=0;
            char ch=chars[left];
            while((left<n)&&(ch ==chars[left])){
                count++;
                left++;
            }
            chars[right]=ch;
            right++;
            if(count>1){

                String charcount=String.valueOf(count);

                for(char digit:charcount.toCharArray()){


                    chars[right]=digit;

                     right++;
                }
            }
        }
        return right;
    }
}



    