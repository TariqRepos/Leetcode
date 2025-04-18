class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int curSum = nums[0];
        int maxSum = curSum;
        
        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If curSum is negative, throw it away. Otherwise, keep adding to it.
            curSum = Math.max(num, curSum + num);
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
    }
}