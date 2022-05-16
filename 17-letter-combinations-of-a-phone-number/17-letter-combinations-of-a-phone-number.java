class Solution {
    HashMap<Character, List<Character>> map;
    List<String> res;
    
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        res = new ArrayList<>();
        
        if(digits.length() == 0)
            return res;

        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        
        dfs("", 0, digits);
        
        return res;
    }
    
    public void dfs(String curr, int index, String digits){
        if(index == digits.length()){
            res.add(curr);
        }
        else{
            for(Character c : map.get(digits.charAt(index))){
                dfs(curr+c, index+1, digits);
            }
        }
        
    }
}