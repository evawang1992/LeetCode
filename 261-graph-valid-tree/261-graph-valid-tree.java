class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        Arrays.fill(root, -1);
        if(edges.length != n-1)return false;
        for(int[] e:edges){
            int e1 = find(root, e[0]);
                        int e2 = find(root, e[1]);
            if(e1 == e2) return false;
            root[e2] = e1;
        }
        return true;

    }
    int find(int[] root, int id){
        if(root[id] == -1) root[id] = id;
        while(id != root[id]) id = root[id];
        return id;
    }
    
    
}