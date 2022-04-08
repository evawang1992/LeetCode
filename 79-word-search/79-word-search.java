class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0;  i< board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                   if(found(word, 0, board, i, j, new HashSet<>())) return true;
                    
                }
                
            }
        }
        return false;
    }
    int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean found(String word, int p, char[][] board, int i, int j, Set<Integer> visited){
        if(p == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) { return false;}
        if(board[i][j] != word.charAt(p)) return false;
        
        if(visited.contains(board[0].length*i+j))return false;
        visited.add(board[0].length*i+j);
      
                boolean flag = found(word, p+1, board, i-1, j, visited) || found(word, p+1, board, i+1, j, visited) || found(word, p+1, board, i, j+1, visited) || found(word, p+1, board, i, j-1, visited);
           
        visited.remove(board[0].length*i+j);
        return flag;
    }
}