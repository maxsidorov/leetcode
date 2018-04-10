class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        subsetsImpl(result, new LinkedList(), nums, 0);
        return result;
    }
    
    private void subsetsImpl(List<List<Integer>> result, LinkedList<Integer> list, int[] nums, int start) {
        result.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsImpl(result, list, nums, i + 1);
            list.removeLast();
        }
    }
}
