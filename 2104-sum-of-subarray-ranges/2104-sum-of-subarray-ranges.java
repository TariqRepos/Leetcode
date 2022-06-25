class Solution {
    public long subArrayRanges(int[] nums) {
        return getSum(nums,false) - getSum(nums,true);
    }

    private long getSum(int[] nums, boolean min){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        long sum = 0L;
        
        for(int i = 0; i <= n; i++){
            while (!stack.isEmpty() && (i==n || 
                    (min && nums[stack.peek()] > nums[i]) ||  // MIN sum
                    (!min && nums[stack.peek()] < nums[i]))){ // MAX sum

                int pop_i = stack.pop(); // Current index in array
                int prev_i = stack.isEmpty() ? -1 : stack.peek(); // Prev min or max
                
                int left = pop_i - prev_i; // Left boundry
                int right = i - pop_i;     // Right boundry
                
                sum += left * right * (long)nums[pop_i];
            }
            stack.push(i);
        }
        return sum;
    }
}