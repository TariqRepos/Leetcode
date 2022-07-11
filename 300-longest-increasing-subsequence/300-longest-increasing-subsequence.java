class Solution {
    // DP solution
    // O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] lsa = new int[nums.length];
        Arrays.fill(lsa, 1);
        int max = 1;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i-1; j>-1; j--){
                if(nums[i] > nums[j]){
                    lsa[i] = Math.max(lsa[i], 1+lsa[j]);
                }
            }
            max = Math.max(max, lsa[i]);
        }
        return max;
    }
}