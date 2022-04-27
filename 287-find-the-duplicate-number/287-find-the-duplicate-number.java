class Solution {
    // Floyad 2 ptr method, slow and fast
    // TC: O(n) SC: O(1)
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        // Phase 1: find first point of intersection
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }
        
        // Phase 2: find start of cycle
        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2)
                break;
        }
        
        return slow;
    }
}