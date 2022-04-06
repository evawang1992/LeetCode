class Solution {
    public int getFood(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length,  m = grid[0].length;
                boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '*') {
                visited[i][j] = true;
                    q.offer(new int[]{i, j}); break;}
               
            }
            if(q.size() != 0) break;
        }
        int level = 0;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] nn = q.poll();
                if(grid[nn[0]][nn[1]] == '#') return level;
                for(int[] d :dir){
                    int ni = d[0]+nn[0], nj = d[1]+nn[1];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] != 'X'&& !visited[ni][nj]){
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj]=true;
                    }
                }
                }
            level++;
        }
        return -1;
    }
}