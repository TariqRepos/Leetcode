class Solution {
    HashSet<List<Integer>> visited = new HashSet<>();
    
    public boolean exist(char[][] board, String word) {        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, char[][] board, String word, int c){
        if(c >= word.length())
            return true;
        
        if(i<0 || i>board.length-1 || j<0 || j>board[i].length-1 ||
           visited.contains(Arrays.asList(i,j)) || 
           word.charAt(c) != board[i][j])
            return false;
        
        visited.add(Arrays.asList(i,j));
        Boolean res = (
            dfs(i-1, j, board, word, c+1) ||
            dfs(i+1, j, board, word, c+1) ||
            dfs(i, j-1, board, word, c+1) ||
            dfs(i, j+1, board, word, c+1));
        visited.remove(Arrays.asList(i,j));
        return res;
          
    }
}