class Solution {
    public int missingNumber(int[] nums) {
        long sum = 0;
        long expectedSum = 0;
        long n = 1; // will be tracking all the natural numbers, 1..|nums| (excluding 0)
        for (int num : nums) {
            sum += num;
            expectedSum += n++;
        }

        // missing
        return (int)(expectedSum - sum);
    }
}