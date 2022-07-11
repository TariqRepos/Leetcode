class Solution {
// one is the counter if you were to flip 1s up to current index
// flip is the counter for the minimum flips you could do up to current index

// so during the looping, you are considering which requires less flips.
    public int minFlipsMonoIncr(String s) {
        int one = 0;
        int flip =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                one++;
            else
                flip++;
            flip = Math.min(one,flip);
        }
        return flip;

    }
}