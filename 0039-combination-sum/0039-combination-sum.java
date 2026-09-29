class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, candidates, target, list, ans);
        return ans;
    }
    void backtrack(int i, int[] candidates, int target,
                   List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i == candidates.length || target < 0) {
            return;
        }
        // Choose current number
        if(candidates[i] <= target) {
            list.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i], list, ans);
            list.remove(list.size() - 1);
        }
        // Skip current number
        backtrack(i + 1, candidates, target, list, ans);
    }
}