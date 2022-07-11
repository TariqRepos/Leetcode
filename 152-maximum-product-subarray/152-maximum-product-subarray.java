class Solution {
    // This is kind of a DP problem where you
    //  need to look at prevs sub problems to
    // calc max product. This has 2 features, 0
    // mult and 2 (-) = a postive
    public int maxProduct(int[] nums) {
        int res =  Integer.MIN_VALUE;
        int maxp = 1;
        int minp = 1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                maxp = 1;
                minp = 1;
                res = Math.max(res, 0);
                continue;
            }
            int temp = Math.max(maxp*nums[i], 
                            Math.max(minp*nums[i], nums[i]));
            minp = Math.min(maxp*nums[i], 
                            Math.min(minp*nums[i], nums[i]));
            maxp = temp;
            res = Math.max(res, maxp);
        }
        return res;
    }
}