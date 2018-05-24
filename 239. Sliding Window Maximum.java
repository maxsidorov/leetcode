// My solution O(N log k), O(N) is too tricky
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < k - 1; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            maxHeap.add(nums[i + k - 1]);
            result[i] = maxHeap.peek();
            maxHeap.remove(nums[i]);
        }
        return result;
    }
}
