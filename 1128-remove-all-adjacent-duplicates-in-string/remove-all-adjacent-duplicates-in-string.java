class Solution {
    public String removeDuplicates(String s) {
        char sta[] = new char[s.length()];
        int top=-1;
        for(char c:s.toCharArray()){
            if(top>=0&&sta[top]==c){
                top--;

            }
            else{
                sta[++top]=c;

            }
        }
        return new String(sta,0,top+1);
        
    }
}