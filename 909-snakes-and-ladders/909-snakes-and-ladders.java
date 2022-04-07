class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int step = 0;
        Set<Integer> visited = new HashSet<>(); 
        visited.add(1);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int num = q.poll();
                if(num == n*n) return step;
                
         for(int j = num+1; j<= Math.min(num+6, n*n); j++){
                    
                  
             int nn = j;
                    if(getP(nn, n, board)!= -1){
                       nn  = getP(nn, n, board);
                    }
                    if(!visited.contains(nn)) {
                        q.offer(nn);
                        visited.add(nn);
                        }
                }
            }
            step++;
        }
        return -1;
    }
    int getP(int num, int n, int[][] board){
       int row =  n- (num-1)/n-1, col = ((num-1)/n % 2) == 0?(num-1)%n:n-(num-1)%n-1;
        return board[row][col];
    }
}