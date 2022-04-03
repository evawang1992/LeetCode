class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 1) return new int[][]{}; 
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b)-> (a[0] == b[0] ? a[1]-b[1]: a[0]-b[0]));
        int[] last = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            
            int[] cur = intervals[i];
            if(cur[0] <= last[1]){
                last[0] = Math.min(cur[0], last[0]);
                last[1] = Math.max(cur[1], last[1]);
            }
            else {res.add(last);
                  last = cur;
           }
        }
        res.add(last);
        int[][] fres = new int[res.size()][2];
        for(int i = 0; i < fres.length; i++){
            fres[i] = res.get(i);
        }
        return fres;
    }
}