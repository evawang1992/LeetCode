class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(res, nums, new ArrayList<>());
        return res;
    }
    void dfs(List<List<Integer>> res, int[] nums, List<Integer> list){
        
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(res, nums, list);
            list.remove(list.size()-1);
        }
    }
}