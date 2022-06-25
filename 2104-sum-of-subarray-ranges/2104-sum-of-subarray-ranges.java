class Solution {
    public long subArrayRanges(int[] nums) {
        return getSum(nums,false) - getSum(nums,true);
    }

    private long getSum(int[] nums, boolean min){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        long sum = 0L;
        
        for(int i = 0; i <= n; i++){
            System.out.println();
            System.out.println("i: " + i);
            while (!stack.isEmpty() && (i==n || (min && nums[stack.peek()]>nums[i]) || (!min && nums[stack.peek()]<nums[i]))){
                int pop_i = stack.pop();
                int value = nums[pop_i];
                int prev_i = stack.isEmpty() ? -1 : stack.peek();
                int left = pop_i-prev_i;
                long dist = (i-pop_i)*(pop_i-prev_i);
                sum += dist*value;
                System.out.println("stack pop_i : " + pop_i);
                System.out.println("pop_i value : " + value);
                System.out.println("(i - pop_i) : " + (i-pop_i));
                // System.out.println("pop_i-peek(): " + (pop_i-stack.peek()));
                System.out.println("distance    : " + dist);
                System.out.println("sum         : " + sum);
                
            }
            stack.push(i);
        }
        return sum;
    }
}