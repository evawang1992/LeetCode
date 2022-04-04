class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (int[] a, int [] b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int[] interval : intervals){
            while(!pq.isEmpty() && pq.peek() <= interval[0]) pq.poll();
            pq.offer(interval[1]);
            count = Math.max(count, pq.size());
        }
        return count;
    }
}