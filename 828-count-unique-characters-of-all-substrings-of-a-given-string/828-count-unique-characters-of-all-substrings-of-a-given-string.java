class Solution {
    public int uniqueLetterString(String S) {
        // Records last two occurrence index for every upper characters
        int[][] index = new int[26][2]; 
        
        // Initialise all values in index to -1
        for (int i = 0; i < 26; ++i) Arrays.fill(index[i], -1);
        
        int res = 0;
        int N = S.length();
        
        // Loop on string S, for every character c, update its last two occurrence index to index[c]
        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A';
            
            // Length btw curr to prev ocurrance * length btw prev to prev prev ocurrance
            res += (i - index[c][1]) * (index[c][1] - index[c][0]);
            index[c] = new int[] {index[c][1], i};
        }
        
        // Loop through Char array and get result
        for (int c = 0; c < 26; ++c)
            // Length btw end to prev ocurrance * length btw prev to prev prev ocurrance
            res += (N - index[c][1]) * (index[c][1] - index[c][0]);
        
        return res;
    }
}