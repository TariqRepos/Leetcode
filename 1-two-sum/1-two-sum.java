class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            complements.put(target - nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            if(complements.containsKey(nums[i]) && complements.get(nums[i]) != i){
                return new int[] {complements.get(nums[i]), i};
            }
        }
        return new int[] {};
        
    }
}