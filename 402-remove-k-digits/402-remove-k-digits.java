class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        
        for(Character c: num.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > c) {
                k--;
                stack.pop();
            }
            stack.add(c);
        }
        
        for(int i=0; i<k; ++i) {
          stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(Character c: stack) {
            if(leadingZero && c == '0') continue;
            leadingZero = false;
            sb.append(c);
        }
        if(sb.toString().equals(""))
            return "0";
        
        return sb.toString();
    }
}