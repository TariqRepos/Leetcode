class Solution {
    // You could do division method, but if you
    // cant you can do both pre and post 
    // multiplcation
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        Arrays.fill(res, 1);
        int prefix = 1;
        for(int i=0; i<res.length; i++){
            res[i] *= prefix;
            prefix *= nums[i];
        }
        
        int postfix = 1;
        for(int i=res.length-1; i>-1; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        
        return res;
    }
}
