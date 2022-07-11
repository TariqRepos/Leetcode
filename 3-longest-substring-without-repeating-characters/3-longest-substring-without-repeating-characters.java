class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] letter_cnt = new int[128];
        // for(Character c : s.toCharArray()){
        //     letter_cnt[c]++;
        // }
        
        int left = 0;
        int max = 0;
        int cnt = 0;
        
        for(int right=0; right< s.length(); right++){
            cnt++;
            if(++letter_cnt[s.charAt(right)] == 1){
                max = Math.max(max, cnt);
            }
            else{
                while(letter_cnt[s.charAt(right)] > 1){
                    letter_cnt[s.charAt(left)]--;
                    left++;
                    cnt--;
                }
            }
        }
        return max;
        
        
        
        
        
        
//         HashSet<Character> chars = new HashSet<>();
//         int p1 = 0;
//         int p2 = 0;
//         int max = 0;
        
//         while(p2 < s.length()){
//             if(!chars.contains(s.charAt(p2))){        
//                 chars.add(s.charAt(p2));
//                 p2++;
//                 max = Math.max(max, chars.size());
//             }
//             else{
//                 chars.remove(s.charAt(p1));
//                 p1++;
//             }
//         }
//         return max;   
    }
}
