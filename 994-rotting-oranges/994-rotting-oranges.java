class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        
        int fresh = 0;
        for(int i= 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)q.offer(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;
        int stage = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] p = q.poll();
                for(int[] d : dir){
                    int nx = d[0]+p[0], ny = d[1]+p[1];
                    if(nx >=0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        fresh--;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            stage++;
        }
        if(fresh == 0) return stage;
        else return -1;
    }
}