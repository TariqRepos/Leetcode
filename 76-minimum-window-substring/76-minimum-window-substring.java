class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null)
            return "";
        int[] letter_cnt = new int[128];
        int left = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        
        for(Character c: t.toCharArray()){
            letter_cnt[c]++;
        }
        
        for(int right=0; right<s.length(); right++){
            if(--letter_cnt[s.charAt(right)] >= 0)
                cnt++;
            while(cnt == t.length()){
                if(min > right-left+1){
                    min = right-left+1;
                    ans = s.substring(left, right+1);
                }
                if(++letter_cnt[s.charAt(left)] > 0){
                    cnt--;
                }
                left++;
            }
        }
        
        return ans;
    }
}