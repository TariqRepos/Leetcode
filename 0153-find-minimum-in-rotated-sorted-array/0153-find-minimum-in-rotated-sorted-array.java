class Solution {
    public int findMin(int[] nums) {
        /* There are 2 sorted regions, left and right
         * Left -> larger sorted region where left most is large than all values in right sorted region
         * Right -> smaller sorted region
         */

        int l=0;
        int r=nums.length-1;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int m = (r - l) / 2 + l;
            
            min = Math.min(min, nums[m]);

            // Is array sorted?
            if (nums[l] <= nums[r]) {
                return Math.min(min, nums[l]);
            }
            
            // Are we in left or right sorted region
            if (nums[l] > nums[m]) {
                // In right sorted region, shift to left
                r = m - 1;
            } else {
                // In left sorted region, shfit to right
                l = m + 1;
            }
        }

        return min;
    }
}