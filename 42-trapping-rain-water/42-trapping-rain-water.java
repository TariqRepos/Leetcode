class Solution {
    public int trap(int[] height) {
        if(height == null)
            return 0;
        int left = 0;
        int right = height.length -1;
        
        int left_max = height[0];
        int right_max = height[height.length - 1];
        
        int sum = 0;
        
        while(left < right){
            if(left_max < right_max){
                left++;
                left_max = Math.max(left_max, height[left]);
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