class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int val = 1;
        for(int i=0; i<nums.length; i++){
            res[i] = val;
            val *= nums[i];
        }
        
        val = 1;
        for(int i=nums.length-1; i>-1; i--){
            res[i] *= val;
            val *= nums[i];
        }
        
        return res;
    }
}