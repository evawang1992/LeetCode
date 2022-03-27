class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(pid == null || pid.size() == 0|| ppid.size() != pid.size()) return res;
        for(int i = 0; i < pid.size(); i++){
            if(ppid.get(i) == 0) {
                // map.add(new HashSet<>());
                continue;
            }
            map.computeIfAbsent(ppid.get(i), k->new HashSet<>()).add(pid.get(i));
        }
        kill(map, res, kill);
        return res;
    }
    void kill(Map<Integer, Set<Integer>> map, List<Integer>  res, int pid){
        res.add(pid);
        if(!map.containsKey(pid)) return;
        for(Integer n:map.get(pid)){
            kill(map, res, n);
        }
    }
}