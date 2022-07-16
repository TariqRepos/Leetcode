/*
Approach 1: Jump Line
For a day i, try painting all areas in the range. If the area is empty, set the value on the number line to end_i,
and increment the amount painted on that day.

If the area has been painted previously, jump to the end of the painted range (which was recorded on the number 
line on a previous day).

Note that we compress jumps so it works efficiently for cases like [[1,2],[1,3],[1,4],...[1,5000]]. 
If we trying to paint [100, 1000], and we see a jump from 200 to 500 (line[200] == 500), we jump to 500, 
but we set line[200] = 1000 as we know we will paint it all the way to 1000. Next time we stamp on that area, we will jump farther.

Here is how our jump line looks like for the [[1,4],[5,9],[4,10]] test case. For the last interval, we paint 4, then jump and paint 9 (compressing the jump value for area 5):

*/
class Solution {
    public int[] amountPainted(int[][] paint) {
        if (paint == null || paint.length == 0) return new int[0];
        
        // Keeps track of next avalible unpainted space
        int[] lines = new int[50001];
        int[] ans = new int[paint.length];
        
        for (int i=0; i<paint.length; i++) {
            int start = paint[i][0];
            int end = paint[i][1];
            System.out.println("ind  : " + i);
            System.out.println("start: " + start);
            System.out.println("end  : " + end);
            
            while (start < end) {
                // Check how far to increment to next unpainted space
                int jump = Math.max(start + 1, lines[start]);
                // Increment ans index by 1 if space has not been painted yet
                ans[i] += lines[start] == 0 ? 1 : 0;
                // Update array
                lines[start] = Math.max(lines[start], end);
                // Update to next spot by jump
                start = jump;
            }
        }
        return ans;
    }
}