class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Add the first meeting
        minheap.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Check meeing ends before next one starts
            if (intervals[i][0] >= minheap.peek()) {
                // Meeting ends without conflict, remove from heap
                minheap.poll();
            }

            // Add end time of room to min heap
            minheap.add(intervals[i][1]);
        }

        // minheap size = minimum rooms required for all the meetings
        return minheap.size();
    }
}