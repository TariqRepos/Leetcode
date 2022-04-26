class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # Initialize total length of array len(A) + len(B), and rounded down half = total // 2
        # We will assume A is smaller array of two(swap A and B if needed)
        # Binary search array A, find its middle i
        # Then the middle of B is j = half - i because half is supposed to be the length of left partition in global scale
        # But we are not sure if this is valid partition where all left partition values are smaller than right partitions
        # So we cross check the end of A's left partition(Aleft) and the start of B's right partition(Bright), and vice versa for B and A
        # If we confirm they are in ascending order, we have a valid partition so we just need to compute median 
        # If they are not in ascending order, fix partitions to make it correct
        # Fixing A will result in B being fixed automatically
        
        A, B = nums1, nums2
        total = len(nums1) + len(nums2)
        half = total // 2
        
        # make sure A is always smaller array
        if len(B) < len(A):
            A, B = B, A
            
        l = 0
        r = len(A) - 1
        while True: # no condition because there is guaranteed to be a median so we can just return right away
            
            i = l + (r - l) // 2 #Middle of A
            j = half - i - 2 #Middle of B
            # we subtract by 2 because array index starts at 0. j starts and 0 and i starts at 0 so take those into account
            print(i,j)
            # Aleft is the end of left partition(= middle, i)
            # Aright is the beginning of right partition(= adjacent to middle, i+1)
            # Vice versa for B
            Aleft = A[i] if i >= 0 else float('-inf') # Is i out of bound? If yes, give it default value of -infinity
            Aright = A[i+1] if (i+1) < len(A) else float('inf') # likewise for right boundary
            Bleft = B[j] if j >= 0 else float('-inf') 
            Bright = B[j+1] if (j+1) < len(B) else float('inf')
            # This infinity arrangement for out of bound is useful for when we check valid partition in next step
            
            # If end of A's left partition is smaller than right partition B's start, and vice versa for B and A, we have a valid partition
            # so then we compute result and return it
            if Aleft <= Bright and Bleft <= Aright:
                # if we have odd length of array
                if total % 2 != 0:
                    return min(Aright, Bright)  # median is the beginning of right partition and it will be min value between Aright and Bright
                # even length of array
                # median is the mean of two values adjacent to mid, which are end of left partition and beginning of right partition
                return (max(Aleft, Bleft) + min(Aright, Bright))/2  
            # If end A's left partition is larger than B's start of right partition, we need to fix partitions.
            # Since arrays are in ascending order, shifting r will result in smaller A's left partition, which leads to smaller Aleft
            elif Aleft > Bright:
                r = i-1
            # Or we could have too small A, in which case we increase A's size by shifting l
            else:
                l = i+1