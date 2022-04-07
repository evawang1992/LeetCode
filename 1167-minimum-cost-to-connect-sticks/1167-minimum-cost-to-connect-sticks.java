class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks.length == 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : sticks){q.offer(s);}
        int res = 0;
        while(q.size() >= 2){
            int a = q.poll();
            int b = q.poll();
            res+=a+b;
            q.offer(a+b);
        }
        // res+=q.peek();
        return res;
    }
}