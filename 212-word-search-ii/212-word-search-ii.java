class TrieNode {
    HashMap<Character, TrieNode> children;
    Boolean is_word;
    
    public TrieNode(){
        children = new HashMap<Character, TrieNode>();
        is_word = false;
    }
    
    public void addWord(String word){
        TrieNode curr = this;
        
        for(Character c : word.toCharArray()){
            if(!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.is_word = true;
    }
    
    // public boolean search(String word) {
    //     TrieNode curr = this;
    //     for(Character c : word.toCharArray()){
    //         if(!curr.children.containsKey(c)){
    //             return false;
    //         }
    //         curr = curr.children.get(c);
    //     }
    //     return curr.is_word;
    // }
}



class Solution {
    HashSet<String> res;
    HashSet<Pair<Integer, Integer>> visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words)
            root.addWord(word);

        res = new HashSet<String>();
        visited = new HashSet<Pair<Integer, Integer>>();
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(root.children.containsKey(board[i][j]))
                    dfs(i, j, root, "", board);
            }   
        }
        
        return new ArrayList<>(res);
    }
    
    
    public void dfs(int i, int j, TrieNode node, String word, char[][] board){
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || 
          visited.contains(new Pair(i, j)) ||
          !node.children.containsKey(board[i][j]))
            return;
        
        Pair<Integer, Integer> coor = new Pair(i, j);
        visited.add(coor);
        
        node = node.children.get(board[i][j]);
        word += board[i][j];
        
        if(node.is_word){
            res.add(word);
        }
        
        dfs(i-1, j, node, word, board);
        dfs(i+1, j, node, word, board);
        dfs(i, j-1, node, word, board);
        dfs(i, j+1, node, word, board);
        
        visited.remove(coor);
    }
}