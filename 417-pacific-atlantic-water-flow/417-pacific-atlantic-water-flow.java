class Solution {
    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] ac = new boolean[m][n];
        boolean[][] pc = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dfs(heights, pc, i, 0);
            dfs(heights, ac, i, n-1);
        }
        for(int j = 0; j < n; j++){
            dfs(heights, pc, 0, j);
            dfs(heights, ac, m-1, j);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(ac[i][j] && pc[i][j])
                    res.add(Arrays.asList(new Integer[]{i, j}));
            }
        }
        return res;
    }
    void dfs(int[][] heights, boolean[][] ocean, int x, int y){
        ocean[x][y] = true;
        for(int[] d:dir){
            int nx = x+d[0], ny = y +d[1];
            if(nx >= heights.length || nx < 0 || ny < 0 || ny >= heights[0].length || ocean[nx][ny] || heights[x][y] > heights[nx][ny]) continue;
            ocean[nx][ny] = true;
            dfs(heights, ocean, nx, ny);
        }
    }
}