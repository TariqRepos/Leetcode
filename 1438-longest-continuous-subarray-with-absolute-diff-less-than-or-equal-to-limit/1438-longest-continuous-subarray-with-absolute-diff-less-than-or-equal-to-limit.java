class Solution {
    public int longestSubarray(int[] A, int limit) {
        // This is a monotonically decreasing double-ended queue. 
        Deque<Integer> maxd = new ArrayDeque<>();
        
        // This is a monotonically increasing double-ended queue.
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        
        for (j = 0; j < A.length; ++j) {
            // At each iteration, we maintain the biggest elements in maxd.
            // Remove any element smaller than A[j]
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            
            // At each iteration, we maintain the smallest elements in mind.
            // Remove any element bigger than A[j]
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            
            
            maxd.add(A[j]);
            mind.add(A[j]);
            
            // maxd holds the biggest elements from A[i]...A[j] in decreasing order.
            // So maxd[0] is the biggest element in the window A[i]...A[j]
            // mind holds the smallest elements from A[i]...A[j] in increasing order.
            // So mind[0] is the smallest element in the window A[i]...A[j]
            // maxd[0]-mind[0] is the biggest difference in the window A[i]...A[j]
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}