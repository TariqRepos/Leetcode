class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int pre = 0, cur = 0, len = 1, res = 1; 
        for (int i = 1; i < arr.length; i++) {
            cur = Integer.compare(arr[i], arr[i - 1]);
            // If the current comparison and previous comparison 
            // are opposite signs (1 * -1 == -1 or -1 * 1 == -1), 
            // it means the turbulence is continuing → increment len
            if (cur * pre == -1) {
                len++;
            }

            // If values are equal → break the turbulence → reset len to 1
            else if (cur == 0) {
                len = 1;
            }

            // Else (same direction as before) → start a new turbulence of 
            // size 2 (the current and previous elements)
            else {
                len = 2;
            }

            res = Math.max(res, len); 
            pre = cur; 
        }
        return res; 
        
    }
}