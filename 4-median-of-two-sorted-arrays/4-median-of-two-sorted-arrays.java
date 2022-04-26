class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if(nums2.length < nums1.length){
            A = nums2;
            B = nums1;
        }
        
        int total = A.length + B.length;
        int half = total / 2;
        
        // Run binary search on small array, A
        int l = 0;
        int r = A.length-1;
        while(true){
            // Get middles
            int i = Math.floorDiv((l+r),2); // A
            int j = half - i - 2; // B need to subract by 2 bc need index
            
            // Now confirm correct partition
            int Aleft = Integer.MIN_VALUE;
            if(i >=0) Aleft = A[i];
            int Aright = Integer.MAX_VALUE;
            if(i+1 < A.length) Aright = A[i+1];
            
            int Bleft = Integer.MIN_VALUE;
            if(j >=0) Bleft = B[j];
            int Bright = Integer.MAX_VALUE;
            if(j+1 < B.length) Bright = B[j+1];
            
            // Checking for correct partition
            if(Aleft <= Bright && Bleft <= Aright){
                // Odd
                if(total % 2 == 1)
                    return Math.min(Aright, Bright);
                // Even
                else
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            else if(Aleft > Bright)
                r = i - 1;
            else
                l = i + 1;
            
        }
    }
}