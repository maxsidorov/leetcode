// 1 - Sort O(N*logN)
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// 2 - Max heap  O(N*logK)
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int num: nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

// 3 - Quick select Avr O(N) Worst O(N*N)
class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestImpl(nums, k - 1, 0, nums.length - 1);
    }
    
    private int findKthLargestImpl(int[] nums, int k, int left, int right) {
        //System.out.println(Arrays.toString(nums));
        int pivat = left + (right - left)/2;
        swap(nums, pivat, right);
        int middle = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[right]) {
                swap(nums, i, middle++);
            }
        }
        swap(nums, right, middle);
        if (middle == k) {
            return nums[middle];
        }
        if (k < middle) {
            return findKthLargestImpl(nums, k, left, middle - 1);
        } else {
            return findKthLargestImpl(nums, k, middle + 1, right);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
