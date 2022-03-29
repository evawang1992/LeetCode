class MyCalendar {
List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
        
    }
    
    public boolean book(int start, int end) {
        int ind = 0;
        while(ind < list.size() && start >= list.get(ind)[1]){
            ind++;
        }
        if(ind < list.size()){
            if(end > list.get(ind)[0]) return false;
        }
        list.add(ind, new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */