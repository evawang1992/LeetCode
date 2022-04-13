class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        dfs(res, 0, target, 0, candidates, new ArrayList<>());
        return res;
    }
   void dfs(List<List<Integer>> res, int ind, int target, int sum, int[] candidates, List<Integer> list){
        if(sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = ind; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs(res, i, target, sum+candidates[i], candidates, list);
            list.remove(list.size()-1);
        }
    }
}