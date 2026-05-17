class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start<0||start>=arr.length){
            return false;
        }
        if(arr[start]<0){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        int jump=arr[start];
        arr[start]=-arr[start];
        int left=start-jump;
        int right=start+jump;
       return canReach(arr, right) || canReach(arr, left);
    }
}