class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> prevmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            int numberneeded=target-current;
            if(prevmap.containsKey(numberneeded)){
                return new int[]{prevmap.get(numberneeded),i};
            }
           prevmap.put(current, i);

        }
       return new int[]{}; 
       
    }
}