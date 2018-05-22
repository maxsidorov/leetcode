// My solution
class Solution1 {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> peaks = new Stack();
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            while (!peaks.isEmpty() && h >= height[peaks.peek()]) {
                int lastPeak = peaks.pop();
                if (!peaks.isEmpty()) {
                    sum += (Math.min(height[peaks.peek()], height[i]) - height[lastPeak]) * (i - peaks.peek() - 1);
                }
            }
            peaks.push(i);
        }
        return sum;
    }
}
// Another simpler solution after some tips
class Solution2 {
    public int trap(int[] height) {
        if (height.length <= 1) return 0;
        int sum = 0;
        int left = 0, right = height.length - 1,  leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                if (height[left] < leftMax && height[left] < rightMax) {
                    sum += Math.min(leftMax, rightMax) - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;
                if (height[right] < leftMax && height[right] < rightMax) {
                    sum += Math.min(leftMax, rightMax) - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return sum;
    }
}
