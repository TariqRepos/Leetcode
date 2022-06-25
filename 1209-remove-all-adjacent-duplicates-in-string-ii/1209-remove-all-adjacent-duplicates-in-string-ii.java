class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        
        for(Character c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().getKey() == c) {
                Pair p = stack.pop();
                stack.add(new Pair(c, 1 + (int)p.getValue()));
            }
            else
                stack.add(new Pair(c, 1));
            
            if(!stack.isEmpty() && stack.peek().getValue() == k)
                stack.pop();
        }
        
        StringBuilder res = new StringBuilder();
        for(Pair p : stack) {
            for(int i=0; i<(int)p.getValue(); i++) {
                res.append(p.getKey() );
            }
        }
        
        return res.toString();
    }
}