class Solution {
    public int characterReplacement(String s, int k) {
        int max_cnt = 0;
        int max_len = 0;
        int left = 0;
        int[] char_cnt = new int[26];
        
        for (int right=0; right<s.length(); right++){
            char_cnt[s.charAt(right) - 'A']++;
            max_cnt = Math.max(max_cnt, char_cnt[s.charAt(right) - 'A']);
            
            while(right - left - max_cnt + 1> k){
                char_cnt[s.charAt(left) - 'A']--;
                left++;
            }
            max_len = Math.max(max_len, right - left +1);
        }
        return max_len;
    }
}