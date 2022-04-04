class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (int[]a, int[]b)-> a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]);
        int[][] res = new int[k][2];
        int ind = 0;
        while(k-->0){
            res[ind]=points[ind];
            ind++;
        }
        return res;
    }
}