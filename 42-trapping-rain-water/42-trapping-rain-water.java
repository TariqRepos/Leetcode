class Solution {
    public int trap(int[] height) {
        // Check if empty
        if(height == null)
            return 0;
        
        int left = 0;
        int right = height.length -1;
        
        int left_max = height[0];
        int right_max = height[height.length - 1];
        
        int sum = 0;
        
        while(left < right){
            // Select smaller height
            if(left_max < right_max){
                left++;
                // Max of prev and new height
                left_max = Math.max(left_max, height[left]);
                // Diff is how much water you can hold
                sum += left_max - height[left];
            }
            else{
                right--;
                right_max = Math.max(right_max, height[right]);
                sum += right_max - height[right];
            }
        }
        return sum;
    }
}