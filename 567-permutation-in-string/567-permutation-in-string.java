public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        
        int l = 0;
        for(int r=s1.length(); r<s2.length(); r++){
            if(count == 26)
                return true;
            
            // Adding character
            int index = s2.charAt(r) - 'a';
            s2map[index] += 1;
            
            // If counts matches, inc
            if (s1map[index] == s2map[index])
                count++;
            // They were equal, but not anymroe, so dec
            else if (s1map[index]+1 == s2map[index]){
                count--;
            }
            
            // Removing charactewr, got to keep window
            index = s2.charAt(l) - 'a';
            s2map[index] -= 1;
            // If counts matches, inc
            if (s1map[index] == s2map[index])
                count++;
            // They were equal, but not anymroe, so dec
            else if (s1map[index]-1 == s2map[index]){
                count--;
            }
            
            l++;
        }
        
        
        
        return count == 26;
    }
}