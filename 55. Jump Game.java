// Recursion + memo [Stack Overflow]
class Solution1 {
    public boolean canJump(int[] nums) {
        boolean visited[] = new boolean[nums.length];
        return canJumpHelper(nums, 0, visited);
    }
    
    public boolean canJumpHelper(int[] nums, int i, boolean[] visited) {
        if (i == nums.length - 1) return true;
        if (i > nums.length - 1) return false;
        if (visited[i]) return false;
        for (int steps = 1; steps <= nums[i]; steps++) {
            if (canJumpHelper(nums, i + steps, visited)) {
                return true;
            }
        }
        visited[i] = true;
        return false;
    }
}

// Iteration + Stack + memo [Time limit exceeded]
class Solution2 {
    
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return true;
        boolean visited[] = new boolean[nums.length];
        Stack<Integer> stack = new Stack();
        stack.push(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (int steps = 1; steps <= nums[i]; steps++) {
                if (i + steps == nums.length - 1) return true;
                if (i + steps < nums.length - 1) {
                    if (!visited[i + steps]) {
                        visited[i + steps] = true;
                        stack.push(i + steps);
                    }
                }
            }
        }
        return false;
    }

}

// Greedy [Accepted]
class Solution {
    
    public boolean canJump(int[] nums) {
        int currStep = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= currStep) {
                currStep = 1;
            } else {
               currStep++; 
            }
        }
        return currStep == 1;
    }

}
