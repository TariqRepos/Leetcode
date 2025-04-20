class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = (r-l)/2 + l;

            if (nums[m] == target) {
                return m;
            }

            // Are we in left or right sorted region?
            if (nums[l] > nums[m]) {
                // Right sorted region
                if (target < nums[m]) {
                    // Target is larger than mid value,
                    // go left to find smaller values
                    r = m - 1;
                } else if (target > nums[r]) {
                    // Target is larger than all right region values,
                    // go left to find smaller values
                    r = m - 1;
                } else {
                    // Search left for larger values
                    l = m + 1;
                }
            } else{
                // Left sorted region
                if (target > nums[m]) {
                    // Target is larger than mid value,
                    // go right to find larger values
                    l = m + 1;
                } else if (target < nums[l]) {
                    // Target is smaller than all left region values,
                    // go right to find smaller values
                    l = m + 1;
                } else {
                    // Search left for smaller values
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}