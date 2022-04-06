class MedianFinder {
PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    boolean odd;
    public MedianFinder() {
        min = new PriorityQueue<>((a,b)->b-a);
        max = new PriorityQueue<>();
        odd = false;
    }
    
    public void addNum(int num) {
        if(!odd){
            max.offer(num);
            min.offer(max.poll());
        }
        else {
            min.offer(num);
            max.offer(min.poll());
        }
        odd = !odd;
    }
    
    public double findMedian() {
        if(odd) return (double)min.peek();
        else return ((double)min.peek()+(double)max.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */