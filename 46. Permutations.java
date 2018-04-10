class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        return permuteImpl(nums, 0);
    }
    
    private List<List<Integer>> permuteImpl(int[] nums, int start) {
        if (start == nums.length - 1) {
            return Arrays.asList(Arrays.asList(nums[start]));
        } else {
            List<List<Integer>> result = new ArrayList();
            List<List<Integer>> tails = permuteImpl(nums, start + 1);
            for (List<Integer> tail: tails) {
                for (int i = 0; i <= tail.size(); i++) {
                    List<Integer> list = new LinkedList(tail);
                    list.add(i, nums[start]);
                    result.add(list);
                }
            }
            return result;
        }
        
    }
}


class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        permuteImpl(result, new LinkedHashSet(), nums);
        return result;
    }
    
    private void permuteImpl(List<List<Integer>> result, LinkedHashSet<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
        } else {
            for (int num: nums) {
                if (!list.contains(num)) {
                    list.add(num);
                    permuteImpl(result, list, nums);
                    list.remove(num);
                }
            }
        }
        
    }
}
